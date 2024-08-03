package cn.xpbootcamp.refactor;

public class Movie {

    static final int CAMPUS = 2;
    static final int HISTORY = 0;
    static final int NEW_RELEASE = 1;

    protected String title;
    protected int priceCode;

    Movie(String title, int priceCode) {
        this.title = title;
        this.priceCode = priceCode;
    }

    int getPriceCode() {
        return priceCode;
    }

    String getTitle() {
        return title;
    }

    public double getAmount(int daysRented) {
        return 0;
    }


    double getCampusAmount(int daysRented) {
        if (daysRented > 3) {
            return 1.5 + (daysRented - 3) * 1.5;
        } else {
            return 1.5;
        }
    }

    int getNewReleaseAmount(int daysRented) {
        return daysRented * 3;
    }

    double getHistoryAmount(int daysRented) {
        if (daysRented > 2) {
            return 2 + (daysRented - 2) * 1.5;
        } else {
            return 2;
        }
    }
}
