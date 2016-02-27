package com.adaptionsoft.games.uglytrivia;

import java.util.Deque;

public class QuestionsDeck {
    private Deque<String> questionsDeck;

    public QuestionsDeck(Deque<String> questionsDeck) {
        this.questionsDeck = questionsDeck;
    }

    public String nextQuestion() {
        return questionsDeck.removeFirst();
    }
}
