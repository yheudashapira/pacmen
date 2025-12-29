package model.entity;

import controler.game_Enums.Direction;
import controler.game_Enums.StatePlayers;
import model.game_board.GameBoard;



public abstract class Ghost extends Entity {

    Pacman pacman;
    double targetX, targetY;

    double lastSpeed;


    public Ghost(GameBoard gameBoard, Pacman pacman) {
        super(gameBoard);
        this.pacman = pacman;
        speed = 0.12;
        lastSpeed = speed;
        direction = Direction.UP;
    }
    @Override
    public void setState(StatePlayers state) {
        if (this.state != state) {
            this.lastState = this.state;
        }
            this.state = state;
    }

    public abstract void chaseTarget();

    public abstract void scatterTarget();



    void checkPossibleDirections() {

        Direction tempDir = null;
        if (x % 1 == 0 && y % 1 == 0) {
            double slant = 100000000;
            for (Direction dir : Direction.values()) {
                if (checkPath(dir) && Direction.oppositeDirection(direction) != dir) {
                    nextY = y;
                    nextX = x;
                    if (dir == Direction.UP) {
                        nextY -= speed;
                    } else if (dir == Direction.DOWN) {
                        nextY += speed;
                    } else if (dir == Direction.RIGHT) {
                        nextX = (x + speed);
                    } else if (dir == Direction.LEFT) {
                        nextX = (x - speed);
                    }
                    double pitagors = (Math.pow(Math.abs(nextX - targetX), 2) + Math.pow(Math.abs(nextY - targetY), 2));
                    if (pitagors < slant) {
                        slant = pitagors;
                        tempDir = dir;
                    }
                }
            }
            if (tempDir == null) {
                direction = Direction.oppositeDirection(direction);
            } else {
                direction = tempDir;
                lastX = x;
                lastY = y;
            }

        }
    }

    void startState(){
//        direction = Direction.UP;
        previousSpeed();
        if (!checkPath(direction)){
            direction = Direction.oppositeDirection(direction);
        }
    }

    void getOutState(){

            targetX = 13;
            targetY = 13;
            checkPossibleDirections();
        if (Math.abs(y - targetY) <0.5 && Math.abs(x - targetX) <0.5){
            setState(StatePlayers.SCATTER);
        }
    }

    public void eatenState(){
        targetX = 13;
        targetY = 13;
        speed = 0.5;
        checkPossibleDirections();
        if (Math.abs(y - targetY) <0.5 && Math.abs(x - targetX) <0.5){
            setFirstLocation();
            setState(StatePlayers.GET_OUT);
            speed = lastSpeed;
        }
    }

    void randomDirections() {
        Direction tempDir = null;
        for (Direction dir : Direction.values()) {
            if (checkPath(dir) && Direction.oppositeDirection(direction) != dir) {
                tempDir = dir;
                break;

            }
        }
        if (tempDir == null){
            direction = Direction.oppositeDirection(direction);
        } else {
            direction = tempDir;
        }
    }
    void scaredState(){
        if (lastState != StatePlayers.START ) {
            randomDirections();
        } else {
            startState();
        }
    }

    void scatterState(){
        scatterTarget();
        checkPossibleDirections();
        if (Math.abs(y - targetY) < 3 && Math.abs(x - targetX) < 3){
            state = StatePlayers.CHASE;
        }
    }


    public void chooseMode() {

        switch (state) {
            case SCARED:
                scaredState();
                break;
            case EAT:
                eatenState();
                break;
            case START:
                startState();
                break;
            case GET_OUT:
                getOutState();
                break;
            case SCATTER:
                scatterState();
                break;
            case CHASE:
                chaseTarget();
                checkPossibleDirections();
                break;
        }
    }

    public String getImageNameForCurrentState(int animationFrame) {
        switch (this.state) {
            case SCARED:
                return "SCARED_" + animationFrame;
            case EAT:
                return "EAT";

            default:
                switch (direction) {

//                        return name.name() + "_up_" + animationFrame;
                    case DOWN:
//                        return name.name() + "_down_" + animationFrame;
                    case RIGHT:
                        return name.name() + "_right_" + animationFrame;
                    case UP:
                    case LEFT:
                        return name.name() + "_left_" + animationFrame;
                }
        }
        return "";
    }

    @Override
    public void update() {
        chooseMode();
        super.move();
    }

    public void addSpeed() {
        this.speed += 0.04;
        this.lastSpeed = speed;
    }

    public void reduceSpeed(double speed){
        this.speed = speed;
    }

    public void previousSpeed(){
        speed = lastSpeed;
    }

    public double getTargetX() {
        return targetX;
    }

    public double getTargetY() {
        return targetY;
    }
}
