package org.example;

import kong.unirest.Unirest;

import java.io.IOException;
import java.net.http.HttpResponse;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

public class Main {
    public static void main(String[] args) throws NoSuchAlgorithmException, InvalidKeyException, IOException {
        GenerateForm.makeCon();
    }
}