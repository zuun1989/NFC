package com.fis.ekyc.nfc.build_in.bouncycastle.pqc.crypto.gmss;

import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.params.AsymmetricKeyParameter;

public class GMSSKeyParameters extends AsymmetricKeyParameter {
    private GMSSParameters params;

    public GMSSKeyParameters(boolean z, GMSSParameters gMSSParameters) {
        super(z);
        this.params = gMSSParameters;
    }

    public GMSSParameters getParameters() {
        return this.params;
    }
}
