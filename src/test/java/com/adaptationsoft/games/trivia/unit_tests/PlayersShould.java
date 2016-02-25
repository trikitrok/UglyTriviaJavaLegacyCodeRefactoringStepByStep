package com.adaptationsoft.games.trivia.unit_tests;

import com.adaptionsoft.games.uglytrivia.Player;
import com.adaptionsoft.games.uglytrivia.Players;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class PlayersShould {
    @Test
    public void select_next_player_in_a_cycle() {
        Players players = new Players("Chet", "Pat", "Sue");

        assertThat(players.next(), is(new Player("Chet")));
        assertThat(players.next(), is(new Player("Pat")));
        assertThat(players.next(), is(new Player("Sue")));
        assertThat(players.next(), is(new Player("Chet")));
    }
}
