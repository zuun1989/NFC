package com.fis.ekyc.nfc.build_in.bouncycastle.pqc.crypto.newhope;

import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.AsymmetricCipherKeyPair;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.AsymmetricCipherKeyPairGenerator;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.KeyGenerationParameters;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.params.AsymmetricKeyParameter;
import java.security.SecureRandom;

public class NHKeyPairGenerator implements AsymmetricCipherKeyPairGenerator {
    private SecureRandom random;

    public AsymmetricCipherKeyPair generateKeyPair() {
        byte[] bArr = new byte[NewHope.SENDA_BYTES];
        short[] sArr = new short[1024];
        NewHope.keygen(this.random, bArr, sArr);
        return new AsymmetricCipherKeyPair((AsymmetricKeyParameter) new NHPublicKeyParameters(bArr), (AsymmetricKeyParameter) new NHPrivateKeyParameters(sArr));
    }

    public void init(KeyGenerationParameters keyGenerationParameters) {
        this.random = keyGenerationParameters.getRandom();
    }
}
