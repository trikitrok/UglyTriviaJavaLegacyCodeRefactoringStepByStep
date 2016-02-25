package com.adaptionsoft.games.uglytrivia;

public class ConsoleGameNotifications implements GameNotifications {

    @Override
    public void newCurrentPlayerIs(Player player) {
        System.out.println(player + " is the current player");
    }
}
