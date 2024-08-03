package cn.xpbootcamp.refactor.movie;

public class CampusMovie extends Movie {
    public CampusMovie(String title) {
        super(title, MovieType.CAMPUS);
    }

    @Override
    public double getAmount(int daysRented) {
        if (daysRented > 3) {
            return 1.5 + (daysRented - 3) * 1.5;
        } else {
            return 1.5;
        }
    }
}
