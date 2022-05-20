package decorator;

public class SideBorder extends Border {
    private final char borderChar;

    public SideBorder(Display display, char ch) {
        super(display);
        this.borderChar = ch;
    }


    @Override
    public int columns() {
        return 1 + display.columns() + 1;
    }

    @Override
    public int rows() {
        return display.rows();
    }

    @Override
    public String rowText(int row) {
        return borderChar + display.rowText(row) + borderChar;
    }
}
