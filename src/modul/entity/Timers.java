package modul.entity;

import controler.GameLoop;

public class Timers {
    public long timerGetOut;
    public long timerScatter;
    public long timerScared;
    public long timerEat;
    final public long second = GameLoop.getFPS();
}
