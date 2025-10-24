package com.fis.ekyc.nfc.build_in.bouncycastle.pqc.crypto.qtesla;

import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.KeyGenerationParameters;
import java.security.SecureRandom;

public class QTESLAKeyGenerationParameters extends KeyGenerationParameters {
    private final int securityCategory;

    public QTESLAKeyGenerationParameters(int i, SecureRandom secureRandom) {
        super(secureRandom, -1);
        QTESLASecurityCategory.getPrivateSize(i);
        this.securityCategory = i;
    }

    public int getSecurityCategory() {
        return this.securityCategory;
    }
}
