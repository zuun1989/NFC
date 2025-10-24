package com.fis.ekyc.nfc.build_in.bouncycastle.pqc.crypto.gmss;

import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.KeyGenerationParameters;
import java.security.SecureRandom;

public class GMSSKeyGenerationParameters extends KeyGenerationParameters {
    private GMSSParameters params;

    public GMSSKeyGenerationParameters(SecureRandom secureRandom, GMSSParameters gMSSParameters) {
        super(secureRandom, 1);
        this.params = gMSSParameters;
    }

    public GMSSParameters getParameters() {
        return this.params;
    }
}
