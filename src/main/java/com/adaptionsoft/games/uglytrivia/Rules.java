package com.adaptionsoft.games.uglytrivia;

public class Rules {
    public boolean playerShouldGetOutOfPenaltyBox(int roll) {
        return roll % 2 != 0;
    }

    public boolean playerHasWon(int pursesWon) {
        return (pursesWon == 6);
    }
}
