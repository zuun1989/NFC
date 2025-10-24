package com.fis.ekyc.nfc.build_in.bouncycastle.pqc.crypto.saber;

import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.params.AsymmetricKeyParameter;

public class SABERKeyParameters extends AsymmetricKeyParameter {
    private SABERParameters params;

    public SABERKeyParameters(boolean z, SABERParameters sABERParameters) {
        super(z);
        this.params = sABERParameters;
    }

    public SABERParameters getParameters() {
        return this.params;
    }
}
