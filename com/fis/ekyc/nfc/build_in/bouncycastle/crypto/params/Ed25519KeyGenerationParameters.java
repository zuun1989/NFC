package com.fis.ekyc.nfc.build_in.bouncycastle.crypto.params;

import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.KeyGenerationParameters;
import java.security.SecureRandom;

public class Ed25519KeyGenerationParameters extends KeyGenerationParameters {
    public Ed25519KeyGenerationParameters(SecureRandom secureRandom) {
        super(secureRandom, 256);
    }
}
