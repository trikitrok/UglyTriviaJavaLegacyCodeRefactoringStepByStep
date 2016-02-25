package com.adaptationsoft.games.trivia.tests.unit;

import com.adaptionsoft.games.uglytrivia.*;
import org.junit.Test;

import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class JuryShould {

    @Test
    public void make_player_win_gold_when_its_answer_is_correct() {
        Player player = mock(Player.class);
        AnswersChecker answersChecker = mock(AnswersChecker.class);
        doReturn(true).when(answersChecker).isAnswerCorrect(player);
        GameNotifications gameNotifications = mock(GameNotifications.class);
        Jury jury = new Jury(answersChecker, gameNotifications);

        jury.rewardAnswer(player);

        verify(player).winGoldCoin();
    }

    @Test
    public void make_player_enter_the_penalty_box_when_its_answer_is_incorrect() {
        Player player = mock(Player.class);
        AnswersChecker answersChecker = mock(AnswersChecker.class);
        doReturn(false).when(answersChecker).isAnswerCorrect(player);
        GameNotifications gameNotifications = mock(GameNotifications.class);
        Jury jury = new Jury(answersChecker, gameNotifications);

        jury.rewardAnswer(player);

        verify(player).enterPenaltyBox();
    }
}
