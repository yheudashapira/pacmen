package modul.entity;

import modul.game_board.GameBoard;

public class Pinky extends Ghost {

    public Pinky(GameBoard gameBoard, Pacman pacman) {
        super(gameBoard, pacman);
        name = Name.PINKY;
        startX = 12;
        startY = 17;
    }

    @Override
    public void updateTarget() {
        switch (state) {
            case SCATTER:
                targetX = 0;
                targetY = 2;
                break;
            case CHASE:
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
                        targetX = (pacman.x + 4) % gameBoard.getLength();
                        targetY = pacman.y;
                        break;
                    case LEFT:
                        targetX = (pacman.x - 4 + gameBoard.getLength()) % gameBoard.getLength();
                        targetY = pacman.y;
                        break;
                }
                break;
        }


    }



}
