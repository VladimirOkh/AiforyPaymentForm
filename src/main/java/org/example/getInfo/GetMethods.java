package org.example.getInfo;

import com.squareup.okhttp.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

@Component
public class GetMethods {


    public static void makeCon() throws NoSuchAlgorithmException, InvalidKeyException, IOException {
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url("https://api.aifory.io/info/p2p_method")
                .get()
                .addHeader("user-agent", "${user-agent}")
                .build();

        Response response = client.newCall(request).execute();


        System.out.println(response.body().string());
    }
}
