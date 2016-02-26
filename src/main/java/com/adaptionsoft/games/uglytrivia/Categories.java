package com.adaptionsoft.games.uglytrivia;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Categories {
    private List<Category> categories = new ArrayList<Category>();

    public Categories(Category... categories) {
        Collections.addAll(this.categories, categories);
    }

    public Categories(List<Category> categories) {
        this.categories = categories;
    }

    public Category categoryAt(int place) {
        return categories.get(place);
    }
}
