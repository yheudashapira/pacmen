package view.main;


import controler.KeyHandler;
import modul.entity.Entity;

import java.awt.*;

public class DrawCharacter extends Character {


    Entity entity;
    GamePanel gp;
    KeyHandler keyH;
    LoudImages images;


    public DrawCharacter(GamePanel gp, KeyHandler keyH) {
        this.gp = gp;
        this.keyH = keyH;
        this.images = new LoudImages();

    }

    public void setDefaultValues() {

        x = (int) (gp.tileSize * entity.getX());
        y = (int) (gp.tileSize * entity.getY());

    }

    public void update(Entity entity) {
        this.entity = entity;
        setDefaultValues();
    }

    void moveImages() {
        SpriteCounter.counter++;
        if (SpriteCounter.counter > 30) {
            if (SpriteCounter.num == 1) {
                SpriteCounter.num = 2;
            } else if (SpriteCounter.num == 2) {
                SpriteCounter.num = 1;
            }

            SpriteCounter.counter = 0;

        }
    }



    public void draw(Graphics2D g2) {
        moveImages();


        g2.drawImage(images.getImage(entity.getImageNameForCurrentState(SpriteCounter.num)), x, y, gp.tileSize, gp.tileSize, null);
    }

}

