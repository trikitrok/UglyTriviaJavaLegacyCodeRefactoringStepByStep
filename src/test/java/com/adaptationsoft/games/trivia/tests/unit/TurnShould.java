package com.adaptationsoft.games.trivia.tests.unit;

import com.adaptationsoft.games.trivia.tests.helpers.BoardFactory;
import com.adaptionsoft.games.uglytrivia.*;
import org.junit.Test;

import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class TurnShould {
    @Test
    public void notify_roll_result() {
        int rollResult = 3;
        Dice dice = mock(Dice.class);
        doReturn(rollResult).when(dice).roll();
        GameNotifications gameNotifications = mock(GameNotifications.class);
        Jury jury = mock(Jury.class);

        Turn turn = new Turn(
            dice,
            BoardFactory.create(),
            new Rules(),
            gameNotifications,
            jury);

        turn.play(new Player("koko", gameNotifications));

        verify(gameNotifications).diceRollWas(rollResult);
    }

    @Test
    public void tells_the_jury_to_reward_the_players_answer() {
        GameNotifications gameNotifications = mock(GameNotifications.class);
        Player player = new Player("koko", gameNotifications);
        int rollResult = 3;
        Dice dice = mock(Dice.class);
        doReturn(rollResult).when(dice).roll();
        Jury jury = mock(Jury.class);

        Turn turn = new Turn(
            dice,
            BoardFactory.create(),
            new Rules(),
            gameNotifications,
            jury);

        turn.play(player);

        verify(jury).rewardAnswer(player);
    }

}
