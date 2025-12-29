package modul.entity;

import controler.game_Enums.Direction;
import modul.game_board.GameBoard;

public class Blinky extends Ghost {


    public Blinky(GameBoard gameBoard, Pacman pacman) {
        super(gameBoard, pacman);
        name = Names.BLINKY;
        direction = Direction.UP;
        startX = 15;
        startY = 17;
        setFirstLocation();

    }

    @Override
    public void chaseTarget() {
        targetX = pacman.getX();
        targetY = pacman.getY();

    }

    @Override
    public void scatterTarget() {
        targetX = 27;
        targetY = 2;
    }


//    @Override
//    void setFirstLocation() {
//        this.x = startX;
//        this.y = startY;
//        lastX = nextX = x;
//        lastY = nextY = y;
//
//    }
}
