package com.adaptionsoft.games.uglytrivia;

public class BoardLocation {
    private final Category category;
    private final String question;
    private int position;

    public BoardLocation(Category category, String question, int position) {
        this.category = category;
        this.question = question;
        this.position = position;
    }

    public Category category() {
        return category;
    }

    public String question() {
        return question;
    }

    public int position() {
        return position;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BoardLocation that = (BoardLocation) o;

        if (category() != that.category()) return false;
        return question() != null ? question().equals(that.question()) : that.question() == null;

    }

    @Override
    public int hashCode() {
        int result = category() != null ? category().hashCode() : 0;
        result = 31 * result + (question() != null ? question().hashCode() : 0);
        return result;
    }
}
