package com.adaptionsoft.games.trivia.tests.unit;

import com.adaptionsoft.games.uglytrivia.Board;
import com.adaptionsoft.games.uglytrivia.BoardLocation;
import com.adaptionsoft.games.uglytrivia.Category;
import com.adaptionsoft.games.uglytrivia.QuestionsDecksByCategory;
import org.junit.Test;

import static com.adaptionsoft.games.trivia.tests.helpers.BoardBuilder.aBoard;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class BoardShould {
    @Test
    public void advance_board_location_some_positions_ahead() {
        QuestionsDecksByCategory anyQuestionsDecksByCategory = null;
        BoardLocation secondBoardLocation = new BoardLocation(Category.Science, anyQuestionsDecksByCategory, 1);
        BoardLocation fourthBoardLocation = new BoardLocation(Category.Sports, anyQuestionsDecksByCategory, 3);
        BoardLocation anyBoardLocation = null;
        Board board = aBoard().withBoardLocations(
                anyBoardLocation,
                secondBoardLocation,
                anyBoardLocation,
                fourthBoardLocation
            ).build();

        assertThat(board.advance(secondBoardLocation, 2), is(fourthBoardLocation));
    }
}
