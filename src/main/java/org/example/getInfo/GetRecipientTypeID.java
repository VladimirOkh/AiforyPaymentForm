package org.example.getInfo;

import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

public class GetRecipientTypeID {
    private static final String PUBLIC_KEY = "0NPUHDA5ceXKrvEX38re7jVErbgKWlLSZ5soAQQlx6AntoyAI7SuvGWWACFabj0pXzhakmSFRMFjtUQI6UckWisn7eg5c8LFVDSAbs7Dw81MrCLDln6fn4m9yzx3xRF6Jvzl5IGi7gwpJxZ4ReW1SkgzWuSPXbrbvp0WybicHYIwaYC7ViJPehfkRKB2pd8gHxUuq8F4YuzonTGMmEDkbNUqQoOKYJpwoKVGI8M9uTuxmU9kZ5fVng3r3Mx25wyf";

    public static void makeCon() throws NoSuchAlgorithmException, InvalidKeyException, IOException {
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url("https://api.euphoria.inc/info/recipient_type")
                .get()
                .addHeader("user-agent", "${user-agent}")
                .build();

        Response response = client.newCall(request).execute();


        System.out.println(response.body().string());
    }
}
