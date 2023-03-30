package br.com.lobo.api.Controller;

import br.com.lobo.api.DAO.Planetary;
import br.com.lobo.api.Services.NasaService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
public class NasaController {

    @GetMapping("/nasa/planetary/today")
    public ArrayList<Planetary> getPlanetaryToday(){
	NasaService service = new NasaService();

	return service.getPlanetaryApodToday();
    }

    @GetMapping("/nasa/planetary")
    public ArrayList<Planetary> getPlanetaryByDate(@RequestParam("start_date") String start_date, @RequestParam("end_date") String end_date){
	NasaService service = new NasaService();

	return service.getPlanetaryApodByDatePeriod(start_date,end_date);
    }
}
