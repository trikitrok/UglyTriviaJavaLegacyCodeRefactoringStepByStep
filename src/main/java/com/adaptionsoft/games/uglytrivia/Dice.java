package com.adaptionsoft.games.uglytrivia;

import java.util.Random;

public class Dice {

    private Random rand;
    private final int DICE_SIDES = 6;

    public Dice(Random rand) {
        super();
        this.rand = rand;
    }

    public int roll() {
        int roll = rand.nextInt(DICE_SIDES - 1) + 1;
        System.out.println("They have rolled a " + roll);
        return roll;
    }
}
