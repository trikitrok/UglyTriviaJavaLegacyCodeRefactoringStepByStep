package com.adaptionsoft.games.trivia.tests.unit;

import com.adaptionsoft.games.trivia.tests.helpers.BoardFactory;
import com.adaptionsoft.games.uglytrivia.*;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class PlayerShould {

    private GameNotifications gameNotifications;
    private Player player;

    @Before
    public void setUp() {
        gameNotifications = mock(GameNotifications.class);
        player = new Player("koko", gameNotifications);
    }

    @Test
    public void notify_when_a_player_wins_gold_coins() {
        player.winGoldCoin();

        verify(gameNotifications).playerWins(player);
    }

    @Test
    public void notify_its_new_board_location_when_it_advances() {
        Board board = BoardFactory.create();
        player.advance(1, board);

        verify(gameNotifications).newBoardLocation(
            player,
            board.advance(board.startLocation(), 1)
        );
    }

    @Test
    public void notify_when_it_is_in_the_penalty_box_and_it_gets_out() {
        int anyOddRoll = 3;
        player.enterPenaltyBox();

        player.tryToGetOutOfPenaltyBox(anyOddRoll, new Rules());

        verify(gameNotifications).gettingOutOfPenaltyBox(player);
        assertThat(player.inPenaltyBox(), is(false));
    }

    @Test
    public void notify_when_it_is_in_the_penalty_box_and_it_does_not_get_out() {
        int anyEvenRoll = 4;
        player.enterPenaltyBox();

        player.tryToGetOutOfPenaltyBox(anyEvenRoll, new Rules());

        verify(gameNotifications).notGettingOutOfPenaltyBox(player);
        assertThat(player.inPenaltyBox(), is(true));
    }
}
