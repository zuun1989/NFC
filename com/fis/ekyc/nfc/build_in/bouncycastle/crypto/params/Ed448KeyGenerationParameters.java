package com.fis.ekyc.nfc.build_in.bouncycastle.crypto.params;

import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.KeyGenerationParameters;
import java.security.SecureRandom;

public class Ed448KeyGenerationParameters extends KeyGenerationParameters {
    public Ed448KeyGenerationParameters(SecureRandom secureRandom) {
        super(secureRandom, 448);
    }
}
