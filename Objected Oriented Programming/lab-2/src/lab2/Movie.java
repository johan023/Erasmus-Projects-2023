package lab2;

public class Movie {
	private String name;
    private String director;
    
    public Movie(String name, String director) {
        this.name = name;
        this.director = director;
    }

    public String getName() {
        return name;
    }

    public String getDirector() {
        return director;
    }
}
