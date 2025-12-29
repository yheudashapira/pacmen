package modul;

import controler.game_Enums.Direction;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import java.util.concurrent.CopyOnWriteArrayList;

public class GameRecording {
    List <String> recordList = new CopyOnWriteArrayList<>();

    public void record(Direction event ,long time){
        recordList.add(time + "," + event.name());
    }

    public void writeToTheFile(){
        String folderName = "data_base/recordings";
        String fileName = "recording.txt";
        Path filePath = Paths.get(folderName, fileName);
        try {
            if (!recordList.isEmpty()) {
                Files.write(filePath, recordList, StandardCharsets.UTF_8);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
