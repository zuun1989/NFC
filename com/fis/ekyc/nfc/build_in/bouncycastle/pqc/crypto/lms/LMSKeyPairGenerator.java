package com.fis.ekyc.nfc.build_in.bouncycastle.pqc.crypto.lms;

import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.AsymmetricCipherKeyPair;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.AsymmetricCipherKeyPairGenerator;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.KeyGenerationParameters;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.params.AsymmetricKeyParameter;
import java.security.SecureRandom;

public class LMSKeyPairGenerator implements AsymmetricCipherKeyPairGenerator {
    LMSKeyGenerationParameters param;

    public AsymmetricCipherKeyPair generateKeyPair() {
        SecureRandom random = this.param.getRandom();
        byte[] bArr = new byte[16];
        random.nextBytes(bArr);
        byte[] bArr2 = new byte[32];
        random.nextBytes(bArr2);
        LMSPrivateKeyParameters generateKeys = LMS.generateKeys(this.param.getParameters().getLMSigParam(), this.param.getParameters().getLMOTSParam(), 0, bArr, bArr2);
        return new AsymmetricCipherKeyPair((AsymmetricKeyParameter) generateKeys.getPublicKey(), (AsymmetricKeyParameter) generateKeys);
    }

    public void init(KeyGenerationParameters keyGenerationParameters) {
        this.param = (LMSKeyGenerationParameters) keyGenerationParameters;
    }
}
