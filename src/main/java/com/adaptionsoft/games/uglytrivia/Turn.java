package com.adaptionsoft.games.uglytrivia;

public class Turn {
    private Dice dice;
    private Board board;
    private Rules rules;
    private GameNotifications gameNotifications;
    private GameHost gameHost;

    public Turn(Dice dice, Board board, Rules rules, GameNotifications gameNotifications, GameHost gameHost) {
        this.dice = dice;
        this.board = board;
        this.rules = rules;
        this.gameNotifications = gameNotifications;
        this.gameHost = gameHost;
    }

    public void play(Player player) {
        int roll = roll();

        tryToGetOutOfPenaltyBox(roll, player);

        if (stillInPenaltyBox(player)) {
            return;
        }

        advance(roll, player);

        answer(player);
    }

    private boolean stillInPenaltyBox(Player player) {
        return player.inPenaltyBox();
    }

    private int roll() {
        int roll = dice.roll();
        gameNotifications.diceRollWas(roll);
        return roll;
    }

    private void answer(Player player) {
        gameHost.rewardAnswer(player);
    }

    private void advance(int places, Player player) {
        player.advance(places, board);
    }

    private void tryToGetOutOfPenaltyBox(int roll, Player player) {
        player.tryToGetOutOfPenaltyBox(roll, rules);
    }
}
