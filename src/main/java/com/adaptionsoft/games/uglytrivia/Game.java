package com.adaptionsoft.games.uglytrivia;

public class Game {

    private Rules rules;
    private Players players;
    private Player currentPlayer;
    private Turn turn;

    public Game(Players players, Rules rules, Turn turn) {
        this.players = players;
        this.rules = rules;
        this.turn = turn;
    }

    public void run() {
        do {
            nextPlayer();
            playTurn();
        } while (noPlayerHasWon());
    }

    private void playTurn() {
        turn.play(currentPlayer);
    }

    private void nextPlayer() {
        currentPlayer = players.next();
    }

    private boolean noPlayerHasWon() {
        return !currentPlayer.hasWonAccordingTo(rules);
    }
}
