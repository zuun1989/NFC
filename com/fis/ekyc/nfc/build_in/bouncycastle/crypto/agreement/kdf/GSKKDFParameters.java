package com.fis.ekyc.nfc.build_in.bouncycastle.crypto.agreement.kdf;

import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.DerivationParameters;

public class GSKKDFParameters implements DerivationParameters {
    private final byte[] nonce;
    private final int startCounter;
    private final byte[] z;

    public GSKKDFParameters(byte[] bArr, int i) {
        this(bArr, i, (byte[]) null);
    }

    public byte[] getNonce() {
        return this.nonce;
    }

    public int getStartCounter() {
        return this.startCounter;
    }

    public byte[] getZ() {
        return this.z;
    }

    public GSKKDFParameters(byte[] bArr, int i, byte[] bArr2) {
        this.z = bArr;
        this.startCounter = i;
        this.nonce = bArr2;
    }
}
