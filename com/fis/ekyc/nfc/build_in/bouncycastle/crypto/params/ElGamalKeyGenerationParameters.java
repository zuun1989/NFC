package com.fis.ekyc.nfc.build_in.bouncycastle.crypto.params;

import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.KeyGenerationParameters;
import java.security.SecureRandom;

public class ElGamalKeyGenerationParameters extends KeyGenerationParameters {
    private ElGamalParameters params;

    public ElGamalKeyGenerationParameters(SecureRandom secureRandom, ElGamalParameters elGamalParameters) {
        super(secureRandom, getStrength(elGamalParameters));
        this.params = elGamalParameters;
    }

    public static int getStrength(ElGamalParameters elGamalParameters) {
        if (elGamalParameters.getL() != 0) {
            return elGamalParameters.getL();
        }
        return elGamalParameters.getP().bitLength();
    }

    public ElGamalParameters getParameters() {
        return this.params;
    }
}
