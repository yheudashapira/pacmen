package modul;

import java.util.LinkedList;
import java.util.Queue;

public class Fruits {

    int value;
    fruits name;
    boolean isTheirFruit;
    int x;
    int y;

    public Fruits(){}
    public Fruits(fruits name, int value){
        this.name = name;
        this.value = value;
        x= 15;
        y = 19;
    }
    public enum fruits{
        CHERRY,
        STRAWBERRY,
        ORANGE,
        APPLE,
        MELON
    }

    public String getName() {
        return name.name();
    }

    public int getValue() {
        return value;
    }
    public Queue<Fruits> createFruitsList() {

        Queue <Fruits>fruitsList = new LinkedList<>();
        fruitsList.add(new Fruits(Fruits.fruits.CHERRY, 100));
        fruitsList.add(new Fruits(Fruits.fruits.STRAWBERRY, 300));
        fruitsList.add(new Fruits(Fruits.fruits.ORANGE, 500));
        fruitsList.add(new Fruits(Fruits.fruits.APPLE, 700));
        fruitsList.add(new Fruits(Fruits.fruits.MELON, 1000));
        return fruitsList;
    }

    public void addFruit(){
        isTheirFruit = true;
    }
    public void removeFruit(){
        isTheirFruit = false;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
