package modul;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;


public class HighScores {

    List<String> scoresArr = new ArrayList<>(1);
    String folderName = "data_base";
    String fileName = "high_scores.txt";

    Path filePath = Paths.get(folderName, fileName);


    public void raedFile() {

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath.toFile()))) {
            String line;

            while ((line = reader.readLine()) != null) {
                scoresArr.add(line);

            }
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    public void collocateScore(int score) {
        raedFile();
        if (scoresArr.isEmpty()) {
            scoresArr.add(playerName(1) + score);
            writeToTheFile();
            return;
        }
        if (scoresArr.size() == 1) {
            if (score > Integer.parseInt(scoresArr.getFirst().split(",")[2])) {
                scoresArr.addFirst(playerName(1) + score);
            } else {
                scoresArr.add(playerName(2) + score);
            }
            writeToTheFile();
        } else {
            int i = 0;
            for (; i < scoresArr.size(); i++) {
                if (score > Integer.parseInt(scoresArr.get(i).split(",")[2])) {
                    scoresArr.add(i, playerName(i + 1) + score);
                    if (scoresArr.size() > 11){
                        scoresArr.removeLast();
                    }
                    writeToTheFile();
                    return;
                }
            }
            if (scoresArr.size() < 11){
                scoresArr.add(i, playerName(i + 1) + score);
                writeToTheFile();
            }
        }
        System.out.println("התווסף לקובץ שיאים");
    }

    public void writeToTheFile(){
        try {
            Files.write(filePath, scoresArr, StandardCharsets.UTF_8);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String playerName(int high) {
        String name = "";
        LocalDateTime currentDateTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss dd-MM-yyyy");
        String formattedDateTime = currentDateTime.format(formatter);
        return  name + "," + formattedDateTime + ",";
    }
}
