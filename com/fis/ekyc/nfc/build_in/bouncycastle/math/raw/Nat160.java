package com.fis.ekyc.nfc.build_in.bouncycastle.math.raw;

import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.cmp.PKIFailureInfo;
import com.fis.ekyc.nfc.build_in.bouncycastle.util.Pack;
import java.math.BigInteger;

public abstract class Nat160 {
    private static final long M = 4294967295L;

    public static int add(int[] iArr, int[] iArr2, int[] iArr3) {
        long j = (((long) iArr[0]) & 4294967295L) + (((long) iArr2[0]) & 4294967295L);
        iArr3[0] = (int) j;
        long j2 = (j >>> 32) + (((long) iArr[1]) & 4294967295L) + (((long) iArr2[1]) & 4294967295L);
        iArr3[1] = (int) j2;
        long j3 = (j2 >>> 32) + (((long) iArr[2]) & 4294967295L) + (((long) iArr2[2]) & 4294967295L);
        iArr3[2] = (int) j3;
        long j4 = (j3 >>> 32) + (((long) iArr[3]) & 4294967295L) + (((long) iArr2[3]) & 4294967295L);
        iArr3[3] = (int) j4;
        long j5 = (j4 >>> 32) + (((long) iArr[4]) & 4294967295L) + (((long) iArr2[4]) & 4294967295L);
        iArr3[4] = (int) j5;
        return (int) (j5 >>> 32);
    }

    public static int addBothTo(int[] iArr, int[] iArr2, int[] iArr3) {
        long j = (((long) iArr[0]) & 4294967295L) + (((long) iArr2[0]) & 4294967295L) + (((long) iArr3[0]) & 4294967295L);
        iArr3[0] = (int) j;
        long j2 = (j >>> 32) + (((long) iArr[1]) & 4294967295L) + (((long) iArr2[1]) & 4294967295L) + (((long) iArr3[1]) & 4294967295L);
        iArr3[1] = (int) j2;
        long j3 = (j2 >>> 32) + (((long) iArr[2]) & 4294967295L) + (((long) iArr2[2]) & 4294967295L) + (((long) iArr3[2]) & 4294967295L);
        iArr3[2] = (int) j3;
        long j4 = (j3 >>> 32) + (((long) iArr[3]) & 4294967295L) + (((long) iArr2[3]) & 4294967295L) + (((long) iArr3[3]) & 4294967295L);
        iArr3[3] = (int) j4;
        long j5 = (j4 >>> 32) + (((long) iArr[4]) & 4294967295L) + (((long) iArr2[4]) & 4294967295L) + (((long) iArr3[4]) & 4294967295L);
        iArr3[4] = (int) j5;
        return (int) (j5 >>> 32);
    }

    public static int addTo(int[] iArr, int[] iArr2) {
        long j = (((long) iArr[0]) & 4294967295L) + (((long) iArr2[0]) & 4294967295L);
        iArr2[0] = (int) j;
        long j2 = (j >>> 32) + (((long) iArr[1]) & 4294967295L) + (((long) iArr2[1]) & 4294967295L);
        iArr2[1] = (int) j2;
        long j3 = (j2 >>> 32) + (((long) iArr[2]) & 4294967295L) + (((long) iArr2[2]) & 4294967295L);
        iArr2[2] = (int) j3;
        long j4 = (j3 >>> 32) + (((long) iArr[3]) & 4294967295L) + (((long) iArr2[3]) & 4294967295L);
        iArr2[3] = (int) j4;
        long j5 = (j4 >>> 32) + (((long) iArr[4]) & 4294967295L) + (4294967295L & ((long) iArr2[4]));
        iArr2[4] = (int) j5;
        return (int) (j5 >>> 32);
    }

    public static int addToEachOther(int[] iArr, int i, int[] iArr2, int i2) {
        long j = (((long) iArr[i]) & 4294967295L) + (((long) iArr2[i2]) & 4294967295L);
        int i3 = (int) j;
        iArr[i] = i3;
        iArr2[i2] = i3;
        int i4 = i + 1;
        int i5 = i2 + 1;
        long j2 = (j >>> 32) + (((long) iArr[i4]) & 4294967295L) + (((long) iArr2[i5]) & 4294967295L);
        int i6 = (int) j2;
        iArr[i4] = i6;
        iArr2[i5] = i6;
        int i7 = i + 2;
        int i8 = i2 + 2;
        long j3 = (j2 >>> 32) + (((long) iArr[i7]) & 4294967295L) + (((long) iArr2[i8]) & 4294967295L);
        int i9 = (int) j3;
        iArr[i7] = i9;
        iArr2[i8] = i9;
        int i10 = i + 3;
        int i11 = i2 + 3;
        long j4 = (j3 >>> 32) + (((long) iArr[i10]) & 4294967295L) + (((long) iArr2[i11]) & 4294967295L);
        int i12 = (int) j4;
        iArr[i10] = i12;
        iArr2[i11] = i12;
        int i13 = i + 4;
        int i14 = i2 + 4;
        long j5 = (j4 >>> 32) + (((long) iArr[i13]) & 4294967295L) + (4294967295L & ((long) iArr2[i14]));
        int i15 = (int) j5;
        iArr[i13] = i15;
        iArr2[i14] = i15;
        return (int) (j5 >>> 32);
    }

    public static void copy(int[] iArr, int[] iArr2) {
        iArr2[0] = iArr[0];
        iArr2[1] = iArr[1];
        iArr2[2] = iArr[2];
        iArr2[3] = iArr[3];
        iArr2[4] = iArr[4];
    }

    public static int[] create() {
        return new int[5];
    }

    public static int[] createExt() {
        return new int[10];
    }

    public static boolean diff(int[] iArr, int i, int[] iArr2, int i2, int[] iArr3, int i3) {
        boolean gte = gte(iArr, i, iArr2, i2);
        if (gte) {
            sub(iArr, i, iArr2, i2, iArr3, i3);
        } else {
            sub(iArr2, i2, iArr, i, iArr3, i3);
        }
        return gte;
    }

    public static boolean eq(int[] iArr, int[] iArr2) {
        for (int i = 4; i >= 0; i--) {
            if (iArr[i] != iArr2[i]) {
                return false;
            }
        }
        return true;
    }

    public static int[] fromBigInteger(BigInteger bigInteger) {
        if (bigInteger.signum() < 0 || bigInteger.bitLength() > 160) {
            throw new IllegalArgumentException();
        }
        int[] create = create();
        for (int i = 0; i < 5; i++) {
            create[i] = bigInteger.intValue();
            bigInteger = bigInteger.shiftRight(32);
        }
        return create;
    }

    public static int getBit(int[] iArr, int i) {
        int i2;
        if (i == 0) {
            i2 = iArr[0];
        } else {
            int i3 = i >> 5;
            if (i3 < 0 || i3 >= 5) {
                return 0;
            }
            i2 = iArr[i3] >>> (i & 31);
        }
        return i2 & 1;
    }

    public static boolean gte(int[] iArr, int[] iArr2) {
        for (int i = 4; i >= 0; i--) {
            int i2 = iArr[i] ^ PKIFailureInfo.systemUnavail;
            int i3 = Integer.MIN_VALUE ^ iArr2[i];
            if (i2 < i3) {
                return false;
            }
            if (i2 > i3) {
                return true;
            }
        }
        return true;
    }

    public static boolean isOne(int[] iArr) {
        if (iArr[0] != 1) {
            return false;
        }
        for (int i = 1; i < 5; i++) {
            if (iArr[i] != 0) {
                return false;
            }
        }
        return true;
    }

    public static boolean isZero(int[] iArr) {
        for (int i = 0; i < 5; i++) {
            if (iArr[i] != 0) {
                return false;
            }
        }
        return true;
    }

    public static void mul(int[] iArr, int[] iArr2, int[] iArr3) {
        long j = ((long) iArr2[0]) & 4294967295L;
        int i = 1;
        long j2 = ((long) iArr2[1]) & 4294967295L;
        long j3 = ((long) iArr2[3]) & 4294967295L;
        long j4 = ((long) iArr2[4]) & 4294967295L;
        long j5 = ((long) iArr2[2]) & 4294967295L;
        long j6 = ((long) iArr[0]) & 4294967295L;
        long j7 = j6 * j;
        iArr3[0] = (int) j7;
        long j8 = (j7 >>> 32) + (j6 * j2);
        iArr3[1] = (int) j8;
        long j9 = (j8 >>> 32) + (j6 * j5);
        iArr3[2] = (int) j9;
        long j10 = (j9 >>> 32) + (j6 * j3);
        iArr3[3] = (int) j10;
        long j11 = (j10 >>> 32) + (j6 * j4);
        iArr3[4] = (int) j11;
        iArr3[5] = (int) (j11 >>> 32);
        for (int i2 = 5; i < i2; i2 = 5) {
            long j12 = ((long) iArr[i]) & 4294967295L;
            long j13 = (j12 * j) + (((long) iArr3[i]) & 4294967295L);
            iArr3[i] = (int) j13;
            int i3 = i + 1;
            int i4 = i3;
            long j14 = (j13 >>> 32) + (j12 * j2) + (((long) iArr3[i3]) & 4294967295L);
            iArr3[i4] = (int) j14;
            int i5 = i + 2;
            long j15 = j2;
            long j16 = (j14 >>> 32) + (j12 * j5) + (((long) iArr3[i5]) & 4294967295L);
            iArr3[i5] = (int) j16;
            int i6 = i + 3;
            long j17 = (j16 >>> 32) + (j12 * j3) + (((long) iArr3[i6]) & 4294967295L);
            iArr3[i6] = (int) j17;
            int i7 = i + 4;
            long j18 = (j17 >>> 32) + (j12 * j4) + (((long) iArr3[i7]) & 4294967295L);
            iArr3[i7] = (int) j18;
            iArr3[i + 5] = (int) (j18 >>> 32);
            j3 = j3;
            j = j;
            i = i4;
            j2 = j15;
        }
    }

    public static long mul33Add(int i, int[] iArr, int i2, int[] iArr2, int i3, int[] iArr3, int i4) {
        long j = ((long) i) & 4294967295L;
        long j2 = ((long) iArr[i2]) & 4294967295L;
        long j3 = (j * j2) + (((long) iArr2[i3]) & 4294967295L);
        iArr3[i4] = (int) j3;
        long j4 = ((long) iArr[i2 + 1]) & 4294967295L;
        long j5 = (j3 >>> 32) + (j * j4) + j2 + (((long) iArr2[i3 + 1]) & 4294967295L);
        iArr3[i4 + 1] = (int) j5;
        long j6 = j5 >>> 32;
        long j7 = ((long) iArr[i2 + 2]) & 4294967295L;
        long j8 = j6 + (j * j7) + j4 + (((long) iArr2[i3 + 2]) & 4294967295L);
        iArr3[i4 + 2] = (int) j8;
        long j9 = ((long) iArr[i2 + 3]) & 4294967295L;
        long j10 = (j8 >>> 32) + (j * j9) + j7 + (((long) iArr2[i3 + 3]) & 4294967295L);
        iArr3[i4 + 3] = (int) j10;
        long j11 = ((long) iArr[i2 + 4]) & 4294967295L;
        long j12 = (j10 >>> 32) + (j * j11) + j9 + (4294967295L & ((long) iArr2[i3 + 4]));
        iArr3[i4 + 4] = (int) j12;
        return (j12 >>> 32) + j11;
    }

    public static int mul33DWordAdd(int i, long j, int[] iArr, int i2) {
        long j2 = ((long) i) & 4294967295L;
        long j3 = j & 4294967295L;
        long j4 = (j2 * j3) + (((long) iArr[i2]) & 4294967295L);
        iArr[i2] = (int) j4;
        long j5 = j >>> 32;
        long j6 = (j2 * j5) + j3;
        int i3 = i2 + 1;
        long j7 = (j4 >>> 32) + j6 + (((long) iArr[i3]) & 4294967295L);
        iArr[i3] = (int) j7;
        int i4 = i2 + 2;
        long j8 = (j7 >>> 32) + j5 + (((long) iArr[i4]) & 4294967295L);
        iArr[i4] = (int) j8;
        long j9 = j8 >>> 32;
        int i5 = i2 + 3;
        long j10 = j9 + (((long) iArr[i5]) & 4294967295L);
        iArr[i5] = (int) j10;
        if ((j10 >>> 32) == 0) {
            return 0;
        }
        return Nat.incAt(5, iArr, i2, 4);
    }

    public static int mul33WordAdd(int i, int i2, int[] iArr, int i3) {
        long j = ((long) i2) & 4294967295L;
        long j2 = ((((long) i) & 4294967295L) * j) + (((long) iArr[i3]) & 4294967295L);
        iArr[i3] = (int) j2;
        int i4 = i3 + 1;
        long j3 = (j2 >>> 32) + j + (((long) iArr[i4]) & 4294967295L);
        iArr[i4] = (int) j3;
        long j4 = j3 >>> 32;
        int i5 = i3 + 2;
        long j5 = j4 + (((long) iArr[i5]) & 4294967295L);
        iArr[i5] = (int) j5;
        if ((j5 >>> 32) == 0) {
            return 0;
        }
        return Nat.incAt(5, iArr, i3, 3);
    }

    public static int mulAddTo(int[] iArr, int[] iArr2, int[] iArr3) {
        int i = 0;
        long j = ((long) iArr2[0]) & 4294967295L;
        long j2 = ((long) iArr2[1]) & 4294967295L;
        long j3 = ((long) iArr2[2]) & 4294967295L;
        long j4 = ((long) iArr2[3]) & 4294967295L;
        long j5 = ((long) iArr2[4]) & 4294967295L;
        long j6 = 0;
        while (i < 5) {
            long j7 = j6;
            long j8 = ((long) iArr[i]) & 4294967295L;
            long j9 = j;
            long j10 = (j8 * j) + (((long) iArr3[i]) & 4294967295L);
            iArr3[i] = (int) j10;
            int i2 = i + 1;
            long j11 = (j10 >>> 32) + (j8 * j2) + (((long) iArr3[i2]) & 4294967295L);
            iArr3[i2] = (int) j11;
            int i3 = i + 2;
            long j12 = (j11 >>> 32) + (j8 * j3) + (((long) iArr3[i3]) & 4294967295L);
            iArr3[i3] = (int) j12;
            int i4 = i + 3;
            long j13 = (j12 >>> 32) + (j8 * j4) + (((long) iArr3[i4]) & 4294967295L);
            iArr3[i4] = (int) j13;
            int i5 = i + 4;
            long j14 = (j13 >>> 32) + (j8 * j5) + (((long) iArr3[i5]) & 4294967295L);
            iArr3[i5] = (int) j14;
            int i6 = i + 5;
            long j15 = j7 + (j14 >>> 32) + (((long) iArr3[i6]) & 4294967295L);
            iArr3[i6] = (int) j15;
            j6 = j15 >>> 32;
            j = j9;
            i = i2;
            j2 = j2;
        }
        return (int) j6;
    }

    public static int mulWord(int i, int[] iArr, int[] iArr2, int i2) {
        long j = ((long) i) & 4294967295L;
        long j2 = 0;
        int i3 = 0;
        do {
            long j3 = j2 + ((((long) iArr[i3]) & 4294967295L) * j);
            iArr2[i2 + i3] = (int) j3;
            j2 = j3 >>> 32;
            i3++;
        } while (i3 < 5);
        return (int) j2;
    }

    public static int mulWordAddExt(int i, int[] iArr, int i2, int[] iArr2, int i3) {
        long j = ((long) i) & 4294967295L;
        long j2 = ((((long) iArr[i2]) & 4294967295L) * j) + (((long) iArr2[i3]) & 4294967295L);
        iArr2[i3] = (int) j2;
        int i4 = i3 + 1;
        long j3 = (j2 >>> 32) + ((((long) iArr[i2 + 1]) & 4294967295L) * j) + (((long) iArr2[i4]) & 4294967295L);
        iArr2[i4] = (int) j3;
        int i5 = i3 + 2;
        long j4 = (j3 >>> 32) + ((((long) iArr[i2 + 2]) & 4294967295L) * j) + (((long) iArr2[i5]) & 4294967295L);
        iArr2[i5] = (int) j4;
        int i6 = i3 + 3;
        long j5 = (j4 >>> 32) + ((((long) iArr[i2 + 3]) & 4294967295L) * j) + (((long) iArr2[i6]) & 4294967295L);
        iArr2[i6] = (int) j5;
        int i7 = i3 + 4;
        long j6 = (j5 >>> 32) + (j * (((long) iArr[i2 + 4]) & 4294967295L)) + (((long) iArr2[i7]) & 4294967295L);
        iArr2[i7] = (int) j6;
        return (int) (j6 >>> 32);
    }

    public static int mulWordDwordAdd(int i, long j, int[] iArr, int i2) {
        long j2 = ((long) i) & 4294967295L;
        long j3 = ((j & 4294967295L) * j2) + (((long) iArr[i2]) & 4294967295L);
        iArr[i2] = (int) j3;
        long j4 = j2 * (j >>> 32);
        int i3 = i2 + 1;
        long j5 = (j3 >>> 32) + j4 + (((long) iArr[i3]) & 4294967295L);
        iArr[i3] = (int) j5;
        int i4 = i2 + 2;
        long j6 = (j5 >>> 32) + (((long) iArr[i4]) & 4294967295L);
        iArr[i4] = (int) j6;
        if ((j6 >>> 32) == 0) {
            return 0;
        }
        return Nat.incAt(5, iArr, i2, 3);
    }

    public static int mulWordsAdd(int i, int i2, int[] iArr, int i3) {
        long j = ((((long) i2) & 4294967295L) * (((long) i) & 4294967295L)) + (((long) iArr[i3]) & 4294967295L);
        iArr[i3] = (int) j;
        int i4 = i3 + 1;
        long j2 = (j >>> 32) + (4294967295L & ((long) iArr[i4]));
        iArr[i4] = (int) j2;
        if ((j2 >>> 32) == 0) {
            return 0;
        }
        return Nat.incAt(5, iArr, i3, 2);
    }

    public static void square(int[] iArr, int[] iArr2) {
        long j = ((long) iArr[0]) & 4294967295L;
        int i = 10;
        int i2 = 0;
        int i3 = 4;
        while (true) {
            int i4 = i3 - 1;
            long j2 = ((long) iArr[i3]) & 4294967295L;
            long j3 = j2 * j2;
            iArr2[i - 1] = (i2 << 31) | ((int) (j3 >>> 33));
            i -= 2;
            iArr2[i] = (int) (j3 >>> 1);
            i2 = (int) j3;
            if (i4 <= 0) {
                long j4 = j * j;
                long j5 = (j4 >>> 33) | (((long) (i2 << 31)) & 4294967295L);
                iArr2[0] = (int) j4;
                long j6 = ((long) iArr[1]) & 4294967295L;
                long j7 = j5 + (j6 * j);
                int i5 = (int) j7;
                iArr2[1] = (i5 << 1) | (((int) (j4 >>> 32)) & 1);
                long j8 = (((long) iArr2[2]) & 4294967295L) + (j7 >>> 32);
                long j9 = ((long) iArr[2]) & 4294967295L;
                long j10 = j;
                long j11 = j8 + (j9 * j10);
                int i6 = (int) j11;
                iArr2[2] = (i6 << 1) | (i5 >>> 31);
                long j12 = (((long) iArr2[3]) & 4294967295L) + (j11 >>> 32) + (j9 * j6);
                long j13 = (((long) iArr2[4]) & 4294967295L) + (j12 >>> 32);
                long j14 = ((long) iArr[3]) & 4294967295L;
                long j15 = j9;
                long j16 = (((long) iArr2[5]) & 4294967295L) + (j13 >>> 32);
                long j17 = j13 & 4294967295L;
                long j18 = (((long) iArr2[6]) & 4294967295L) + (j16 >>> 32);
                long j19 = (j12 & 4294967295L) + (j14 * j10);
                int i7 = (int) j19;
                iArr2[3] = (i7 << 1) | (i6 >>> 31);
                int i8 = i7 >>> 31;
                long j20 = j17 + (j19 >>> 32) + (j14 * j6);
                long j21 = (j16 & 4294967295L) + (j20 >>> 32) + (j14 * j15);
                long j22 = j18 + (j21 >>> 32);
                long j23 = ((long) iArr[4]) & 4294967295L;
                long j24 = (((long) iArr2[7]) & 4294967295L) + (j22 >>> 32);
                long j25 = 4294967295L & j24;
                long j26 = (j20 & 4294967295L) + (j23 * j10);
                int i9 = (int) j26;
                iArr2[4] = i8 | (i9 << 1);
                long j27 = (j21 & 4294967295L) + (j26 >>> 32) + (j6 * j23);
                long j28 = (j22 & 4294967295L) + (j27 >>> 32) + (j23 * j15);
                long j29 = j25 + (j28 >>> 32) + (j23 * j14);
                long j30 = (((long) iArr2[8]) & 4294967295L) + (j24 >>> 32) + (j29 >>> 32);
                int i10 = (int) j27;
                iArr2[5] = (i9 >>> 31) | (i10 << 1);
                int i11 = (int) j28;
                iArr2[6] = (i11 << 1) | (i10 >>> 31);
                int i12 = (int) j29;
                iArr2[7] = (i11 >>> 31) | (i12 << 1);
                int i13 = i12 >>> 31;
                int i14 = (int) j30;
                iArr2[8] = i13 | (i14 << 1);
                iArr2[9] = (i14 >>> 31) | ((iArr2[9] + ((int) (j30 >>> 32))) << 1);
                return;
            }
            i3 = i4;
        }
    }

    public static int sub(int[] iArr, int[] iArr2, int[] iArr3) {
        long j = (((long) iArr[0]) & 4294967295L) - (((long) iArr2[0]) & 4294967295L);
        iArr3[0] = (int) j;
        long j2 = (j >> 32) + ((((long) iArr[1]) & 4294967295L) - (((long) iArr2[1]) & 4294967295L));
        iArr3[1] = (int) j2;
        long j3 = (j2 >> 32) + ((((long) iArr[2]) & 4294967295L) - (((long) iArr2[2]) & 4294967295L));
        iArr3[2] = (int) j3;
        long j4 = (j3 >> 32) + ((((long) iArr[3]) & 4294967295L) - (((long) iArr2[3]) & 4294967295L));
        iArr3[3] = (int) j4;
        long j5 = (j4 >> 32) + ((((long) iArr[4]) & 4294967295L) - (((long) iArr2[4]) & 4294967295L));
        iArr3[4] = (int) j5;
        return (int) (j5 >> 32);
    }

    public static int subBothFrom(int[] iArr, int[] iArr2, int[] iArr3) {
        long j = ((((long) iArr3[0]) & 4294967295L) - (((long) iArr[0]) & 4294967295L)) - (((long) iArr2[0]) & 4294967295L);
        iArr3[0] = (int) j;
        long j2 = (j >> 32) + (((((long) iArr3[1]) & 4294967295L) - (((long) iArr[1]) & 4294967295L)) - (((long) iArr2[1]) & 4294967295L));
        iArr3[1] = (int) j2;
        long j3 = (j2 >> 32) + (((((long) iArr3[2]) & 4294967295L) - (((long) iArr[2]) & 4294967295L)) - (((long) iArr2[2]) & 4294967295L));
        iArr3[2] = (int) j3;
        long j4 = (j3 >> 32) + (((((long) iArr3[3]) & 4294967295L) - (((long) iArr[3]) & 4294967295L)) - (((long) iArr2[3]) & 4294967295L));
        iArr3[3] = (int) j4;
        long j5 = (j4 >> 32) + (((((long) iArr3[4]) & 4294967295L) - (((long) iArr[4]) & 4294967295L)) - (((long) iArr2[4]) & 4294967295L));
        iArr3[4] = (int) j5;
        return (int) (j5 >> 32);
    }

    public static int subFrom(int[] iArr, int[] iArr2) {
        long j = (((long) iArr2[0]) & 4294967295L) - (((long) iArr[0]) & 4294967295L);
        iArr2[0] = (int) j;
        long j2 = (j >> 32) + ((((long) iArr2[1]) & 4294967295L) - (((long) iArr[1]) & 4294967295L));
        iArr2[1] = (int) j2;
        long j3 = (j2 >> 32) + ((((long) iArr2[2]) & 4294967295L) - (((long) iArr[2]) & 4294967295L));
        iArr2[2] = (int) j3;
        long j4 = (j3 >> 32) + ((((long) iArr2[3]) & 4294967295L) - (((long) iArr[3]) & 4294967295L));
        iArr2[3] = (int) j4;
        long j5 = (j4 >> 32) + ((((long) iArr2[4]) & 4294967295L) - (4294967295L & ((long) iArr[4])));
        iArr2[4] = (int) j5;
        return (int) (j5 >> 32);
    }

    public static BigInteger toBigInteger(int[] iArr) {
        byte[] bArr = new byte[20];
        for (int i = 0; i < 5; i++) {
            int i2 = iArr[i];
            if (i2 != 0) {
                Pack.intToBigEndian(i2, bArr, (4 - i) << 2);
            }
        }
        return new BigInteger(1, bArr);
    }

    public static void zero(int[] iArr) {
        iArr[0] = 0;
        iArr[1] = 0;
        iArr[2] = 0;
        iArr[3] = 0;
        iArr[4] = 0;
    }

    public static boolean gte(int[] iArr, int i, int[] iArr2, int i2) {
        for (int i3 = 4; i3 >= 0; i3--) {
            int i4 = iArr[i + i3] ^ PKIFailureInfo.systemUnavail;
            int i5 = Integer.MIN_VALUE ^ iArr2[i2 + i3];
            if (i4 < i5) {
                return false;
            }
            if (i4 > i5) {
                return true;
            }
        }
        return true;
    }

    public static void copy(int[] iArr, int i, int[] iArr2, int i2) {
        iArr2[i2] = iArr[i];
        iArr2[i2 + 1] = iArr[i + 1];
        iArr2[i2 + 2] = iArr[i + 2];
        iArr2[i2 + 3] = iArr[i + 3];
        iArr2[i2 + 4] = iArr[i + 4];
    }

    public static int addTo(int[] iArr, int i, int[] iArr2, int i2, int i3) {
        long j = (((long) i3) & 4294967295L) + (((long) iArr[i]) & 4294967295L) + (((long) iArr2[i2]) & 4294967295L);
        iArr2[i2] = (int) j;
        int i4 = i2 + 1;
        long j2 = (j >>> 32) + (((long) iArr[i + 1]) & 4294967295L) + (((long) iArr2[i4]) & 4294967295L);
        iArr2[i4] = (int) j2;
        int i5 = i2 + 2;
        long j3 = (j2 >>> 32) + (((long) iArr[i + 2]) & 4294967295L) + (((long) iArr2[i5]) & 4294967295L);
        iArr2[i5] = (int) j3;
        int i6 = i2 + 3;
        long j4 = (j3 >>> 32) + (((long) iArr[i + 3]) & 4294967295L) + (((long) iArr2[i6]) & 4294967295L);
        iArr2[i6] = (int) j4;
        int i7 = i2 + 4;
        long j5 = (j4 >>> 32) + (((long) iArr[i + 4]) & 4294967295L) + (4294967295L & ((long) iArr2[i7]));
        iArr2[i7] = (int) j5;
        return (int) (j5 >>> 32);
    }

    public static int sub(int[] iArr, int i, int[] iArr2, int i2, int[] iArr3, int i3) {
        long j = (((long) iArr[i]) & 4294967295L) - (((long) iArr2[i2]) & 4294967295L);
        iArr3[i3] = (int) j;
        long j2 = (j >> 32) + ((((long) iArr[i + 1]) & 4294967295L) - (((long) iArr2[i2 + 1]) & 4294967295L));
        iArr3[i3 + 1] = (int) j2;
        long j3 = (j2 >> 32) + ((((long) iArr[i + 2]) & 4294967295L) - (((long) iArr2[i2 + 2]) & 4294967295L));
        iArr3[i3 + 2] = (int) j3;
        long j4 = (j3 >> 32) + ((((long) iArr[i + 3]) & 4294967295L) - (((long) iArr2[i2 + 3]) & 4294967295L));
        iArr3[i3 + 3] = (int) j4;
        long j5 = (j4 >> 32) + ((((long) iArr[i + 4]) & 4294967295L) - (((long) iArr2[i2 + 4]) & 4294967295L));
        iArr3[i3 + 4] = (int) j5;
        return (int) (j5 >> 32);
    }

    public static int subFrom(int[] iArr, int i, int[] iArr2, int i2) {
        long j = (((long) iArr2[i2]) & 4294967295L) - (((long) iArr[i]) & 4294967295L);
        iArr2[i2] = (int) j;
        int i3 = i2 + 1;
        long j2 = (j >> 32) + ((((long) iArr2[i3]) & 4294967295L) - (((long) iArr[i + 1]) & 4294967295L));
        iArr2[i3] = (int) j2;
        int i4 = i2 + 2;
        long j3 = (j2 >> 32) + ((((long) iArr2[i4]) & 4294967295L) - (((long) iArr[i + 2]) & 4294967295L));
        iArr2[i4] = (int) j3;
        int i5 = i2 + 3;
        long j4 = (j3 >> 32) + ((((long) iArr2[i5]) & 4294967295L) - (((long) iArr[i + 3]) & 4294967295L));
        iArr2[i5] = (int) j4;
        int i6 = i2 + 4;
        long j5 = (j4 >> 32) + ((((long) iArr2[i6]) & 4294967295L) - (((long) iArr[i + 4]) & 4294967295L));
        iArr2[i6] = (int) j5;
        return (int) (j5 >> 32);
    }

    public static int mulAddTo(int[] iArr, int i, int[] iArr2, int i2, int[] iArr3, int i3) {
        long j = ((long) iArr2[i2]) & 4294967295L;
        long j2 = ((long) iArr2[i2 + 1]) & 4294967295L;
        long j3 = ((long) iArr2[i2 + 2]) & 4294967295L;
        long j4 = ((long) iArr2[i2 + 3]) & 4294967295L;
        long j5 = ((long) iArr2[i2 + 4]) & 4294967295L;
        int i4 = 0;
        long j6 = 0;
        int i5 = i3;
        while (i4 < 5) {
            long j7 = ((long) iArr[i + i4]) & 4294967295L;
            long j8 = j;
            long j9 = (j7 * j) + (((long) iArr3[i5]) & 4294967295L);
            iArr3[i5] = (int) j9;
            int i6 = i5 + 1;
            long j10 = (j9 >>> 32) + (j7 * j2) + (((long) iArr3[i6]) & 4294967295L);
            iArr3[i6] = (int) j10;
            int i7 = i5 + 2;
            long j11 = (j10 >>> 32) + (j7 * j3) + (((long) iArr3[i7]) & 4294967295L);
            iArr3[i7] = (int) j11;
            int i8 = i5 + 3;
            long j12 = (j11 >>> 32) + (j7 * j4) + (((long) iArr3[i8]) & 4294967295L);
            iArr3[i8] = (int) j12;
            int i9 = i5 + 4;
            long j13 = (j12 >>> 32) + (j7 * j5) + (((long) iArr3[i9]) & 4294967295L);
            iArr3[i9] = (int) j13;
            int i10 = i5 + 5;
            long j14 = j6 + (j13 >>> 32) + (((long) iArr3[i10]) & 4294967295L);
            iArr3[i10] = (int) j14;
            j6 = j14 >>> 32;
            i4++;
            i5 = i6;
            j = j8;
            j2 = j2;
        }
        return (int) j6;
    }

    public static void mul(int[] iArr, int i, int[] iArr2, int i2, int[] iArr3, int i3) {
        long j = ((long) iArr2[i2]) & 4294967295L;
        long j2 = ((long) iArr2[i2 + 1]) & 4294967295L;
        long j3 = ((long) iArr2[i2 + 2]) & 4294967295L;
        long j4 = ((long) iArr2[i2 + 3]) & 4294967295L;
        long j5 = ((long) iArr2[i2 + 4]) & 4294967295L;
        long j6 = ((long) iArr[i]) & 4294967295L;
        long j7 = j6 * j;
        iArr3[i3] = (int) j7;
        long j8 = (j7 >>> 32) + (j6 * j2);
        long j9 = j2;
        iArr3[i3 + 1] = (int) j8;
        long j10 = (j8 >>> 32) + (j6 * j3);
        iArr3[i3 + 2] = (int) j10;
        long j11 = (j10 >>> 32) + (j6 * j4);
        iArr3[i3 + 3] = (int) j11;
        long j12 = (j11 >>> 32) + (j6 * j5);
        iArr3[i3 + 4] = (int) j12;
        iArr3[i3 + 5] = (int) (j12 >>> 32);
        int i4 = 1;
        int i5 = i3;
        while (i4 < 5) {
            int i6 = i5 + 1;
            long j13 = ((long) iArr[i + i4]) & 4294967295L;
            long j14 = j;
            long j15 = (j13 * j) + (((long) iArr3[i6]) & 4294967295L);
            iArr3[i6] = (int) j15;
            int i7 = i5 + 2;
            long j16 = (j15 >>> 32) + (j13 * j9) + (((long) iArr3[i7]) & 4294967295L);
            iArr3[i7] = (int) j16;
            int i8 = i5 + 3;
            long j17 = j3;
            long j18 = (j16 >>> 32) + (j13 * j3) + (((long) iArr3[i8]) & 4294967295L);
            iArr3[i8] = (int) j18;
            int i9 = i5 + 4;
            int i10 = i5;
            long j19 = (j18 >>> 32) + (j13 * j4) + (((long) iArr3[i9]) & 4294967295L);
            iArr3[i9] = (int) j19;
            int i11 = i10 + 5;
            long j20 = (j19 >>> 32) + (j13 * j5) + (((long) iArr3[i11]) & 4294967295L);
            iArr3[i11] = (int) j20;
            iArr3[i10 + 6] = (int) (j20 >>> 32);
            i4++;
            i5 = i6;
            j = j14;
            j3 = j17;
        }
    }

    public static void square(int[] iArr, int i, int[] iArr2, int i2) {
        long j = ((long) iArr[i]) & 4294967295L;
        int i3 = 0;
        int i4 = 10;
        int i5 = 4;
        while (true) {
            int i6 = i5 - 1;
            long j2 = ((long) iArr[i + i5]) & 4294967295L;
            long j3 = j2 * j2;
            iArr2[i2 + (i4 - 1)] = (i3 << 31) | ((int) (j3 >>> 33));
            i4 -= 2;
            iArr2[i2 + i4] = (int) (j3 >>> 1);
            i3 = (int) j3;
            if (i6 <= 0) {
                long j4 = j * j;
                iArr2[i2] = (int) j4;
                long j5 = ((long) iArr[i + 1]) & 4294967295L;
                int i7 = i2 + 2;
                long j6 = ((j4 >>> 33) | (((long) (i3 << 31)) & 4294967295L)) + (j5 * j);
                int i8 = (int) j6;
                iArr2[i2 + 1] = (i8 << 1) | (((int) (j4 >>> 32)) & 1);
                int i9 = i8 >>> 31;
                long j7 = (((long) iArr2[i7]) & 4294967295L) + (j6 >>> 32);
                long j8 = ((long) iArr[i + 2]) & 4294967295L;
                int i10 = i2 + 3;
                int i11 = i2 + 4;
                int i12 = i10;
                long j9 = ((long) iArr2[i10]) & 4294967295L;
                long j10 = j7 + (j8 * j);
                int i13 = (int) j10;
                iArr2[i7] = (i13 << 1) | i9;
                long j11 = j9 + (j10 >>> 32) + (j8 * j5);
                long j12 = (((long) iArr2[i11]) & 4294967295L) + (j11 >>> 32);
                long j13 = ((long) iArr[i + 3]) & 4294967295L;
                int i14 = i2 + 5;
                long j14 = j8;
                long j15 = (((long) iArr2[i14]) & 4294967295L) + (j12 >>> 32);
                int i15 = i2 + 6;
                long j16 = j12 & 4294967295L;
                long j17 = (((long) iArr2[i15]) & 4294967295L) + (j15 >>> 32);
                long j18 = (j11 & 4294967295L) + (j13 * j);
                int i16 = (int) j18;
                iArr2[i12] = (i16 << 1) | (i13 >>> 31);
                long j19 = j16 + (j18 >>> 32) + (j13 * j5);
                long j20 = (j15 & 4294967295L) + (j19 >>> 32) + (j13 * j14);
                long j21 = j17 + (j20 >>> 32);
                long j22 = j20 & 4294967295L;
                long j23 = ((long) iArr[i + 4]) & 4294967295L;
                int i17 = i2 + 7;
                long j24 = j13;
                long j25 = (((long) iArr2[i17]) & 4294967295L) + (j21 >>> 32);
                int i18 = i2 + 8;
                int i19 = i17;
                long j26 = (j19 & 4294967295L) + (j * j23);
                int i20 = (int) j26;
                iArr2[i11] = (i20 << 1) | (i16 >>> 31);
                long j27 = j22 + (j26 >>> 32) + (j5 * j23);
                long j28 = (j21 & 4294967295L) + (j27 >>> 32) + (j23 * j14);
                long j29 = (j25 & 4294967295L) + (j28 >>> 32) + (j23 * j24);
                long j30 = (((long) iArr2[i18]) & 4294967295L) + (j25 >>> 32) + (j29 >>> 32);
                int i21 = (int) j27;
                iArr2[i14] = (i20 >>> 31) | (i21 << 1);
                int i22 = (int) j28;
                iArr2[i15] = (i21 >>> 31) | (i22 << 1);
                int i23 = i22 >>> 31;
                int i24 = (int) j29;
                iArr2[i19] = i23 | (i24 << 1);
                int i25 = i24 >>> 31;
                int i26 = (int) j30;
                iArr2[i18] = i25 | (i26 << 1);
                int i27 = i26 >>> 31;
                int i28 = i2 + 9;
                iArr2[i28] = i27 | ((iArr2[i28] + ((int) (j30 >>> 32))) << 1);
                return;
            }
            i5 = i6;
        }
    }
}
