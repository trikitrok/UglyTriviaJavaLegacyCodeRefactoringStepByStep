package com.adaptionsoft.games.uglytrivia;

public class Player {
    public static final int GOLD_COINS_PER_WIN = 1;

    int place;
    String name;
    int goldCoins;
    boolean inPenaltyBox;

    public Player(String name) {
        this.name = name;
        this.place = 0;
        this.goldCoins = 0;
        this.inPenaltyBox = false;
    }

    public void winGoldCoin() {
        this.goldCoins += GOLD_COINS_PER_WIN;
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

    public void getOutOfPenaltyBox() {
        this.inPenaltyBox = false;
    }

    public void advance(int places, Board board) {
        this.place = board.getPlaceAhead(this.place, places);
    }

    public int place() {
        return this.place;
    }

    public String toString() {
        return this.name;
    }

    public int goldCoins() {
        return this.goldCoins;
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
