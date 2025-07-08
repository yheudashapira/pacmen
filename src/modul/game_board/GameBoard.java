package modul.game_board;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


public class GameBoard {
    tileType[][] gameBoard;
    int length = 28;
    int high = 34;

    public GameBoard(){
        bordFileReader("C:\\Users\\User\\code\\pacmen\\src\\modul\\game_board\\boards_files\\map02.txt");
    }
    public int getLength() {
        return length;
    }

    public int getHigh() {
        return high;
    }

    public enum tileType {
        PATH,
        WALL,
        PELLET,
        POWER_PELLET,
        GHOST_HOME,
        EMPTY,
        PACMAN,
        GHOSTS_DOOR;

    }

    void  bordFileReader(String filePath){
        tileType[][] gameBoard = new tileType[34][28];


        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))){
            String line;
            int j = 0;
            while ((line = reader.readLine()) != null){
                String[] arrTiles = line.split("\\s+");
                for (int i = 0; i < arrTiles.length; i++){
                    switch (arrTiles[i]) {
                        case "WALL":
                            gameBoard[j][i] = tileType.WALL;
                            break;
                        case "PATH":
                            gameBoard[j][i] = tileType.PATH;
                            break;
                        case "PELLET":
                            gameBoard[j][i] = tileType.PELLET;
                            break;
                        case "BIG_PELLET":
                            gameBoard[j][i] = tileType.POWER_PELLET;
                            break;
                        case "EMPTY":
                            gameBoard[j][i] = tileType.EMPTY;
                            break;
                        case "GHOSTS_DOOR":
                            gameBoard[j][i] = tileType.GHOSTS_DOOR;
                            break;
                        case "GHOSTS_HOME":
                            gameBoard[j][i] = tileType.GHOST_HOME;
                            break;
                    }
                }
                j++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.gameBoard = gameBoard;
    }


//    tileType[][] gameBoard = {
//                {tileType.EMPTY, tileType.EMPTY, tileType.EMPTY, tileType.EMPTY, tileType.EMPTY, tileType.EMPTY, tileType.EMPTY, tileType.EMPTY, tileType.EMPTY, tileType.EMPTY, tileType.EMPTY, tileType.EMPTY, tileType.EMPTY, tileType.EMPTY, tileType.EMPTY, tileType.EMPTY, tileType.EMPTY, tileType.EMPTY, tileType.EMPTY, tileType.EMPTY, tileType.EMPTY, tileType.EMPTY, tileType.EMPTY, tileType.EMPTY, tileType.EMPTY, tileType.EMPTY, tileType.EMPTY, tileType.EMPTY},
//                {tileType.EMPTY, tileType.EMPTY, tileType.EMPTY, tileType.EMPTY, tileType.EMPTY, tileType.EMPTY, tileType.EMPTY, tileType.EMPTY, tileType.EMPTY, tileType.EMPTY, tileType.EMPTY, tileType.EMPTY, tileType.EMPTY, tileType.EMPTY, tileType.EMPTY, tileType.EMPTY, tileType.EMPTY, tileType.EMPTY, tileType.EMPTY, tileType.EMPTY, tileType.EMPTY, tileType.EMPTY, tileType.EMPTY, tileType.EMPTY, tileType.EMPTY, tileType.EMPTY, tileType.EMPTY, tileType.EMPTY},
//                {tileType.WALL, tileType.WALL, tileType.WALL, tileType.WALL, tileType.WALL, tileType.WALL, tileType.WALL, tileType.WALL, tileType.WALL, tileType.WALL, tileType.WALL, tileType.WALL, tileType.WALL, tileType.WALL, tileType.WALL, tileType.WALL, tileType.WALL, tileType.WALL, tileType.WALL, tileType.WALL, tileType.WALL, tileType.WALL, tileType.WALL, tileType.WALL, tileType.WALL, tileType.WALL, tileType.WALL, tileType.WALL},
//                {tileType.WALL, tileType.PELLET, tileType.PELLET, tileType.PELLET, tileType.PELLET, tileType.PELLET, tileType.PELLET, tileType.PELLET, tileType.PELLET, tileType.PELLET, tileType.PELLET, tileType.PELLET, tileType.PELLET, tileType.WALL, tileType.WALL, tileType.PELLET, tileType.PELLET, tileType.PELLET, tileType.PELLET, tileType.PELLET, tileType.PELLET, tileType.PELLET, tileType.PELLET, tileType.PELLET, tileType.PELLET, tileType.PELLET, tileType.PELLET, tileType.WALL},
//                {tileType.WALL, tileType.PELLET, tileType.WALL, tileType.WALL, tileType.WALL, tileType.WALL, tileType.PELLET, tileType.WALL, tileType.WALL, tileType.WALL, tileType.WALL, tileType.WALL, tileType.PELLET, tileType.WALL, tileType.WALL, tileType.PELLET, tileType.WALL, tileType.WALL, tileType.WALL, tileType.WALL, tileType.WALL, tileType.PELLET, tileType.WALL, tileType.WALL, tileType.WALL, tileType.WALL, tileType.PELLET, tileType.WALL},
//                {tileType.WALL, tileType.POWER_PELLET, tileType.WALL, tileType.WALL, tileType.WALL, tileType.WALL, tileType.PELLET, tileType.WALL, tileType.WALL, tileType.WALL, tileType.WALL, tileType.WALL, tileType.PELLET, tileType.WALL, tileType.WALL, tileType.PELLET, tileType.WALL, tileType.WALL, tileType.WALL, tileType.WALL, tileType.WALL, tileType.PELLET, tileType.WALL, tileType.WALL, tileType.WALL, tileType.WALL, tileType.POWER_PELLET, tileType.WALL},
//                {tileType.WALL, tileType.PELLET, tileType.WALL, tileType.WALL, tileType.WALL, tileType.WALL, tileType.PELLET, tileType.WALL, tileType.WALL, tileType.WALL, tileType.WALL, tileType.WALL, tileType.PELLET, tileType.WALL, tileType.WALL, tileType.PELLET, tileType.WALL, tileType.WALL, tileType.WALL, tileType.WALL, tileType.WALL, tileType.PELLET, tileType.WALL, tileType.WALL, tileType.WALL, tileType.WALL, tileType.PELLET, tileType.WALL},
//                {tileType.WALL, tileType.PACMAN, tileType.PELLET, tileType.PELLET, tileType.PELLET, tileType.PELLET, tileType.PELLET, tileType.PELLET, tileType.PELLET, tileType.PELLET, tileType.PELLET, tileType.PELLET, tileType.PELLET, tileType.PELLET, tileType.PELLET, tileType.PELLET, tileType.PELLET, tileType.PELLET, tileType.PELLET, tileType.PELLET, tileType.PELLET, tileType.PELLET, tileType.PELLET, tileType.PELLET, tileType.PELLET, tileType.PELLET, tileType.PELLET, tileType.WALL},
//                {tileType.WALL, tileType.PELLET, tileType.WALL, tileType.WALL, tileType.WALL, tileType.WALL, tileType.PELLET, tileType.WALL, tileType.WALL, tileType.WALL, tileType.WALL, tileType.WALL, tileType.WALL, tileType.WALL, tileType.WALL, tileType.WALL, tileType.WALL, tileType.WALL, tileType.WALL, tileType.WALL, tileType.WALL, tileType.PELLET, tileType.WALL, tileType.WALL, tileType.WALL, tileType.WALL, tileType.PELLET, tileType.WALL},
//                {tileType.WALL, tileType.PELLET, tileType.WALL, tileType.WALL, tileType.WALL, tileType.WALL, tileType.PELLET, tileType.WALL, tileType.WALL, tileType.WALL, tileType.WALL, tileType.WALL, tileType.WALL, tileType.WALL, tileType.WALL, tileType.WALL, tileType.WALL, tileType.WALL, tileType.WALL, tileType.WALL, tileType.WALL, tileType.PELLET, tileType.WALL, tileType.WALL, tileType.WALL, tileType.WALL, tileType.PELLET, tileType.WALL},
//                {tileType.WALL, tileType.PELLET, tileType.PELLET, tileType.PELLET, tileType.PELLET, tileType.PELLET, tileType.PELLET, tileType.WALL, tileType.WALL, tileType.WALL, tileType.WALL, tileType.WALL, tileType.WALL, tileType.WALL, tileType.WALL, tileType.WALL, tileType.WALL, tileType.WALL, tileType.WALL, tileType.WALL, tileType.WALL, tileType.PELLET, tileType.PELLET, tileType.PELLET, tileType.PELLET, tileType.PELLET, tileType.PELLET, tileType.WALL},
//                {tileType.WALL, tileType.WALL, tileType.WALL, tileType.WALL, tileType.WALL, tileType.WALL, tileType.PELLET, tileType.WALL, tileType.WALL, tileType.WALL, tileType.WALL, tileType.WALL, tileType.WALL, tileType.WALL, tileType.WALL, tileType.WALL, tileType.WALL, tileType.WALL, tileType.WALL, tileType.WALL, tileType.WALL, tileType.PELLET, tileType.WALL, tileType.WALL, tileType.WALL, tileType.WALL, tileType.WALL, tileType.WALL},
//                {tileType.PATH, tileType.PATH, tileType.PATH, tileType.PATH, tileType.PATH, tileType.WALL, tileType.PELLET, tileType.WALL, tileType.WALL, tileType.WALL, tileType.WALL, tileType.WALL, tileType.WALL, tileType.WALL, tileType.WALL, tileType.WALL, tileType.WALL, tileType.WALL, tileType.WALL, tileType.WALL, tileType.WALL, tileType.PELLET, tileType.WALL, tileType.PATH, tileType.PATH, tileType.PATH, tileType.PATH, tileType.PATH},
//                {tileType.PATH, tileType.PATH, tileType.PATH, tileType.PATH, tileType.PATH, tileType.WALL, tileType.PELLET, tileType.WALL, tileType.WALL, tileType.WALL, tileType.WALL, tileType.WALL, tileType.WALL, tileType.WALL, tileType.WALL, tileType.WALL, tileType.WALL, tileType.WALL, tileType.WALL, tileType.WALL, tileType.WALL, tileType.PELLET, tileType.WALL, tileType.PATH, tileType.PATH, tileType.PATH, tileType.PATH, tileType.PATH},
//                {tileType.PATH, tileType.PATH, tileType.PATH, tileType.PATH, tileType.PATH, tileType.WALL, tileType.PELLET, tileType.WALL, tileType.PATH, tileType.PATH, tileType.PATH, tileType.PATH, tileType.PATH, tileType.PATH, tileType.PATH, tileType.PATH, tileType.PATH, tileType.PATH, tileType.PATH, tileType.PATH, tileType.WALL, tileType.PELLET, tileType.WALL, tileType.PATH, tileType.PATH, tileType.PATH, tileType.PATH, tileType.PATH},
//                {tileType.WALL, tileType.WALL, tileType.WALL, tileType.WALL, tileType.WALL, tileType.WALL, tileType.PELLET, tileType.WALL, tileType.PATH, tileType.PATH, tileType.WALL, tileType.WALL, tileType.WALL, tileType.PATH, tileType.PATH, tileType.WALL, tileType.WALL, tileType.WALL, tileType.PATH, tileType.PATH, tileType.WALL, tileType.PELLET, tileType.WALL, tileType.WALL, tileType.WALL, tileType.WALL, tileType.WALL, tileType.WALL},
//                {tileType.PATH, tileType.PATH, tileType.PATH, tileType.PATH, tileType.PATH, tileType.PATH, tileType.PELLET, tileType.PATH, tileType.PATH, tileType.PATH, tileType.WALL, tileType.PATH, tileType.PATH, tileType.PATH, tileType.PATH, tileType.PATH, tileType.PATH, tileType.WALL, tileType.PATH, tileType.PATH, tileType.PATH, tileType.PELLET, tileType.PATH, tileType.PATH, tileType.PATH, tileType.PATH, tileType.PATH, tileType.PATH},
//                {tileType.WALL, tileType.WALL, tileType.WALL, tileType.WALL, tileType.WALL, tileType.WALL, tileType.PELLET, tileType.WALL, tileType.PATH, tileType.PATH, tileType.WALL, tileType.PATH, tileType.PATH, tileType.PATH, tileType.PATH, tileType.PATH, tileType.PATH, tileType.WALL, tileType.WALL, tileType.WALL, tileType.WALL, tileType.PELLET, tileType.WALL, tileType.WALL, tileType.WALL, tileType.WALL, tileType.WALL, tileType.WALL},
//                {tileType.PATH, tileType.PATH, tileType.PATH, tileType.PATH, tileType.PATH, tileType.WALL, tileType.PELLET, tileType.WALL, tileType.PATH, tileType.PATH, tileType.WALL, tileType.WALL, tileType.WALL, tileType.WALL, tileType.WALL, tileType.WALL, tileType.WALL, tileType.WALL, tileType.WALL, tileType.WALL, tileType.WALL, tileType.PELLET, tileType.WALL, tileType.PATH, tileType.PATH, tileType.PATH, tileType.PATH, tileType.PATH},
//                {tileType.PATH, tileType.PATH, tileType.PATH, tileType.PATH, tileType.PATH, tileType.WALL, tileType.PELLET, tileType.WALL, tileType.PATH, tileType.PATH, tileType.PATH, tileType.PATH, tileType.PATH, tileType.PATH, tileType.PATH, tileType.PATH, tileType.PATH, tileType.PATH, tileType.PATH, tileType.PATH, tileType.WALL, tileType.PELLET, tileType.WALL, tileType.PATH, tileType.PATH, tileType.PATH, tileType.PATH, tileType.PATH},
//                {tileType.WALL, tileType.WALL, tileType.WALL, tileType.WALL, tileType.WALL, tileType.WALL, tileType.PELLET, tileType.WALL, tileType.WALL, tileType.WALL, tileType.WALL, tileType.WALL, tileType.WALL, tileType.WALL, tileType.WALL, tileType.WALL, tileType.WALL, tileType.WALL, tileType.WALL, tileType.PATH, tileType.WALL, tileType.PELLET, tileType.WALL, tileType.WALL, tileType.WALL, tileType.WALL, tileType.WALL, tileType.WALL},
//                {tileType.WALL, tileType.PELLET, tileType.PELLET, tileType.PELLET, tileType.PELLET, tileType.PELLET, tileType.PELLET, tileType.WALL, tileType.WALL, tileType.WALL, tileType.WALL, tileType.WALL, tileType.WALL, tileType.WALL, tileType.WALL, tileType.WALL, tileType.WALL, tileType.WALL, tileType.WALL, tileType.WALL, tileType.WALL, tileType.PELLET, tileType.PELLET, tileType.PELLET, tileType.PELLET, tileType.PELLET, tileType.PELLET, tileType.WALL},
//                {tileType.WALL, tileType.PELLET, tileType.WALL, tileType.WALL, tileType.WALL, tileType.WALL, tileType.PELLET, tileType.WALL, tileType.WALL, tileType.WALL, tileType.WALL, tileType.WALL, tileType.WALL, tileType.WALL, tileType.WALL, tileType.WALL, tileType.WALL, tileType.WALL, tileType.WALL, tileType.WALL, tileType.WALL, tileType.PELLET, tileType.WALL, tileType.WALL, tileType.WALL, tileType.WALL, tileType.PELLET, tileType.WALL},
//                {tileType.WALL, tileType.PELLET, tileType.WALL, tileType.WALL, tileType.WALL, tileType.WALL, tileType.PELLET, tileType.WALL, tileType.WALL, tileType.WALL, tileType.WALL, tileType.WALL, tileType.WALL, tileType.WALL, tileType.WALL, tileType.WALL, tileType.WALL, tileType.WALL, tileType.WALL, tileType.WALL, tileType.WALL, tileType.PELLET, tileType.WALL, tileType.WALL, tileType.WALL, tileType.WALL, tileType.PELLET, tileType.WALL},
//                {tileType.WALL, tileType.POWER_PELLET, tileType.PELLET, tileType.PELLET, tileType.WALL, tileType.WALL, tileType.PELLET, tileType.WALL, tileType.WALL, tileType.WALL, tileType.WALL, tileType.WALL, tileType.WALL, tileType.WALL, tileType.WALL, tileType.WALL, tileType.WALL, tileType.WALL, tileType.WALL, tileType.WALL, tileType.WALL, tileType.PELLET, tileType.WALL, tileType.WALL, tileType.PELLET, tileType.PELLET, tileType.POWER_PELLET, tileType.WALL},
//                {tileType.WALL, tileType.WALL, tileType.WALL, tileType.PELLET, tileType.WALL, tileType.WALL, tileType.PELLET, tileType.WALL, tileType.WALL, tileType.WALL, tileType.WALL, tileType.WALL, tileType.WALL, tileType.WALL, tileType.WALL, tileType.WALL, tileType.WALL, tileType.WALL, tileType.WALL, tileType.WALL, tileType.WALL, tileType.PELLET, tileType.WALL, tileType.WALL, tileType.PELLET, tileType.WALL, tileType.WALL, tileType.WALL},
//                {tileType.WALL, tileType.WALL, tileType.WALL, tileType.PELLET, tileType.WALL, tileType.WALL, tileType.PELLET, tileType.WALL, tileType.WALL, tileType.WALL, tileType.WALL, tileType.WALL, tileType.WALL, tileType.WALL, tileType.WALL, tileType.WALL, tileType.WALL, tileType.WALL, tileType.WALL, tileType.WALL, tileType.WALL, tileType.PELLET, tileType.WALL, tileType.WALL, tileType.PELLET, tileType.WALL, tileType.WALL, tileType.WALL},
//                {tileType.WALL, tileType.PELLET, tileType.PELLET, tileType.PELLET, tileType.WALL, tileType.WALL, tileType.PELLET, tileType.WALL, tileType.WALL, tileType.WALL, tileType.WALL, tileType.WALL, tileType.WALL, tileType.WALL, tileType.WALL, tileType.WALL, tileType.WALL, tileType.WALL, tileType.WALL, tileType.WALL, tileType.WALL, tileType.PELLET, tileType.PELLET, tileType.PELLET, tileType.PELLET, tileType.PELLET, tileType.PELLET, tileType.WALL},
//                {tileType.WALL, tileType.PELLET, tileType.WALL, tileType.WALL, tileType.WALL, tileType.WALL, tileType.PELLET, tileType.WALL, tileType.WALL, tileType.WALL, tileType.WALL, tileType.WALL, tileType.WALL, tileType.WALL, tileType.WALL, tileType.WALL, tileType.WALL, tileType.WALL, tileType.WALL, tileType.WALL, tileType.WALL, tileType.PELLET, tileType.WALL, tileType.WALL, tileType.WALL, tileType.WALL, tileType.PELLET, tileType.WALL},
//                {tileType.WALL, tileType.PELLET, tileType.WALL, tileType.WALL, tileType.WALL, tileType.WALL, tileType.PELLET, tileType.WALL, tileType.WALL, tileType.WALL, tileType.WALL, tileType.WALL, tileType.WALL, tileType.WALL, tileType.WALL, tileType.WALL, tileType.WALL, tileType.WALL, tileType.WALL, tileType.WALL, tileType.WALL, tileType.PELLET, tileType.WALL, tileType.WALL, tileType.WALL, tileType.WALL, tileType.PELLET, tileType.WALL},
//                {tileType.WALL, tileType.PELLET, tileType.WALL, tileType.WALL, tileType.WALL, tileType.WALL, tileType.PELLET, tileType.WALL, tileType.WALL, tileType.WALL, tileType.WALL, tileType.WALL, tileType.WALL, tileType.WALL, tileType.WALL, tileType.WALL, tileType.WALL, tileType.WALL, tileType.WALL, tileType.WALL, tileType.WALL, tileType.PELLET, tileType.WALL, tileType.WALL, tileType.WALL, tileType.WALL, tileType.PELLET, tileType.WALL},
//                {tileType.WALL, tileType.PELLET, tileType.PELLET, tileType.PELLET, tileType.PELLET, tileType.PELLET, tileType.PELLET, tileType.PELLET, tileType.PELLET, tileType.PELLET, tileType.PELLET, tileType.PELLET, tileType.PELLET, tileType.PELLET, tileType.PELLET, tileType.PELLET, tileType.PELLET, tileType.PELLET, tileType.PELLET, tileType.PELLET, tileType.PELLET, tileType.PELLET, tileType.PELLET, tileType.PELLET, tileType.PELLET, tileType.PELLET, tileType.PELLET, tileType.WALL},
//                {tileType.WALL, tileType.WALL, tileType.WALL, tileType.WALL, tileType.WALL, tileType.WALL, tileType.WALL, tileType.WALL, tileType.WALL, tileType.WALL, tileType.WALL, tileType.WALL, tileType.WALL, tileType.WALL, tileType.WALL, tileType.WALL, tileType.WALL, tileType.WALL, tileType.WALL, tileType.WALL, tileType.WALL, tileType.WALL, tileType.WALL, tileType.WALL, tileType.WALL, tileType.WALL, tileType.WALL, tileType.WALL}
//        };

    public tileType[][] getGameBoard() {
        return gameBoard;
    }


    public void updateBoard(int y, int x, tileType tileType){
        gameBoard[y][x] = tileType;
    }

}
