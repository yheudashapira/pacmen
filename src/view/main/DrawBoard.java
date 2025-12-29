package view.main;

import model.GameManger;
//import model.entity.Pacman;
import model.game_board.GameBoard;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Objects;

public class DrawBoard {

    BufferedImage wall, pellet, powerPellet, empty, ghostsDoor, pacmansImage;

    GamePanel gp;
    GamesStrings gamesStrings;
    GameManger gameManger;


    public DrawBoard(GamePanel gp, GameManger gameManger){
        this.gameManger = gameManger;
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
            pacmansImage = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("..\\res/packman/packman_right_1.png")));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void loudMap(Graphics2D g2, GameBoard.tileType[][] gameBoard){
        int y = 0;
        int x = 0;
        for (int row = 0; row < gameBoard.length; row++) {
            x = 0;
            for (int col = 0; col < gameBoard[row].length; col++) {
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

        for (int i = 0; i < gameManger.getPacmansLife(); i++) {
            g2.drawImage(pacmansImage, gp.tileSize*i, y - gp.tileSize, gp.tileSize, gp.tileSize, null);
        }
        gamesStrings.drawString(gameManger, g2);
    }
}
