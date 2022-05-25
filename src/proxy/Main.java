package proxy;

public class Main {
    public static void main(String[] args) {
        Printable p = new PrinterProxy("Alice");
        System.out.println("My name is " + p.getPrinterName() + " now.");
        p.setPrinterName("Bob");
        System.out.println("My name is " + p.getPrinterName() + " now.");
        p.print("Hello, world!");

        p.setPrinterName("John");
        System.out.println("My name is " + p.getPrinterName() + " now.");
        p.print("Hello, world2!");
    }
}
