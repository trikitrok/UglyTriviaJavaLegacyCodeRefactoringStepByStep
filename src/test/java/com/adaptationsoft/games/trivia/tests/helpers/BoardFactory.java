package com.adaptationsoft.games.trivia.tests.helpers;

import com.adaptionsoft.games.uglytrivia.Board;
import com.adaptionsoft.games.uglytrivia.Categories;
import com.adaptionsoft.games.uglytrivia.Questions;

public class BoardFactory {
    public static Board create() {
        Questions questions = QuestionsFactory.create();
        Categories categories = CategoriesFactory.create();
        return new Board(categories, questions);
    }
}
