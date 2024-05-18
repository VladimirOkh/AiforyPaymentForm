package org.example;

import org.example.getInfo.GetCurrencies;
import org.example.getInfo.GetMethods;
import org.example.getInfo.GetRecipientTypeID;
import org.example.postMethod.GenerateForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.*;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

@Component
public class Runner implements CommandLineRunner {

    GenerateForm generateForm;
    GetMethods getMethods;
    GetRecipientTypeID getRecipientTypeID;
    GetCurrencies getCurrencies;

    @Autowired
    public Runner(GenerateForm generateForm, GetMethods getMethods, GetRecipientTypeID getRecipientTypeID, GetCurrencies getCurrencies) {
        this.generateForm = generateForm;
        this.getMethods = getMethods;
        this.getRecipientTypeID = getRecipientTypeID;
        this.getCurrencies = getCurrencies;
    }

    public void run(String[] args) throws IOException, NoSuchAlgorithmException, InvalidKeyException {

        InputStream inputStream = System.in;
        Reader inputStreamReader = new InputStreamReader(inputStream);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);



        System.out.println(
                """
                        1 - Сгенерировать ссылку на оплату
                        2 - Вывести методы
                        3 - Вывести recipientTypeIDs
                        4 - Вывести валюты""");

        String method = bufferedReader.readLine();

        int methodID = Integer.parseInt(method);

        switch (methodID) {
            case 1:
                generateForm.makeCon();
                break;
            case 2:
                getMethods.makeCon();
                break;
            case 3:
                getRecipientTypeID.makeCon();
                break;
            case 4:
                getCurrencies.makeCon();
                break;
        }
    }
}
