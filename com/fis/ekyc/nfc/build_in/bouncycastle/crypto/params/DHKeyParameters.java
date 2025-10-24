package com.fis.ekyc.nfc.build_in.bouncycastle.crypto.params;

public class DHKeyParameters extends AsymmetricKeyParameter {
    private DHParameters params;

    public DHKeyParameters(boolean z, DHParameters dHParameters) {
        super(z);
        this.params = dHParameters;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof DHKeyParameters)) {
            return false;
        }
        DHKeyParameters dHKeyParameters = (DHKeyParameters) obj;
        DHParameters dHParameters = this.params;
        if (dHParameters != null) {
            return dHParameters.equals(dHKeyParameters.getParameters());
        }
        if (dHKeyParameters.getParameters() == null) {
            return true;
        }
        return false;
    }

    public DHParameters getParameters() {
        return this.params;
    }

    public int hashCode() {
        boolean z = !isPrivate();
        DHParameters dHParameters = this.params;
        return dHParameters != null ? z ^ dHParameters.hashCode() ? 1 : 0 : z ? 1 : 0;
    }
}
