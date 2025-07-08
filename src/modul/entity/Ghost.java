package modul.entity;

import modul.game_board.GameBoard;

import java.util.Random;

public abstract class Ghost extends Entity {

    Pacman pacman;
    double targetX, targetY;


    public Ghost(GameBoard gameBoard, Pacman pacman) {
        super(gameBoard);
        this.pacman = pacman;
        direction = Direction.UP;
    }
    @Override
    public void setState(StateEnum state) {
        this.state = state;
    }

    public abstract void updateTarget();

    public void eatenTarget(){
        targetX = 13;
        targetY = 13;
        if (x == targetX && y == targetY){
            setFirstLocation();
        }
    }


    void checkPossibleDirections() {
        Direction tempDir = null;
        if (Math.abs(lastX - x) >= 1 || Math.abs(lastY - y) >= 1) {
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
            direction = tempDir;
            lastX = x;
            lastY = y;
        }
    }

    void startDirection(){
//        direction = Direction.UP;
        if (!checkPath(direction)){
            direction = Direction.oppositeDirection(direction);
        }
    }

    void getOutDirection(){
        targetX = 13;
        targetY = 13;
    }

    public void eatenState(){
        targetX = 13;
        targetY = 13;
        speed *= 1;
        if (y == targetY && x == targetX){
            setFirstLocation();
            state = StateEnum.GET_OUT;
            speed /= 1;
        }
    }

    void randomDirections() {
        Direction tempDir = null;
        Random random = new Random();
        if (Math.abs(lastX - x) >= 1 || Math.abs(lastY - y) >= 1) {
            for (int i = 0; i < 10; i++) {
                int num = random.nextInt(1, 4);
                switch (num) {
                    case 1:
                        tempDir = Direction.UP;
                        break;
                    case 2:
                        tempDir = Direction.DOWN;
                        break;
                    case 3:
                        tempDir = Direction.RIGHT;
                        break;
                    case 4:
                        tempDir = Direction.LEFT;
                        break;
                }
                if (checkPath(tempDir) && Direction.oppositeDirection(direction) != tempDir){
                    direction = tempDir;
                    return;
                }
            }
        }
    }
    void scaredState(){
        randomDirections();
    }

    void scatterState(){
        updateTarget();
        if (Math.abs(y - targetY) < 3 && Math.abs(x - targetX) < 3){
            state = StateEnum.CHASE;
        }
    }

    @Override
    public void move() {
        if (state == StateEnum.SCARED){
            randomDirections();
        } else if (state == StateEnum.EAT){

        } else if (state == StateEnum.START) {
            startDirection();
        }else if (state == StateEnum.GET_OUT){
            getOutDirection();
        } else {
            checkPossibleDirections();
        }
        super.move();
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
        updateTarget();
        checkPossibleDirections();
        move();
    }

    public double getTargetX() {
        return targetX;
    }

    public double getTargetY() {
        return targetY;
    }
}
