package view.main;

import model.GameManger;

import java.awt.*;

public class GamesStrings {

    GamePanel gp;

    GamesStrings(GamePanel gp){
        this.gp = gp;
    }

    public void printBaseInformation(Graphics2D g2, GameManger gameManger){
        Font font = new Font("ariel", Font.BOLD, 20);
        g2.setFont(font);
        g2.setColor(Color.white);


        String score = "score: " + gameManger.getScore();
        g2.drawString(score, gp.screenWrite /2 - g2.getFontMetrics().stringWidth(score) / 2, 30);
        String level = "level: " + gameManger.getLevel();
        g2.drawString(level, 10, 30);
    }

    public void printGameOver(Graphics2D g2){
        Font font = new Font("david", Font.ITALIC | Font.BOLD, 70);
        g2.setFont(font);
        g2.setColor(Color.yellow);

        String gameOver = "Game Over";
        g2.drawString(gameOver,gp.screenWrite /2 - g2.getFontMetrics().stringWidth(gameOver) / 2 , gp.screenHigte/2);
    }

    public void printReady(Graphics2D g2){
        Font font = new Font("david", Font.ITALIC | Font.BOLD, 30);
        g2.setFont(font);
        g2.setColor(Color.yellow);

        String ready = "ready!";
        g2.drawString(ready,gp.screenWrite /2 - g2.getFontMetrics().stringWidth(ready) / 2 , gp.screenHigte/2+ gp.tileSize*3);
    }

    public void drawString(GameManger gameManger, Graphics2D g2){
        switch (gameManger.getGameState()){
            case READY:
                printReady(g2);
                break;
            case GAME_OVER:
                printGameOver(g2);
                break;
            default:
                printBaseInformation(g2, gameManger);
        }
    }
}
