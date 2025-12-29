package controler.game_Enums;

public enum Direction {
    UP,
    DOWN,
    LEFT,
    RIGHT,
    ENTER,
    FULL;

    public static Direction oppositeDirection(Direction direction) {
        switch (direction) {
            case UP:
                return Direction.DOWN;
            case DOWN:
                return Direction.UP;
            case RIGHT:
                return Direction.LEFT;
            case LEFT:
                return Direction.RIGHT;
        }
        return null;
    }
}



