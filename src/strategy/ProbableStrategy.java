package strategy;

import java.util.Random;

import static strategy.Hand.handPatterns;

public class ProbableStrategy implements Strategy {
    private Random random;
    private int previousHandValue = rockHandValue();
    private int currentHandValue = rockHandValue();
    private int[][] patternHistory = {
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
        if (bet < patternHistory[currentHandValue][rockHandValue()]) {
            nextHandValue = rockHandValue();
        } else if (bet < patternHistory[currentHandValue][rockHandValue()] + patternHistory[currentHandValue][scissorsHandValue()]) {
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
        for (int secondHandValue = 0; secondHandValue < patternHistory[firstHandValue].length; secondHandValue++) {
            sum += patternHistory[firstHandValue][secondHandValue];
        }
        return sum;
    }

    @Override
    public void study(boolean win) {
        if (win) {
            patternHistory[previousHandValue][currentHandValue]++;
        } else {
            patternHistory[previousHandValue][(currentHandValue + 1) % 3]++;
            patternHistory[previousHandValue][(currentHandValue + 2) % 3]++;
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
