package model;

import controler.game_Enums.Direction;
import controler.game_Enums.GameState;
import controler.game_Enums.StatePlayers;
import model.entity.*;
import model.game_board.GameBoard;

import java.util.*;

public class GameManger {

    public Timers timers = new Timers();
    int pacmansLife = 3;
    int level = 1;
    int score = 0;
    int pelletsEaten;
    int pelletCounter;
    boolean ghostsScaredState = false;
    GameState gameState = GameState.MAIN_MENU;

    boolean recording = false;
    boolean fromRecording = false;
    GameRecording gameRecording = new GameRecording();


    public void setFromRecording(boolean fromRecording) {
        this.fromRecording = fromRecording;
    }

    public boolean isFromRecording() {
        return fromRecording;
    }

    public void setGameState(GameState gameState) {
        this.gameState = gameState;
    }


    public boolean isGhostsScaredState() {
        return ghostsScaredState;
    }

    final public long second = 30;

    public MainMenu mainMenu = new MainMenu(this);
    public GameBoard gameBoard = new GameBoard();
    int totalPellets = gameBoard.getCountPellets();


    public Pacman pacman = new Pacman(gameBoard);
    Ghost clyde = new Clyde(gameBoard, pacman);
    Ghost blinky = new Blinky(gameBoard, pacman);
    Ghost inky = new Inky(gameBoard, pacman, blinky);
    Ghost pinky = new Pinky(gameBoard, pacman);


    public List<Entity> entities = new ArrayList<>(Arrays.asList(pacman, clyde, blinky, inky, pinky));
    public List<Ghost> ghostList = new ArrayList<>(Arrays.asList(blinky, clyde, inky, pinky));

    Fruits fruits = new Fruits();
    Queue<Fruits> fruitsList = fruits.createFruitsList();
    Fruits fruit = null;
    boolean isTheirFruit;

    public boolean isTheirFruit() {
        return isTheirFruit;
    }

    void addLevel() {
        gameBoard.loudBoard();
        resetLevelEntities();
        this.level += 1;
        this.pacmansLife += 1;
        pelletCounter = 0;
        fruitsList = fruits.createFruitsList();

        for (Ghost ghost : ghostList) {
            ghost.addSpeed();
        }
    }

    public int getLevel() {
        return level;
    }

    public int getScore() {
        return score;
    }

    public void directionEvent(Direction direction) {
        if (direction != null) {
            if (gameState == GameState.MAIN_MENU) {
                timers.menuCounter++;
                if (timers.menuCounter % (second / 8) == 0) {
                    mainMenu.setDirection(direction);
                    setGameState(mainMenu.select());
                }
            } else {
                pacman.setDirection(direction);
                if (recording) {
                    gameRecording.record(direction, timers.getTimeCounter());
                }
            }
        }
    }

    void loss() {
        if (pacmansLife > 1) {
            pacman.setState(StatePlayers.LOSS);
            timers.timerEat = timers.getTimeCounter();
            pacmansLife--;
            resetLevelEntities();
            gameState = GameState.LOSS;
        } else {
            gameState = GameState.GAME_OVER;
            timers.timerGameOver = timers.getTimeCounter();
            if (recording){
                gameRecording.writeToTheFile();
            }
            HighScores highScores = new HighScores();
            highScores.collocateScore(score);
        }


    }

    void handleTimers() {
        if (isTheirFruit) {
            if ((timers.getTimeCounter() - timers.timerFruits) > (second * (18 - level))) {
                removeFruit();
            }
        }
        if (ghostsScaredState) {
            if ((timers.getTimeCounter() - timers.timerScared) > (second * (12 - level))) {
                ghostsScaredState = false;
                changeFromScared();
            }

        }
        switch (gameState) {
            case LOSS:
                if ((timers.getTimeCounter() - timers.timerEat) > (second * (5))) {
                    gameState = GameState.RUN;
                }
                break;
            case READY:
                if (timers.getTimeCounter() > (second * 4)) {
                    gameState = GameState.RUN;
                }
                break;
            case LEVEL_CLEARED:
                if ((timers.getTimeCounter() - timers.timerNewLevel) > (second * 3)) {
                    gameState = GameState.RUN;
                    addLevel();
                }
                break;
            case GAME_OVER:
                if ((timers.getTimeCounter() - timers.timerGameOver) > (second * 5)) {
                    gameState = GameState.MAIN_MENU;
                }
                break;
        }
    }


    public void update() {
        if (gameState != GameState.MAIN_MENU) {
            timers.setTimeCounter();
            handleTimers();
        }

//        print state and game time to the console
        System.out.println(gameState);
        System.out.println(timers.getTimeCounter());
//
        switch (gameState) {
            case RUN:

                eatPellet();
                addFruit();
                sentOutGhost();
                checkCollisionsWithPacman();

                pacman.update();
                for (Ghost ghost : ghostList) {
                    ghost.update();
                    System.out.println(ghost.getState());
                }
                checkGameStatus();
                break;
//            case MAIN_MENU:
//                mainMenu.update();
//                break;
            default:
                return;
        }

    }

    void resetLevelEntities() {
        for (Entity entity : entities) {
            entity.setFirstLocation();
            entity.setState(StatePlayers.START);
        }
    }

    void sentOutGhost() {
        int i = 1;
        for (Ghost ghost : ghostList) {
            if (ghost.getState() == StatePlayers.START && pelletCounter > 40 * i) {
                ghost.setState(StatePlayers.GET_OUT);
            }
            i++;
        }
    }


    void checkCollisionsWithPacman() {
        for (Ghost ghost : ghostList) {
            if (pacman.checkCollisions(ghost)) {
                if (ghost.getState() == StatePlayers.SCARED) {
                    eatGhost(ghost);
                } else if (ghost.getState() != StatePlayers.EAT) {
                    loss();
                    break;
                }
            }
        }
    }

    void changeToScared() {
        for (Ghost ghost : ghostList) {
            if (ghostsScaredState && ghost.getState() != StatePlayers.EAT) {
                ghost.reduceSpeed(0.12);
                ghost.setState(StatePlayers.SCARED);
            }
        }
    }

    void changeFromScared() {
        for (Ghost ghost : ghostList) {
            if (ghost.getState() == StatePlayers.SCARED) {
                ghost.setState(ghost.getLastState());
                ghost.previousSpeed();
            }
        }
    }

    void eatGhost(Ghost ghost) {
        ghost.setState(StatePlayers.EAT);
    }


    void addPoints(int amount) {
        score += amount;
    }

    void eatPellet() {
        if (gameBoard.getGameBoard()[(int) pacman.getY()][(int) pacman.getX() % gameBoard.getWrite()] == GameBoard.tileType.PELLET) {
            addPoints(10);
            pelletsEaten++;
            pelletCounter++;
            gameBoard.updateBoard((int) pacman.getY(), (int) pacman.getX() % gameBoard.getWrite(), GameBoard.tileType.EMPTY);
        }
        if (gameBoard.getGameBoard()[(int) pacman.getY()][(int) pacman.getX() % gameBoard.getWrite()] == GameBoard.tileType.POWER_PELLET) {
            addPoints(50);
            gameBoard.updateBoard((int) pacman.getY(), (int) pacman.getX() % gameBoard.getWrite(), GameBoard.tileType.EMPTY);
            ghostsScaredState = true;
            changeToScared();
            timers.timerScared = timers.getTimeCounter();
        }
        if (isTheirFruit && (int) pacman.getY() == fruit.getY() && (int) pacman.getX() == fruit.getX()) {
            addPoints(fruit.value);
            removeFruit();
        }
    }


    void checkGameStatus() {

        if (pelletCounter == totalPellets) {
            timers.timerNewLevel = timers.getTimeCounter();
            gameState = GameState.LEVEL_CLEARED;

        }
    }

    public int getPacmansLife() {
        return pacmansLife;
    }

    public GameState getGameState() {
        return gameState;
    }


    int i = 1;

    public void addFruit() {
        if ((totalPellets / 7) * i == pelletCounter) {
            i++;
            if (!fruitsList.isEmpty()) {
                fruit = fruitsList.poll();
                isTheirFruit = true;
                timers.timerFruits = timers.getTimeCounter();
            }
        }
    }

    void removeFruit() {
        fruit = null;
        isTheirFruit = false;
    }

    public Fruits getFruit() {
        return fruit;
    }

    public void setRecording(boolean recording) {
        this.recording = recording;
    }
}
