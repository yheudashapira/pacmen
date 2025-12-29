package view.main;

import controler.KeyBoardsEvent;
import model.GameManger;
import model.entity.Entity;
import model.entity.Pacman;
import model.game_board.GameBoard;


import javax.swing.*;
import java.awt.*;
import java.util.List;

public class GamePanel extends JPanel {

    final public int tileSize = 20;

    JFrame window = new JFrame();


    void createWindow(KeyBoardsEvent keyH) {

        this.setPreferredSize(new Dimension(screenWrite, screenHigte));
        this.setBackground(Color.black);
        this.setDoubleBuffered(true);
        this.addKeyListener(keyH);
        this.setFocusable(true);

        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(false);
        window.setTitle("pacman");

        window.add(this);

        window.pack();

        window.setLocationRelativeTo(null);
        window.setVisible(true);
    }

    GameManger gameManger;
    DrawCharacter drawCharacter;
    DrawBoard drawBoard;
    GameBoard gameBoard;
    DrawMenu drawMenu;
    List<Entity> entitys;


    final int screenWrite;
    final int screenHigte;

    public GamePanel(GameManger gameManger, KeyBoardsEvent keyH) {
        this.gameManger = gameManger;
        this.gameBoard = gameManger.gameBoard;
        this.entitys = gameManger.entities;
        this.drawBoard = new DrawBoard(this, gameManger);
        this.drawCharacter = new DrawCharacter(this);
        this.drawMenu = new DrawMenu(this, gameManger);
        this.screenWrite = tileSize * this.gameBoard.getWrite();
        this.screenHigte = tileSize * this.gameBoard.getHigh();

        createWindow(keyH);
    }


    public void paintComponent(Graphics g) {

        Graphics2D g2 = (Graphics2D) g;

        super.paintComponent(g);

        switch (gameManger.getGameState()) {
            case MAIN_MENU:
                drawMenu.printMenu(g2);
                break;
            default:

                drawBoard.loudMap(g2, this.gameBoard.getGameBoard());

                if (gameManger.isTheirFruit()) {
                    drawCharacter.draw(g2, gameManger);
                    System.out.println(gameManger.getFruit().getName() + "rrrrrrrrrrrrrrrrrrrrrrr");
                }
                for (Entity entity : entitys) {
                    drawCharacter.update(entity);
                    drawCharacter.draw(g2);
                }

                g2.dispose();
        }
    }
}
