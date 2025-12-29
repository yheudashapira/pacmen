package view.main;

import model.GameManger;
import model.MainMenu;


import java.awt.*;


public class DrawMenu {

    GamePanel gp;
    GameManger gameManger;
    MainMenu mainMenu ;
    int size = 30;
    String[] stringsMenu;


    public DrawMenu(GamePanel gp, GameManger gameManger) {
        this.gameManger = gameManger;
        this.gp = gp;
        this.mainMenu = gameManger.mainMenu;
        stringsMenu = mainMenu.getMenu();
    }

//    BufferedImage circle;
//
//    {
//        try {
//            circle = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("../res/general/circle.png")));
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//    }

    void printMenu(Graphics2D g2){
        Font font = new Font("ariel", Font.BOLD, size);
        g2.setFont(font);
        g2.setColor(Color.white);
        int y = 2;
        for (int i = 0; i < stringsMenu.length; i++) {
            String thisStr = stringsMenu[i];
            g2.drawString(thisStr, gp.screenWrite / 2 - g2.getFontMetrics().stringWidth(thisStr) / 2, size * y);
            y += 2;

        }
            g2.setColor(Color.yellow);
            g2.drawString(">",(gp.screenWrite / 2 - g2.getFontMetrics().stringWidth(stringsMenu[mainMenu.getNum()]) / 2) - 30, size * (mainMenu.getNum()+1)*2 );
    }
}
