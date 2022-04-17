package facade.pagemaker;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

class Database {
  private Database() {
  }

  static Properties getProperties(String dbname) throws IOException {
    String filename = dbname + ".txt";
    Properties prop = new Properties();
    prop.load(new FileReader(filename));
    return prop;
  }
}
