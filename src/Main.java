import Services.ImdbService;
import java.io.IOException;
import java.util.ArrayList;
import DAO.Movie;

public class Main {

    public static void main(String[] args) throws IOException, InterruptedException {

	ImdbService imdbService = new ImdbService();
	ArrayList<Movie> moviesList = imdbService.getMoviesList();

	for (Movie movie : moviesList) {
	    System.out.println(movie.getMovieData());
	}
    }
}