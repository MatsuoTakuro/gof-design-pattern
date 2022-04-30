package protoype;

import protoype.framework.Product;

public class UnderlinePen implements Product {
    private char ulChar;

    public UnderlinePen(char ulChar) {
        this.ulChar = ulChar;
    }

    public UnderlinePen(UnderlinePen prototype) {
        this.ulChar = prototype.ulChar;
    }

    @Override
    public void use(String s) {
        int uLen = s.length();
        System.out.println(s);
        for (int i = 0; i < uLen; i++) {
            System.out.print(ulChar);
        }
        System.out.println();
    }

    @Override
    public Product createCopy() {
        return new UnderlinePen(this);
    }
}
