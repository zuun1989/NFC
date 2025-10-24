package com.fis.ekyc.nfc.build_in.bouncycastle.pqc.math.ntru.euclid;

public class IntEuclidean {
    public int gcd;
    public int x;
    public int y;

    private IntEuclidean() {
    }

    public static IntEuclidean calculate(int i, int i2) {
        int i3 = 0;
        int i4 = 1;
        int i5 = 1;
        int i6 = 0;
        int i7 = i2;
        int i8 = i;
        int i9 = i7;
        while (i9 != 0) {
            int i10 = i8 / i9;
            int i11 = i8 % i9;
            i8 = i9;
            i9 = i11;
            int i12 = i4;
            i4 = i3 - (i10 * i4);
            i3 = i12;
            int i13 = i5 - (i10 * i6);
            i5 = i6;
            i6 = i13;
        }
        IntEuclidean intEuclidean = new IntEuclidean();
        intEuclidean.x = i5;
        intEuclidean.y = i3;
        intEuclidean.gcd = i8;
        return intEuclidean;
    }
}
