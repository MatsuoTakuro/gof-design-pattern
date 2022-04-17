package facade.pagemaker;

import java.io.IOException;
import java.io.Writer;

class HtmlWriter {
  private Writer writer;

  HtmlWriter(Writer writer) {
    this.writer = writer;
  }

  void title(String title) throws IOException {
    writer.write("<!DOCTYPE html>");
    writer.write("<html>");
    writer.write("<head>");
    writer.write("<title>" + title + "</title>");
    writer.write("</head>");
    writer.write("<body>");
    writer.write("\n");
    writer.write("<h1>" + title + "</h1>");
    writer.write("\n");
  }

  void mailTo(String mailAddr, String username) throws IOException {
    link("mail to:" + mailAddr, username);
  }

  void link(String href, String caption) throws IOException {
    paragraph("<a href=\"" + href + "\">" + caption + "</a>");
  }

  void paragraph(String msg) throws IOException {
    writer.write("<p>" + msg + "</p>");
    writer.write("\n");
  }

  void close() throws IOException {
    writer.write("</body>");
    writer.write("</html>");
    writer.write("\n");
    writer.close();
  }
}
