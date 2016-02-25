package com.adaptationsoft.games.trivia.tests.unit;

import com.adaptionsoft.games.uglytrivia.GameNotifications;
import com.adaptionsoft.games.uglytrivia.Player;
import com.adaptionsoft.games.uglytrivia.Players;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InOrder;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.inOrder;
import static org.mockito.Mockito.mock;

public class PlayersShould {
    private Player chet;
    private Player pat;
    private Player sue;

    @Before
    public void setUp() {
        chet = new Player("Chet");
        pat = new Player("Pat");
        sue = new Player("Sue");
    }

    @Test
    public void select_next_player_in_a_cycle() {
        Players players = new Players("Chet", "Pat", "Sue");

        assertThat(players.next(), is(chet));
        assertThat(players.next(), is(pat));
        assertThat(players.next(), is(sue));
        assertThat(players.next(), is(chet));
    }

    @Test
    public void tell_the_game_notifications_who_the_next_player_is() {
        GameNotifications gameNotifications = mock(GameNotifications.class);
        InOrder inOrder = inOrder(gameNotifications);

        Players players = new Players(gameNotifications, "Chet", "Pat", "Sue");

        players.next();
        players.next();
        players.next();
        players.next();

        inOrder.verify(gameNotifications).newCurrentPlayerIs(chet);
        inOrder.verify(gameNotifications).newCurrentPlayerIs(pat);
        inOrder.verify(gameNotifications).newCurrentPlayerIs(sue);
        inOrder.verify(gameNotifications).newCurrentPlayerIs(chet);
    }

    @Test
    public void tell_the_game_notifications_which_players_are_added() {
        GameNotifications gameNotifications = mock(GameNotifications.class);
        InOrder inOrder = inOrder(gameNotifications);

        new Players(gameNotifications, "Chet", "Pat", "Sue");

        inOrder.verify(gameNotifications).newPlayerAdded(chet, 1);
        inOrder.verify(gameNotifications).newPlayerAdded(pat, 2);
        inOrder.verify(gameNotifications).newPlayerAdded(sue, 3);
    }
}