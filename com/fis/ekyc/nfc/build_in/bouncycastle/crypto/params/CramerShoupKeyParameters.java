package com.fis.ekyc.nfc.build_in.bouncycastle.crypto.params;

public class CramerShoupKeyParameters extends AsymmetricKeyParameter {
    private CramerShoupParameters params;

    public CramerShoupKeyParameters(boolean z, CramerShoupParameters cramerShoupParameters) {
        super(z);
        this.params = cramerShoupParameters;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof CramerShoupKeyParameters)) {
            return false;
        }
        CramerShoupKeyParameters cramerShoupKeyParameters = (CramerShoupKeyParameters) obj;
        CramerShoupParameters cramerShoupParameters = this.params;
        if (cramerShoupParameters != null) {
            return cramerShoupParameters.equals(cramerShoupKeyParameters.getParameters());
        }
        if (cramerShoupKeyParameters.getParameters() == null) {
            return true;
        }
        return false;
    }

    public CramerShoupParameters getParameters() {
        return this.params;
    }

    public int hashCode() {
        boolean z = !isPrivate();
        CramerShoupParameters cramerShoupParameters = this.params;
        return cramerShoupParameters != null ? z ^ cramerShoupParameters.hashCode() ? 1 : 0 : z ? 1 : 0;
    }
}
