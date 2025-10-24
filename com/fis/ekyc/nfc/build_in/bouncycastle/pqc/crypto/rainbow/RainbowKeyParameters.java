package com.fis.ekyc.nfc.build_in.bouncycastle.pqc.crypto.rainbow;

import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.params.AsymmetricKeyParameter;

public class RainbowKeyParameters extends AsymmetricKeyParameter {
    private int docLength;

    public RainbowKeyParameters(boolean z, int i) {
        super(z);
        this.docLength = i;
    }

    public int getDocLength() {
        return this.docLength;
    }
}
