package com.adaptionsoft.games.trivia.tests.helpers;

import com.adaptionsoft.games.uglytrivia.Category;
import com.adaptionsoft.games.uglytrivia.QuestionsDeck;
import com.adaptionsoft.games.uglytrivia.QuestionsDecksByCategory;

import java.util.HashMap;
import java.util.Map;

public class QuestionsDecksByCategoryBuilder {
    private final Map<Category, QuestionsDeck> questionsDecksByCategory;

    public static QuestionsDecksByCategoryBuilder aQuestionsDecksByCategory() {
        return new QuestionsDecksByCategoryBuilder();
    }

    private QuestionsDecksByCategoryBuilder() {
        questionsDecksByCategory = new HashMap<Category, QuestionsDeck>();
    }

    public QuestionsDecksByCategoryBuilder with(Category category, QuestionsDeckBuilder questionsDeckBuilder) {
        questionsDecksByCategory.put(category, questionsDeckBuilder.build());
        return this;
    }

    public QuestionsDecksByCategoryBuilder andWith(Category category, QuestionsDeckBuilder questionsDeckBuilder) {
        return with(category, questionsDeckBuilder);
    }

    public QuestionsDecksByCategory build() {
        return new QuestionsDecksByCategory(questionsDecksByCategory);
    }
}
