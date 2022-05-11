package builder;

public class Director {
    private final Builder builder;

    public Director(Builder builder) {
        this.builder = builder;
    }

    public void construct() {
        builder.makeTitle("Bye");
        builder.makeString("Casual farewells");
        builder.makeItems(new String[]{
                "See you.",
                "Take care.",
                "Bye."
        });
        builder.makeString("Polite Farewells");
        builder.makeItems(new String[]{
                "It was nice to see you.",
                "I'm looking forward to seeing you again.",
        });
        builder.close();
    }
}
