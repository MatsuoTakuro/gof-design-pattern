package protoype;

import protoype.framework.Product;

public class MessageBox implements Product {
    private char decoChar;

    public MessageBox(char decoChar) { this.decoChar = decoChar; }

    public MessageBox(MessageBox prototype) {
        this.decoChar = prototype.decoChar;
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

    @Override
    public Product createCopy() {
        return new MessageBox(this);
    }
}
