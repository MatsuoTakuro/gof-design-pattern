package protoype.framework;

public abstract class ConcreteProduct implements Product {
    @Override
    public abstract void use(String s);

    @Override
    public Product createCopy() {
        Product p = null;
        try {
            p = (Product)clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return p;
    }
}
