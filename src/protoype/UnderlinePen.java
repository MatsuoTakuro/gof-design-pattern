package protoype;

import protoype.framework.ConcreteProduct;

public class UnderlinePen extends ConcreteProduct {
    private char ulChar;

    public UnderlinePen(char ulChar) {
        this.ulChar = ulChar;
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
}
