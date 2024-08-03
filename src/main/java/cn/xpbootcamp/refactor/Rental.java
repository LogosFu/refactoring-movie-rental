package cn.xpbootcamp.refactor;

import cn.xpbootcamp.refactor.movie.Movie;

public class Rental {

    private Movie movie;
    private int daysRented;

    Rental(Movie movie, int daysRented) {
        this.movie = movie;
        this.daysRented = daysRented;
    }

    Movie getMovie() {
        return movie;
    }

    int getDaysRented() {
        return daysRented;
    }

    int getAddPoint() {
        return (getMovie().getPriceCode() == Movie.NEW_RELEASE) && getDaysRented() > 1 ? 2 : 1;
    }

    double getRowAmount() {
        return movie.getAmount(getDaysRented());
    }

    StringBuilder buildRow() {
        StringBuilder row = new StringBuilder();
        row.append("\t")
                .append(getMovie().getTitle())
                .append("\t")
                .append(getRowAmount()).append("\n");
        return row;
    }
}
