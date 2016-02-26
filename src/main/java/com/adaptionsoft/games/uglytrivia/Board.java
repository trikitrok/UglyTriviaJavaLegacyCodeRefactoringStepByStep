package com.adaptionsoft.games.uglytrivia;

import java.util.List;

public class Board {
    private final int BOARDS_PLACES_NUMBER = 12;
    private List<BoardLocation> boardLocations;

    public Board(List<BoardLocation> boardLocations) {
        this.boardLocations = boardLocations;
    }

    public int getPlaceAhead(int currentPlace, int places) {
        int place = currentPlace + places;
        if (place > BOARDS_PLACES_NUMBER - 1) {
            place = place - BOARDS_PLACES_NUMBER;
        }
        return place;
    }

    public BoardLocation boardLocationAt(int place) {
        return boardLocations.get(place);
    }

    public BoardLocation getLocationAhead(BoardLocation currentBoardLocation, int places) {
        return boardLocationAt(getPlaceAhead(currentBoardLocation.position(), places));
    }

    public BoardLocation getStart() {
        return boardLocations.get(0);
    }
}
