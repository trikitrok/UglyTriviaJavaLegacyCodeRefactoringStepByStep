package com.adaptionsoft.games.uglytrivia;

import java.util.Random;

public class Turn {
    private Dice dice;
    private Random rand;
    private Board board;
    private Rules rules;
    private Judge judge;

    public Turn(Dice dice, Random rand, Board board, Rules rules, Judge judge) {
        super();
        this.dice = dice;
        this.rand = rand;
        this.board = board;
        this.rules = rules;
        this.judge = judge;
    }

    public Turn(Dice dice, Random rand, Board board, Rules rules) {
        this.dice = dice;
        this.rand = rand;
        this.board = board;
        this.rules = rules;
    }

    public void play(Player player) {
        int roll = dice.roll();
        System.out.println("They have rolled a " + roll);

        tryToGetOutOfPenaltyBox(roll, player);

        if (inPenaltyBox(player))
            return;

        advance(roll, player);

        nextQuestionFor(player);

        answer(player);
    }

    private boolean inPenaltyBox(Player player) {
        return player.inPenaltyBox();
    }

    private void answer(Player player) {
        if (answerWasWrong()) {
            System.out.println("Question was incorrectly answered");
            System.out.println(player + " was sent to the penalty box");
            player.enterPenaltyBox();
        } else {
            System.out.println("Answer was correct!!!!");
            player.winGoldCoin();
            System.out.println(player + " now has " + player.goldCoins() + " Gold Coins.");
        }
    }

    private boolean answerWasWrong() {
        if (judge!= null)
            judge.answerWasWrong();
        return rand.nextInt(9) == 7;
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
