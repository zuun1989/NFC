package com.fis.ekyc.nfc.build_in.bouncycastle.pqc.crypto.mceliece;

import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.KeyGenerationParameters;
import java.security.SecureRandom;

public class McElieceCCA2KeyGenerationParameters extends KeyGenerationParameters {
    private McElieceCCA2Parameters params;

    public McElieceCCA2KeyGenerationParameters(SecureRandom secureRandom, McElieceCCA2Parameters mcElieceCCA2Parameters) {
        super(secureRandom, 128);
        this.params = mcElieceCCA2Parameters;
    }

    public McElieceCCA2Parameters getParameters() {
        return this.params;
    }
}
