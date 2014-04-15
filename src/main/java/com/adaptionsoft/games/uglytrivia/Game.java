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
        presentPlayers();
        play();
    }

    private void play() {
        do {
            nextPlayer();
            playTurn();
        } while (noPlayerHasWon());
    }

    private void presentPlayers() {
        int num = 0;
        for (Player player : players) {
            System.out.println(player + " was added");
            System.out.println("They are player number " + String.valueOf(++num));
        }
    }

    private void playTurn() {
        turn.play(currentPlayer);
    }

    private void nextPlayer() {
        currentPlayer = players.next();
        System.out.println(currentPlayer + " is the current player");
    }

    private boolean noPlayerHasWon() {
        return !currentPlayer.hasWonAccordingTo(rules);
    }
}
