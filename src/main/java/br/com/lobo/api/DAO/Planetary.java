package br.com.lobo.api.DAO;

import java.util.ArrayList;
import java.util.Date;
import java.util.Map;

public class Planetary {
    public String explanation;
    public String date;
    public String hdUrl;
    public String title;
    public String url;

    public Planetary(Map<String, String> planetaryList){
	this.explanation = planetaryList.get("explanation");
	this.date = planetaryList.get("date");
	this.hdUrl = planetaryList.get("hdurl");
	this.title = planetaryList.get("title");
	this.url = planetaryList.get("url");
    }

    public ArrayList<String> planetaryAllData(){
	ArrayList<String> data = new ArrayList<>();
	data.add(this.title);
	data.add(this.explanation);
	data.add(this.date);
	data.add(this.hdUrl);
	data.add(this.url);

	return data;
    }
}
