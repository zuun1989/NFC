package com.fis.ekyc.nfc.build_in.bouncycastle.crypto.params;

import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.KeyGenerationParameters;
import java.security.SecureRandom;

public class X448KeyGenerationParameters extends KeyGenerationParameters {
    public X448KeyGenerationParameters(SecureRandom secureRandom) {
        super(secureRandom, 448);
    }
}
