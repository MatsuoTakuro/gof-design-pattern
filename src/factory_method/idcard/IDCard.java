package factory_method.idcard;

import factory_method.framework.Product;

public class IDCard extends Product {
    private String owner;

    IDCard(String owner) {
        this.owner = owner;
        System.out.println(owner + "'s card was created.");
    }

    @Override
    public void use() {
        System.out.println(this + " was used.");
    }

    @Override
    public String toString() {
        return "[IDCard: " + owner + "]";
    }

    public String getOwner() {
        return owner;
    }
}
