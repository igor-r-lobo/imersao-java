package br.com.lobo.api.Clients;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.logging.Logger;

public class HttpClient {

    private URI uri;
    private java.net.http.HttpClient client;
    private HttpRequest request;
    private Logger log;


    public HttpClient(String endpoint) {
	this.uri = URI.create(endpoint);
	this.connection();
	this.log = Logger.getLogger(HttpClient.class.getName());
    }

    public HttpResponse<String> response() {
	try {
	    HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
	    return response;
	} catch (IOException e) {
	  e.printStackTrace();

	} catch (InterruptedException e) {
	    e.printStackTrace();
	}
	return null;
    }

    private void connection() {
	this.client = java.net.http.HttpClient.newHttpClient();
	this.request = HttpRequest.newBuilder(this.uri).GET().build();
    }
}
