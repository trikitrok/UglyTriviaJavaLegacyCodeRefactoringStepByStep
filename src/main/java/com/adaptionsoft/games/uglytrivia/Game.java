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

    public Game(Random rand, Players players, Rules rules, Questions questions, Board board,
                Dice dice) {
        this.players = players;
        this.rules = rules;
        this.rand = rand;
        this.questions = questions;
        this.board = board;
        this.dice = dice;
    }

    public void run() {
        do {
            nextPlayer();
            playTurn();
        } while (noPlayerHasWon());
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

    private boolean noPlayerHasWon() {
        return !currentPlayer.hasWonAccordingTo(rules);
    }
}
