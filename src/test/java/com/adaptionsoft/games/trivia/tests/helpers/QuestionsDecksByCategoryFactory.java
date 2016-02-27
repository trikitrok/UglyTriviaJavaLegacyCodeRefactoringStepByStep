package com.adaptionsoft.games.trivia.tests.helpers;

import com.adaptionsoft.games.uglytrivia.Category;
import com.adaptionsoft.games.uglytrivia.QuestionsDeck;
import com.adaptionsoft.games.uglytrivia.QuestionsDecksByCategory;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

public class QuestionsDecksByCategoryFactory {

    public static QuestionsDecksByCategory create() {
        Map<Category, QuestionsDeck> questionsDecksByCategory = new HashMap<Category, QuestionsDeck>();
        questionsDecksByCategory.put(Category.Pop, createQuestionsDeck(Category.Pop, 50));
        questionsDecksByCategory.put(Category.Science, createQuestionsDeck(Category.Science, 50));
        questionsDecksByCategory.put(Category.Sports, createQuestionsDeck(Category.Sports, 50));
        questionsDecksByCategory.put(Category.Rock, createQuestionsDeck(Category.Rock, 50));

        return new QuestionsDecksByCategory(questionsDecksByCategory);
    }

    private static QuestionsDeck createQuestionsDeck(Category category, int num) {
        Deque<String> questionsDeck = new ArrayDeque<String>();
        for (int i = 0; i < num; i++) {
            questionsDeck.addLast(category + " Question " + i);
        }
        return new QuestionsDeck(questionsDeck);
    }
}
