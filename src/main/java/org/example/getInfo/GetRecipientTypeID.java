package org.example.getInfo;

import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

@PropertySource("classpath:application.properties")
@Component
public class GetRecipientTypeID {

    @Value("${user-agent}")
    public String USERAGENT;

    public void makeCon() throws NoSuchAlgorithmException, InvalidKeyException, IOException {
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url("https://api.euphoria.inc/info/recipient_type")
                .get()
                .addHeader("user-agent", USERAGENT)
                .build();

        Response response = client.newCall(request).execute();


        System.out.println(response.body().string());
    }
}
