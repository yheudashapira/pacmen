package controler;

import controler.game_Enums.Direction;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyBoardsEvent implements KeyListener ,KeyHandler{

    public boolean upPressed, downPressed, leftPress, rightPressed, enterPressed;

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {

        int code = e.getKeyCode();

        if (code == KeyEvent.VK_DOWN){
            downPressed = true;
        }if (code == KeyEvent.VK_UP){
            upPressed = true;
        }if (code == KeyEvent.VK_LEFT){
            leftPress = true;
        }if (code == KeyEvent.VK_RIGHT){
            rightPressed = true;
        } if (code == KeyEvent.VK_ENTER){
            enterPressed = true;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

        int code = e.getKeyCode();

        if (code == KeyEvent.VK_DOWN){
            downPressed = false;
        }if (code == KeyEvent.VK_UP){
            upPressed = false;
        }if (code == KeyEvent.VK_LEFT){
            leftPress = false;
        }if (code == KeyEvent.VK_RIGHT){
            rightPressed = false;
        }if (code == KeyEvent.VK_ENTER){
            enterPressed = false;
        }

    }

    public Direction newEvent(){
        if (upPressed) {
            return (Direction.UP);
        }
        else if (downPressed){
            return (Direction.DOWN);
        }
        else if (rightPressed){
            return (Direction.RIGHT);
        }
        else if (leftPress){
           return (Direction.LEFT);
        }
        else if (enterPressed){
            return (Direction.ENTER);
        }
        return null;

    }

}
