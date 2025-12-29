package controler;

import controler.game_Enums.Direction;
import model.GameManger;
import model.Timers;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;

public class RecordsEvent implements KeyHandler {

    Timers timers;
    String filePath = "data_base/recordings/recording.txt";

    Queue<String> loadedFile = new LinkedList<>();

    public RecordsEvent(GameManger gameManger) {
        this.timers = gameManger.timers;
        readFile();
    }

    public void readFile() {

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;

            while ((line = reader.readLine()) != null) {
                loadedFile.add(line);

            }
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    @Override
    public Direction newEvent() {
        if (!loadedFile.isEmpty()) {
            long frame = Integer.parseInt(loadedFile.peek().split(",")[0]);
            String direction = loadedFile.peek().split(",")[1];
            if (timers.getTimeCounter() == frame) {
                loadedFile.poll();
                switch (direction) {
                    case "UP":
                        return Direction.UP;
                    case "DOWN":
                        return Direction.DOWN;
                    case "RIGHT":
                        return Direction.RIGHT;
                    case "LEFT":
                        return Direction.LEFT;

                }

            }
        }
        return null;
    }
}
