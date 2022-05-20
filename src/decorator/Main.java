package decorator;

public class Main {
    public static void main(String[] args) {
        Display str = new StringDisplay("Hello, world.");
        Display side = new SideBorder(str, 'x');
        Display full = new FullBorder(side);
        str.show();
        side.show();
        full.show();
        Display decorator =
                new SideBorder(
                        new FullBorder(
                                new FullBorder(
                                        new SideBorder(
                                                new FullBorder(
                                                        new StringDisplay("Hello, world.")
                                                ),
                                                'a'
                                        )
                                )
                        ),
                        'b');
        decorator.show();
    }
}
