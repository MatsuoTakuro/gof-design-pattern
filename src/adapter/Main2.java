package adapter;

import java.io.IOException;

public class Main2 {
    public static void main(String[] args) {
        FileIO f = new FileProperties();
        try {
            f.readFromFile("src/adapter/file.txt");
            System.out.println(f.getValue("width"));
            f.setValue("width", "1024");
            System.out.println(f.getValue("width"));
            f.setValue("height", "512");
            System.out.println(f.getValue("height"));
            f.setValue("depth", "32");
            System.out.println(f.getValue("depth"));
            f.writeToFile("src/adapter/new.text");
            System.out.println("new.text is created.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
