package br.com.alura.Api;


	import com.google.gson.Gson;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Api {
		String endereco = "https://v6.exchangerate-api.com/v6/f28e1e5af8fa6f5b7988a429/pair/";
		
		public String consultaMoeda(String moedaOrigem, String moedaDestino) {
			HttpClient client = HttpClient.newHttpClient();
			HttpRequest request = HttpRequest.newBuilder()
			.uri(URI.create(endereco + moedaOrigem + "/" + moedaDestino))
			.build();
			
			try {
				HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
				return response.body();
			} catch (Exception e) {
				System.out.println(e);
				return "";
			}
			
		}
		
	}
	

