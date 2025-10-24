package com.fis.ekyc.nfc.build_in.bouncycastle.crypto.params;

import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.CipherParameters;
import com.fis.ekyc.nfc.build_in.bouncycastle.util.Arrays;

public class IESParameters implements CipherParameters {
    private byte[] derivation;
    private byte[] encoding;
    private int macKeySize;

    public IESParameters(byte[] bArr, byte[] bArr2, int i) {
        this.derivation = Arrays.clone(bArr);
        this.encoding = Arrays.clone(bArr2);
        this.macKeySize = i;
    }

    public byte[] getDerivationV() {
        return Arrays.clone(this.derivation);
    }

    public byte[] getEncodingV() {
        return Arrays.clone(this.encoding);
    }

    public int getMacKeySize() {
        return this.macKeySize;
    }
}
