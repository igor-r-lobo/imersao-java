package br.com.lobo.api.DAO;

import java.util.Map;
import java.util.ArrayList;

public class Movie {

    public String title;
    public String fullTitle;
    public String crew;
    public String image;
    public String year;
    public String rank;
    public String id;
    public String imdbRating;

    public Movie(Map<String, String> MovieList) {
	this.title = MovieList.get("title");
	this.fullTitle = MovieList.get("fullTitle");
	this.crew = MovieList.get("crew");
	this.image = MovieList.get("image");
	this.year = MovieList.get("year");
	this.rank = MovieList.get("rank");
	this.id = MovieList.get("id");
	this.imdbRating = MovieList.get("imDbRating");
    }

    public ArrayList<String> getMovieData() {
	ArrayList<String> movie = new ArrayList<>();
	movie.add(this.title);
	movie.add(this.fullTitle);
	movie.add(this.crew);
	movie.add(this.image);
	movie.add(this.year);
	movie.add(this.rank);
	movie.add(this.id);
	movie.add(this.imdbRating);

	return movie;
    }
}
