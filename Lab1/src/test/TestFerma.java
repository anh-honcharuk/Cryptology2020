package test;

import com.anhel.methods.FermaTest;
import com.anhel.methods.KaratsuboMultiply;
import com.anhel.methods.MillerRabinTest;
import com.anhel.methods.ModPow;
import org.junit.Assert;
import org.junit.Test;

import java.math.BigInteger;

public class TestFerma {
    @Test
    public void testFerma() {

        FermaTest fermaTest = new FermaTest();
        BigInteger[] listTrue = {BigInteger.valueOf(5646541), BigInteger.valueOf(13), BigInteger.valueOf(174469), BigInteger.valueOf(174079), BigInteger.valueOf(513153371)};
        BigInteger[] listFalse = {BigInteger.valueOf(196), BigInteger.valueOf(22222)};

        int n = 20;
        boolean result;

        for (int i = 0; i < listTrue.length; i++) {
            result = fermaTest.test(listTrue[i], n);
            Assert.assertTrue(result);
        }

        for (int i = 0; i < listFalse.length; i++) {
            result = fermaTest.test(listFalse[i], n);
            Assert.assertFalse(result);
        }

    }
}
