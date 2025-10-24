package com.fis.ekyc.nfc.build_in.bouncycastle.crypto.params;

public class ECKeyParameters extends AsymmetricKeyParameter {
    private final ECDomainParameters parameters;

    public ECKeyParameters(boolean z, ECDomainParameters eCDomainParameters) {
        super(z);
        if (eCDomainParameters != null) {
            this.parameters = eCDomainParameters;
            return;
        }
        throw new NullPointerException("'parameters' cannot be null");
    }

    public ECDomainParameters getParameters() {
        return this.parameters;
    }
}
