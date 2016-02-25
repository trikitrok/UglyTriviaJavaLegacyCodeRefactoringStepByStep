package com.adaptationsoft.games.trivia.unit_tests;

import com.adaptionsoft.games.uglytrivia.Player;
import com.adaptionsoft.games.uglytrivia.Players;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.hasItems;

public class PlayersShould {
    @Test
    public void select_next_player_in_a_cycle() {
        Players players = new Players("Chet", "Pat", "Sue");

        assertThat(players.next(), is(new Player("Chet")));
        assertThat(players.next(), is(new Player("Pat")));
        assertThat(players.next(), is(new Player("Sue")));
        assertThat(players.next(), is(new Player("Chet")));
    }

    @Test
    public void notify_who_the_next_player_is() {
        Player chet = new Player("Chet");
        Player pat = new Player("Pat");
        Player sue = new Player("Sue");

        FakePlayers players = new FakePlayers("Chet", "Pat", "Sue");

        players.next();
        players.next();
        players.next();
        players.next();

        assertThat(players.currentPlayersSequence, hasItems(chet, pat, sue, chet));
    }

    class FakePlayers extends Players {
        public List<Player> currentPlayersSequence = new ArrayList<Player>();

        public FakePlayers(String... playerNames) {
            super(playerNames);
        }

        protected void notifyNewCurrentPlayer(Player currentPlayer) {
            currentPlayersSequence.add(currentPlayer);
        }
    }
}
