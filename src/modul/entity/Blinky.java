package modul.entity;

import modul.game_board.GameBoard;

public class Blinky extends Ghost {


    public Blinky(GameBoard gameBoard, Pacman pacman) {
        super(gameBoard, pacman);
        name = Name.BLINKY;
        direction = Direction.UP;
        startX = 13;
        startY = 13;

    }

    @Override
    public void updateTarget() {
        switch (state) {
            case SCATTER:
                targetX = 27;
                targetY = 2;
                break;
            case CHASE:
                targetX = pacman.x;
                targetY = pacman.y;
                break;
        }
    }


    @Override
    void setFirstLocation() {
        this.x = startX;
        this.y = startY;
        lastX = nextX = x;
        lastY = nextY = y;

    }
}
