package strategy;

import java.util.Random;

public class ProbableStrategy implements Strategy {
    private Random random;
    private int previousHandValue = rockHandValue();
    private int currentHandValue = rockHandValue();
    private int[][] winningHistory = {
            // first hand: [0]=Rock
            {1, 1, 1}, // second hand: [0]=Rock, [1]=Scissors, [2]=Paper

            // first hand: [1]=Scissors
            {1, 1, 1}, // second hand: [0]=Rock, [1]=Scissors, [2]=Paper

            // first hand: [2]=Paper
            {1, 1, 1}, // second hand: [0]=Rock, [1]=Scissors, [2]=Paper
    };

    public ProbableStrategy(int seed) {
        random = new Random(seed);
    }

    @Override
    public Hand nextHand() {
        previousHandValue = currentHandValue;
        int max = getSum(currentHandValue);
        int bet = random.nextInt(max);
        int nextHandValue;
        if (bet < winningHistory[currentHandValue][rockHandValue()]) {
            nextHandValue = rockHandValue();
        } else if (bet < winningHistory[currentHandValue][rockHandValue()] + winningHistory[currentHandValue][scissorsHandValue()]) {
            nextHandValue = scissorsHandValue();
        } else {
            nextHandValue = paperHandValue();
        }
        currentHandValue = nextHandValue;
        Hand nextHand = Hand.getHand(nextHandValue);
        return nextHand;
    }

    private int getSum(int firstHandValue) {
        int sum = 0;
        for (int secondHandValue = 0; secondHandValue < 3; secondHandValue++) {
            sum += winningHistory[firstHandValue][secondHandValue];
        }
        return sum;
    }

    @Override
    public void study(boolean win) {
        if (win) {
            winningHistory[previousHandValue][currentHandValue]++;
        } else {
            winningHistory[previousHandValue][(currentHandValue + 1) % 3]++;
            winningHistory[previousHandValue][(currentHandValue + 2) % 3]++;
        }
    }

    private int rockHandValue() {
        return Hand.ROCK.getHandValue();
    }

    private int scissorsHandValue() {
        return Hand.SCISSORS.getHandValue();
    }

    private int paperHandValue() {
        return Hand.PAPER.getHandValue();
    }
}
