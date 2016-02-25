package com.adaptationsoft.games.trivia.tests.unit;

import com.adaptionsoft.games.uglytrivia.*;
import org.junit.Test;

import java.util.Random;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class TurnShould {

    @Test
    public void ask_a_judge_if_an_answer_was_wrong() {
        Judge judge = mock(Judge.class);

        int seed = 1234;
        Random random = new Random(seed);

        Turn turn = new Turn(
                new Dice(random),
                Board.create(),
                new Rules(),
                judge
        );

        turn.play(new Player("koko"));

        verify(judge).answerWasWrong();
    }
}
