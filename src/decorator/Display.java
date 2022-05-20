package decorator;

public abstract class Display {
    public abstract int columns();
    public abstract int rows();
    public abstract String rowText(int row);

    public void show() {
        for (int row = 0; row < rows(); row++) {
            System.out.println(rowText(row));
        }
    }
}
