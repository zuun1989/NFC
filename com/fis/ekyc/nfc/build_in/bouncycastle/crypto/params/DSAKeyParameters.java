package com.fis.ekyc.nfc.build_in.bouncycastle.crypto.params;

public class DSAKeyParameters extends AsymmetricKeyParameter {
    private DSAParameters params;

    public DSAKeyParameters(boolean z, DSAParameters dSAParameters) {
        super(z);
        this.params = dSAParameters;
    }

    public DSAParameters getParameters() {
        return this.params;
    }
}
