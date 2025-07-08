package controler;

import modul.GameManger;

import view.main.GamePanel;


public class GameLoop implements Runnable {


    KeyHandler keyH = new KeyHandler();
    GameManger gameManger = new GameManger();
    GamePanel gamePanel = new GamePanel(gameManger, keyH);



    Thread gameThread;

    GameLoop() {

//        movements = new Movements(pacman, keyH, gameBoard);
        startGemaThread();
    }

    public void startGemaThread() {

        gameThread = new Thread(this);
        gameThread.start();
    }


    static int FPS = 30;

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


//                System.out.println("pacman X Y " + pacman.x + " " + pacman.y);
//                System.out.println("clyde X Y " + clyde.x + " " + clyde.y);
//                System.out.println("blinky X Y " + blinky.x + " " + blinky.y);
//                System.out.println(timeCounter);
//                try {
//                    Thread.sleep(1);
//                } catch (InterruptedException e) {
//                    throw new RuntimeException(e);
//                }
//                SpriteCounter.counter++;
                delta--;
            }
//            long remainingTime = (long) (drawInterval - (System.nanoTime() - lastTime) - (delta * drawInterval));
//            if (remainingTime > 0) { // אם נשאר זמן עד לטיק הבא
//                long sleepMillis = remainingTime / 1_000_000; // המר לננו-שניות למילי-שניות
//                int sleepNanos = (int) (remainingTime % 1_000_000); // השארית בננו-שניות
//                try {
//                    Thread.sleep(sleepMillis, sleepNanos);
//                } catch (InterruptedException e) {
//                    Thread.currentThread().interrupt();
//                    System.err.println("Game loop interrupted!");
//                    break;
//                }
//            }
        }
    }

    void update(){
        gameManger.pacman.setDirection(keyH.newEvent());
        gameManger.update();
    }
}
