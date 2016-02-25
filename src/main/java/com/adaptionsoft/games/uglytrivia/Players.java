package com.adaptionsoft.games.uglytrivia;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Players {
    GameNotifications gameNotifications;
    int currentPlayerIndex = -1;
    List<Player> players = new ArrayList<Player>();

    public Players(String... playerNames) {
        this(new ConsoleGameNotifications(), playerNames);
    }

    public Players(GameNotifications gameNotifications, String... playerNames) {
        this.gameNotifications = gameNotifications;
        for (String playerName : playerNames) {
            add(playerName);
        }
    }

    public Player next() {
        updateCurrentPlayerIndex();

        Player currentPlayer = players.get(currentPlayerIndex);

        gameNotifications.newCurrentPlayerIs(currentPlayer);

        return currentPlayer;
    }

    private void updateCurrentPlayerIndex() {
        currentPlayerIndex++;
        if (currentPlayerIndex == players.size())
            currentPlayerIndex = 0;
    }

    private void add(String playerName) {
        Player player = new Player(playerName);
        players.add(player);
        gameNotifications.newPlayerAdded(player, players.size());
    }
}
