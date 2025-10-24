package com.fis.ekyc.nfc.build_in.bouncycastle.crypto.paddings;

import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.InvalidCipherTextException;
import java.security.SecureRandom;

public class PKCS7Padding implements BlockCipherPadding {
    public int addPadding(byte[] bArr, int i) {
        byte length = (byte) (bArr.length - i);
        while (i < bArr.length) {
            bArr[i] = length;
            i++;
        }
        return length;
    }

    public String getPaddingName() {
        return "PKCS7";
    }

    public void init(SecureRandom secureRandom) throws IllegalArgumentException {
    }

    public int padCount(byte[] bArr) throws InvalidCipherTextException {
        boolean z;
        boolean z2;
        boolean z3;
        boolean z5;
        byte b = bArr[bArr.length - 1] & 255;
        byte b2 = (byte) b;
        if (b > bArr.length) {
            z = true;
        } else {
            z = false;
        }
        if (b == 0) {
            z2 = true;
        } else {
            z2 = false;
        }
        boolean z6 = z | z2;
        for (int i = 0; i < bArr.length; i++) {
            if (bArr.length - i <= b) {
                z3 = true;
            } else {
                z3 = false;
            }
            if (bArr[i] != b2) {
                z5 = true;
            } else {
                z5 = false;
            }
            z6 |= z3 & z5;
        }
        if (!z6) {
            return b;
        }
        throw new InvalidCipherTextException("pad block corrupted");
    }
}
