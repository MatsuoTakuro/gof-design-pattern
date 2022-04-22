package factory_method;

import factory_method.framework.Factory;
import factory_method.framework.Product;
import factory_method.idcard.IDCardFactory;

public class Main {
    public static void main(String[] args) {
        Factory factory = new IDCardFactory();
        Product card1 = factory.create("Hiroshi Yuki");
        Product card2 = factory.create("Tomora");
        Product card3 = factory.create("Hanako Sato");
        card1.use();
        card2.use();
        card3.use();
    }
}
