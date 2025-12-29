package modul.entity;

import modul.game_board.GameBoard;

public class Pinky extends Ghost {

    public Pinky(GameBoard gameBoard, Pacman pacman) {
        super(gameBoard, pacman);
        name = Names.PINKY;
        startX = 12;
        startY = 17;
        setFirstLocation();
    }

    @Override
    public void chaseTarget() {

        switch (pacman.direction) {
            case UP:
                targetX = pacman.x - 4;
                targetY = pacman.y - 4;
                break;
            case DOWN:
                targetX = pacman.x;
                targetY = pacman.y + 4;
                break;
            case RIGHT:
                targetX = (pacman.x + 4) % gameBoard.getWrite();
                targetY = pacman.y;
                break;
            case LEFT:
                targetX = (pacman.x - 4 + gameBoard.getWrite()) % gameBoard.getWrite();
                targetY = pacman.y;
                break;
        }


    }

    @Override
    public void scatterTarget() {
        targetX = 0;
        targetY = 2;
    }


}
