package com.adaptionsoft.games.uglytrivia;

public class Rules {

    public static final int NUMBER_OF_PURSES_TO_WIN = 6;

    public boolean playerShouldContinueInPenaltyBox(int roll) {
        return isEven(roll);
    }

    public boolean playerHasWon(int pursesWon) {
        return (pursesWon == NUMBER_OF_PURSES_TO_WIN);
    }

    private boolean isEven(int roll) {
        return roll % 2 == 0;
    }
}
