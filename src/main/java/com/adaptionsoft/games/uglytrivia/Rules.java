package com.adaptionsoft.games.uglytrivia;

public class Rules {
    public boolean shouldGetOutOfPenaltyBox(int roll) {
        return roll % 2 != 0;
    }
}
