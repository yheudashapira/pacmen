package model;

import controler.GameLoop;

public class Timers {
    private long timeCounter = 0;

    public int menuCounter = 0;
    public long timerFruits;
    public long timerScatter;
    public long timerScared;
    public long timerEat;
    public long timerNewLevel;
    public long timerGameOver;
    final public long second = GameLoop.getFPS();

    public  long getTimeCounter() {
        return timeCounter;
    }

    public  void setTimeCounter() {
        timeCounter++;
    }
}
