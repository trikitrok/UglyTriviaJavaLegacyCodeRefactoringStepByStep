package com.adaptionsoft.games.uglytrivia;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Players implements Iterable<Player> {
    int currentPlayerIndex = -1;
    List<Player> players = new ArrayList<Player>();

    public Players(String... playerNames) {
        for (String playerName : playerNames) {
            add(playerName);
        }
    }

    public Player next() {
        updateCurrentPlayerIndex();

        Player currentPlayer = players.get(currentPlayerIndex);

        System.out.println(currentPlayer + " is the current player");

        return currentPlayer;
    }

    private void updateCurrentPlayerIndex() {
        currentPlayerIndex++;
        if (currentPlayerIndex == players.size())
            currentPlayerIndex = 0;
    }

    public void add(String playerName) {
        Player player = new Player(playerName);
        players.add(player);
        System.out.println(player + " was added");
        System.out.println("They are player number " + String.valueOf(players.size()));
    }

    @Override
    public Iterator<Player> iterator() {
        return players.iterator();
    }
}
