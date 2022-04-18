package strategy;

import java.util.Random;

public class ProbableStrategy implements Strategy {
    private Random random;
    private int previousHandValue = rockHandValue();
    private int currentHandValue = rockHandValue();
    private int[][] winningPatternHistory = {
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
        int max = getSumWith(currentHandValue);
        int bet = random.nextInt(max);
        int nextHandValue;
        if (bet < winningPatternHistory[currentHandValue][rockHandValue()]) {
            nextHandValue = rockHandValue();
        } else if (bet < winningPatternHistory[currentHandValue][rockHandValue()] + winningPatternHistory[currentHandValue][scissorsHandValue()]) {
            nextHandValue = scissorsHandValue();
        } else {
            nextHandValue = paperHandValue();
        }
        currentHandValue = nextHandValue;
        Hand nextHand = Hand.getHand(nextHandValue);
        return nextHand;
    }

    private int getSumWith(int firstHandValue) {
        int sum = 0;
        for (int secondHandValue = 0; secondHandValue < 3; secondHandValue++) {
            sum += winningPatternHistory[firstHandValue][secondHandValue];
        }
        return sum;
    }

    @Override
    public void study(boolean win) {
        if (win) {
            winningPatternHistory[previousHandValue][currentHandValue]++;
        } else {
            winningPatternHistory[previousHandValue][(currentHandValue + 1) % 3]++;
            winningPatternHistory[previousHandValue][(currentHandValue + 2) % 3]++;
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
