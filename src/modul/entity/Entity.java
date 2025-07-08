package modul.entity;

import modul.game_board.GameBoard;


public abstract class Entity {

    Name name;
    Direction direction = Direction.RIGHT;
    StateEnum state = StateEnum.START;

    double x, y, lastX, lastY, nextX, nextY;
    public double speed = 0.04;
    int startY;
    int startX;
    Timers timers = new Timers();
    long time;

    public void setTime(long time) {
        this.time = time;
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

    public Name getName() {
        return name;
    }

    void setFirstLocation() {
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
            nextY -= speed;
            nextY = Math.round(nextY * 1000.0) / 1000.0;
//            x =  Math.round(x);
        } else if (direction == Direction.DOWN) {
            nextY += speed;
            nextY = Math.round(nextY * 1000.0) / 1000.0;
//            x =  Math.round(x);
        } else if (direction == Direction.RIGHT) {
            nextX = (x + speed) % gameBoard.getLength();
            nextX = Math.round(nextX * 1000.0) / 1000.0;
//            y =  Math.round(y);
        } else if (direction == Direction.LEFT) {
            nextX = (x - speed + gameBoard.getLength()) % gameBoard.getLength();
            nextX = Math.round(nextX * 1000.0) / 1000.0;
//            y =  Math.round(y);
        }
        if (checkPath(this.direction)) {
            x = nextX;
            y = nextY;
        }
    }


    public abstract void update();

    public abstract void setState(StateEnum state);

    public boolean checkPath(Direction direction){
        if (direction == Direction.RIGHT) {
            if (gameBoard.getGameBoard()[(int) y][(int) (x + 1) % gameBoard.getLength()] != GameBoard.tileType.WALL) {
                return true;
            }
        }
        else if (direction == Direction.LEFT){
            if (gameBoard.getGameBoard()[(int) (y)][(int) ((x - speed)% gameBoard.getLength())] != GameBoard.tileType.WALL) {
                return true;
            }
        }
        else if(direction == Direction.UP){
            if (gameBoard.getGameBoard()[(int) (y - speed)][(int) x] != GameBoard.tileType.WALL) {
                return true;
            }
        }
        else if (direction == Direction.DOWN){
            if (gameBoard.getGameBoard()[(int) (y + 1)][(int) x] != GameBoard.tileType.WALL
                    && gameBoard.getGameBoard()[(int) (y + 1)][(int) x] != GameBoard.tileType.GHOSTS_DOOR) {
                return true;
            }
        }
        return false;
    }
}
