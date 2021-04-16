package test;

import com.anhel.methods.ModPow;
import org.junit.Assert;
import org.junit.Test;

import java.math.BigInteger;

public class TestModPow {
    @Test
    public void testModPow() {
        ModPow qw = new ModPow();

        BigInteger base = new BigInteger("12340000007");
        BigInteger exponent = new BigInteger("875555555");
        BigInteger modulus = new BigInteger("1234000");

        BigInteger result1 = qw.modPow(base, exponent, modulus);
        BigInteger result2 = base.modPow(exponent, modulus);

        boolean result = false;
        if (result1.compareTo(result2) == 0) {
            result = true;
        }
        Assert.assertTrue(result);
    }

}
