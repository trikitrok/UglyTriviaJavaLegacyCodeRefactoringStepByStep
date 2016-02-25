package com.adaptionsoft.games.uglytrivia;

public class Turn {
    private Dice dice;
    private Board board;
    private Rules rules;
    private GameNotifications gameNotifications;
    private Jury jury;

    public Turn(Dice dice, Board board, Rules rules, GameNotifications gameNotifications, Jury jury) {
        super();
        this.dice = dice;
        this.board = board;
        this.rules = rules;
        this.gameNotifications = gameNotifications;
        this.jury = jury;
    }

    public void play(Player player) {
        int roll = roll();

        tryToGetOutOfPenaltyBox(roll, player);

        if (inPenaltyBox(player))
            return;

        advance(roll, player);

        answer(player);
    }

    private int roll() {
        int roll = dice.roll();
        gameNotifications.diceRollWas(roll);
        return roll;
    }

    private boolean inPenaltyBox(Player player) {
        return player.inPenaltyBox();
    }

    private void answer(Player player) {
        jury.rewardAnswer(player);
    }

    private void advance(int places, Player player) {
       player.advance(places, board);
    }

    private void tryToGetOutOfPenaltyBox(int roll, Player player) {
        if (!inPenaltyBox(player))
            return;

        player.tryToGetOutOfPenaltyBox(roll, rules);
    }
}
