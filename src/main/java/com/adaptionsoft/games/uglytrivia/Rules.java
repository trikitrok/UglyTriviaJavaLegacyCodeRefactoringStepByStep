package com.adaptionsoft.games.uglytrivia;

public class Rules {
    public boolean playerShouldContinueInPenaltyBox(int roll) {
        return isEven(roll);
    }

    public boolean playerHasWon(int pursesWon) {
        return (pursesWon == 6);
    }

    private boolean isEven(int roll) {
        return roll % 2 == 0;
    }
}
