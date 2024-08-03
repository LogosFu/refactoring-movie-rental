package cn.xpbootcamp.refactor;

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
}
