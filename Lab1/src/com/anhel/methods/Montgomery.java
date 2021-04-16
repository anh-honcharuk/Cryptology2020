package com.anhel.methods;
import java.math.BigInteger;
import java.util.Objects;


public class Montgomery {

    public static BigInteger monProduct(BigInteger a, BigInteger b, BigInteger n) {
        AdvancedEuclideanAlgorithm advancedEuclideanAlgorithm = new AdvancedEuclideanAlgorithm();
        BigInteger r = BigInteger.TWO.shiftLeft(n.bitLength());
        BigInteger[] euclid = advancedEuclideanAlgorithm.gcd_(n, r);
        BigInteger t = a.multiply(b);
        BigInteger m = t.multiply(euclid[0].negate()).and(r.subtract(BigInteger.ONE));
        BigInteger u = t.add(m.multiply(n)).shiftRight(n.bitLength());
        if (u.compareTo(n) >= 0) return u.subtract(n);
        else return u;
    }

    public static BigInteger mongMultiply(BigInteger a, BigInteger b, BigInteger n) {
        BigInteger a1 = a.shiftLeft(n.bitLength()).mod(n);
        BigInteger b1 = b.shiftLeft(n.bitLength()).mod(n);
        BigInteger u1 = monProduct(a1, b1, n);
        return monProduct(u1, BigInteger.ONE, n);
    }
    public static BigInteger modPow(BigInteger m, BigInteger e, BigInteger n) {
        BigInteger m1 = m.shiftLeft(n.bitLength()).mod(n);
        BigInteger x1 = BigInteger.ONE.shiftLeft(n.bitLength()).mod(n);
        for (int i = e.bitLength() - 1; i >= 0; i--) {
            x1 = monProduct(x1, x1, n); if (e.testBit(i)) x1 = monProduct(m1, x1, n);
        }
        return monProduct(x1, BigInteger.ONE, n);
    }

}