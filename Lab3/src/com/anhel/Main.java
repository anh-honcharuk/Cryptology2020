package com.anhel;
import java.nio.charset.Charset;

public class Main {
    public static void main(String[] args) {
        Charset cs = Charset.forName("UTF-8");
        String value = "Cryptography is a method of protecting information and communications through the use of codes, so that only those for whom the information is intended can read and process it.";
        byte[] data = value.getBytes(cs);
        byte[] hash = SHA256.encode(data);

        StringBuilder hex = new StringBuilder(hash.length * 2);
        int len = hash.length;
        for (int i = 0 ; i < len ; i++) {
            hex.append(String.format("%02X", hash[i]));
        }
        System.out.println( hex.toString().toLowerCase());
    }
}
