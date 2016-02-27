package com.adaptionsoft.games.trivia.tests.helpers;

import com.adaptionsoft.games.uglytrivia.Board;
import com.adaptionsoft.games.uglytrivia.BoardLocation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BoardBuilder {

    private final List<BoardLocation> boardLocations;

    public static BoardBuilder aBoard() {
        return new BoardBuilder();
    }

    private BoardBuilder() {
        boardLocations = new ArrayList<BoardLocation>();
    }

    public BoardBuilder withBoardLocations(BoardLocation... boardLocations) {
        Collections.addAll(this.boardLocations, boardLocations);
        return this;
    }

    public Board build() {
        return new Board(boardLocations);
    }
}
