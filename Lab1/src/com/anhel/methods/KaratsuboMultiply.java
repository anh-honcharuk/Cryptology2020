package com.anhel.methods;

import java.math.BigInteger;
//.toString().length()

public class KaratsuboMultiply {

    private BigInteger myPow(BigInteger a, int b) {
        BigInteger res = new BigInteger("1");

        for (int i = 0; i < b; i++) {
            res = res.multiply(a);
        }

        return res;
    }

    private BigInteger hasZeroOrContinueMultiply(BigInteger a, BigInteger b) {
        BigInteger result;

        if (a.compareTo(BigInteger.valueOf(0)) == 0 || b.compareTo(BigInteger.valueOf(0)) == 0) {
            result = new BigInteger("0");
        } else {
            result = multiply(a, b);
        }

        return result;
    }

    public BigInteger multiply(BigInteger n, BigInteger m) {
        int len;
        int half;
        BigInteger a = n;
        BigInteger c = m;
        BigInteger b;
        BigInteger d;
        BigInteger Half;

        BigInteger ab;
        BigInteger cd;

        BigInteger AC;
        BigInteger BD;
        BigInteger ABCD;

        switch (n.compareTo(m)) {
            case 1:
                len = n.toString().length();
                half = (int) Math.ceil((double) len / 2);
                break;
            default:
                len = m.toString().length();
                half = (int) Math.ceil((double) len / 2);
                break;
        }

        if (half == 1) {
            return n.multiply(m);
        }

        Half = myPow(new BigInteger("10"), half);

        a = a.divide(Half);
        c = c.divide(Half);
        b = n.subtract(a.multiply(Half));
        d = m.subtract(c.multiply(Half));

        ab = a.add(b);
        cd = c.add(d);

        BD = hasZeroOrContinueMultiply(b, d);
        AC = hasZeroOrContinueMultiply(a, c);
        ABCD = hasZeroOrContinueMultiply(ab, cd);


        BigInteger result = (AC.multiply(Half.multiply(Half))).add((Half.multiply(ABCD.subtract(AC.add(BD)))).add(BD));
        return result;
    }
}
