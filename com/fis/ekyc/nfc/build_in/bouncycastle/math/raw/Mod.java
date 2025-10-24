package com.fis.ekyc.nfc.build_in.bouncycastle.math.raw;

import com.fis.ekyc.nfc.build_in.bouncycastle.util.Integers;
import java.util.Random;

public abstract class Mod {
    private static final int M30 = 1073741823;
    private static final long M32L = 4294967295L;

    public static void add(int[] iArr, int[] iArr2, int[] iArr3, int[] iArr4) {
        int length = iArr.length;
        if (Nat.add(length, iArr2, iArr3, iArr4) != 0) {
            Nat.subFrom(length, iArr, iArr4);
        }
    }

    private static int add30(int i, int[] iArr, int[] iArr2) {
        int i2 = i - 1;
        int i3 = 0;
        for (int i4 = 0; i4 < i2; i4++) {
            int i5 = i3 + iArr[i4] + iArr2[i4];
            iArr[i4] = M30 & i5;
            i3 = i5 >> 30;
        }
        int i6 = i3 + iArr[i2] + iArr2[i2];
        iArr[i2] = i6;
        return i6 >> 30;
    }

    private static int cadd30(int i, int i2, int[] iArr, int[] iArr2) {
        int i3 = i - 1;
        int i4 = 0;
        for (int i5 = 0; i5 < i3; i5++) {
            int i6 = i4 + iArr[i5] + (iArr2[i5] & i2);
            iArr[i5] = M30 & i6;
            i4 = i6 >> 30;
        }
        int i7 = i4 + iArr[i3] + (i2 & iArr2[i3]);
        iArr[i3] = i7;
        return i7 >> 30;
    }

    public static void checkedModOddInverse(int[] iArr, int[] iArr2, int[] iArr3) {
        if (modOddInverse(iArr, iArr2, iArr3) == 0) {
            throw new ArithmeticException("Inverse does not exist.");
        }
    }

    public static void checkedModOddInverseVar(int[] iArr, int[] iArr2, int[] iArr3) {
        if (!modOddInverseVar(iArr, iArr2, iArr3)) {
            throw new ArithmeticException("Inverse does not exist.");
        }
    }

    private static int cnegate30(int i, int i2, int[] iArr) {
        int i3 = i - 1;
        int i4 = 0;
        for (int i5 = 0; i5 < i3; i5++) {
            int i6 = i4 + ((iArr[i5] ^ i2) - i2);
            iArr[i5] = M30 & i6;
            i4 = i6 >> 30;
        }
        int i7 = i4 + ((iArr[i3] ^ i2) - i2);
        iArr[i3] = i7;
        return i7 >> 30;
    }

    private static int csub30(int i, int i2, int[] iArr, int[] iArr2) {
        int i3 = i - 1;
        int i4 = 0;
        for (int i5 = 0; i5 < i3; i5++) {
            int i6 = i4 + (iArr[i5] - (iArr2[i5] & i2));
            iArr[i5] = M30 & i6;
            i4 = i6 >> 30;
        }
        int i7 = i4 + (iArr[i3] - (i2 & iArr2[i3]));
        iArr[i3] = i7;
        return i7 >> 30;
    }

    private static void decode30(int i, int[] iArr, int i2, int[] iArr2, int i3) {
        int i4 = 0;
        long j = 0;
        while (i > 0) {
            while (i4 < Math.min(32, i)) {
                j |= ((long) iArr[i2]) << i4;
                i4 += 30;
                i2++;
            }
            iArr2[i3] = (int) j;
            j >>>= 32;
            i4 -= 32;
            i -= 32;
            i3++;
        }
    }

    private static int divsteps30(int i, int i2, int i3, int[] iArr) {
        int i4 = 1;
        int i5 = 1;
        int i6 = 0;
        int i7 = 0;
        for (int i8 = 0; i8 < 30; i8++) {
            int i9 = i >> 31;
            int i10 = -(i3 & 1);
            int i11 = i3 + (((i2 ^ i9) - i9) & i10);
            i7 += ((i4 ^ i9) - i9) & i10;
            i5 += ((i6 ^ i9) - i9) & i10;
            int i12 = i9 & i10;
            i = (i ^ i12) - (i12 + 1);
            i2 += i11 & i12;
            i3 = i11 >> 1;
            i4 = (i4 + (i7 & i12)) << 1;
            i6 = (i6 + (i12 & i5)) << 1;
        }
        iArr[0] = i4;
        iArr[1] = i6;
        iArr[2] = i7;
        iArr[3] = i5;
        return i;
    }

    private static int divsteps30Var(int i, int i2, int i3, int[] iArr) {
        int i4;
        int i5 = i2;
        int i6 = i3;
        int i7 = 1;
        int i8 = 1;
        int i9 = 0;
        int i10 = 0;
        int i11 = 30;
        int i12 = i;
        while (true) {
            int numberOfTrailingZeros = Integers.numberOfTrailingZeros((-1 << i11) | i6);
            int i13 = i6 >> numberOfTrailingZeros;
            i7 <<= numberOfTrailingZeros;
            i9 <<= numberOfTrailingZeros;
            i12 -= numberOfTrailingZeros;
            i11 -= numberOfTrailingZeros;
            if (i11 <= 0) {
                iArr[0] = i7;
                iArr[1] = i9;
                iArr[2] = i10;
                iArr[3] = i8;
                return i12;
            }
            if (i12 < 0) {
                i12 = -i12;
                int i14 = -i5;
                int i15 = -i7;
                int i16 = -i9;
                int i17 = i12 + 1;
                if (i17 > i11) {
                    i17 = i11;
                }
                i4 = (-1 >>> (32 - i17)) & 63 & (i13 * i14 * ((i13 * i13) - 2));
                int i18 = i13;
                i13 = i14;
                i5 = i18;
                int i19 = i10;
                i10 = i15;
                i7 = i19;
                int i20 = i8;
                i8 = i16;
                i9 = i20;
            } else {
                int i21 = i12 + 1;
                if (i21 > i11) {
                    i21 = i11;
                }
                i4 = (-1 >>> (32 - i21)) & 15 & ((-((((i5 + 1) & 4) << 1) + i5)) * i13);
            }
            i6 = i13 + (i5 * i4);
            i10 += i7 * i4;
            i8 += i4 * i9;
        }
    }

    private static void encode30(int i, int[] iArr, int i2, int[] iArr2, int i3) {
        int i4 = 0;
        long j = 0;
        while (i > 0) {
            if (i4 < Math.min(30, i)) {
                j |= (((long) iArr[i2]) & 4294967295L) << i4;
                i4 += 32;
                i2++;
            }
            iArr2[i3] = ((int) j) & M30;
            j >>>= 30;
            i4 -= 30;
            i -= 30;
            i3++;
        }
    }

    private static int getMaximumDivsteps(int i) {
        int i2;
        int i3 = i * 49;
        if (i < 46) {
            i2 = 80;
        } else {
            i2 = 47;
        }
        return (i3 + i2) / 17;
    }

    public static int inverse32(int i) {
        int i2 = (2 - (i * i)) * i;
        int i3 = i2 * (2 - (i * i2));
        int i4 = i3 * (2 - (i * i3));
        return i4 * (2 - (i * i4));
    }

    public static void invert(int[] iArr, int[] iArr2, int[] iArr3) {
        checkedModOddInverseVar(iArr, iArr2, iArr3);
    }

    public static int modOddInverse(int[] iArr, int[] iArr2, int[] iArr3) {
        int[] iArr4 = iArr;
        int length = iArr4.length;
        int numberOfLeadingZeros = (length << 5) - Integers.numberOfLeadingZeros(iArr4[length - 1]);
        int i = (numberOfLeadingZeros + 29) / 30;
        int i2 = (-inverse32(iArr4[0])) << 2;
        int[] iArr5 = new int[4];
        int[] iArr6 = new int[i];
        int[] iArr7 = new int[i];
        int[] iArr8 = new int[i];
        int[] iArr9 = new int[i];
        int[] iArr10 = new int[i];
        iArr7[0] = 1;
        encode30(numberOfLeadingZeros, iArr2, 0, iArr9, 0);
        encode30(numberOfLeadingZeros, iArr4, 0, iArr10, 0);
        System.arraycopy(iArr10, 0, iArr8, 0, i);
        int maximumDivsteps = getMaximumDivsteps(numberOfLeadingZeros);
        int i3 = -1;
        int i4 = 0;
        while (i4 < maximumDivsteps) {
            int divsteps30 = divsteps30(i3, iArr8[0], iArr9[0], iArr5);
            int[] iArr11 = iArr10;
            int[] iArr12 = iArr9;
            updateDE30(i, iArr6, iArr7, iArr5, i2, iArr11);
            updateFG30(i, iArr8, iArr12, iArr5);
            i4 += 30;
            iArr10 = iArr11;
            iArr9 = iArr12;
            i3 = divsteps30;
        }
        int i5 = iArr8[i - 1] >> 31;
        cnegate30(i, i5, iArr8);
        int[] iArr13 = iArr10;
        cadd30(i, cadd30(i, csub30(i, ~cnegate30(i, i5, iArr6), iArr6, iArr13), iArr6, iArr13), iArr6, iArr13);
        decode30(numberOfLeadingZeros, iArr6, 0, iArr3, 0);
        return Nat.equalTo(i, iArr8, 1) & Nat.equalToZero(i, iArr9);
    }

    /* JADX WARNING: type inference failed for: r10v0 */
    /* JADX WARNING: type inference failed for: r10v1, types: [boolean] */
    /* JADX WARNING: type inference failed for: r10v4 */
    public static boolean modOddInverseVar(int[] iArr, int[] iArr2, int[] iArr3) {
        int i;
        int[] iArr4;
        int[] iArr5 = iArr;
        int length = iArr5.length;
        int numberOfLeadingZeros = (length << 5) - Integers.numberOfLeadingZeros(iArr5[length - 1]);
        int i2 = (numberOfLeadingZeros + 29) / 30;
        ? r10 = 0;
        int i3 = (-inverse32(iArr5[0])) << 2;
        int[] iArr6 = new int[4];
        int[] iArr7 = new int[i2];
        int[] iArr8 = new int[i2];
        int[] iArr9 = new int[i2];
        int[] iArr10 = new int[i2];
        int[] iArr11 = new int[i2];
        iArr8[0] = 1;
        encode30(numberOfLeadingZeros, iArr2, 0, iArr10, 0);
        encode30(numberOfLeadingZeros, iArr5, 0, iArr11, 0);
        System.arraycopy(iArr11, 0, iArr9, 0, i2);
        int i4 = i2 - 1;
        int numberOfLeadingZeros2 = -1 - (Integers.numberOfLeadingZeros(iArr10[i4] | 1) - (((i2 * 30) + 2) - numberOfLeadingZeros));
        int maximumDivsteps = getMaximumDivsteps(numberOfLeadingZeros);
        int i5 = i2;
        int i6 = 0;
        while (!Nat.isZero(i5, iArr10)) {
            if (i6 >= maximumDivsteps) {
                return r10;
            }
            int i7 = i6 + 30;
            int divsteps30Var = divsteps30Var(numberOfLeadingZeros2, iArr9[r10], iArr10[r10], iArr6);
            int i8 = i5;
            int i9 = maximumDivsteps;
            int[] iArr12 = iArr11;
            int i10 = divsteps30Var;
            int[] iArr13 = iArr10;
            updateDE30(i2, iArr7, iArr8, iArr6, i3, iArr12);
            updateFG30(i8, iArr9, iArr13, iArr6);
            int i11 = i8 - 1;
            int i12 = iArr9[i11];
            int i13 = iArr13[i11];
            int i14 = i8 - 2;
            if (((i14 >> 31) | ((i12 >> 31) ^ i12) | ((i13 >> 31) ^ i13)) == 0) {
                iArr9[i14] = (i12 << 30) | iArr9[i14];
                iArr13[i14] = iArr13[i14] | (i13 << 30);
                i5 = i8 - 1;
            } else {
                i5 = i8;
            }
            iArr11 = iArr12;
            numberOfLeadingZeros2 = i10;
            iArr10 = iArr13;
            i6 = i7;
            maximumDivsteps = i9;
            r10 = 0;
        }
        int i15 = i5;
        int[] iArr14 = iArr11;
        if ((iArr9[i15 - 1] >> 31) != 0) {
            negate30(i15, iArr9);
            negate30(i2, iArr7);
        }
        if (!Nat.isOne(i15, iArr9)) {
            return false;
        }
        if ((iArr7[i4] >> 31) < 0) {
            iArr4 = iArr14;
            i = add30(i2, iArr7, iArr4);
        } else {
            iArr4 = iArr14;
            i = sub30(i2, iArr7, iArr4);
        }
        if (i < 0) {
            add30(i2, iArr7, iArr4);
        }
        decode30(numberOfLeadingZeros, iArr7, 0, iArr3, 0);
        return true;
    }

    private static int negate30(int i, int[] iArr) {
        int i2 = i - 1;
        int i3 = 0;
        for (int i4 = 0; i4 < i2; i4++) {
            int i5 = i3 - iArr[i4];
            iArr[i4] = M30 & i5;
            i3 = i5 >> 30;
        }
        int i6 = i3 - iArr[i2];
        iArr[i2] = i6;
        return i6 >> 30;
    }

    public static int[] random(int[] iArr) {
        int length = iArr.length;
        Random random = new Random();
        int[] create = Nat.create(length);
        int i = length - 1;
        int i2 = iArr[i];
        int i3 = i2 | (i2 >>> 1);
        int i4 = i3 | (i3 >>> 2);
        int i5 = i4 | (i4 >>> 4);
        int i6 = i5 | (i5 >>> 8);
        int i7 = i6 | (i6 >>> 16);
        do {
            for (int i8 = 0; i8 != length; i8++) {
                create[i8] = random.nextInt();
            }
            create[i] = create[i] & i7;
        } while (Nat.gte(length, create, iArr));
        return create;
    }

    private static int sub30(int i, int[] iArr, int[] iArr2) {
        int i2 = i - 1;
        int i3 = 0;
        for (int i4 = 0; i4 < i2; i4++) {
            int i5 = i3 + (iArr[i4] - iArr2[i4]);
            iArr[i4] = M30 & i5;
            i3 = i5 >> 30;
        }
        int i6 = i3 + (iArr[i2] - iArr2[i2]);
        iArr[i2] = i6;
        return i6 >> 30;
    }

    public static void subtract(int[] iArr, int[] iArr2, int[] iArr3, int[] iArr4) {
        int length = iArr.length;
        if (Nat.sub(length, iArr2, iArr3, iArr4) != 0) {
            Nat.addTo(length, iArr, iArr4);
        }
    }

    private static void updateDE30(int i, int[] iArr, int[] iArr2, int[] iArr3, int i2, int[] iArr4) {
        int i3 = i;
        int i4 = iArr3[0];
        int i5 = iArr3[1];
        int i6 = iArr3[2];
        int i7 = iArr3[3];
        long j = (long) i4;
        long j2 = (long) iArr[0];
        long j3 = (long) i5;
        long j4 = (long) iArr2[0];
        long j5 = (j * j2) + (j3 * j4);
        long j6 = j3;
        long j7 = (long) i6;
        long j8 = (long) i7;
        long j9 = (j2 * j7) + (j4 * j8);
        int i8 = iArr4[0];
        long j10 = j8;
        long j11 = (long) ((((int) j5) * i2) >> 2);
        long j12 = (long) ((((int) j9) * i2) >> 2);
        long j13 = (j5 + (((long) i8) * j11)) >> 30;
        long j14 = (j9 + (((long) i8) * j12)) >> 30;
        int i9 = 1;
        while (i9 < i3) {
            long j15 = j12;
            long j16 = (long) iArr[i9];
            long j17 = j * j16;
            long j18 = j;
            long j19 = (long) iArr2[i9];
            int i10 = iArr4[i9];
            long j20 = j13 + j17 + (j6 * j19) + (((long) i10) * j11);
            long j21 = j14 + (j16 * j7) + (j19 * j10) + (((long) i10) * j15);
            int i11 = i9 - 1;
            iArr[i11] = ((int) j20) & M30;
            j13 = j20 >> 30;
            iArr2[i11] = M30 & ((int) j21);
            j14 = j21 >> 30;
            i9++;
            j12 = j15;
            j = j18;
        }
        int i12 = i3 - 1;
        iArr[i12] = (int) j13;
        iArr2[i12] = (int) j14;
    }

    private static void updateFG30(int i, int[] iArr, int[] iArr2, int[] iArr3) {
        int i2 = i;
        int i3 = iArr3[0];
        int i4 = 1;
        int i5 = iArr3[1];
        int i6 = iArr3[2];
        int i7 = iArr3[3];
        long j = (long) i3;
        long j2 = (long) iArr[0];
        long j3 = (long) i5;
        long j4 = (long) iArr2[0];
        long j5 = (long) i6;
        long j6 = (long) i7;
        long j7 = ((j * j2) + (j3 * j4)) >> 30;
        long j8 = ((j2 * j5) + (j4 * j6)) >> 30;
        int i8 = 1;
        while (i8 < i2) {
            int i9 = iArr[i8];
            int i10 = iArr2[i8];
            int i11 = i8;
            long j9 = (long) i9;
            long j10 = j * j9;
            long j11 = j;
            long j12 = (long) i10;
            long j13 = j7 + j10 + (j3 * j12);
            long j14 = j8 + (j9 * j5) + (j12 * j6);
            int i12 = i11 - 1;
            iArr[i12] = ((int) j13) & M30;
            j7 = j13 >> 30;
            iArr2[i12] = M30 & ((int) j14);
            j8 = j14 >> 30;
            i8 = i11 + 1;
            j = j11;
            i4 = 1;
        }
        int i13 = i2 - i4;
        iArr[i13] = (int) j7;
        iArr2[i13] = (int) j8;
    }
}
