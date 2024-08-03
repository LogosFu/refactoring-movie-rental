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
                thisAmount += 2;
                if (getDaysRented() > 2)
                    thisAmount += (getDaysRented() - 2) * 1.5;
                break;
            case Movie.NEW_RELEASE:
                thisAmount += getDaysRented() * 3;
                break;
            case Movie.CAMPUS:
                thisAmount += 1.5;
                if (getDaysRented() > 3)
                    thisAmount += (getDaysRented() - 3) * 1.5;
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
