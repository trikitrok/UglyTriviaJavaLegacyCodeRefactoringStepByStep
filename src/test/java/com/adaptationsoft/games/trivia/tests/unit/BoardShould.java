package com.adaptationsoft.games.trivia.tests.unit;

import com.adaptationsoft.games.trivia.tests.helpers.QuestionsDecksByCategoryFactory;
import com.adaptionsoft.games.uglytrivia.Board;
import com.adaptionsoft.games.uglytrivia.BoardLocation;
import com.adaptionsoft.games.uglytrivia.Category;
import com.adaptionsoft.games.uglytrivia.QuestionsDecksByCategory;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class BoardShould {
    @Test
    public void advance_board_location_some_positions_ahead() {
        QuestionsDecksByCategory anyQuestionsDecksByCategory = null;
        BoardLocation secondBoardLocation = new BoardLocation(Category.Science, anyQuestionsDecksByCategory, 1);
        BoardLocation fourthBoardLocation = new BoardLocation(Category.Sports, anyQuestionsDecksByCategory, 3);
        BoardLocation anyBoardLocation = null;
        List<BoardLocation> boardLocations = new ArrayList<BoardLocation>();
        boardLocations.add(anyBoardLocation);
        boardLocations.add(secondBoardLocation);
        boardLocations.add(anyBoardLocation);
        boardLocations.add(fourthBoardLocation);
        Board board = new Board(boardLocations);

        assertThat(board.advance(secondBoardLocation, 2), is(fourthBoardLocation));
    }
}
