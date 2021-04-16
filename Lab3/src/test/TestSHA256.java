package test;

import com.anhel.SHA256;
import org.junit.Assert;
import org.junit.Test;

import java.nio.charset.Charset;

public class TestSHA256 {
    @Test
    public void testSHA256() {
        Charset cs = Charset.forName("UTF-8");
        String value = "Cryptography is a method of protecting information and communications through the use of codes, so that only those for whom the information is intended can read and process it.";
        byte[] data = value.getBytes(cs);
        byte[] hash = SHA256.encode(data);

        StringBuilder hex = new StringBuilder(hash.length * 2);
        int len = hash.length;
        for (int i = 0 ; i < len ; i++) {
            hex.append(String.format("%02X", hash[i]));
        }
        Assert.assertTrue(hex.toString().toLowerCase().equals("6ad26e7a91a579e227e76f0bbd2cd8b8b31f23f54596405df82454d10316801c"));
    }
}
