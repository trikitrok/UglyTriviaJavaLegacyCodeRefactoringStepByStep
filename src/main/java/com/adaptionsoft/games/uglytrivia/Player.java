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

    public String name() {
        return this.name;
    }

    public void tryToGetOutOfPenaltyBox(int roll, Rules rules) {
        if (!rules.playerShouldContinueInPenaltyBox(roll)) {
            this.inPenaltyBox = false;
            System.out.println(this.name + " is getting out of the penalty box");
        } else {
            System.out.println(this.name + " is not getting out of the penalty box");
        }
    }

    public void advance(int places, Board board) {
        this.place = board.getPlaceAhead(this.place, places);
        System.out.println(this.name + "'s new location is " + this.place);
    }

    public int place() {
        return this.place;
    }
}
