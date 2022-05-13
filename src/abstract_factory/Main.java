package abstract_factory;

import abstract_factory.factory.Factory;
import abstract_factory.factory.Link;
import abstract_factory.factory.Page;
import abstract_factory.factory.Tray;

public class Main {
    public static void main(String[] args) {
        if (args.length != 2) {
            System.out.println("usage: java Main filename.html class.name.of.ConcreteFactory");
            System.out.println("Example 1: java Main list.html listfactory.ListFactory()");
            System.out.println("Example 1: java Main div.html listfactory.DivFactory()");
            System.exit(0);
        }

        String filename = args[0];
        String className = args[1];

        Factory factory = Factory.getFactory(className);

        Link blog1 = factory.createLink("Blog1", "https://example.com/blog1");
        Link blog2 = factory.createLink("Blog2", "https://example.com/blog2");
        Link blog3 = factory.createLink("Blog3", "https://example.com/blog3");
        Tray blogTray = factory.createTray("Blog Site");
        blogTray.add(blog1);
        blogTray.add(blog2);
        blogTray.add(blog3);

        Link news1 = factory.createLink("News 1", "https://example.com/news1");
        Link news2 = factory.createLink("News 2", "https://example.com/news2");
        Tray news3 = factory.createTray("News 3");
        news3.add(factory.createLink("News 3 (US)", "https://example.com/news3us"));
        news3.add(factory.createLink("News 3 (Japan)", "https://example.com/news3jp"));

        Tray newsTray = factory.createTray("News Site");
        newsTray.add(news1);
        newsTray.add(news2);
        newsTray.add(news3);

        Page page = factory.createPage("Blog and News", "Hiroshi Yuki");
        page.add(blogTray);
        page.add(newsTray);

        page.output(filename);
    }
}
