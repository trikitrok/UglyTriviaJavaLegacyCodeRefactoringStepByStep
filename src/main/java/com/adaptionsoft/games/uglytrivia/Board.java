package com.adaptionsoft.games.uglytrivia;

public class Board {
    private final int BOARDS_PLACES_NUMBER = 12;

    public int getPlaceAhead(int currentPlace, int places) {
        int place = currentPlace + places;
        if (place > BOARDS_PLACES_NUMBER - 1) {
            place = place - BOARDS_PLACES_NUMBER;
        }
        return place;
    }
}
