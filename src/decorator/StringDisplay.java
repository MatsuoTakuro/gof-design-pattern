package decorator;

public class StringDisplay extends Display {
    private final String string;

    public StringDisplay(String string) {
        this.string = string;
    }

    @Override
    public int columns() {
        return string.length();
    }

    @Override
    public int rows() {
        return 1;
    }

    @Override
    public String rowText(int row) {
        if (row != 0) {
            throw new IndexOutOfBoundsException();
        }
        return string;
    }
}
