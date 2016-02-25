package com.adaptionsoft.games.uglytrivia;

import java.util.Random;

public class RandomAnswerChecker implements AnswersChecker {

    private Random rand;

    public RandomAnswerChecker(Random rand) {
        this.rand = rand;
    }

    @Override
    public boolean isAnswerRight(Player player) {
        return !(rand.nextInt(9) == 7);
    }
}
