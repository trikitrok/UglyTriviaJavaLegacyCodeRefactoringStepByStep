package com.adaptionsoft.games.trivia.tests.helpers;

import com.adaptionsoft.games.uglytrivia.QuestionsDeck;

import java.util.ArrayDeque;
import java.util.Deque;

public class QuestionsDeckBuilder {
    private final Deque<String> questions;

    public static QuestionsDeckBuilder aQuestionDeck() {
        return new QuestionsDeckBuilder();
    }

    private QuestionsDeckBuilder() {
        questions = new ArrayDeque<String>();
    }

    public QuestionsDeckBuilder withQuestions(String... questions) {
        for (String question : questions) {
            this.questions.addLast(question);
        }
        return this;
    }

    public QuestionsDeck build() {
        return new QuestionsDeck(questions);
    }
}
