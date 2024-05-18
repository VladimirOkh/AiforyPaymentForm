package org.example;

import org.example.getInfo.GetCurrencies;
import org.example.getInfo.GetMethods;
import org.example.getInfo.GetRecipientTypeID;
import org.example.postMethod.GenerateForm;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.*;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
@SpringBootApplication
public class Main {
    public static void main(String[] args) throws NoSuchAlgorithmException, InvalidKeyException, IOException {
        SpringApplication.run(Main.class, args);



    }
}