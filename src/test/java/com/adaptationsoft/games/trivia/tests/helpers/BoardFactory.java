package com.adaptationsoft.games.trivia.tests.helpers;

import com.adaptionsoft.games.uglytrivia.*;

import java.util.ArrayList;
import java.util.List;

public class BoardFactory {
    public static Board create() {
        QuestionsDecksByCategory questionsDecksByCategory = QuestionsDecksByCategoryFactory.create();

        List<BoardLocation> boardLocations = createBoardLocations(questionsDecksByCategory);

        return new Board(boardLocations);
    }

    private static List<BoardLocation> createBoardLocations(QuestionsDecksByCategory questionsDecksByCategory) {
        List<BoardLocation> boardLocations = new ArrayList<BoardLocation>();

        List<Category> categories = createCategoriesList();

        int position = 0;
        for (Category category : categories) {
            boardLocations.add(new BoardLocation(category, questionsDecksByCategory, position));
            position++;
        }

        return boardLocations;
    }

    private static List<Category> createCategoriesList() {
        List<Category> categories = new ArrayList<Category>();
        categories.add(Category.Pop);
        categories.add(Category.Science);
        categories.add(Category.Sports);
        categories.add(Category.Rock);

        categories.add(Category.Pop);
        categories.add(Category.Science);
        categories.add(Category.Sports);
        categories.add(Category.Rock);
        categories.add(Category.Pop);

        categories.add(Category.Science);
        categories.add(Category.Sports);
        categories.add(Category.Rock);
        return categories;
    }
}
