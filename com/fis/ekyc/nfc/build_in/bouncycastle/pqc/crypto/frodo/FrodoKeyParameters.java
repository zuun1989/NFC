package com.fis.ekyc.nfc.build_in.bouncycastle.pqc.crypto.frodo;

import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.params.AsymmetricKeyParameter;

public class FrodoKeyParameters extends AsymmetricKeyParameter {
    private FrodoParameters params;

    public FrodoKeyParameters(boolean z, FrodoParameters frodoParameters) {
        super(z);
        this.params = frodoParameters;
    }

    public FrodoParameters getParameters() {
        return this.params;
    }
}
