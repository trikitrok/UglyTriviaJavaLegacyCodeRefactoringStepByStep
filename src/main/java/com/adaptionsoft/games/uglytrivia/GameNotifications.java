package com.adaptionsoft.games.uglytrivia;

public interface GameNotifications {
    void newCurrentPlayerIs(Player player);
    void newPlayerAdded(Player player, int numberOfPlayers);

    void diceRollWas(int roll);

    void wrongAnswer(Player player);

    void rightAnswer(Player player);

    void playerWins(Player player);
}
