package test;

import com.anhel.methods.Montgomery;
import org.junit.Assert;
import org.junit.Test;

import java.math.BigInteger;

import static org.junit.Assert.assertEquals;

public class TestMontgomery {
    @Test
    public void modMultuplyTest() {
        Montgomery montgomery = new Montgomery();

        BigInteger a, b, n;

        a = BigInteger.valueOf(123L);
        b = BigInteger.valueOf(567L);
        n = BigInteger.valueOf(43L);
        assertEquals(a.multiply(b).mod(n), montgomery.mongMultiply(a,b,n));

        a = BigInteger.valueOf(1400L);
        b = BigInteger.valueOf(200L);
        n = BigInteger.valueOf(5L);
        assertEquals(a.multiply(b).mod(n), montgomery.mongMultiply(a,b,n));
    }

    @Test
    public void modPowTest() {
        Montgomery montgomery = new Montgomery();
        BigInteger a, b, n;

        a = BigInteger.valueOf(12L);
        b = BigInteger.valueOf(5L);
        n = BigInteger.valueOf(43L);
        //System.out.println(a.modPow(b, n)+ " "+ montgomery.modPow(a,b,n));
        assertEquals(a.modPow(b, n), montgomery.modPow(a,b,n));

        a = BigInteger.valueOf(1400L);
        b = BigInteger.valueOf(20L);
        n = BigInteger.valueOf(5L);
        assertEquals(a.modPow(b, n), montgomery.modPow(a,b,n));
    }
}
