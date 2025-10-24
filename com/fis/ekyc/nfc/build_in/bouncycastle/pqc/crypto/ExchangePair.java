package com.fis.ekyc.nfc.build_in.bouncycastle.pqc.crypto;

import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.params.AsymmetricKeyParameter;
import com.fis.ekyc.nfc.build_in.bouncycastle.util.Arrays;

public class ExchangePair {
    private final AsymmetricKeyParameter publicKey;
    private final byte[] shared;

    public ExchangePair(AsymmetricKeyParameter asymmetricKeyParameter, byte[] bArr) {
        this.publicKey = asymmetricKeyParameter;
        this.shared = Arrays.clone(bArr);
    }

    public AsymmetricKeyParameter getPublicKey() {
        return this.publicKey;
    }

    public byte[] getSharedValue() {
        return Arrays.clone(this.shared);
    }
}
