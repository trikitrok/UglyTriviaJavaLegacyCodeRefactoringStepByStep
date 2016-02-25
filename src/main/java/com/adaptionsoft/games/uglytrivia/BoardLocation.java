package com.adaptionsoft.games.uglytrivia;

public class BoardLocation {
    private final Category category;
    private final String question;

    public BoardLocation(Category category, String question) {
        this.category = category;
        this.question = question;
    }

    public Category category() {
        return category;
    }

    public String question() {
        return question;
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
