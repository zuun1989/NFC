package com.fis.ekyc.nfc.build_in.bouncycastle.pqc.crypto.lms;

import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.KeyGenerationParameters;
import java.security.SecureRandom;

public class HSSKeyGenerationParameters extends KeyGenerationParameters {
    private final LMSParameters[] lmsParameters;

    public HSSKeyGenerationParameters(LMSParameters[] lMSParametersArr, SecureRandom secureRandom) {
        super(secureRandom, LmsUtils.calculateStrength(lMSParametersArr[0]));
        if (lMSParametersArr.length == 0 || lMSParametersArr.length > 8) {
            throw new IllegalArgumentException("lmsParameters length should be between 1 and 8 inclusive");
        }
        this.lmsParameters = lMSParametersArr;
    }

    public int getDepth() {
        return this.lmsParameters.length;
    }

    public LMSParameters[] getLmsParameters() {
        return this.lmsParameters;
    }
}
