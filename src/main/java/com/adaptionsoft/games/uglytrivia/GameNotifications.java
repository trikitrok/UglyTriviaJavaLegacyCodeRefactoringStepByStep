package com.adaptionsoft.games.uglytrivia;

public interface GameNotifications {
    void newCurrentPlayerIs(Player player);
    void newPlayerAdded(Player player, int numberOfPlayers);
}
