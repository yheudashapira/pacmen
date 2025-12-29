package model.entity;

import model.game_board.GameBoard;

public class Inky extends Ghost {

    Ghost blinky;

    public Inky(GameBoard gameBoard, Pacman pacman, Ghost blinky) {
        super(gameBoard, pacman);
        startX = 16;
        startY = 17;
        setFirstLocation();
        name = Names.INKY;
        this.blinky = blinky;
    }

    @Override
    public void chaseTarget() {
        double tempX = 0;
        double tempY = 0;

        switch (pacman.direction) {
            case UP:
                tempX = pacman.x - 2;
                tempY = pacman.y - 2;
                break;
            case DOWN:
                tempX = pacman.x;
                tempY = pacman.y + 2;
                break;
            case RIGHT:
                tempX = (pacman.x + 2) % gameBoard.getWrite();
                tempY = pacman.y;
                break;
            case LEFT:
                tempX = (pacman.x - 2 + gameBoard.getWrite()) % gameBoard.getWrite();
                tempY = pacman.y;
                break;
        }
        targetX = (int) tempX + (tempX - blinky.x);
        targetY = (int) tempY + (tempY - blinky.y);
    }

    @Override
    public void scatterTarget() {
        targetX = 27;
        targetY = 33;
    }


//    void setFirstLocation() {
//        this.x = 12;
//        this.y = 17;
//        lastX = nextX = x;
//        lastY = nextY = y;
//
//    }
}
