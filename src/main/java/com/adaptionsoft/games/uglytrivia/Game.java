package com.adaptionsoft.games.uglytrivia;

import java.util.Random;

public class Game {
    boolean notAWinner = true;

    private Random rand;
    private Rules rules;
    Players players;
    Questions questions;

    private Board board;

    public Game(Random rand, Players players) {
        this.players = players;
        this.rules = new Rules();
        this.rand = rand;
        this.questions = new Questions();
        this.board = new Board();
    }

    public void run() {
        do {
            runOneTurn();
        } while (notAWinner);
    }

    private void runOneTurn() {
        System.out.println(currentPlayer().name() + " is the current player");

        int roll = currentPlayerThrowDice();

        if (currentPlayer().inPenaltyBox()) {
            currentPlayer().tryToGetOutOfPenaltyBox(roll, this.rules);
        }

        if (!currentPlayer().inPenaltyBox()) {
            advancePlayerBy(roll);

            askQuestion();

            reactToAnswer();
        }

        players.next();
    }

    private void reactToAnswer() {
        if (answerWasWrong()) {
            reactToWrongAnswer();
        } else {
            reactToCorrectAnswer();
        }
    }

    private void reactToCorrectAnswer() {
        System.out.println("Answer was correct!!!!");
        currentPlayer().winGoldCoin();
        notAWinner = !currentPlayer().hasWonAccordingTo(rules);
    }

    private boolean answerWasWrong() {
        return rand.nextInt(9) == 7;
    }

    private Player currentPlayer() {
        return players.getCurrentPlayer();
    }

    private void advancePlayerBy(int places) {
        currentPlayer().advance(places, board);
        System.out.println("The category is " + this.currentCategory());
    }

    private int currentPlayerThrowDice() {
        int roll = rand.nextInt(5) + 1;
        System.out.println("They have rolled a " + roll);
        return roll;
    }

    private void askQuestion() {
        System.out.println(questions.nextQuestionAbout(currentCategory()));
    }

    private String currentCategory() {
        if (currentPlayer().isAt(0))
            return "Pop";
        if (currentPlayer().isAt(4))
            return "Pop";
        if (currentPlayer().isAt(8))
            return "Pop";
        if (currentPlayer().isAt(1))
            return "Science";
        if (currentPlayer().isAt(5))
            return "Science";
        if (currentPlayer().isAt(9))
            return "Science";
        if (currentPlayer().isAt(2))
            return "Sports";
        if (currentPlayer().isAt(6))
            return "Sports";
        if (currentPlayer().isAt(10))
            return "Sports";
        return "Rock";
    }

    private void reactToWrongAnswer() {
        System.out.println("Question was incorrectly answered");
        currentPlayer().enterPenaltyBox();
        notAWinner = true;
    }
}
