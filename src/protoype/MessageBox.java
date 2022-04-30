package protoype;

import protoype.framework.ConcreteProduct;

public class MessageBox extends ConcreteProduct {
    private char decoChar;

    public MessageBox(char decoChar) {
        this.decoChar = decoChar;
    }

    @Override
    public void use(String s) {
        int decoLen = 1 + s.length() + 1;
        for (int i = 0; i < decoLen; i++) {
            System.out.print(decoChar);
        }
        System.out.println();
        System.out.println(decoChar + s + decoChar);
        for (int i = 0; i < decoLen; i++) {
            System.out.print(decoChar);
        }
        System.out.println();
    }
}
