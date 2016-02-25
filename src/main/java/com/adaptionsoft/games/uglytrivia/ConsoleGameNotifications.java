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

    @Override
    public void diceRollWas(int roll) {
        System.out.println("They have rolled a " + roll);
    }

    @Override
    public void wrongAnswer(Player player) {
        System.out.println("Question was incorrectly answered");
        System.out.println(player + " was sent to the penalty box");
    }

    @Override
    public void rightAnswer(Player player) {
        System.out.println("Answer was correct!!!!");
    }

    @Override
    public void playerWins(Player player) {
        System.out.println(player + " now has " + player.goldCoins() + " Gold Coins.");
    }

    @Override
    public void newBoardLocation(Player player, BoardLocation boardLocation) {
        System.out.println(player + "'s new location is " + player.place());
        System.out.println("The category is " + boardLocation.category());
        System.out.println(boardLocation.question());
    }
}
