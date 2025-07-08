package modul.entity;


import modul.game_board.GameBoard;

public class Pacman extends Entity {

    int life = 3;

    final int startX = 14;
    final int startY = 25;

    public Pacman(GameBoard gameBoard) {
        super(gameBoard);
        name = Name.PACMAN;
        speed = 0.10;
        direction = Direction.FULL;

    }

    @Override
    public void update() {
        move();
//        eatPellet();
    }

    @Override
    public void setState(StateEnum state) {

    }
//    @Override
//    public void setDirection(Direction direction) {
//        if (checkPath(direction)) {
//            this.direction = direction;
//        } else if (!checkPath(direction)){
//            this.direction = Direction.FULL;
//        }
//    }


    @Override
    public void setFirstLocation() {

        lastX = x = startX;
        lastY = y = startY;
        direction = Direction.FULL;
    }

    public void loss() {
        if (life > 0) {
            life--;
//            direction = Direction.LOSS;
        }
    }


    public String getImageNameForCurrentState(int animationFrame) {
        if (state == StateEnum.EAT) {
            return "packman_loss";
        }
        if (animationFrame == 3) {
            return "packman_full";
        }

        switch (direction) {
            case UP:
                return "packman_up_" + animationFrame;
            case DOWN:
                return "packman_down_" + animationFrame;
            case LEFT:
                return "packman_left_" + animationFrame;
            case RIGHT:
                return "packman_right_" + animationFrame;
            default:
                return "packman_full";
        }

    }
}
//}



