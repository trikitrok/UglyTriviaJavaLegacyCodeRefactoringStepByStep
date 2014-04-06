package com.adaptionsoft.games.uglytrivia;

import java.util.ArrayList;
import java.util.List;

public class Board {
    private final int BOARDS_PLACES_NUMBER = 12;
    private List<Category> categories;

    public Board() {
        this.categories = new ArrayList<Category>();

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
    }

    public int getPlaceAhead(int currentPlace, int places) {
        int place = currentPlace + places;
        if (place > BOARDS_PLACES_NUMBER - 1) {
            place = place - BOARDS_PLACES_NUMBER;
        }
        return place;
    }

    public Category categoryAt(int place) {
        return categories.get(place);
    }
}
