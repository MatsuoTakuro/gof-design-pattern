package abstract_factory;

import abstract_factory.factory.Factory;
import abstract_factory.factory.Page;

public class Main {
    public static void main(String[] args) {
        if (args.length != 2) {
            System.out.println("usage: java Main filename.html class.name.of.ConcreteFactory");
            System.out.println("Example 1: java Main listYahoo.html listfactory.ListFactory()");
            System.out.println("Example 1: java Main divYahoo.html listfactory.DivFactory()");
            System.exit(0);
        }

        String filename = args[0];
        String className = args[1];

        Factory factory = Factory.getFactory(className);

        Page yahooPage = factory.createYahooPage();

        yahooPage.output(filename);
    }
}
