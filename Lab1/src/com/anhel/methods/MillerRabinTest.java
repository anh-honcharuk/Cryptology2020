package com.anhel.methods;

/*
BigInteger add(BigInteger other): возвращает сумму двух чисел

BigInteger subtract(BigInteger other): возвращает разность двух чисел

BigInteger multiply(BigInteger other): возвращает произведение двух чисел

BigInteger divide(BigInteger other): возвращает частное двух чисел

BigInteger mod(BigInteger other): возвращает остаток от целочисленного деления двух чисел

BigInteger sqrt(): возвращает квадратный корень числа

int compareTo(BigInteger other): сравнивает два числа. Возвращает -1, если текущий объект меньше числа other, 1 - если текущий объект больше и 0 - если числа равны

static BigInteger valueOf(long x): возвращает объект BigInteger, значение которого равно числу, переданному в качестве параметра

int intValue(): конвертирует объект BigInteger в объект int

byte byteValue(): преобразует объект BigInteger в byte

short shortValue(): преобразует объект BigInteger в short

long longValue(): преобразует объект BigInteger в long
BigInteger nine = ten.subtract(BigInteger.ONE); // 10 - 1 = 9
BigInteger oneHundredTen = ten.multiply(eleven); // 10 * 11 = 110
BigInteger twelve = oneHundredTen.divide(nine); // integer division: 12
* \
* BigInteger three = BigInteger.valueOf(3);
BigInteger six = BigInteger.valueOf(6);
System.out.println(three.gcd(six)); // 3
*
*
*BigInteger eleven = ten.add(one);
System.out.println(eleven); // 11

System.out.println(ten); // 10, it has not changed!
*
BigInteger reallyBig = BigInteger.valueOf(10);
BigInteger reallyBig1 = BigInteger.valueOf(100);

if(reallyBig.compareTo(reallyBig1) == 0){
    //code when both are equal.
}
else if(reallyBig.compareTo(reallyBig1) == 1){
    //code when reallyBig is greater than reallyBig1.
}
else if(reallyBig.compareTo(reallyBig1) == -1){
    //code when reallyBig is less than reallyBig1.
}
* */
import java.math.BigInteger;
import java.util.Random;

public class MillerRabinTest {
    //точно складене \ не точно просте

    public boolean test(BigInteger n, int k) {
        if (n.compareTo(BigInteger.valueOf(2)) == 0 || n.compareTo(BigInteger.valueOf(3)) == 0) {
            return true;
        }
        if (n.compareTo(BigInteger.valueOf(2)) == -1 || n.mod(BigInteger.valueOf(2)) == BigInteger.valueOf(0)) {
            return false;
        }
        BigInteger t = n.subtract(BigInteger.valueOf(1));
        int s = 0;
        while (t.mod(BigInteger.valueOf(2)).compareTo( BigInteger.valueOf(0)) == 0) {
            t = t.divide(BigInteger.valueOf(2));
            s++;
        }
        BigInteger a;
        BigInteger x;

        for (int i = 0; i < k; i++) {

            Random rand = new Random();
            a = BigInteger.valueOf(rand.nextLong() * rand.nextLong() * rand.nextLong());
            a = a.mod(n.subtract(BigInteger.valueOf(2)));
            a = a.abs();
            a = a.add(BigInteger.valueOf(2));

            x = a.modPow(t, n);

            if (x.compareTo(BigInteger.valueOf(1)) == 0 || x.compareTo(n.subtract(BigInteger.valueOf(1))) == 0){
                continue;
            }
            for (int r = 1; r < s; r++) {

                x = x.modPow(BigInteger.valueOf(2), n);

                if (x.compareTo(BigInteger.valueOf(1)) == 0) {
                    return false;
                }
                if (x.compareTo(n.subtract(BigInteger.valueOf(1))) == 0) {
                    break;
                }
            }
            if (!(x.compareTo(n.subtract(BigInteger.valueOf(1))) == 0)) {
                return false;
            }
        }
        return true;
    }
}
