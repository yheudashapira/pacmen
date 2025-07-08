package view.main;

import java.awt.*;

public class GamesStrings {

    GamePanel gp;

    GamesStrings(GamePanel gp){
        this.gp = gp;
    }

    public void printBaseInformation(Graphics2D g2, int points){
        Font font = new Font("ariel", Font.BOLD, 20);
        g2.setFont(font);
        g2.setColor(Color.white);


        String score = "score: " + points;
        g2.drawString(score, 10, 30);
    }

    public void printGameOver(Graphics2D g2){
        Font font = new Font("david", Font.ITALIC | Font.BOLD, 70);
        g2.setFont(font);
        g2.setColor(Color.yellow);

        String gameOver = "Game Over";
        g2.drawString(gameOver,gp.screenWrite /2 - g2.getFontMetrics().stringWidth(gameOver) / 2 , gp.screenHigte/2);
    }
}
