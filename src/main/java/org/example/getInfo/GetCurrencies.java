package org.example.getInfo;

import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

public class GetCurrencies {

    public static void makeCon() throws NoSuchAlgorithmException, InvalidKeyException, IOException {
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url("https://api.aifory.io/info/currency")
                .get()
                .addHeader("user-agent", "${user-agent}")
                .build();

        Response response = client.newCall(request).execute();

        System.out.println(response.body().string());
    }
}
