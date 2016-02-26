package com.adaptationsoft.games.trivia.tests.unit;

import com.adaptationsoft.games.trivia.tests.helpers.BoardFactory;
import com.adaptionsoft.games.uglytrivia.Board;
import com.adaptionsoft.games.uglytrivia.BoardLocation;
import com.adaptionsoft.games.uglytrivia.Category;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class BoardShould {
    @Test
    public void return_the_board_location_at_a_given_place() {
        Board board = BoardFactory.create();
        assertThat(board.boardLocationAt(0), is(board.boardLocationAt(0)));
    }

    @Test
    public void return_the_board_location_some_places_ahead() {
        Board board = BoardFactory.create();
        assertThat(board.getLocationAhead(
            board.boardLocationAt(0), 1),
            is(board.boardLocationAt(1))
        );
    }
}
