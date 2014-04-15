package com.adaptionsoft.games.uglytrivia;

import java.util.ArrayList;
import java.util.List;

public class Categories {
    private List<Category> categories;

    public Categories() {
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

    public Category categoryAt(int place) {
        return categories.get(place);
    }
}
