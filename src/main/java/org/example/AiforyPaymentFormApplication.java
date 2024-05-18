package org.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.*;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

@SpringBootApplication
public class AiforyPaymentFormApplication {

    public static void main(String[] args) throws NoSuchAlgorithmException, InvalidKeyException, IOException {
        SpringApplication.run(AiforyPaymentFormApplication.class, args);

    }
}