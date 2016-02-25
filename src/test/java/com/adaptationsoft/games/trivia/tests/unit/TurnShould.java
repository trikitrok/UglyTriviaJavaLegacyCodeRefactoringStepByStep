package com.adaptationsoft.games.trivia.tests.unit;

import com.adaptionsoft.games.uglytrivia.*;
import org.junit.Test;

import java.util.Random;

import static org.mockito.Mockito.doReturn;
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
                judge, new ConsoleGameNotifications());

        turn.play(new Player("koko"));

        verify(judge).answerWasWrong();
    }

    @Test
    public void notify_roll_result() {
        int rollResult = 3;
        Dice dice = mock(Dice.class);
        doReturn(rollResult).when(dice).roll();
        GameNotifications gameNotifications = mock(GameNotifications.class);
        Turn turn = new Turn(
                dice,
                Board.create(),
                new Rules(),
                new RandomJudge(new Random()),
                gameNotifications);

        turn.play(new Player("koko"));

        verify(gameNotifications).diceRollWas(rollResult);
    }

    @Test
    public void notify_when_an_answer_is_wrong() {
        Player player = new Player("koko");
        int anySide = 3;
        Dice dice = mock(Dice.class);
        doReturn(anySide).when(dice).roll();
        Judge judge = mock(Judge.class);
        doReturn(true).when(judge).answerWasWrong();
        GameNotifications gameNotifications = mock(GameNotifications.class);
        Turn turn = new Turn(
                dice,
                Board.create(),
                new Rules(),
                judge,
                gameNotifications);

        turn.play(player);

        verify(gameNotifications).wrongAnswer(player);
    }

    @Test
    public void notify_when_an_answer_is_right() {
        Player player = new Player("koko");
        int anySide = 3;
        Dice dice = mock(Dice.class);
        doReturn(anySide).when(dice).roll();
        Judge judge = mock(Judge.class);
        doReturn(false).when(judge).answerWasWrong();
        GameNotifications gameNotifications = mock(GameNotifications.class);
        Turn turn = new Turn(
                dice,
                Board.create(),
                new Rules(),
                judge,
                gameNotifications);

        turn.play(player);

        verify(gameNotifications).rightAnswer(player);
    }

    @Test
    public void notify_when_a_player_wins_gold_coins() {
        Player player = new Player("koko");
        int anySide = 3;
        Dice dice = mock(Dice.class);
        doReturn(anySide).when(dice).roll();
        Judge judge = mock(Judge.class);
        doReturn(false).when(judge).answerWasWrong();
        GameNotifications gameNotifications = mock(GameNotifications.class);
        Turn turn = new Turn(
                dice,
                Board.create(),
                new Rules(),
                judge,
                gameNotifications);

        turn.play(player);

        verify(gameNotifications).playerWins(player);
    }
}
