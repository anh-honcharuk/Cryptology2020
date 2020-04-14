package com.anhel.methods;

import java.math.BigInteger;
import java.util.Random;

public class FermaTest {

    public boolean test(BigInteger p, int n){
        Random rand = new Random();
        BigInteger a;
        BigInteger result;

        if (p.compareTo(BigInteger.valueOf(2)) == 0) {
            return true;
        }
        if (p.compareTo(BigInteger.valueOf(2)) == -1 || p.mod(BigInteger.valueOf(2)) == BigInteger.valueOf(0)) {
            return false;
        }

        for (int i = 0; i < n; i++) {
            do {
                a = (((BigInteger.valueOf(rand.nextLong() * rand.nextLong())).mod(p)).abs()).add(BigInteger.valueOf(1));
            } while (!(p.compareTo(a) == 0));

            result = a.modPow(p.subtract(BigInteger.valueOf(1)), p);
           // System.out.println(result);
            if (result.compareTo(BigInteger.valueOf(1)) == 0) return false; //точно складене
        }
        return true; //не точно просте
    }

}
