package br.com.lobo.api.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import br.com.lobo.api.Services.ImdbService;
import br.com.lobo.api.DAO.Movie;

import java.lang.reflect.Array;
import java.util.ArrayList;

@RestController
public class ImdbController {

    @GetMapping("/imdb/movies")
    public ArrayList<Movie> getMovies(){
	ImdbService service = new ImdbService();

	return service.getMoviesList();
    }
}
