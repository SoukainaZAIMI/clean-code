package com.c.refactoring.movie;

public class Movie {

    String rating;

    public Movie(String rating) {
        super();
        this.rating = rating;
    }

    public String getRating() {
        return rating;
    }

    // Valid formats: Axx (x = 0-9) or By (y = 1-4)
    public boolean isValidRating() {
        if (rating == null) return false;
        return isAFormat() || isBFormat();
    }

    private boolean isAFormat() {
        return rating.length() == 3
            && rating.toUpperCase().startsWith("A")
            && Character.isDigit(rating.charAt(1))
            && Character.isDigit(rating.charAt(2));
    }

    private boolean isBFormat() {
        char digit = rating.charAt(1);
        return rating.length() == 2
            && rating.toUpperCase().startsWith("B")
            && digit >= '1' && digit <= '4';
    }

    public void setRating(String rating) {
        this.rating = rating;
    }
}
