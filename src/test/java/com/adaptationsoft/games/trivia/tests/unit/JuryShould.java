package com.adaptationsoft.games.trivia.tests.unit;

import com.adaptionsoft.games.uglytrivia.*;
import org.junit.Test;

import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class JuryShould {

    @Test
    public void make_player_win_gold_when_its_answer_is_right() {
        Player player = mock(Player.class);
        AnswersChecker answersChecker = mock(AnswersChecker.class);
        doReturn(true).when(answersChecker).isAnswerRight(player);
        GameNotifications gameNotifications = mock(GameNotifications.class);
        AnswerReward answerReward = new AnswerReward(answersChecker, gameNotifications);

        answerReward.giveTo(player);

        verify(player).winGoldCoin();
    }

    @Test
    public void make_player_enter_the_penalty_box_when_its_answer_is_incorrect() {
        Player player = mock(Player.class);
        AnswersChecker answersChecker = mock(AnswersChecker.class);
        doReturn(false).when(answersChecker).isAnswerRight(player);
        GameNotifications gameNotifications = mock(GameNotifications.class);
        AnswerReward answerReward = new AnswerReward(answersChecker, gameNotifications);

        answerReward.giveTo(player);

        verify(player).enterPenaltyBox();
    }

    @Test
    public void notify_when_players_answer_is_right() {
        Player player = mock(Player.class);
        AnswersChecker answersChecker = mock(AnswersChecker.class);
        doReturn(true).when(answersChecker).isAnswerRight(player);
        GameNotifications gameNotifications = mock(GameNotifications.class);
        AnswerReward answerReward = new AnswerReward(answersChecker, gameNotifications);

        answerReward.giveTo(player);

        verify(gameNotifications).rightAnswer(player);
    }

    @Test
    public void notify_when_players_answer_is_wrong() {
        Player player = mock(Player.class);
        AnswersChecker answersChecker = mock(AnswersChecker.class);
        doReturn(false).when(answersChecker).isAnswerRight(player);
        GameNotifications gameNotifications = mock(GameNotifications.class);
        AnswerReward answerReward = new AnswerReward(answersChecker, gameNotifications);

        answerReward.giveTo(player);

        verify(gameNotifications).wrongAnswer(player);
    }
}
