package singleton;

public class TicketMaker {
    private static TicketMaker singleton = new TicketMaker();
    private int ticket = 1000;

    private TicketMaker() {
        System.out.println("instance has been created.");
    }

    public static TicketMaker getInstance() {
        return singleton;
    }

    public synchronized int getNextTicketNumber() {
        return ticket++;
    }
}
