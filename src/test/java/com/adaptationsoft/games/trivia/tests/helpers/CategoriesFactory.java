package com.adaptationsoft.games.trivia.tests.helpers;

import com.adaptionsoft.games.uglytrivia.Categories;
import com.adaptionsoft.games.uglytrivia.Category;

import java.util.ArrayList;
import java.util.List;

public class CategoriesFactory {
    public static Categories create() {
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

        return new Categories(categories);
    }
}
