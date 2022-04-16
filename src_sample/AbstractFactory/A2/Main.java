import factory.*;

public class Main {
    public static void main(String[] args) {
        if (args.length != 2) {
            System.out.println("Usage: java Iterator.Main filename.html class.name.of.ConcreteFactory");
            System.out.println("Example 1: java Iterator.Main listYahoo.html listfactory.ListFactory");
            System.out.println("Example 2: java Iterator.Main divYahoo.html divfactory.DivFactory");
            System.exit(0);
        }

        String filename = args[0];
        String classname = args[1];

        Factory factory = Factory.getFactory(classname);

        // Page
        Page page = factory.createYahooPage();

        page.output(filename);
    }
}
