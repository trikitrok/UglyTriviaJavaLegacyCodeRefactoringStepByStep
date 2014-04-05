package com.adaptionsoft.games.uglytrivia;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Random;

public class Game {
    ArrayList players = new ArrayList();
    int[] places = new int[6];
    int[] purses = new int[6];
    boolean[] inPenaltyBox = new boolean[6];

    LinkedList popQuestions = new LinkedList();
    LinkedList scienceQuestions = new LinkedList();
    LinkedList sportsQuestions = new LinkedList();
    LinkedList rockQuestions = new LinkedList();

    int currentPlayer = 0;
    boolean isGettingOutOfPenaltyBox;

    boolean notAWinner = true;

    private Random rand;

    private Rules rules;

    public Game(Random rand) {

        this.rules = new Rules();
        this.rand = rand;

        for (int i = 0; i < 50; i++) {
            popQuestions.addLast("Pop Question " + i);
            scienceQuestions.addLast(("Science Question " + i));
            sportsQuestions.addLast(("Sports Question " + i));
            rockQuestions.addLast("Rock Question " + i);
        }
    }

    public void run() {
        do {
            System.out.println(this.players.get(this.currentPlayer) + " is the current player");

            int roll = currentPlayerThrowDice();

            if (currentPlayerInPenaltyBox()) {
                isGettingOutOfPenaltyBox = isCurrentPlayerGettingOutOfPenaltyBox(roll);

                if (isGettingOutOfPenaltyBox == true) {
                    moveAndAskQuestionToCurrentPlayer(roll);
                }

            } else {
                moveAndAskQuestionToCurrentPlayer(roll);
            }

            if (answerWasCorrect()) {
                responseToWrongAnswer();
            } else {
                responseToCorrectAnswer();
            }
        } while (notAWinner);
    }

    private boolean answerWasCorrect() {
        return rand.nextInt(9) == 7;
    }

    private void moveAndAskQuestionToCurrentPlayer(int roll) {
        moveCurrentPlayer(roll);
        System.out.println("The category is " + this.currentCategory());
        askQuestion();
    }

    private boolean isCurrentPlayerGettingOutOfPenaltyBox(int roll) {
        if (this.rules.playerShouldGetOutOfPenaltyBox(roll)) {
            System.out.println(this.players.get(this.currentPlayer)
                    + " is getting out of the penalty box");
            return true;
        }

        System.out.println(this.players.get(this.currentPlayer)
                + " is not getting out of the penalty box");
        return false;
    }

    private void moveCurrentPlayer(int roll) {
        this.places[this.currentPlayer] = this.places[this.currentPlayer] + roll;
        if (this.places[this.currentPlayer] > 11)
            this.places[this.currentPlayer] = this.places[this.currentPlayer] - 12;

        System.out.println(this.players.get(this.currentPlayer) + "'s new location is "
                + this.places[this.currentPlayer]);
    }

    private boolean currentPlayerInPenaltyBox() {
        return this.inPenaltyBox[this.currentPlayer];
    }

    private int currentPlayerThrowDice() {
        int roll = rand.nextInt(5) + 1;
        System.out.println("They have rolled a " + roll);
        return roll;
    }

    public boolean add(String playerName) {

        players.add(playerName);
        places[howManyPlayers()] = 0;
        purses[howManyPlayers()] = 0;
        inPenaltyBox[howManyPlayers()] = false;

        System.out.println(playerName + " was added");
        System.out.println("They are player number " + players.size());
        return true;
    }

    private int howManyPlayers() {
        return players.size();
    }

    private void askQuestion() {
        if (currentCategory() == "Pop")
            System.out.println(popQuestions.removeFirst());
        if (currentCategory() == "Science")
            System.out.println(scienceQuestions.removeFirst());
        if (currentCategory() == "Sports")
            System.out.println(sportsQuestions.removeFirst());
        if (currentCategory() == "Rock")
            System.out.println(rockQuestions.removeFirst());
    }

    private String currentCategory() {
        if (places[currentPlayer] == 0)
            return "Pop";
        if (places[currentPlayer] == 4)
            return "Pop";
        if (places[currentPlayer] == 8)
            return "Pop";
        if (places[currentPlayer] == 1)
            return "Science";
        if (places[currentPlayer] == 5)
            return "Science";
        if (places[currentPlayer] == 9)
            return "Science";
        if (places[currentPlayer] == 2)
            return "Sports";
        if (places[currentPlayer] == 6)
            return "Sports";
        if (places[currentPlayer] == 10)
            return "Sports";
        return "Rock";
    }

    private void responseToCorrectAnswer() {
        if (inPenaltyBox[currentPlayer]) {
            if (isGettingOutOfPenaltyBox) {
                System.out.println("Answer was correct!!!!");
                purses[currentPlayer]++;
                System.out.println(players.get(currentPlayer) + " now has " + purses[currentPlayer]
                        + " Gold Coins.");

                notAWinner = !currentPlayerHasWon();

                nextPlayer();

            } else {
                nextPlayer();
                notAWinner = true;
            }

        } else {

            System.out.println("Answer was corrent!!!!");
            purses[currentPlayer]++;
            System.out.println(players.get(currentPlayer) + " now has " + purses[currentPlayer]
                    + " Gold Coins.");

            notAWinner = !currentPlayerHasWon();

            nextPlayer();

        }
    }

    private void responseToWrongAnswer() {
        System.out.println("Question was incorrectly answered");
        System.out.println(players.get(currentPlayer) + " was sent to the penalty box");
        inPenaltyBox[currentPlayer] = true;

        nextPlayer();

        notAWinner = true;
    }

    private void nextPlayer() {
        currentPlayer++;
        if (currentPlayer == players.size())
            currentPlayer = 0;
    }

    private boolean currentPlayerHasWon() {
        return this.rules.playerHasWon(purses[currentPlayer]);
    }
}
