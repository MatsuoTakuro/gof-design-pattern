package abstract_factory.factory;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;

public abstract class Page {
    private static final Path baseDir = Paths.get("/Users/user/training/java/gof-design-patterns/src/abstract_factory");
    protected String title;
    protected String author;
    protected List<Item> content = new ArrayList<>();

    public Page(String title, String author) {
        this.title = title;
        this.author = author;
    }

    public void add(Item item) {
        content.add(item);
    }

    public void output(String filename) {
        try {
            Files.writeString(Path.of(filePath(filename)), makeHTML(),
                    StandardOpenOption.CREATE,
                    StandardOpenOption.TRUNCATE_EXISTING,
                    StandardOpenOption.WRITE);
            System.out.println(filename + " was created.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public abstract String makeHTML();

    private String filePath(String filename) {
        return Paths.get(String.valueOf(baseDir), filename).toString();
    }
}