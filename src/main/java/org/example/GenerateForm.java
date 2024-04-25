package org.example;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.squareup.okhttp.*;
import kong.unirest.Unirest;

import java.awt.*;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

public class GenerateForm {

    private static final String PUBLIC_KEY = "";
    private static final String PRIVATE_KEY = "";
    private static final String BODY =
            """
                    {
                      "amount": 1000,
                      "currencyID": 3,
                      "typeID": 4,
                      "clientOrderID": "1234161231421346153451",
                      "TTL": 999,
                      "webhookURL": "https://webhook.site/fef4b9cf-c949-4533-9a33-8547911dabf1",
                      "extra": {
                        "comment": "payin for site x.com",
                        "allowedMethodIDs": [
                          1,
                          2,
                          3,
                          4,
                          5,
                          6,
                          7,
                          8,
                          10
                        ],
                        "failedRedirectURL": "http://youdomain.com/failed_redirect",
                        "successRedirectURL": "http://youdomain.com/success_redirect",
                        "payerInfo": {
                          "userAgent": "Mozilla/5.0 (iPhone; CPU iPhone OS 16_6_1 like Mac OS X) AppleWebKit/655.1.15 (KHTML, like Gecko) Version/16.4 Mobile/148 Safari/04.1",
                          "IP": "123.123.123.123",
                          "userID": "1",
                          "fingerprint": "fbb77b9f4265b18538e66cac5a37c6410dc2cdd7f0cddfde6eda25aa10df669b",
                          "registeredAt": 1695057185
                        }
                      }
                    }""";

    public static void makeCon() throws NoSuchAlgorithmException, InvalidKeyException, IOException {
        OkHttpClient client = new OkHttpClient();

        MediaType mediaType = MediaType.parse("application/json");
        RequestBody body = RequestBody.create(mediaType, BODY);
        Request request = new Request.Builder()
                .url("https://api.aifory.io/payin/process")
                .post(body)
                .addHeader("Content-Type", "application/json")
                .addHeader("Signature", HMACUtil.signData(PRIVATE_KEY, BODY))
                .addHeader("user-agent", "")
                .addHeader("API-Key", PUBLIC_KEY)
                .build();

        Response response = client.newCall(request).execute();

        System.out.println(response.body().string());
    }
}
