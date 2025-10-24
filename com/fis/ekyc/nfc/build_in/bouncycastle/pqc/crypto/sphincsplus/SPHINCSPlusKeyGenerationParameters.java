package com.fis.ekyc.nfc.build_in.bouncycastle.pqc.crypto.sphincsplus;

import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.KeyGenerationParameters;
import java.security.SecureRandom;

public class SPHINCSPlusKeyGenerationParameters extends KeyGenerationParameters {
    private final SPHINCSPlusParameters parameters;

    public SPHINCSPlusKeyGenerationParameters(SecureRandom secureRandom, SPHINCSPlusParameters sPHINCSPlusParameters) {
        super(secureRandom, -1);
        this.parameters = sPHINCSPlusParameters;
    }

    public SPHINCSPlusParameters getParameters() {
        return this.parameters;
    }
}
