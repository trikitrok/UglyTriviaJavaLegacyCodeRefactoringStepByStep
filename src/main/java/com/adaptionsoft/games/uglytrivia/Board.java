package com.adaptionsoft.games.uglytrivia;

import java.util.List;

public class Board {
    private final int BOARD_LENGTH = 12;
    private List<BoardLocation> boardLocations;

    public Board(List<BoardLocation> boardLocations) {
        this.boardLocations = boardLocations;
    }

    public BoardLocation advance(BoardLocation currentBoardLocation, int positions) {
        return boardLocationAt(getPositionAhead(currentBoardLocation.position(), positions));
    }

    public BoardLocation startLocation() {
        return boardLocations.get(0);
    }

    private BoardLocation boardLocationAt(int position) {
        return boardLocations.get(position);
    }

    private int getPositionAhead(int currentPositions, int positions) {
        int position = currentPositions + positions;
        return position % BOARD_LENGTH;
    }
}
