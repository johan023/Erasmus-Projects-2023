package lab2;

public class WatchedMovie extends Movie implements WatchableMovie {
    
    private int numberOfViews;
    private double highestRating;

    public WatchedMovie(String name, String director) {
        super(name, director);
        this.numberOfViews = 0;
        this.highestRating = 0;
    }

    @Override
    public void watch(double rating) {
        numberOfViews++;
        if (rating >= 0 && rating <= 10) {
            if (rating > highestRating) {
                highestRating = rating;
            }
        }
    }

    @Override
    public int getNumberOfViews() {
        return numberOfViews;
    }

    @Override
    public double getHighestRating() {
        return highestRating;
    }

    @Override
    public String toString() {
        return "WatchedMovie [name=" + getName() + ", director=" + getDirector() + ", numberOfViews=" + numberOfViews + ", highestRating=" + highestRating + "]";
    }
}
