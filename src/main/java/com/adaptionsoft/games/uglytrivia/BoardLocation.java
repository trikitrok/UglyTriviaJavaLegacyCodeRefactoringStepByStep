package com.adaptionsoft.games.uglytrivia;

public class BoardLocation {
    private final Category category;
    private final Questions questions;
    private int position;

    public BoardLocation(Category category, Questions questions, int position) {
        this.category = category;
        this.questions = questions;
        this.position = position;
    }

    public Category category() {
        return category;
    }

    public String question() {
        return questions.nextQuestionAbout(category);
    }

    public int position() {
        return position;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BoardLocation that = (BoardLocation) o;

        return position == that.position;
    }

    @Override
    public int hashCode() {
        return position;
    }
}
