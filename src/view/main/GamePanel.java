package view.main;

import controler.KeyHandler;
import modul.GameManger;
import modul.entity.Entity;
import modul.entity.Pacman;
import modul.game_board.GameBoard;


import javax.swing.*;
import java.awt.*;
import java.util.List;

public class GamePanel extends JPanel {

    final public int tileSize = 20;

    JFrame window = new JFrame();


    void createWindow(KeyHandler keyH) {

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


    DrawCharacter drawCharacter;
    DrawBoard drawBoard;
    GameBoard.tileType[][] gameBoard;
    List<Entity> entitys;

    final int screenWrite;
    final int screenHigte;

    public GamePanel(GameManger gameManger, KeyHandler keyH) {
        this.gameBoard = gameManger.gameBoard.getGameBoard();
        this.entitys = gameManger.entities;
        this.drawBoard = new DrawBoard(this);
        this.drawCharacter = new DrawCharacter(this, keyH);
        this.screenWrite = tileSize * this.gameBoard[0].length;
        this.screenHigte = tileSize * this.gameBoard.length;

        createWindow(keyH);
    }


    public void paintComponent(Graphics g) {

        Graphics2D g2 = (Graphics2D) g;

        super.paintComponent(g);
        drawBoard.loudMap(g2, this.gameBoard, (Pacman) entitys.get(0));

        for (Entity entity : entitys) {
            drawCharacter.update(entity);
            drawCharacter.draw(g2);
        }

        g2.dispose();
    }
}
