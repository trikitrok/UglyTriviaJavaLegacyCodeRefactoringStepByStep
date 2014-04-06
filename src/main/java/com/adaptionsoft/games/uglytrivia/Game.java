package com.adaptionsoft.games.uglytrivia;

import java.util.Random;

public class Game {

    private Random rand;
    private Rules rules;
    private Players players;
    private Questions questions;
    private Board board;
    private Player currentPlayer;
    private Dice dice;

    public Game(Random rand, Players players) {
        this.players = players;
        this.rules = new Rules();
        this.rand = rand;
        this.questions = new Questions();
        this.board = new Board();
        this.dice = new Dice(rand);
    }

    public void run() {
        do {
            nextPlayer();
            playTurn();

        } while (!currentPlayer.hasWonAccordingTo(rules));
    }

    private void playTurn() {
        System.out.println(currentPlayer + " is the current player");

        int roll = rollDice();

        if (currentPlayer.inPenaltyBox()) {
            currentPlayer.tryToGetOutOfPenaltyBox(roll, this.rules);
        }

        play(roll);
    }

    private void play(int roll) {
        if (currentPlayer.inPenaltyBox())
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
        currentPlayer.enterPenaltyBox();
    }

    private void reactToCorrectAnswer() {
        System.out.println("Answer was correct!!!!");
        currentPlayer.winGoldCoin();
    }

    private boolean answerWasWrong() {
        return rand.nextInt(9) == 7;
    }

    private void advancePlayerBy(int places) {
        currentPlayer.advance(places, board);
        System.out.println("The category is " + this.currentCategory());
    }

    private int rollDice() {
        return this.dice.roll();
    }

    private void askQuestion() {
        System.out.println(questions.nextQuestionAbout(currentCategory()));
    }

    private Category currentCategory() {
        return board.categoryAt(currentPlayer.place());
    }

    private void nextPlayer() {
        currentPlayer = players.next();
    }
}
