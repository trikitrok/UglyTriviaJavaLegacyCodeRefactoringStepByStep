package com.adaptionsoft.games.uglytrivia;

import java.util.ArrayList;
import java.util.List;

public class Players {
    GameNotifications gameNotifications;
    int currentPlayerIndex = -1;
    List<Player> players = new ArrayList<Player>();
    
    public Players(GameNotifications gameNotifications, String... playerNames) {
        this.gameNotifications = gameNotifications;
        for (String playerName : playerNames) {
            add(playerName);
        }
    }

    public Player next() {
        Player currentPlayer = nextCurrentPlayer();
        gameNotifications.newCurrentPlayerIs(currentPlayer);
        return currentPlayer;
    }

    private Player nextCurrentPlayer() {
        updateCurrentPlayerIndex();
        return players.get(currentPlayerIndex);
    }

    private void updateCurrentPlayerIndex() {
        currentPlayerIndex++;
        if (currentPlayerIndex == players.size())
            currentPlayerIndex = 0;
    }

    private void add(String playerName) {
        Player player = new Player(playerName, gameNotifications);
        players.add(player);
        gameNotifications.newPlayerAdded(player, players.size());
    }
}
