package Singleton;

public class Singleton {
    private static Singleton singleton = new Singleton(); // this instance is only one.

    private Singleton() {
        System.out.println("instance has been created.");
    }

    public static Singleton getInstance() {
        return singleton;
    }
}
