package com.adaptionsoft.games.uglytrivia;

public class Rules {

    public static final int NECESSARY_GOLD_COINS_NUMBER_TO_WIN = 6;

    public boolean playerShouldContinueInPenaltyBox(int roll) {
        return isEven(roll);
    }

    public boolean playerHasWon(int goldCoinsEarned) {
        return (goldCoinsEarned == NECESSARY_GOLD_COINS_NUMBER_TO_WIN);
    }

    private boolean isEven(int roll) {
        return roll % 2 == 0;
    }
}
