package com.adaptationsoft.games.trivia.tests.unit;

import com.adaptionsoft.games.uglytrivia.Board;
import com.adaptionsoft.games.uglytrivia.BoardLocation;
import com.adaptionsoft.games.uglytrivia.Category;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class BoardShould {
    @Test
    public void return_the_board_location_at_a_given_place() {
        Board board = Board.create();
        assertThat(board.boardLocationAt(0), is(new BoardLocation(Category.Pop, "Pop Question 0", 0)));
    }

    @Test
    public void return_the_board_location_some_places_ahead() {
        Board board = Board.create();
        assertThat(board.getLocationAhead(0, 1), is(new BoardLocation(Category.Science, "Science Question 0", 1)));
    }
}
