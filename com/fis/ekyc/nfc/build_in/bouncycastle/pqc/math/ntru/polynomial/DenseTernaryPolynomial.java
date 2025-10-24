package com.fis.ekyc.nfc.build_in.bouncycastle.pqc.math.ntru.polynomial;

import com.fis.ekyc.nfc.build_in.bouncycastle.pqc.math.ntru.util.Util;
import com.fis.ekyc.nfc.build_in.bouncycastle.util.Arrays;
import java.security.SecureRandom;

public class DenseTernaryPolynomial extends IntegerPolynomial implements TernaryPolynomial {
    public DenseTernaryPolynomial(int i) {
        super(i);
        checkTernarity();
    }

    private void checkTernarity() {
        int i;
        int i2 = 0;
        while (true) {
            int[] iArr = this.coeffs;
            if (i2 != iArr.length) {
                i = iArr[i2];
                if (i < -1 || i > 1) {
                } else {
                    i2++;
                }
            } else {
                return;
            }
        }
        throw new IllegalStateException("Illegal value: " + i + ", must be one of {-1, 0, 1}");
    }

    public static DenseTernaryPolynomial generateRandom(int i, int i2, int i3, SecureRandom secureRandom) {
        return new DenseTernaryPolynomial(Util.generateRandomTernary(i, i2, i3, secureRandom));
    }

    public int[] getNegOnes() {
        int length = this.coeffs.length;
        int[] iArr = new int[length];
        int i = 0;
        for (int i2 = 0; i2 < length; i2++) {
            if (this.coeffs[i2] == -1) {
                iArr[i] = i2;
                i++;
            }
        }
        return Arrays.copyOf(iArr, i);
    }

    public int[] getOnes() {
        int length = this.coeffs.length;
        int[] iArr = new int[length];
        int i = 0;
        for (int i2 = 0; i2 < length; i2++) {
            if (this.coeffs[i2] == 1) {
                iArr[i] = i2;
                i++;
            }
        }
        return Arrays.copyOf(iArr, i);
    }

    public IntegerPolynomial mult(IntegerPolynomial integerPolynomial, int i) {
        if (i != 2048) {
            return super.mult(integerPolynomial, i);
        }
        IntegerPolynomial integerPolynomial2 = (IntegerPolynomial) integerPolynomial.clone();
        integerPolynomial2.modPositive(2048);
        return new LongPolynomial5(integerPolynomial2).mult(this).toIntegerPolynomial();
    }

    public int size() {
        return this.coeffs.length;
    }

    public DenseTernaryPolynomial(IntegerPolynomial integerPolynomial) {
        this(integerPolynomial.coeffs);
    }

    public static DenseTernaryPolynomial generateRandom(int i, SecureRandom secureRandom) {
        DenseTernaryPolynomial denseTernaryPolynomial = new DenseTernaryPolynomial(i);
        for (int i2 = 0; i2 < i; i2++) {
            denseTernaryPolynomial.coeffs[i2] = secureRandom.nextInt(3) - 1;
        }
        return denseTernaryPolynomial;
    }

    public DenseTernaryPolynomial(int[] iArr) {
        super(iArr);
        checkTernarity();
    }
}
