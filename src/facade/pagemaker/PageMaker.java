package facade.pagemaker;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;

public class PageMaker {
  private PageMaker() {
  }

  public static void makeWelcomePage(String mailAddr, String filename) {
    try {
      Properties mailProp = Database.getProperties("src/facade/maildata");
      String username = mailProp.getProperty(mailAddr);
      HtmlWriter writer = new HtmlWriter(new FileWriter("src/facade/"+filename));
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
}
