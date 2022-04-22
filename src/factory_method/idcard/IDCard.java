package factory_method.idcard;

import factory_method.framework.Product;

public class IDCard extends Product {
    private String owner;
    private int serial;

    IDCard(String owner, int serial) {
        this.owner = owner;
        this.serial = serial;
        System.out.println(this.owner + "'s card was created with No." + this.serial + ".");
    }

    @Override
    public void use() {
        System.out.println(this + " was used.");
    }

    @Override
    public String toString() {
        return "[IDCard: " + owner + " (" + serial +")]";
    }

    public String getOwner() {
        return owner;
    }

    public int getSerial() {
        return serial;
    }
}
