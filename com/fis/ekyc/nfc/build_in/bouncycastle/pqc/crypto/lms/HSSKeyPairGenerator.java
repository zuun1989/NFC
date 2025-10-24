package com.fis.ekyc.nfc.build_in.bouncycastle.pqc.crypto.lms;

import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.AsymmetricCipherKeyPair;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.AsymmetricCipherKeyPairGenerator;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.KeyGenerationParameters;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.params.AsymmetricKeyParameter;

public class HSSKeyPairGenerator implements AsymmetricCipherKeyPairGenerator {
    HSSKeyGenerationParameters param;

    public AsymmetricCipherKeyPair generateKeyPair() {
        HSSPrivateKeyParameters generateHSSKeyPair = HSS.generateHSSKeyPair(this.param);
        return new AsymmetricCipherKeyPair((AsymmetricKeyParameter) generateHSSKeyPair.getPublicKey(), (AsymmetricKeyParameter) generateHSSKeyPair);
    }

    public void init(KeyGenerationParameters keyGenerationParameters) {
        this.param = (HSSKeyGenerationParameters) keyGenerationParameters;
    }
}
