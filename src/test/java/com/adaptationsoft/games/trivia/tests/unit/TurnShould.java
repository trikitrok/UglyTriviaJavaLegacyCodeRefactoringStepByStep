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

        Turn turn = new Turn(
                new Dice(new Random()),
                Board.create(),
                new Rules(),
                judge);

        turn.play(new Player("koko"));

        verify(judge).answerWasWrong();
    }
}
