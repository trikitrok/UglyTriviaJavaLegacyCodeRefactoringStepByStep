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
        QuestionsDecksByCategory questionsDecksByCategory = QuestionsDecksByCategoryFactory.create();
        BoardLocation secondOne = new BoardLocation(Category.Science, questionsDecksByCategory, 1);
        BoardLocation fourthOne = new BoardLocation(Category.Sports, questionsDecksByCategory, 3);
        BoardLocation anyOne = null;
        List<BoardLocation> boardLocations = new ArrayList<BoardLocation>();
        boardLocations.add(anyOne);
        boardLocations.add(secondOne);
        boardLocations.add(anyOne);
        boardLocations.add(fourthOne);
        Board board = new Board(boardLocations);

        assertThat(board.advance(secondOne, 2), is(fourthOne));
    }
}
