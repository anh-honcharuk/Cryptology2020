package test;

import com.anhel.methods.AdvancedEuclideanAlgorithm;
import org.junit.Assert;
import org.junit.Test;

import java.math.BigInteger;

public class TestAdvancedEuclideanAlgorithm {
    @Test
    public void testAdvancedEuclideanAlgorithm() {
        BigInteger a = new BigInteger("8455658562565");
        BigInteger b = new BigInteger("89454565446565654");
        AdvancedEuclideanAlgorithm advancedEuclideanAlgorithm = new AdvancedEuclideanAlgorithm();
        BigInteger gcd1 = advancedEuclideanAlgorithm.gcd(a,b);
        BigInteger gcd2 = a.gcd(b);
        boolean result = false;
        if (gcd1.compareTo(gcd2) == 0) {
            result = true;
        }
        Assert.assertTrue(result);
    }
}
