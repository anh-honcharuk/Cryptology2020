package test;

import com.anhel.methods.FermaTest;
import com.anhel.methods.MillerRabinTest;
import org.junit.Assert;
import org.junit.Test;

import java.math.BigInteger;

public class TestMillerRabin {
    @Test
    public void testMillerRabin() {

        MillerRabinTest millerRabinTest = new MillerRabinTest();
        BigInteger[] listTrue = {BigInteger.valueOf(5646541), BigInteger.valueOf(13), BigInteger.valueOf(174469), BigInteger.valueOf(174079), BigInteger.valueOf(513153371)};
        BigInteger[] listFalse = {BigInteger.valueOf(5646543), BigInteger.valueOf(22222)};

        int n = 100;
        boolean result;

        for (int i = 0; i < listTrue.length; i++) {
            result = millerRabinTest.test(listTrue[i], n);
            Assert.assertTrue(result);
        }

        for (int i = 0; i < listFalse.length; i++) {
            result = millerRabinTest.test(listFalse[i], n);
            Assert.assertFalse(result);
        }

    }
}
