package com.fis.ekyc.nfc.build_in.bouncycastle.crypto.params;

import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.KeyGenerationParameters;
import java.security.SecureRandom;

public class CramerShoupKeyGenerationParameters extends KeyGenerationParameters {
    private CramerShoupParameters params;

    public CramerShoupKeyGenerationParameters(SecureRandom secureRandom, CramerShoupParameters cramerShoupParameters) {
        super(secureRandom, getStrength(cramerShoupParameters));
        this.params = cramerShoupParameters;
    }

    public static int getStrength(CramerShoupParameters cramerShoupParameters) {
        return cramerShoupParameters.getP().bitLength();
    }

    public CramerShoupParameters getParameters() {
        return this.params;
    }
}
