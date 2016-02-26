package com.adaptationsoft.games.trivia.tests.helpers;

import com.adaptionsoft.games.uglytrivia.Category;
import com.adaptionsoft.games.uglytrivia.QuestionsDecksByCategory;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

public class QuestionsDecksByCategoryFactory {

    public static QuestionsDecksByCategory create() {
        Map<Category, Deque<String>> questionsByCategory = new HashMap<Category, Deque<String>>();
        questionsByCategory.put(Category.Pop, new ArrayDeque<String>());
        questionsByCategory.put(Category.Science, new ArrayDeque<String>());
        questionsByCategory.put(Category.Sports, new ArrayDeque<String>());
        questionsByCategory.put(Category.Rock, new ArrayDeque<String>());

        initializeQuestionsByCategory(questionsByCategory);

        return new QuestionsDecksByCategory(questionsByCategory);
    }

    private static void initializeQuestionsByCategory(Map<Category, Deque<String>> questionsByCategory) {
        for (int i = 0; i < 50; i++) {
            questionsByCategory.get(Category.Pop).addLast("Pop Question " + i);
            questionsByCategory.get(Category.Science).addLast("Science Question " + i);
            questionsByCategory.get(Category.Sports).addLast("Sports Question " + i);
            questionsByCategory.get(Category.Rock).addLast("Rock Question " + i);
        }
    }
}
