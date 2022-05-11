package builder;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        if (args.length != 1) {
            usage();
            System.exit(0);
        }

        switch (args[0]) {
            case "text":
                TextBuilder textBuilder = new TextBuilder();
                Director textDirector = new Director(textBuilder);
                textDirector.construct();
                String result = textBuilder.getTextResult();
                System.out.println(result);
                break;
            case "html":
                HTMLBuilder htmlBuilder = new HTMLBuilder();
                Director htmlDirector = new Director(htmlBuilder);
                htmlDirector.construct();
                String filename = htmlBuilder.getHTMLResult();
                System.out.println("html file: " + filename + " was created.");
                break;
            case "frame":
                FrameBuilder frameBuilder = new FrameBuilder();
                Director frameDirector = new Director(frameBuilder);
                frameDirector.construct();
                JFrame frame = frameBuilder.getFrameResult();
                frame.setVisible(true);
                break;
            default:
                usage();
                System.exit(0);
        }
    }


    public static void usage() {
        System.out.println("Usage: java Main 'text'  create a doc in plain text");
        System.out.println("Usage: java Main 'html'  create a doc in html file");
    }
}
