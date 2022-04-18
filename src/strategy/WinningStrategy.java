package strategy;

import java.util.Random;

public class WinningStrategy implements Strategy {
    private Random random;
    private boolean hasWon = false;
    private Hand previousHand;
    private Hand nextHand;

    public WinningStrategy(int seed) {
        random = new Random(seed);
    }

    @Override
    public Hand nextHand() {
        if (!hasWon) {
            nextHand = Hand.getHand(random.nextInt(3));
            previousHand = nextHand;
            return nextHand;
        }
        nextHand = previousHand;
        return nextHand;
    }

    @Override
    public  void study(boolean win) {
        hasWon = win;
    }
}
