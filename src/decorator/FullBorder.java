package decorator;

public class FullBorder extends Border {

    public FullBorder(Display display) {
        super(display);
    }

    @Override
    public int columns() {
        return 1 + display.columns() + 1;
    }

    @Override
    public int rows() {
        return 1 + display.rows() + 1;
    }

    @Override
    public String rowText(int row) {
        if (row == 0) {
            return "+" + makeLine('-', display.columns()) + "+";
        } else if (row == display.rows() + 1) {
            return "+" + makeLine('-', display.columns()) + "+";
        } else {
            return "|" + display.rowText(row - 1) + "|";
        }
    }

    private String makeLine(char ch, int count) {
        StringBuilder line = new StringBuilder();
        line.append(String.valueOf(ch).repeat(Math.max(0, count)));
        return line.toString();
    }
}
