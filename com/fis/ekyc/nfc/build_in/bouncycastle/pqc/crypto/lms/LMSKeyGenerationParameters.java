package com.fis.ekyc.nfc.build_in.bouncycastle.pqc.crypto.lms;

import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.KeyGenerationParameters;
import java.security.SecureRandom;

public class LMSKeyGenerationParameters extends KeyGenerationParameters {
    private final LMSParameters lmsParameters;

    public LMSKeyGenerationParameters(LMSParameters lMSParameters, SecureRandom secureRandom) {
        super(secureRandom, LmsUtils.calculateStrength(lMSParameters));
        this.lmsParameters = lMSParameters;
    }

    public LMSParameters getParameters() {
        return this.lmsParameters;
    }
}
