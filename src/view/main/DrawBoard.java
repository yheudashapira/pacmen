package view.main;

import modul.entity.Pacman;
import modul.game_board.GameBoard;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Objects;

public class DrawBoard {

    BufferedImage wall, pellet, powerPellet, empty, ghostsDoor;

    GamePanel gp;
    GamesStrings gamesStrings;


    public DrawBoard(GamePanel gp){
        this.gp = gp;
        this.gamesStrings = new GamesStrings(gp);

        getBoardImages();

    }

    public void getBoardImages(){

        try {
            wall = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("..\\res/general/wall.png")));
            pellet = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("..\\res/general/currency.png")));
            powerPellet = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("..\\res/general/bonus.png")));
            empty = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("..\\res/general/empty.png")));
            ghostsDoor = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("..\\res/general/ghosts_door.png")));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void loudMap(Graphics2D g2, GameBoard.tileType[][] gameBoard, Pacman pacman){
        int y = 0;
        for (int row = 0; row < gameBoard.length; row++) {
            int x = 0;
            for (int col = 0; col < gameBoard[row].length; col++) {
                // הדפסת תו ראשוני שמייצג את סוג האריח
                // (תוכלו לשפר את זה לגרפיקה בפועל)
                switch (gameBoard[row][col]) {
                    case WALL:
                        g2.drawImage(wall, x, y, gp.tileSize, gp.tileSize, null);// קיר
                        break;
                    case PATH:
                        g2.drawImage(empty, x, y, gp.tileSize, gp.tileSize, null); // שביל ריק
                        break;
                    case PELLET:
                        g2.drawImage(pellet, x, y, gp.tileSize, gp.tileSize, null); // נקודה
                        break;
                    case POWER_PELLET:
                        g2.drawImage(powerPellet, x, y, gp.tileSize, gp.tileSize, null); // נקודה גדולה
                        break;
                    case GHOSTS_DOOR:
                        g2.drawImage(ghostsDoor,x, y, gp.tileSize, gp.tileSize, null);
                        break;
                    case GHOST_HOME:
//                        g2.drawImage(ghostsDoor,x, y, gp.tileSize, gp.tileSize, null);
//                        g2.fillRect(x, y, gp.tileSize, gp.tileSize);
                        break;
                }
                x += gp.tileSize;
            }
            y += gp.tileSize;
        }
//        gamesStrings.printBaseInformation(g2, .getScore());
//        gamesStrings.printGameOver(g2);
    }
}
