package com.adaptionsoft.games.uglytrivia;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class Questions {
    Map<Category, LinkedList<String>> questionsByCategory;

    public Questions() {
        questionsByCategory = new HashMap<Category, LinkedList<String>>();
        questionsByCategory.put(Category.Pop, new LinkedList<String>());
        questionsByCategory.put(Category.Science, new LinkedList<String>());
        questionsByCategory.put(Category.Sports, new LinkedList<String>());
        questionsByCategory.put(Category.Rock, new LinkedList<String>());

        for (int i = 0; i < 50; i++) {
            questionsByCategory.get(Category.Pop).addLast("Pop Question " + i);
            questionsByCategory.get(Category.Science).addLast("Science Question " + i);
            questionsByCategory.get(Category.Sports).addLast("Sports Question " + i);
            questionsByCategory.get(Category.Rock).addLast("Rock Question " + i);
        }
    }

    public String nextQuestionAbout(Category category) {
        return questionsByCategory.get(category).removeFirst();
    }

}
