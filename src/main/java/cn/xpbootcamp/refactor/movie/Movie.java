package cn.xpbootcamp.refactor.movie;

public abstract class Movie {

    public static final int CAMPUS = 2;
    public static final int HISTORY = 0;
    public static final int NEW_RELEASE = 1;

    protected String title;
    protected int priceCode;

    Movie(String title, int priceCode) {
        this.title = title;
        this.priceCode = priceCode;
    }

    public int getPriceCode() {
        return priceCode;
    }

    public String getTitle() {
        return title;
    }

    public abstract double getAmount(int daysRented);
}
