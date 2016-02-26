package com.adaptationsoft.games.trivia.tests.unit;

import com.adaptationsoft.games.trivia.tests.helpers.QuestionsDecksByCategoryFactory;
import com.adaptionsoft.games.uglytrivia.BoardLocation;
import com.adaptionsoft.games.uglytrivia.Category;
import com.adaptionsoft.games.uglytrivia.QuestionsDecksByCategory;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class BoardLocationShould {

    @Test
    public void return_questions_from_its_category_from_a_questions_deck() {
        int anyPosition = 3;
        QuestionsDecksByCategory questionsDecksByCategoryDecks = QuestionsDecksByCategoryFactory.create();
        BoardLocation boardLocation = new BoardLocation(
            Category.Sports, questionsDecksByCategoryDecks, anyPosition
        );

        assertThat(boardLocation.question(), is("Sports Question 0"));
        assertThat(boardLocation.question(), is("Sports Question 1"));
        assertThat(boardLocation.question(), is("Sports Question 2"));
        assertThat(boardLocation.question(), is("Sports Question 3"));
        assertThat(boardLocation.question(), is("Sports Question 4"));
    }
}