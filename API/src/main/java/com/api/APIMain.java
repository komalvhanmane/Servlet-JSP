package com.api;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class APIMain {
	public static void main(String[] args) throws IOException, InterruptedException {
//		String url="https://api.themoviedb.org/3/movie/65/images?api_key=2b5cabf80643a494399746b96314764f&language=en-US";
		//httprequest
		String url="https://jsonmock.hackerrank.com/api/inventory?barcode=74002314";
		HttpRequest request =HttpRequest.newBuilder().GET().uri(URI.create(url)).build();
		
		HttpClient client=HttpClient.newBuilder().build();
		HttpResponse response=client.send(request, HttpResponse.BodyHandlers.ofString());
		System.out.println(response.statusCode());
		System.out.println();
//		System.out.println(response.getClass());
	}
}
