package Clients;

import Clients.HttpClient;

import java.net.http.HttpResponse;

public class NasaClient {
    private String endpoint = "https://api.nasa.gov/planetary/apod?api_key=1ULOVX4ORj1kIdbDwS6hdNWafaAJZ61DFM7W839x";
    private HttpClient client;

    public NasaClient(String params){

	if (params != null){
	    this.endpoint = this.endpoint+params;
	}

	this.client = new HttpClient(this.endpoint);
    }

    public String response(){
	HttpResponse<String> response = this.client.response();
	return response.body();
    }
}
