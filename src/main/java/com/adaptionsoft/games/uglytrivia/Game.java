package com.adaptionsoft.games.uglytrivia;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class Game {
    ArrayList players = new ArrayList();

    LinkedList popQuestions = new LinkedList();
    LinkedList scienceQuestions = new LinkedList();
    LinkedList sportsQuestions = new LinkedList();
    LinkedList rockQuestions = new LinkedList();

    int currentPlayer = 0;

    List<Player> playersList;

    boolean notAWinner = true;

    private Random rand;

    private Rules rules;

    public Game(Random rand) {
        playersList = new ArrayList<Player>();
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
            runOneTurn();
        } while (notAWinner);
    }

    private void runOneTurn() {
        System.out.println(this.players.get(this.currentPlayer) + " is the current player");

        int roll = currentPlayerThrowDice();

        if (playerCanUseThisTurn(roll)) {

            advancePlayerBy(roll);

            askQuestion();

            reactToAnswer();
        }

        nextPlayer();
    }

    private boolean playerCanUseThisTurn(int roll) {
        return !currentPlayer().inPenaltyBox() || isCurrentPlayerGettingOutOfPenaltyBox(roll);
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
        // purses[currentPlayer]++;
        currentPlayer().winGoldCoin();
        System.out.println(players.get(currentPlayer) + " now has " + currentPlayer().coins()
                + " Gold Coins.");
        notAWinner = !currentPlayer().hasWonAccordingTo(rules);
    }

    private boolean answerWasWrong() {
        return rand.nextInt(9) == 7;
    }

    private boolean isCurrentPlayerGettingOutOfPenaltyBox(int roll) {
        if (this.rules.playerShouldContinueInPenaltyBox(roll)) {

            System.out.println(this.players.get(this.currentPlayer)
                    + " is not getting out of the penalty box");

            return false;
        }

        System.out.println(this.players.get(this.currentPlayer)
                + " is getting out of the penalty box");

        return true;
    }

    private Player currentPlayer() {
        return playersList.get(currentPlayer);
    }

    private void advancePlayerBy(int places) {
        int place = advanceInBoard(places);

        currentPlayer().moveTo(place);

        System.out.println(this.players.get(this.currentPlayer) + "'s new location is "
                + currentPlayer().place());
        System.out.println("The category is " + this.currentCategory());
    }

    private int advanceInBoard(int places) {
        int place = currentPlayer().place() + places;
        final int BOARDS_PLACES_NUMBER = 12;
        if (place > BOARDS_PLACES_NUMBER - 1) {
            place = place - BOARDS_PLACES_NUMBER;
        }
        return place;
    }

    private int currentPlayerThrowDice() {
        int roll = rand.nextInt(5) + 1;
        System.out.println("They have rolled a " + roll);
        return roll;
    }

    public boolean add(String playerName) {
        playersList.add(new Player(playerName));
        players.add(playerName);
        currentPlayer().getOutOfPenaltyBox();

        System.out.println(playerName + " was added");
        System.out.println("They are player number " + players.size());
        return true;
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
        System.out.println(players.get(currentPlayer) + " was sent to the penalty box");
        currentPlayer().enterPenaltyBox();
        notAWinner = true;
    }

    private void nextPlayer() {
        currentPlayer++;
        if (currentPlayer == players.size())
            currentPlayer = 0;
    }
}
