package proxy;

public class Printer implements Printable {
    private String name;

    public Printer() {
        heavyJob("Generating the instance of Printer.");
    }

    public Printer(String name) {
        this.name = name;
        heavyJob("Generating the instance(" + name + ") of Printer.");
    }

    @Override
    public void setPrinterName(String name) {
        this.name = name;
    }

    @Override
    public String getPrinterName() {
        return name;
    }

    @Override
    public void print(String string) {
        System.out.println("=== " + name + " ===");
        System.out.println(string);
    }

    private void heavyJob(String msg) {
        System.out.print(msg);
        for (int i = 0; i < 5; i++) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ignored) {
            }
            System.out.print(".");
        }
        System.out.println("Completed.");
    }
}
