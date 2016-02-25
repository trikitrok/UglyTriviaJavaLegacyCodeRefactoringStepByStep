package com.adaptionsoft.games.uglytrivia;

import java.util.Random;

public class RandomJudge implements Judge {

    private Random rand;

    public RandomJudge(Random rand) {
        this.rand = rand;
    }

    @Override
    public boolean answerWasWrong() {
        return rand.nextInt(9) == 7;
    }
}
