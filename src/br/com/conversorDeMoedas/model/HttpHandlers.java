package src.br.com.conversorDeMoedas.model;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.BufferedWriter;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class HttpHandlers {
    private final String baseCode;
    private final String targetCode;
    private final double amount;

    public HttpHandlers(ConverterMoedas converter) {
        this.baseCode = converter.getBase_code();
        this.targetCode = converter.getTarget_code();
        this.amount = converter.getAmount();
    }

    public String fazerRequisicao() throws IOException, InterruptedException {
        String endereco = "https://v6.exchangerate-api.com/v6/805d9f4d64081181e59aafe1/pair/"
                + this.baseCode + "/" + this.targetCode + "/" + this.amount;

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(endereco))
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        String json = response.body();

        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        return gson.toJson(gson.fromJson(json, ConverterMoedas.class));

    }
}
