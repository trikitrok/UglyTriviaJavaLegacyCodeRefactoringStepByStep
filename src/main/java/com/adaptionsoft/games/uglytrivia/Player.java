package com.adaptionsoft.games.uglytrivia;

public class Player {
    int place;
    String name;
    int goldCoins;
    boolean inPenaltyBox;

    public Player(String name) {
        super();
        this.name = name;
        this.place = 0;
        this.goldCoins = 0;
        this.inPenaltyBox = false;
    }

    public void moveTo(int newPlace) {
        this.place = newPlace;
    }

    public int place() {
        return this.place;
    }

    public boolean isAt(int place) {
        return this.place == place;
    }

    public void winGoldCoin() {
        this.goldCoins++;
    }

    public boolean hasWonAccordingTo(Rules rules) {
        return rules.playerHasWon(this.goldCoins);
    }

    public Object coins() {
        return this.goldCoins;
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
}
