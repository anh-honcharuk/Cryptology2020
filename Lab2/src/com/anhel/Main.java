package com.anhel;

import org.junit.Assert;

import java.util.Base64;

public class Main {
    public static void main(String[] args) {
        String key = "1234";
        String word = "Hello word!";
        String enc = Base64.getEncoder().encodeToString(RC6.encrypt(word.getBytes(), key.getBytes()));
        System.out.println(enc);
        String dec = new String(RC6.decrypt(Base64.getDecoder().decode(enc), key.getBytes()));
        System.out.println(dec);
        String enc2 = Base64.getEncoder().encodeToString(RC6.encrypt(dec.getBytes(), key.getBytes()));
        //System.out.println(word.equals(word2));
        //Assert.assertTrue(enc.equals(enc2));
    }
}
