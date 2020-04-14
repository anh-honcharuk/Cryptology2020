package test;

import com.anhel.methods.KaratsuboMultiply;
import org.junit.Assert;
import org.junit.Test;

import java.math.BigInteger;

public class TestKaratsuboMultiply {
    @Test
    public void testKaratsuboMultiply() {
        KaratsuboMultiply karatsuboMultiply = new KaratsuboMultiply();
        BigInteger a = new BigInteger("12345784746468468464600000000008");
        BigInteger b = new BigInteger("12345844654464698779878880000005");
        BigInteger mult = karatsuboMultiply.multiply(a, b);
        BigInteger mult2 = a.multiply(b);
        boolean result = false;
        if (mult.compareTo(mult2) == 0) {
            result = true;
        }
        Assert.assertTrue(result);
    }
}
