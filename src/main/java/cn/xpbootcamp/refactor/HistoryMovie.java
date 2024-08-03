package cn.xpbootcamp.refactor;

public class HistoryMovie extends Movie {
    HistoryMovie(String title) {

        super(title, Movie.HISTORY);
    }

    @Override
    public double getAmount(int daysRented) {
        if (daysRented > 2) {
            return 2 + (daysRented - 2) * 1.5;
        } else {
            return 2;
        }
    }
}
