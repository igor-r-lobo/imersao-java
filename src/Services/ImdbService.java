package Services;

import Clients.ImdbClient;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import Utils.JsonParser;
import DAO.Movie;

public class ImdbService {

    private String movies;
    private List<Map<String, String>> moviesList;

    public ImdbService() {
	this.makeRequest();
	this.parseData();
    }

    public ArrayList<Movie> getMoviesList() {
	ArrayList<Movie> movieListData = new ArrayList<>();

	for (Map<String, String> MovieList : this.moviesList) {
	    Movie movie = new Movie(MovieList);
	    movieListData.add(movie);
	}

	return movieListData;
    }

    private void makeRequest() {
	ImdbClient client = new ImdbClient();
	this.movies = client.getData();
    }

    private void parseData() {
	JsonParser jsonParser = new JsonParser();
	this.moviesList = jsonParser.parse(this.movies);
    }
}
