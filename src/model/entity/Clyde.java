package model.entity;

import controler.game_Enums.Direction;
import controler.game_Enums.StatePlayers;
import model.game_board.GameBoard;

public class Clyde extends Ghost {

    public Clyde(GameBoard gameBoard, Pacman pacman) {
        super(gameBoard, pacman);
        name = Names.CLYDE;
        direction = Direction.UP;
        startX = 11;
        startY = 17;
        setFirstLocation();
    }

    @Override
    public void chaseTarget() {

        if (Math.abs(x - pacman.x) > 8 || Math.abs(y - pacman.y) > 8) {
            targetX = pacman.x;
            targetY = pacman.y;
        } else {
            state = StatePlayers.SCATTER;
        }
    }

    @Override
    public void scatterTarget() {
        targetX = 0;
        targetY = 33;
    }
}




