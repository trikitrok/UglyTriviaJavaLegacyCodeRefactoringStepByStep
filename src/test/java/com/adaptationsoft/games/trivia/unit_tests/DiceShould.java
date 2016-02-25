package com.adaptationsoft.games.trivia.unit_tests;

import com.adaptionsoft.games.uglytrivia.Dice;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.isOneOf;

public class DiceShould {

    @Test
    public void produce_rolls_that_are_dice_side_values() {
        Dice dice = new Dice(new Random());

        List<Integer> rolls = rollSeveralTimes(dice, 5000);

        for (int roll : rolls) {
            assertThat(roll, isOneOf(1, 2, 3, 4, 5, 6));
        }
    }

    private List<Integer> rollSeveralTimes(Dice dice, int times) {
        List<Integer> rolls = new ArrayList<Integer>();
        for(int i = 0; i< times; ++i) {
            rolls.add(dice.roll());
        }
        return rolls;
    }
}
