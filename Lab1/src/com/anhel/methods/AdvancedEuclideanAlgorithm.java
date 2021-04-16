package com.anhel.methods;

import java.math.BigInteger;

public class AdvancedEuclideanAlgorithm {
    private void swap(BigInteger a, BigInteger b) {
        BigInteger n = a;
        a = b;
        b = n;
    }

    public BigInteger gcd(BigInteger a, BigInteger b) {
        if (a.compareTo(b) == -1) {
            swap(a, b);
        }
        double len = Math.log(a.doubleValue()) * (Math.log(a.doubleValue() - Math.log(a.doubleValue()) + 1));
        BigInteger[] r = new BigInteger[(int)len + 3];
        BigInteger[] q = new BigInteger[(int)len + 3];
        r[0] = a;
        r[1] = b;
        r[2] = r[0].mod(r[1]);
        q[0] = a.subtract(r[2]).divide(b);

        int n = 0;

        while (r[n + 2].compareTo(BigInteger.valueOf(0)) != 0) {
            n++;
            r[n + 2] = r[n].mod(r[n + 1]);
            q[n] = r[n].subtract(r[n + 2]).divide(r[n + 1]);

        }

        BigInteger[] u = new BigInteger[n + 3];
        BigInteger[] v = new BigInteger[n + 3];

        u[0] = BigInteger.valueOf(1);
        u[1] = BigInteger.valueOf(0);
        v[0] = BigInteger.valueOf(0);
        v[1] = BigInteger.valueOf(1);

        for (int i = 0; i < n; i++) {

            u[i + 2] = u[i].subtract(q[i].multiply(u[i + 1]));
            v[i + 2] = v[i].subtract(q[i].multiply(v[i + 1]));

        }

        BigInteger result = u[n + 1].multiply(a).add(v[n + 1].multiply(b));
        return result;
    }

    public static BigInteger[] gcd_(BigInteger a, BigInteger b) {

        if (a.equals(BigInteger.ZERO)) {

            return new BigInteger[] { BigInteger.ZERO, BigInteger.ONE, b };
        }

        BigInteger[] gcdRes = gcd_(b.mod(a), a);

        return new BigInteger[]{
                gcdRes[1].subtract(b.divide(a).multiply(gcdRes[0])),
                gcdRes[0], gcdRes[2]
        };
    }

}

