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
        System.out.println(this.name + "'s new location is " + this.place);
    }

    public int place() {
        return this.place;
    }

    public boolean isAt(int place) {
        return this.place == place;
    }

    public void winGoldCoin() {
        this.goldCoins++;
        System.out.println(this.name + " now has " + this.goldCoins + " Gold Coins.");
    }

    public boolean hasWonAccordingTo(Rules rules) {
        return rules.playerHasWon(this.goldCoins);
    }

    public boolean inPenaltyBox() {
        return this.inPenaltyBox;
    }

    public void enterPenaltyBox() {
        this.inPenaltyBox = true;
        System.out.println(this.name + " was sent to the penalty box");
    }

    public void getOutOfPenaltyBox() {
        this.inPenaltyBox = false;
    }

    public String name() {
        return this.name;
    }
}
