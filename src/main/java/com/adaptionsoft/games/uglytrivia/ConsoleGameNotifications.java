package com.adaptionsoft.games.uglytrivia;

public class ConsoleGameNotifications implements GameNotifications {

    @Override
    public void newCurrentPlayerIs(Player player) {
        System.out.println(player + " is the current player");
    }

    @Override
    public void newPlayerAdded(Player player, int numberOfPlayers) {
        System.out.println(player + " was added");
        System.out.println("They are player number " + String.valueOf(numberOfPlayers));
    }
}
