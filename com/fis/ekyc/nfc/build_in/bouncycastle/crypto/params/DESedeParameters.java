package com.fis.ekyc.nfc.build_in.bouncycastle.crypto.params;

public class DESedeParameters extends DESParameters {
    public static final int DES_EDE_KEY_LENGTH = 24;

    public DESedeParameters(byte[] bArr) {
        super(bArr);
        if (isWeakKey(bArr, 0, bArr.length)) {
            throw new IllegalArgumentException("attempt to create weak DESede key");
        }
    }

    public static boolean isReal2Key(byte[] bArr, int i) {
        boolean z = false;
        for (int i2 = i; i2 != i + 8; i2++) {
            if (bArr[i2] != bArr[i2 + 8]) {
                z = true;
            }
        }
        return z;
    }

    public static boolean isReal3Key(byte[] bArr, int i) {
        boolean z;
        boolean z2;
        int i2 = i;
        boolean z3 = false;
        boolean z5 = false;
        boolean z6 = false;
        while (true) {
            boolean z7 = true;
            if (i2 == i + 8) {
                break;
            }
            byte b = bArr[i2];
            byte b2 = bArr[i2 + 8];
            if (b != b2) {
                z = true;
            } else {
                z = false;
            }
            z3 |= z;
            byte b3 = bArr[i2 + 16];
            if (b != b3) {
                z2 = true;
            } else {
                z2 = false;
            }
            z5 |= z2;
            if (b2 == b3) {
                z7 = false;
            }
            z6 |= z7;
            i2++;
        }
        if (!z3 || !z5 || !z6) {
            return false;
        }
        return true;
    }

    public static boolean isRealEDEKey(byte[] bArr, int i) {
        if (bArr.length == 16) {
            return isReal2Key(bArr, i);
        }
        return isReal3Key(bArr, i);
    }

    public static boolean isWeakKey(byte[] bArr, int i, int i2) {
        while (i < i2) {
            if (DESParameters.isWeakKey(bArr, i)) {
                return true;
            }
            i += 8;
        }
        return false;
    }

    public static boolean isWeakKey(byte[] bArr, int i) {
        return isWeakKey(bArr, i, bArr.length - i);
    }
}
