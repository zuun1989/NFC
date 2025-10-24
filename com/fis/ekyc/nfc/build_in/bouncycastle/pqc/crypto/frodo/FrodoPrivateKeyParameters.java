package com.fis.ekyc.nfc.build_in.bouncycastle.pqc.crypto.frodo;

import com.fis.ekyc.nfc.build_in.bouncycastle.util.Arrays;

public class FrodoPrivateKeyParameters extends FrodoKeyParameters {
    private byte[] privateKey;

    public FrodoPrivateKeyParameters(FrodoParameters frodoParameters, byte[] bArr) {
        super(true, frodoParameters);
        this.privateKey = Arrays.clone(bArr);
    }

    public byte[] getEncoded() {
        return Arrays.clone(this.privateKey);
    }

    public byte[] getPrivateKey() {
        return Arrays.clone(this.privateKey);
    }
}
