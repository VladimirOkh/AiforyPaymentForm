package org.example;

import com.google.gson.Gson;
import kong.unirest.Unirest;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.concurrent.CompletableFuture;

public class GenerateForm {

    private static final String PUBLIC_KEY = "YOUR API-KEY";
    private static final String PRIVATE_KEY = "YOUR PRIVATE KEY";
    private static final String BODY = "{\n  \"amount\": 500,\n  \"currencyID\": 3,\n  \"typeID\": 4,\n  \"clientOrderID\": \"129802376321867137613486734\",\n  \"TTL\": 999,\n  \"webhookURL\": \"https://webhook.site/fef4b9cf-c949-4533-9a33-8547911dabf1\",\n  \"extra\": {\n    \"comment\": \"payin for site x.com\",\n    \"allowedMethodIDs\": [\n      1,\n      2,\n      3,\n      4,\n      5,\n      6,\n      7,\n      8,\n      10\n    ],\n    \"failedRedirectURL\": \"http://youdomain.com/failed_redirect\",\n    \"successRedirectURL\": \"http://youdomain.com/success_redirect\",\n    \"payerInfo\": {\n      \"userAgent\": \"Mozilla/5.0 (iPhone; CPU iPhone OS 16_6_1 like Mac OS X) AppleWebKit/655.1.15 (KHTML, like Gecko) Version/16.4 Mobile/148 Safari/04.1\",\n      \"IP\": \"123.123.123.123\",\n      \"userID\": \"1\",\n      \"fingerprint\": \"fbb77b9f4265b18538e66cac5a37c6410dc2cdd7f0cddfde6eda25aa10df669b\",\n      \"registeredAt\": 1695057185\n    }\n  }\n}";

    public static void makeCon() throws NoSuchAlgorithmException, InvalidKeyException {
        HttpClient client = HttpClient.newHttpClient();
        Gson gson = new Gson();

        String bodyJSON = gson.toJson(BODY);

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://api.aifory.io/payin/process"))
                .header("Content-Type", "application/json")
                .header("Signature", HMACUtil.signData(PRIVATE_KEY, bodyJSON))
                .header("user-agent", "YOUR USER-AGENT")
                .header("API-Key", PUBLIC_KEY)
                .POST(HttpRequest.BodyPublishers.ofString(BODY))
                .build();
        System.out.println(bodyJSON);
        CompletableFuture<HttpResponse<String>> responseFuture = client.sendAsync(request, HttpResponse.BodyHandlers.ofString());


        responseFuture.thenAccept(response -> {
            System.out.println(response.statusCode());
            System.out.println(response.body());
        });


        responseFuture.join();
    }
}
