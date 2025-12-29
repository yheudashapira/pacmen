package model;

import controler.game_Enums.Direction;
import controler.game_Enums.GameState;


public class MainMenu {

    GameManger gameManger;

    public MainMenu(GameManger gameManger){
        this.gameManger = gameManger;
    }
    String[] menu = {"התחל משחק", "התחל משחק עם הקלטה", "הפעל משחקים שמורים", "הוראות", "יציאה"};

    Direction direction;

    int num = 0;

    public int getNum() {
        return num;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }
    public GameState select(){
        switch (direction){
            case UP:
                num = (num - 1 + menu.length) % menu.length;
                direction = null;
                break;
            case DOWN:
                num = (num + 1 + menu.length) % menu.length;

                direction = null;
                break;

        }
        if (direction == Direction.ENTER){
            switch (num){
                case 0:
                    gameManger.setRecording(false);
                    return GameState.READY;
                case 1:
                    gameManger.setRecording(true);
                    return GameState.READY;
                case 2:
                    gameManger.setRecording(false);
                    gameManger.setFromRecording(true);
                    return GameState.READY;
                case 3:
                    break;
                case 4:
                    System.exit(0);
                    break;
            }
        }
        return GameState.MAIN_MENU;
    }




    public String[] getMenu() {
        return menu;
    }


}
