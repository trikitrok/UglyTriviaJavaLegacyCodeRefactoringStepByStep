package com.adaptionsoft.games.uglytrivia;

import java.util.Deque;
import java.util.Map;

public class Questions {
    Map<Category, Deque<String>> questionsByCategory;

    public Questions(Map<Category, Deque<String>> questionsByCategory) {
        this.questionsByCategory = questionsByCategory;
    }

    public String nextQuestionAbout(Category category) {
        return questionsByCategory.get(category).removeFirst();
    }
}
