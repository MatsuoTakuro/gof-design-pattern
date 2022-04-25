package adapter;

import java.io.IOException;

public class Main2 {
    public static void main(String[] args) {
        FileIO f = new FileProperties();
        try {
            f.readFromFile("src/adapter/file.txt");
            f.setValue("width", "1024");
            f.setValue("height", "512");
            f.setValue("depth", "32");
            f.writeToFile("src/adapter/new.text");
            System.out.println("new.text is created.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
