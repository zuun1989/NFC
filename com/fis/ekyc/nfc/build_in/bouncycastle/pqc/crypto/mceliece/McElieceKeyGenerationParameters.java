package com.fis.ekyc.nfc.build_in.bouncycastle.pqc.crypto.mceliece;

import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.KeyGenerationParameters;
import java.security.SecureRandom;

public class McElieceKeyGenerationParameters extends KeyGenerationParameters {
    private McElieceParameters params;

    public McElieceKeyGenerationParameters(SecureRandom secureRandom, McElieceParameters mcElieceParameters) {
        super(secureRandom, 256);
        this.params = mcElieceParameters;
    }

    public McElieceParameters getParameters() {
        return this.params;
    }
}
