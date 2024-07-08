package lab2;

public class Exercise1 {

	// Usage example
	public class Main {
	    public static void main(String[] args) {
	        WatchedMovie movie = new WatchedMovie("Guardians of the Galaxy", "James Gunn");

	        movie.watch(7.5);
	        System.out.println(movie.getNumberOfViews()); // returns 1
	        System.out.println(movie.getHighestRating()); // returns 7.5

	        movie.watch(11.0);
	        System.out.println(movie.getNumberOfViews()); // returns 2
	        System.out.println(movie.getHighestRating()); // returns 7.5

	        for (int i = 0; i < 20; i++) {
	            movie.watch(7.1);
	        }
	        System.out.println(movie.getNumberOfViews()); // returns 22
	        System.out.println(movie.getHighestRating()); // returns 7.5

	        movie.watch(8.0);
	        System.out.println(movie.getNumberOfViews()); // returns 23
	        System.out.println(movie.getHighestRating()); // returns 8.0

	        System.out.println(movie); // prints "WatchedMovie [name=Guardians of the Galaxy, director=James Gunn, numberOfViews=23, highestRating=8.0]"
	    }
	}



}
