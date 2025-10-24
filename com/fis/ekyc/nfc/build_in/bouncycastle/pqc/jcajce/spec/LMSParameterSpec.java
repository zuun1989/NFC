package com.fis.ekyc.nfc.build_in.bouncycastle.pqc.jcajce.spec;

import com.fis.ekyc.nfc.build_in.bouncycastle.pqc.crypto.lms.LMOtsParameters;
import com.fis.ekyc.nfc.build_in.bouncycastle.pqc.crypto.lms.LMSigParameters;
import java.security.spec.AlgorithmParameterSpec;

public class LMSParameterSpec implements AlgorithmParameterSpec {
    private final LMOtsParameters lmOtsParameters;
    private final LMSigParameters lmSigParams;

    public LMSParameterSpec(LMSigParameters lMSigParameters, LMOtsParameters lMOtsParameters) {
        this.lmSigParams = lMSigParameters;
        this.lmOtsParameters = lMOtsParameters;
    }

    public LMOtsParameters getOtsParams() {
        return this.lmOtsParameters;
    }

    public LMSigParameters getSigParams() {
        return this.lmSigParams;
    }
}
