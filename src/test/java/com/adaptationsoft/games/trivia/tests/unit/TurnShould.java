package com.adaptationsoft.games.trivia.tests.unit;

import com.adaptationsoft.games.trivia.tests.helpers.BoardFactory;
import com.adaptionsoft.games.uglytrivia.*;
import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class TurnShould {

    private Dice dice;
    private GameNotifications gameNotifications;
    private Player player;
    private int rollResult;
    private AnswerReward answerReward;
    private Turn turn;

    @Before
    public void setUp() {
        rollResult = 3;
        dice = mock(Dice.class);
        doReturn(rollResult).when(dice).roll();
        gameNotifications = mock(GameNotifications.class);
        player = new Player("koko", gameNotifications);
        answerReward = mock(AnswerReward.class);
        turn = new Turn(
            dice,
            BoardFactory.create(),
            new Rules(),
            gameNotifications,
            answerReward);
    }

    @Test
    public void notify_roll_result() {
        turn.play(new Player("koko", gameNotifications));

        verify(gameNotifications).diceRollWas(rollResult);
    }

    @Test
    public void tells_the_jury_to_reward_the_players_answer() {
        turn.play(player);

        verify(answerReward).giveTo(player);
    }

}
