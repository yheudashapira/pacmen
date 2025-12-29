package view.main;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class LoudImages {

    Map <String, BufferedImage> images;

    public LoudImages(){
        images = new HashMap<>();
        loud();
    }

    void loud(){
        try {
            images.put("packman_full", ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("../res/packman/packman_full.png"))));
            images.put("packman_up_1", ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("../res/packman/packman_up_1.png"))));
            images.put("packman_up_2", ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("../res/packman/packman_up_2.png"))));
            images.put("packman_down_1", ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("../res/packman/packman_down_1.png"))));
            images.put("packman_down_2", ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("../res/packman/packman_down_2.png"))));
            images.put("packman_left_1", ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("../res/packman/packman_left_1.png"))));
            images.put("packman_left_2", ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("../res/packman/packman_left_2.png"))));
            images.put("packman_right_1", ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("../res/packman/packman_right_1.png"))));
            images.put("packman_right_2", ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("../res/packman/packman_right_2.png"))));
            images.put("packman_loss", ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("../res/packman/packman_right_2.png"))));


            // --- תמונות קלייד (Clyde) ---
            // קלייד משתמש בתמונות right/left גם עבור up/down, כפי שהיה בקוד המקורי שלך.
            images.put("CLYDE_right_1", ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("../res/clyde/clyde_right_1.png"))));
            images.put("CLYDE_right_2", ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("../res/clyde/clyde_right_2.png"))));
            images.put("CLYDE_left_1", ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("../res/clyde/clyde_left_1.png"))));
            images.put("CLYDE_left_2", ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("../res/clyde/clyde_left_2.png"))));


            // --- תמונות בלינקי (Blinky) ---
            images.put("BLINKY_right_1", ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("../res/blinky/blinky_right_1.png"))));
            images.put("BLINKY_right_2", ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("../res/blinky/blinky_right_2.png"))));
            images.put("BLINKY_left_1", ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("../res/blinky/blinky_left_1.png"))));
            images.put("BLINKY_left_2", ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("../res/blinky/blinky_left_2.png"))));


            // --- תמונות אינקי (Inky) ---
            images.put("INKY_right_1", ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("../res/inky/inky_right_1.png"))));
            images.put("INKY_right_2", ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("../res/inky/inky_right_2.png"))));
            images.put("INKY_left_1", ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("../res/inky/inky_left_1.png"))));
            images.put("INKY_left_2", ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("../res/inky/inky_left_2.png"))));


            // --- תמונות פינקי (Pinky) ---
            images.put("PINKY_right_1", ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("../res/pinky/pinky_right_1.png"))));
            images.put("PINKY_right_2", ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("../res/pinky/pinky_right_2.png"))));
            images.put("PINKY_left_1", ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("../res/pinky/pinky_left_1.png"))));
            images.put("PINKY_left_2", ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("../res/pinky/pinky_left_2.png"))));

            images.put("SCARED_1", ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("../res/general/scared_1.png"))));
            images.put("SCARED_2", ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("../res/general/scared_2.png"))));
            images.put("EAT",ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("../res/general/eat.png"))));


            images.put("CHERRY", ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("../res/fruits/cherry.png"))));
            // תות - Strawberry
            images.put("STRAWBERRY", ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("../res/fruits/strawberry.png"))));
            // תפוז - Orange
            images.put("ORANGE", ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("../res/fruits/orange.png"))));
            // תפוח - Apple
            images.put("APPLE", ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("../res/fruits/apple.png"))));
            // מלון - Melon
            images.put("MELON", ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("../res/fruits/melon.png"))));




        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public BufferedImage getImage(String keyName){
        return images.get(keyName);
    }
}
