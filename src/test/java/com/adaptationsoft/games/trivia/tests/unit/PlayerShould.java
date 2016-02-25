package com.adaptationsoft.games.trivia.tests.unit;

import com.adaptionsoft.games.uglytrivia.*;
import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class PlayerShould {
    @Test
    public void notify_when_a_player_wins_gold_coins() {
        GameNotifications gameNotifications = mock(GameNotifications.class);
        Player player = new Player("koko", gameNotifications);

        player.winGoldCoin();

        verify(gameNotifications).playerWins(player);
    }
}
