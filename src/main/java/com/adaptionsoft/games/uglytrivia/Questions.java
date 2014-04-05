package com.adaptionsoft.games.uglytrivia;

import java.util.LinkedList;

public class Questions {
    LinkedList<String> popQuestions = new LinkedList<String>();
    LinkedList<String> scienceQuestions = new LinkedList<String>();
    LinkedList<String> sportsQuestions = new LinkedList<String>();
    LinkedList<String> rockQuestions = new LinkedList<String>();

    public Questions() {
        for (int i = 0; i < 50; i++) {
            popQuestions.addLast("Pop Question " + i);
            scienceQuestions.addLast(("Science Question " + i));
            sportsQuestions.addLast(("Sports Question " + i));
            rockQuestions.addLast("Rock Question " + i);
        }
    }

    public String nextQuestionAbout(String category) {
        String question = "";

        if (category == "Pop")
            question = popQuestions.removeFirst();
        if (category == "Science")
            question = scienceQuestions.removeFirst();
        if (category == "Sports")
            question = sportsQuestions.removeFirst();
        if (category == "Rock")
            question = rockQuestions.removeFirst();

        return question;
    }

}
