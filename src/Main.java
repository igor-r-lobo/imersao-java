import Services.ImdbService;
import Services.StickersService;
import java.io.IOException;
import java.util.ArrayList;
import DAO.Movie;

public class Main {

    public static void main(String[] args) throws IOException, InterruptedException {

	ImdbService imdbService = new ImdbService();
	StickersService stickersService = new StickersService();
	ArrayList<Movie> moviesList = imdbService.getMoviesList();

	for (Movie movie : moviesList) {
	    stickersService.create(movie.image, movie.title);
	}
    }
}