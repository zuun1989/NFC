package com.fis.ekyc.nfc.build_in.bouncycastle.crypto.params;

import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.DerivationParameters;

public class ISO18033KDFParameters implements DerivationParameters {
    byte[] seed;

    public ISO18033KDFParameters(byte[] bArr) {
        this.seed = bArr;
    }

    public byte[] getSeed() {
        return this.seed;
    }
}
