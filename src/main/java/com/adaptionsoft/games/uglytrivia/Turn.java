package com.adaptionsoft.games.uglytrivia;

public class Turn {
    private Dice dice;
    private Board board;
    private Rules rules;
    private Judge judge;
    private GameNotifications gameNotifications;

    public Turn(Dice dice, Board board, Rules rules, Judge judge, GameNotifications gameNotifications) {
        super();
        this.dice = dice;
        this.board = board;
        this.rules = rules;
        this.judge = judge;
        this.gameNotifications = gameNotifications;
    }

    public void play(Player player) {
        int roll = roll();

        tryToGetOutOfPenaltyBox(roll, player);

        if (inPenaltyBox(player))
            return;

        advance(roll, player);

        nextQuestionFor(player);

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
        if (answerWasWrong()) {
            gameNotifications.wrongAnswer(player);
            player.enterPenaltyBox();
        } else {
            gameNotifications.rightAnswer(player);
            player.winGoldCoin();
        }
    }

    private boolean answerWasWrong() {
        return judge.answerWasWrong();
    }

    private void advance(int places, Player player) {
        player.advance(places, board);
        System.out.println(player + "'s new location is " + player.place());
        System.out.println("The category is " + board.categoryAt(player.place()));
    }

    private void nextQuestionFor(Player player) {
        System.out.println(board.questionAt(player.place()));
    }

    private void tryToGetOutOfPenaltyBox(int roll, Player player) {
        if (!inPenaltyBox(player))
            return;

        if (!rules.playerShouldContinueInPenaltyBox(roll)) {
            player.getOutOfPenaltyBox();
            System.out.println(player + " is getting out of the penalty box");
        } else {
            System.out.println(player + " is not getting out of the penalty box");
        }
    }
}
