package controler;

import model.GameManger;
import view.main.GamePanel;


public class GameLoop implements Runnable {


    GameManger gameManger = new GameManger();
    KeyHandler keyH = new KeyBoardsEvent();
    GamePanel gamePanel = new GamePanel(gameManger, (KeyBoardsEvent) keyH);
    
    Thread gameThread;

    public void startGameThread() {

        gameThread = new Thread(this);
        gameThread.start();
    }


    final static int FPS = 30;

    public static int getFPS() {
        return FPS;
    }

    public void run() {
        double drawInterval = (double) 1000000000 / FPS;
        double delta = 0;
        long lastTime = System.nanoTime();
        long currentTime;

        while (gameThread != null) {

            currentTime = System.nanoTime();
            delta += (currentTime - lastTime) / drawInterval;
            lastTime = currentTime;

            if (delta >= 1) {
                update();
                gamePanel.repaint();

                delta--;
            }
        }
    }

    void update() {
        if (gameManger.isFromRecording()) {
            keyH = new RecordsEvent(gameManger);
            gameManger.setFromRecording(false);
        }
        gameManger.directionEvent(keyH.newEvent());

        gameManger.update();
    }


}
