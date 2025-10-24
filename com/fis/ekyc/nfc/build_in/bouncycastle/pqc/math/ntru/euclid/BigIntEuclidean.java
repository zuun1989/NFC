package com.fis.ekyc.nfc.build_in.bouncycastle.pqc.math.ntru.euclid;

import java.math.BigInteger;

public class BigIntEuclidean {
    public BigInteger gcd;
    public BigInteger x;
    public BigInteger y;

    private BigIntEuclidean() {
    }

    public static BigIntEuclidean calculate(BigInteger bigInteger, BigInteger bigInteger2) {
        BigInteger bigInteger3 = BigInteger.ZERO;
        BigInteger bigInteger4 = BigInteger.ONE;
        BigInteger bigInteger5 = bigInteger4;
        BigInteger bigInteger6 = bigInteger3;
        BigInteger bigInteger7 = bigInteger2;
        BigInteger bigInteger8 = bigInteger;
        BigInteger bigInteger9 = bigInteger7;
        while (!bigInteger9.equals(BigInteger.ZERO)) {
            BigInteger[] divideAndRemainder = bigInteger8.divideAndRemainder(bigInteger9);
            BigInteger bigInteger10 = divideAndRemainder[0];
            BigInteger bigInteger11 = divideAndRemainder[1];
            BigInteger subtract = bigInteger5.subtract(bigInteger10.multiply(bigInteger6));
            BigInteger bigInteger12 = bigInteger11;
            bigInteger8 = bigInteger9;
            bigInteger9 = bigInteger12;
            BigInteger bigInteger13 = bigInteger4;
            bigInteger4 = bigInteger3.subtract(bigInteger10.multiply(bigInteger4));
            bigInteger3 = bigInteger13;
            BigInteger bigInteger14 = subtract;
            bigInteger5 = bigInteger6;
            bigInteger6 = bigInteger14;
        }
        BigIntEuclidean bigIntEuclidean = new BigIntEuclidean();
        bigIntEuclidean.x = bigInteger5;
        bigIntEuclidean.y = bigInteger3;
        bigIntEuclidean.gcd = bigInteger8;
        return bigIntEuclidean;
    }
}
