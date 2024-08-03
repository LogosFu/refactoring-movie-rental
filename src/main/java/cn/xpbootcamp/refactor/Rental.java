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

    double getRowAmount() {
        double thisAmount = 0d;
        switch (getMovie().getPriceCode()) {
            case Movie.HISTORY:
                thisAmount += movie.getAmount(getDaysRented());
                break;
            case Movie.NEW_RELEASE:
                thisAmount += movie.getNewReleaseAmount(getDaysRented());
                break;
            case Movie.CAMPUS:
                thisAmount += movie.getCampusAmount(getDaysRented());
                break;
        }
        return thisAmount;
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
