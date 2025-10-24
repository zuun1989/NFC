package com.fis.ekyc.nfc.build_in.bouncycastle.pqc.crypto.frodo;

import com.fis.ekyc.nfc.build_in.bouncycastle.util.Arrays;

public class FrodoPublicKeyParameters extends FrodoKeyParameters {
    public byte[] publicKey;

    public FrodoPublicKeyParameters(FrodoParameters frodoParameters, byte[] bArr) {
        super(false, frodoParameters);
        this.publicKey = Arrays.clone(bArr);
    }

    public byte[] getEncoded() {
        return getPublicKey();
    }

    public byte[] getPublicKey() {
        return Arrays.clone(this.publicKey);
    }
}
