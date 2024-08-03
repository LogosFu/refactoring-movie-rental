package cn.xpbootcamp.refactor.movie;

public class NewReleaseMovie extends Movie {
    public NewReleaseMovie(String title) {
        super(title, MovieType.NEW_RELEASE);
    }

    @Override
    public double getAmount(int daysRented) {
        return daysRented * 3;
    }
}
