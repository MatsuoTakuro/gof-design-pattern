package facade.pagemaker;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;

public class PageMaker {
  final static String PATH = "src/facade/";

  private PageMaker() {
  }

  public static void makeWelcomePage(String mailAddr, String filename) {
    try {
      Properties mailProp = Database.getProperties(PATH + "maildata");
      String username = mailProp.getProperty(mailAddr);
      HtmlWriter writer = new HtmlWriter(new FileWriter(PATH + filename));
      writer.title(username + "'s web page");
      writer.paragraph("Welcome to " + username + "'s web page!");
      writer.paragraph("Nice to meet you!");
      writer.mailTo(mailAddr, username);
      writer.close();
      System.out.println(filename + " is created for " + mailAddr + " (" + username + ")");
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public static void makeLinkPage(String filename) {
    try {
      HtmlWriter writer = new HtmlWriter(new FileWriter(PATH + filename));
      writer.title("Link page");
      Properties mailProp = Database.getProperties(PATH + "maildata");
      for (String mailAddr: mailProp.stringPropertyNames()) {
        String username = mailProp.getProperty(mailAddr, "(unknown)");
        writer.mailTo(mailAddr, username);
      }
      writer.close();
      System.out.println(filename + "is created.");
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
