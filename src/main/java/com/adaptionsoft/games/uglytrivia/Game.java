package com.adaptionsoft.games.uglytrivia;

import java.util.Random;

public class Game {

    boolean notAWinner = true;
    private Random rand;
    private Rules rules;
    private Players players;
    private Questions questions;
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
            playTurn();

            nextPlayer();
        } while (notAWinner);
    }

    private void playTurn() {
        System.out.println(currentPlayer().name() + " is the current player");

        int roll = throwDice();

        if (currentPlayer().inPenaltyBox()) {
            currentPlayer().tryToGetOutOfPenaltyBox(roll, this.rules);
        }

        play(roll);

        notAWinner = !currentPlayer().hasWonAccordingTo(rules);
    }

    private void play(int roll) {
        if (currentPlayer().inPenaltyBox())
            return;

        advancePlayerBy(roll);

        askQuestion();

        reactToAnswer();
    }

    private void reactToAnswer() {
        if (answerWasWrong()) {
            reactToWrongAnswer();
        } else {
            reactToCorrectAnswer();
        }
    }

    private void reactToWrongAnswer() {
        System.out.println("Question was incorrectly answered");
        currentPlayer().enterPenaltyBox();
    }

    private void reactToCorrectAnswer() {
        System.out.println("Answer was correct!!!!");
        currentPlayer().winGoldCoin();
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

    private int throwDice() {
        int roll = rand.nextInt(5) + 1;
        System.out.println("They have rolled a " + roll);
        return roll;
    }

    private void askQuestion() {
        System.out.println(questions.nextQuestionAbout(currentCategory()));
    }

    private Category currentCategory() {
        return board.categoryAt(currentPlayer().place());
    }

    private void nextPlayer() {
        players.next();
    }
}
