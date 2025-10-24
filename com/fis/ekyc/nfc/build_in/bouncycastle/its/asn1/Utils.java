package com.fis.ekyc.nfc.build_in.bouncycastle.its.asn1;

import com.fis.ekyc.nfc.build_in.bouncycastle.util.Arrays;

class Utils {
    public static byte[] octetStringFixed(byte[] bArr, int i) {
        if (bArr.length == i) {
            return bArr;
        }
        throw new IllegalArgumentException("octet string out of range");
    }

    public static byte[] octetStringFixed(byte[] bArr) {
        if (bArr.length >= 1 && bArr.length <= 32) {
            return Arrays.clone(bArr);
        }
        throw new IllegalArgumentException("octet string out of range");
    }
}
