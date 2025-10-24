package com.fis.ekyc.nfc.build_in.bouncycastle.crypto.generators;

import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.KeyGenerationParameters;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.params.DESParameters;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.params.DESedeParameters;

public class DESedeKeyGenerator extends DESKeyGenerator {
    private static final int MAX_IT = 20;

    public byte[] generateKey() {
        int i = this.strength;
        byte[] bArr = new byte[i];
        int i2 = 0;
        while (true) {
            this.random.nextBytes(bArr);
            DESParameters.setOddParity(bArr);
            i2++;
            if (i2 >= 20 || (!DESedeParameters.isWeakKey(bArr, 0, i) && DESedeParameters.isRealEDEKey(bArr, 0))) {
            }
        }
        if (!DESedeParameters.isWeakKey(bArr, 0, i) && DESedeParameters.isRealEDEKey(bArr, 0)) {
            return bArr;
        }
        throw new IllegalStateException("Unable to generate DES-EDE key");
    }

    public void init(KeyGenerationParameters keyGenerationParameters) {
        this.random = keyGenerationParameters.getRandom();
        int strength = (keyGenerationParameters.getStrength() + 7) / 8;
        this.strength = strength;
        if (strength == 0 || strength == 21) {
            this.strength = 24;
        } else if (strength == 14) {
            this.strength = 16;
        } else if (strength != 24 && strength != 16) {
            throw new IllegalArgumentException("DESede key must be 192 or 128 bits long.");
        }
    }
}
