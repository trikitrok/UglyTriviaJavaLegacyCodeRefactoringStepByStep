package com.adaptionsoft.games.uglytrivia;

import java.util.ArrayList;
import java.util.List;

public class Players {
    int currentPlayer = 0;
    List<Player> players = new ArrayList<Player>();

    public Players(String... playerNames) {
        for (String playerName : playerNames) {
            add(playerName);
        }
    }

    public void next() {
        currentPlayer++;
        if (currentPlayer == players.size())
            currentPlayer = 0;
    }

    public void add(String playerName) {
        players.add(new Player(playerName));
        System.out.println(playerName + " was added");
        System.out.println("They are player number " + players.size());
    }

    public Player getCurrentPlayer() {
        return players.get(currentPlayer);
    }
}
