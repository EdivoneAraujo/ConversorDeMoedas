package br.com.projeto.api;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class ApiClient {

    // Método que consome a API e retorna as taxas de câmbio
    public JsonObject obterTaxasDeCambio() throws Exception {
        String apiUrl = "https://api.exchangerate-api.com/v4/latest/USD";

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create(apiUrl)).build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        return JsonParser.parseString(response.body()).getAsJsonObject().getAsJsonObject("rates");
    }
}
