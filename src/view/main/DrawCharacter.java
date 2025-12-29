package view.main;

import model.GameManger;
import model.entity.Entity;

import java.awt.*;

public class DrawCharacter  {

    public int x, y;
    Entity entity;
    GamePanel gp;

    LoudImages images;


    public DrawCharacter(GamePanel gp) {
        this.gp = gp;
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

    public void draw(Graphics2D g2, GameManger gameManger){
        g2.drawImage(images.getImage(gameManger.getFruit().getName()),gameManger.getFruit().getX() * gp.tileSize, gameManger.getFruit().getY()* gp.tileSize,gp.tileSize, gp.tileSize, null);
    }

}

