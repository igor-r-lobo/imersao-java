import Services.ImdbService;
import Services.NasaService;
import Services.StickersService;
import java.io.IOException;
import java.util.ArrayList;
import DAO.Movie;
import DAO.Planetary;

public class Main {

    public static void main(String[] args) throws IOException, InterruptedException {

	NasaService nasaService = new NasaService();
//	ArrayList<Planetary> planetaryToday = nasaService.getPlanetaryApodToday();
	ArrayList<Planetary> planetaryToday = nasaService.getPlanetaryApodByDatePeriod("2022-04-12", "2022-04-16");
	ImdbService imdbService = new ImdbService();
	StickersService stickersService = new StickersService();
	ArrayList<Movie> moviesList = imdbService.getMoviesList();

	for (Movie movie : moviesList) {
	    stickersService.create(movie.image, movie.title, "movies");
	}

	for (Planetary planetary : planetaryToday) {
	    stickersService.create(planetary.hdUrl, planetary.title, "planetary");

	}
    }
}