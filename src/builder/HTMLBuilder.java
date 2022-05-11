package builder;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class HTMLBuilder implements Builder {
    private final String dir = "/Users/user/training/java/gof-design-patterns/src/builder/";
    private String filename = "untitled.html";
    private final StringBuilder sb = new StringBuilder();


    @Override
    public void makeTitle(String title) {
        filename = title + ".html";
        sb.append("<!DOCTYPE html>\n");
        sb.append("<html>\n");
        sb.append("<head><title>");
        sb.append(title);
        sb.append("</title></head>\n");
        sb.append("<body>\n");
        sb.append("<h1>");
        sb.append(title);
        sb.append("</h1>\n\n");
    }

    @Override
    public void makeString(String str) {
        sb.append("<p>");
        sb.append(str);
        sb.append("</p>\n\n");
    }

    @Override
    public void makeItems(String[] items) {
        sb.append("<ul>\n");
        for (String s: items) {
            sb.append("<li>");
            sb.append(s);
            sb.append("</li>\n");
        }
        sb.append("</ul>\n\n");
    }

    @Override
    public void close() {
        sb.append("</body>");
        sb.append("</html>\n");
        try {
            File file = new File(dir, filename);
            Writer writer = new FileWriter(file);
            writer.write(sb.toString());
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getHTMLResult() {
        return filename;
    }
}
