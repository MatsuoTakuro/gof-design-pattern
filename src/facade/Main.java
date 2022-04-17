package facade;

import facade.pagemaker.PageMaker;

public class Main {
    public static void main(String[] args) {
      PageMaker.makeWelcomePage("hyuki@example.com", "welcome.html");
      PageMaker.makeLinkPage("linkpage.html");
      String title = "Welcome!";
      String message = "Hello, world!";
      String html = """
      <!DOCTYPE html>
      <html>
          <head>
              <title>%s</title>
          </head>
          <body>
              <h1 style="text-align: center">%s</h1>
          </body>
      </html>
      """.formatted(title, message);
      System.out.print(html);
  }
}
