package com.fis.ekyc.nfc.build_in.bouncycastle.pqc.crypto.rainbow;

import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.KeyGenerationParameters;
import java.security.SecureRandom;

public class RainbowKeyGenerationParameters extends KeyGenerationParameters {
    private RainbowParameters params;

    public RainbowKeyGenerationParameters(SecureRandom secureRandom, RainbowParameters rainbowParameters) {
        super(secureRandom, rainbowParameters.getVi()[rainbowParameters.getVi().length - 1] - rainbowParameters.getVi()[0]);
        this.params = rainbowParameters;
    }

    public RainbowParameters getParameters() {
        return this.params;
    }
}
