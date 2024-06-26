package org.example.postMethod;

import com.squareup.okhttp.*;
import org.example.encryption.HMACUtil;
import org.example.service.CurrentTime;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

@PropertySource("classpath:application.properties")
@Component
public class GenerateForm {
    @Value("${API-KEY}")
    private String PUBLIC_KEY;

    @Value("${SECRET-KEY}")
    private String PRIVATE_KEY;

    @Value("${user-agent}")
    private String USERAGENT;

    private static final String BODY =
            "{\n" +
                    "                          \"amount\": 1000,\n" +
                    "                          \"currencyID\": 3,\n" +
                    "                          \"typeID\": 4,\n" +
                    "                          \"clientOrderID\": " + "\"" + CurrentTime.getCurrentTime() +"\"" + ",\n" +
                    "                          \"TTL\": 999,\n" +
                    "                          \"webhookURL\": \"https://webhook.site/fef4b9cf-c949-4533-9a33-8547911dabf1\",\n" +
                    "                          \"extra\": {\n" +
                    "                            \"comment\": \"payin for site x.com\",\n" +
                    "                            \"allowedMethodIDs\": [\n" +
                    "                              1,\n" +
                    "                              2,\n" +
                    "                              3,\n" +
                    "                              4,\n" +
                    "                              5,\n" +
                    "                              6,\n" +
                    "                              7,\n" +
                    "                              8,\n" +
                    "                              10\n" +
                    "                            ],\n" +
                    "                            \"failedRedirectURL\": \"http://youdomain.com/failed_redirect\",\n" +
                    "                            \"successRedirectURL\": \"http://youdomain.com/success_redirect\",\n" +
                    "                            \"payerInfo\": {\n" +
                    "                              \"userAgent\": \"Mozilla/5.0 (iPhone; CPU iPhone OS 16_6_1 like Mac OS X) AppleWebKit/655.1.15 (KHTML, like Gecko) Version/16.4 Mobile/148 Safari/04.1\",\n" +
                    "                              \"IP\": \"123.123.123.123\",\n" +
                    "                              \"userID\": " + "\"" + CurrentTime.getCurrentTime() + "\"" + ",\n" +
                    "                              \"fingerprint\": \"fbb77b9f4265b18538e66cac5a37c6410dc2cdd7f0cddfde6eda25aa10df669b\",\n" +
                    "                              \"registeredAt\": 1695057185\n" +
                    "                            }\n" +
                    "                          }\n" +
                    "                        }"
            ;

    public void makeCon() throws NoSuchAlgorithmException, InvalidKeyException, IOException {

        OkHttpClient client = new OkHttpClient();
        MediaType mediaType = MediaType.parse("application/json");
        RequestBody body = RequestBody.create(mediaType, BODY);
        Request request = new Request.Builder()
                .url("https://api.aifory.io/payin/process")
                .post(body)
                .addHeader("Content-Type", "application/json")
                .addHeader("Signature", HMACUtil.signData(PRIVATE_KEY, BODY))
                .addHeader("user-agent", USERAGENT)
                .addHeader("API-Key", PUBLIC_KEY)
                .build();

        Response response = client.newCall(request).execute();
        System.out.println(response.body().string());
    }
}
