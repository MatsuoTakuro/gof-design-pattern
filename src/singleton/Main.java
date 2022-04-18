package singleton;

public class Main {
    public static void main(String[] args) {
        System.out.println("Start. ");
        Singleton obj1 = Singleton.getInstance();
        Singleton obj2 = Singleton.getInstance();
        if (obj1 == obj2) {
            System.out.println("obj1 and obj2 is the same instance.");
        } else {
            System.out.println("obj1 and obj2 is not the same instance.");
        }
        System.out.println("End. ");

        SingletonEnum.INSTANCE.hello();

        for (int i = 0; i < 10; i++) {
            System.out.println(i + ":" + TicketMaker.getInstance().getNextTicketNumber());
        }
    }
}
