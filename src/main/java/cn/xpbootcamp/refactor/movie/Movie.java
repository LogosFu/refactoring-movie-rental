package cn.xpbootcamp.refactor.movie;

public abstract class Movie {

    protected String title;
    protected MovieType type;

    public Movie(String title, MovieType type) {
        this.title = title;
        this.type = type;
    }

    public String getTitle() {
        return title;
    }

    public MovieType getType() {
        return type;
    }

    public abstract double getAmount(int daysRented);
}
