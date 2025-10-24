package com.fis.ekyc.nfc.build_in.bouncycastle.pqc.crypto.cmce;

import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.params.AsymmetricKeyParameter;

public class CMCEKeyParameters extends AsymmetricKeyParameter {
    private CMCEParameters params;

    public CMCEKeyParameters(boolean z, CMCEParameters cMCEParameters) {
        super(z);
        this.params = cMCEParameters;
    }

    public CMCEParameters getParameters() {
        return this.params;
    }
}
