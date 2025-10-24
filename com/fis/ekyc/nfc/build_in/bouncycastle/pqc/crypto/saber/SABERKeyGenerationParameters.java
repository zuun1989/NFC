package com.fis.ekyc.nfc.build_in.bouncycastle.pqc.crypto.saber;

import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.KeyGenerationParameters;
import java.security.SecureRandom;

public class SABERKeyGenerationParameters extends KeyGenerationParameters {
    private SABERParameters params;

    public SABERKeyGenerationParameters(SecureRandom secureRandom, SABERParameters sABERParameters) {
        super(secureRandom, 256);
        this.params = sABERParameters;
    }

    public SABERParameters getParameters() {
        return this.params;
    }
}
