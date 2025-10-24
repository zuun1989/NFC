package com.fis.ekyc.nfc.build_in.bouncycastle.crypto.params;

import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.KeyGenerationParameters;
import java.security.SecureRandom;

public class DHKeyGenerationParameters extends KeyGenerationParameters {
    private DHParameters params;

    public DHKeyGenerationParameters(SecureRandom secureRandom, DHParameters dHParameters) {
        super(secureRandom, getStrength(dHParameters));
        this.params = dHParameters;
    }

    public static int getStrength(DHParameters dHParameters) {
        if (dHParameters.getL() != 0) {
            return dHParameters.getL();
        }
        return dHParameters.getP().bitLength();
    }

    public DHParameters getParameters() {
        return this.params;
    }
}
