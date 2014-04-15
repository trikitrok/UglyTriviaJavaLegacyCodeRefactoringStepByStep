package com.adaptionsoft.games.uglytrivia;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

public class Questions {
    Map<Category, Deque<String>> questionsByCategory;

    public Questions() {
        questionsByCategory = new HashMap<Category, Deque<String>>();
        questionsByCategory.put(Category.Pop, new ArrayDeque<String>());
        questionsByCategory.put(Category.Science, new ArrayDeque<String>());
        questionsByCategory.put(Category.Sports, new ArrayDeque<String>());
        questionsByCategory.put(Category.Rock, new ArrayDeque<String>());

        initializeQuestionsByCategory();
    }

    public String nextQuestionAbout(Category category) {
        return questionsByCategory.get(category).removeFirst();
    }

    private void initializeQuestionsByCategory() {
        for (int i = 0; i < 50; i++) {
            questionsByCategory.get(Category.Pop).addLast("Pop Question " + i);
            questionsByCategory.get(Category.Science).addLast("Science Question " + i);
            questionsByCategory.get(Category.Sports).addLast("Sports Question " + i);
            questionsByCategory.get(Category.Rock).addLast("Rock Question " + i);
        }
    }
}
