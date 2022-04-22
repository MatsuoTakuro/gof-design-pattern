package factory_method.idcard;

import factory_method.framework.Factory;
import factory_method.framework.Product;

public class IDCardFactory extends Factory {
    private int serial = 100;

    @Override
    protected synchronized Product createProduct(String owner) {
        return new IDCard(owner, serial++);
    }

    @Override
    protected void registerProduct(Product p) {
        System.out.println(p + " is registered.");
    }
}
