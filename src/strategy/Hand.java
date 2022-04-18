package strategy;

public enum Hand {
    ROCK("Rock", 0),
    SCISSORS("Scissors", 1),
    PAPER("Paper", 2);

    private String name;
    private int handValue;

    private static Hand[] hands = {
            ROCK, SCISSORS, PAPER
    };

    private Hand(String name, int handValue) {
        this.name = name;
        this.handValue = handValue;
    }

    public static Hand getHand(int handValue) {
        return hands[handValue];
    }

    public boolean isStrongerThan(Hand h) {
        return fight(h) == 1;
    }

    public boolean isWeakerThan(Hand h) {
        return fight(h) == -1;
    }

    private int fight(Hand h) {
        if (this == h) {
            return 0;
        } else if ((this.handValue + 1) % 3 == h.handValue) {
            return 1;
        } else {
            return -1;
        }
    }

    @Override
    public String toString() {
        return name;
    }

    public int getHandValue() {
        return handValue;
    }
}
