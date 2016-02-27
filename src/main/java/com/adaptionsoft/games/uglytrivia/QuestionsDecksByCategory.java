package com.adaptionsoft.games.uglytrivia;

import java.util.Map;

public class QuestionsDecksByCategory {
    Map<Category, QuestionsDeck> questionsDecksByCategory;

    public QuestionsDecksByCategory(Map<Category, QuestionsDeck> questionsDecksByCategory) {
        this.questionsDecksByCategory = questionsDecksByCategory;
    }

    public String nextQuestionAbout(Category category) {
        return questionsDecksByCategory.get(category).nextQuestion();
    }
}
