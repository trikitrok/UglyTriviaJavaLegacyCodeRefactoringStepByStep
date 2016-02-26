package com.adaptionsoft.games.uglytrivia;

public class Player {
    public static final int GOLD_COINS_PER_WIN = 1;
    private final GameNotifications gameNotifications;

    String name;
    int goldCoins;
    boolean inPenaltyBox;
    BoardLocation boardLocation;

    public Player(String name, GameNotifications gameNotifications) {
        this.gameNotifications = gameNotifications;
        this.name = name;
        this.goldCoins = 0;
        this.inPenaltyBox = false;
    }

    public void advance(int places, Board board) {
        if (inPenaltyBox()) {
            return;
        }
        boardLocation = board.advance(boardLocation(board), places);
        gameNotifications.newBoardLocation(this, boardLocation);
    }

    public void tryToGetOutOfPenaltyBox(int roll, Rules rules) {
        if (!inPenaltyBox()) {
            return;
        }

        if (rules.playerShouldContinueInPenaltyBox(roll)) {
            gameNotifications.notGettingOutOfPenaltyBox(this);
            return;
        }
        getOutOfPenaltyBox();
    }

    private void getOutOfPenaltyBox() {
        this.inPenaltyBox = false;
        gameNotifications.gettingOutOfPenaltyBox(this);
    }

    public void winGoldCoin() {
        this.goldCoins += GOLD_COINS_PER_WIN;
        gameNotifications.playerWins(this);
    }

    public boolean hasWonAccordingTo(Rules rules) {
        return rules.playerHasWon(this.goldCoins);
    }

    public boolean inPenaltyBox() {
        return this.inPenaltyBox;
    }

    public void enterPenaltyBox() {
        this.inPenaltyBox = true;
    }

    public int place() {
        return boardLocation.position();
    }

    public String toString() {
        return this.name;
    }

    public int goldCoins() {
        return this.goldCoins;
    }

    private BoardLocation boardLocation(Board board) {
        if(boardLocation == null) {
            boardLocation = board.startLocation();
        }
        return boardLocation;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Player player = (Player) o;

        return name.equals(player.name);

    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }
}
