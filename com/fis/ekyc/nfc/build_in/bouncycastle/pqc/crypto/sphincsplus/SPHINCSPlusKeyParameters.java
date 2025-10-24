package com.fis.ekyc.nfc.build_in.bouncycastle.pqc.crypto.sphincsplus;

import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.params.AsymmetricKeyParameter;

public class SPHINCSPlusKeyParameters extends AsymmetricKeyParameter {
    final SPHINCSPlusParameters parameters;

    public SPHINCSPlusKeyParameters(boolean z, SPHINCSPlusParameters sPHINCSPlusParameters) {
        super(z);
        this.parameters = sPHINCSPlusParameters;
    }

    public SPHINCSPlusParameters getParameters() {
        return this.parameters;
    }
}
