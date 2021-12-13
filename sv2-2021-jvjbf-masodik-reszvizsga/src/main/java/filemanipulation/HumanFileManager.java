package filemanipulation;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class HumanFileManager {
    private final List<Human> humans = new ArrayList<>();

    public List<Human> getHumans() {
        return humans;
    }

    public void readHumansFromFile(Path path) {
        try {
            List<String> allLines = Files.readAllLines(path);
            for (String record : allLines) {
                addHumanFromLineString(record);
            }
        } catch (IOException ioe) {
            throw new IllegalStateException("Can't read file!", ioe);
        }
    }
    

    public void writeMaleHumansToFile(Path path) {
        try {
            List<String> linesList = getMaleLines();
            Files.write(path, linesList);
        } catch (IOException ioe) {
            throw new IllegalStateException("Can't write file!"+path, ioe);
        }
    }

    private void addHumanFromLineString(String line) {
        String[] parts = line.split(";");
        humans.add(new Human(parts[0], parts[1]));
    }

    private List<String> getMaleLines() {
        List<String> lines = new ArrayList<>();
        for (Human human : humans) {
            if (isHumanMale(human)) {
                lines.add(human.getName() + ";" + human.getIdentityNumber());
            }
        }
        return lines;
    }
    

    private boolean isHumanMale(Human human) {
        char firstChar = human.getIdentityNumber().charAt(0);
        if(firstChar=='1' || firstChar=='3'){
            return true;
        }
        return false;
    }
}
