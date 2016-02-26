package com.adaptionsoft.games.uglytrivia;

import java.util.Deque;
import java.util.Map;

public class QuestionsDecksByCategory {
    Map<Category, Deque<String>> questionsDecksByCategory;

    public QuestionsDecksByCategory(Map<Category, Deque<String>> questionsDecksByCategory) {
        this.questionsDecksByCategory = questionsDecksByCategory;
    }

    public String nextQuestionAbout(Category category) {
        return questionsDecksByCategory.get(category).removeFirst();
    }
}
