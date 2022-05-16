package bridge.impl;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileDisplayImpl extends DisplayImpl {
    private static final Path baseDir = Paths.get("/Users/user/training/java/gof-design-patterns/src/bridge");
    private final String filename;

    public FileDisplayImpl(final String filename) {
        this.filename = filename;
    }

    @Override
    public void rawOpen() {
        System.out.println("=-=-=-=-=-= " + filename +  " =-=-=-=-=-=");
    }

    @Override
    public void rawPrint() {
        try {
            for (final String line : Files.readAllLines(filePath())) {
                System.out.print("> ");
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void rawClose() {
        System.out.println("=-=-=-=-=-==-=-=-=-=-==-=-=-=-=");
    }

    private Path filePath() {
        return Paths.get(String.valueOf(baseDir), filename);
    }

}
