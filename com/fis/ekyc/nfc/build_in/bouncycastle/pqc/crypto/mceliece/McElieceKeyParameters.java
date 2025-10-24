package com.fis.ekyc.nfc.build_in.bouncycastle.pqc.crypto.mceliece;

import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.params.AsymmetricKeyParameter;

public class McElieceKeyParameters extends AsymmetricKeyParameter {
    private McElieceParameters params;

    public McElieceKeyParameters(boolean z, McElieceParameters mcElieceParameters) {
        super(z);
        this.params = mcElieceParameters;
    }

    public McElieceParameters getParameters() {
        return this.params;
    }
}
