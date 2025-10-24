package com.fis.ekyc.nfc.build_in.bouncycastle.pqc.crypto.ntru;

import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.params.AsymmetricKeyParameter;

public class NTRUEncryptionKeyParameters extends AsymmetricKeyParameter {
    protected final NTRUEncryptionParameters params;

    public NTRUEncryptionKeyParameters(boolean z, NTRUEncryptionParameters nTRUEncryptionParameters) {
        super(z);
        this.params = nTRUEncryptionParameters;
    }

    public NTRUEncryptionParameters getParameters() {
        return this.params;
    }
}
