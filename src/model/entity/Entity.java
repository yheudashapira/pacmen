package modul.entity;

import controler.game_Enums.Direction;
import controler.game_Enums.StatePlayers;
import modul.game_board.GameBoard;


public abstract class Entity {

    Names name;
    Direction direction;
    StatePlayers state = StatePlayers.START;
    StatePlayers lastState = StatePlayers.START;;

    double x, y, lastX, lastY, nextX, nextY;
    public double speed = 0.06;
    int startY;
    int startX;



    public void addSpeed() {
        this.speed += 0.01;
    }

    GameBoard gameBoard;

    public Entity(GameBoard gameBoard) {
        this.gameBoard = gameBoard;
        setFirstLocation();
    }

    public void setDirection(Direction direction) {
        if (checkPath(direction)) {
            this.direction = direction;
        }
    }

    public Direction getDirection() {
        return direction;
    }

    public Names getName() {
        return name;
    }

    public void setFirstLocation() {
        this.x = startX;
        this.y = startY;
        lastX = nextX = x;
        lastY = nextY = y;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public abstract String getImageNameForCurrentState(int animationFrame);



    public void align() {

        if (direction == Direction.UP) {
            x = (int) x;
        } else if (direction == Direction.DOWN) {
            x = (int) x;
        } else if (direction == Direction.RIGHT) {
            y = (int) y;
        } else if (direction == Direction.LEFT) {
            y = (int) y;
        }
    }

    public void move() {
        align();
        nextY = y;
        nextX = x;
        if (direction == Direction.UP) {
            nextY = (nextY - speed + gameBoard.getHigh()) % gameBoard.getHigh();
            nextY = Math.round(nextY * 1000.0) / 1000.0;
//            x =  Math.round(x);
        } else if (direction == Direction.DOWN) {
            nextY = (nextY + speed + gameBoard.getHigh()) % gameBoard.getHigh();
            nextY = Math.round(nextY * 1000.0) / 1000.0;
//            x =  Math.round(x);
        } else if (direction == Direction.RIGHT) {
            nextX = (nextX + speed) % gameBoard.getWrite();
            nextX = Math.round(nextX * 1000.0) / 1000.0;
//            y =  Math.round(y);
        } else if (direction == Direction.LEFT) {
            nextX = (nextX - speed + gameBoard.getWrite()) % gameBoard.getWrite();
            nextX = Math.round(nextX * 1000.0) / 1000.0;
//            y =  Math.round(y);
        }
        if (checkPath(direction)) {
            x = roundSpeed(nextX);
            y = roundSpeed(nextY);
        }
            System.out.println(name + "x: " + x + "y: " + y);
    }

    double roundSpeed(double next){
        double epsilon = 0.0000001;
        if (Math.abs((next % 1) - 1) < speed - epsilon){
            next = Math.round(next);
        }
        return next;
    }


    public abstract void update();

    public abstract void setState(StatePlayers state);

    public boolean checkPath(Direction direction){
        switch (direction){
            case UP:
                if (y % 1 != 0){
                    return true;
                } else if (gameBoard.getGameBoard()[(int) y - 1][(int) x % gameBoard.getWrite()] != GameBoard.tileType.WALL){
                    return true;
                }
                break;
            case DOWN:
                if (y % 1 != 0){
                    return true;
                } else if (gameBoard.getGameBoard()[(int) y + 1][(int) x % gameBoard.getWrite()] != GameBoard.tileType.WALL &&
                        gameBoard.getGameBoard()[(int) y + 1][(int) x % gameBoard.getWrite()] != GameBoard.tileType.GHOSTS_DOOR){
                    return true;
                }
                break;
            case RIGHT:
                if (x % 1 != 0){
                    return true;
                } else if (gameBoard.getGameBoard()[(int) y][(int) (x + 1) % gameBoard.getWrite()] != GameBoard.tileType.WALL){
                    return true;
                }
                break;
            case LEFT:
                if (x % 1 != 0){
                    return true;
                } else if (gameBoard.getGameBoard()[(int) y][(int) (x - 1 + gameBoard.getWrite()) % gameBoard.getWrite()] != GameBoard.tileType.WALL){
                    return true;
                }
                break;
        }
        return false;
    }
//        if (direction == Direction.RIGHT) {
//            if (gameBoard.getGameBoard()[(int) y][(int) (x + 1) % gameBoard.getWrite()] != GameBoard.tileType.WALL) {
//                return true;
//            }
//        }
//        else if (direction == Direction.LEFT){
//            if (gameBoard.getGameBoard()[(int) (y)][(int) ((x - speed)% gameBoard.getWrite())] != GameBoard.tileType.WALL) {
//                return true;
//            }
//        }
//        else if(direction == Direction.UP){
//            if (gameBoard.getGameBoard()[(int) (y - speed)][(int) x] != GameBoard.tileType.WALL) {
//                return true;
//            }
//        }
//        else if (direction == Direction.DOWN){
//            if (gameBoard.getGameBoard()[(int) (y + 1)][(int) x] != GameBoard.tileType.WALL
//                    && gameBoard.getGameBoard()[(int) (y + 1)][(int) x] != GameBoard.tileType.GHOSTS_DOOR) {
//                return true;
//            }
//        }
//        return false;
//    }

    public StatePlayers getState() {
        return state;
    }

    public StatePlayers getLastState() {
        return lastState;
    }
}
