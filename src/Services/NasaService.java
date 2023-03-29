package Services;

import Clients.NasaClient;
import Utils.JsonParser;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import DAO.Planetary;

public class NasaService {

    public ArrayList<Planetary> getPlanetaryApodToday() {
	NasaClient client = new NasaClient(null);
	JsonParser jsonParser = new JsonParser();
	String response = client.response();
	Map<String, String> data = jsonParser.parseForOne(response);
	Planetary planetary = new Planetary(data);
	ArrayList<Planetary> planetaries = new ArrayList<>();
	planetaries.add(planetary);

	return planetaries;
    }

    public ArrayList<Planetary> getPlanetaryApodByDatePeriod(String start_date, String end_date){
	NasaClient client = new NasaClient("&start_date="+start_date+"&end_date="+end_date);
	JsonParser jsonParser = new JsonParser();
	String response = client.response();
	List<Map<String,String>> planetaries = jsonParser.parse(response);
	ArrayList<Planetary> planetariesList = new ArrayList<>();

	for (Map<String, String> planetaryList : planetaries) {
	    Planetary planetary = new Planetary(planetaryList);
	    planetariesList.add(planetary);
	}

	return planetariesList;
    }

}
