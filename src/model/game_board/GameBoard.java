package model.game_board;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


public class GameBoard {
    tileType[][] gameBoard;
    int write;
    int high;
    int countPellets;
    String directory = "C:\\Users\\User\\code\\pacmen\\src\\model\\game_board\\boards_files\\";
    String filePath;

    public GameBoard(){
        loudBoard();
    }

    public void chooseBoard(){
         filePath = directory + "map02.txt";
    }
    public int getWrite() {
        return write;
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
        GHOSTS_DOOR;

    }

    public void loudBoard(){
        chooseBoard();
        bordFileReader(filePath);

    }

    void checkDimensions(String filePath){
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            int high = 0;
            while ((line = reader.readLine()) != null) {
                int lenLine = line.split("\\s+").length;
                if (lenLine > write) write = lenLine;
                high++;
            }
            this.high = high;
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    void  bordFileReader(String filePath){
        checkDimensions(filePath);
        gameBoard = new tileType[high][write];
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
                            countPellets++;
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
//        this.gameBoard = gameBoard;
    }


    public tileType[][] getGameBoard() {
        return gameBoard;
    }


    public void updateBoard(int y, int x, tileType tileType){
        gameBoard[y][x] = tileType;
    }

    public int getCountPellets() {
        return countPellets;
    }
}
