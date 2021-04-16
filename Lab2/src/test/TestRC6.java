package test;

import com.anhel.RC6;
import org.junit.Assert;
import org.junit.Test;

import java.util.Base64;

public class TestRC6 {
    @Test
    public void testRC6() {
        String key = "1234";
        String word = "Hello word!";
        String enc = Base64.getEncoder().encodeToString(RC6.encrypt(word.getBytes(), key.getBytes()));
        String dec = new String(RC6.decrypt(Base64.getDecoder().decode(enc), key.getBytes()));

        String enc2 = Base64.getEncoder().encodeToString(RC6.encrypt(dec.getBytes(), key.getBytes()));
        //System.out.println(word.equals(word2));
        Assert.assertTrue(enc.equals(enc2));
    }

}
