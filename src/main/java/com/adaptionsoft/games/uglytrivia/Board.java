package com.adaptionsoft.games.uglytrivia;

public class Board {
    private final int BOARDS_PLACES_NUMBER = 12;
    private Categories categories;
    private Questions questions;

    public static Board create() {
        return new Board(new Categories(), new Questions());
    }

    public Board(Categories categories, Questions questions) {
        this.categories = categories;
        this.questions = questions;
    }

    public int getPlaceAhead(int currentPlace, int places) {
        int place = currentPlace + places;
        if (place > BOARDS_PLACES_NUMBER - 1) {
            place = place - BOARDS_PLACES_NUMBER;
        }
        return place;
    }

    public String questionAt(int place) {
        return questions.nextQuestionAbout(categoryAt(place));
    }

    public Category categoryAt(int place) {
        return categories.categoryAt(place);
    }

    public BoardLocation boardLocationAt(int place) {
        return new BoardLocation(categoryAt(place), questionAt(place));
    }

    public BoardLocation getLocationAhead(int currentPlace, int places) {
        return boardLocationAt(getPlaceAhead(currentPlace, places));
    }
}
