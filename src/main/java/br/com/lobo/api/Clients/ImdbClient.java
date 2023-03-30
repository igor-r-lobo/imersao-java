package br.com.lobo.api.Clients;

import java.net.http.HttpResponse;

public class ImdbClient {

    private final String endpoint = "https://raw.githubusercontent.com/alura-cursos/imersao-java-2-api/main/TopMovies.json";
    private HttpClient client;

    public ImdbClient() {
	this.client = new HttpClient(this.endpoint);
    }

    public String getData() {
	HttpResponse<String> response = this.client.response();
	return response.body();
    }

}
