package com.fis.ekyc.nfc.build_in.bouncycastle.pqc.crypto.saber;

import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.AsymmetricCipherKeyPair;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.AsymmetricCipherKeyPairGenerator;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.KeyGenerationParameters;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.params.AsymmetricKeyParameter;
import java.security.SecureRandom;

public class SABERKeyPairGenerator implements AsymmetricCipherKeyPairGenerator {
    private int l;
    private SecureRandom random;
    private SABERKeyGenerationParameters saberParams;

    private AsymmetricCipherKeyPair genKeyPair() {
        SABEREngine engine = this.saberParams.getParameters().getEngine();
        byte[] bArr = new byte[engine.getPrivateKeySize()];
        byte[] bArr2 = new byte[engine.getPublicKeySize()];
        engine.crypto_kem_keypair(bArr2, bArr, this.random);
        return new AsymmetricCipherKeyPair((AsymmetricKeyParameter) new SABERPublicKeyParameters(this.saberParams.getParameters(), bArr2), (AsymmetricKeyParameter) new SABERPrivateKeyParameters(this.saberParams.getParameters(), bArr));
    }

    private void initialize(KeyGenerationParameters keyGenerationParameters) {
        this.saberParams = (SABERKeyGenerationParameters) keyGenerationParameters;
        this.random = keyGenerationParameters.getRandom();
        this.l = this.saberParams.getParameters().getL();
    }

    public AsymmetricCipherKeyPair generateKeyPair() {
        return genKeyPair();
    }

    public void init(KeyGenerationParameters keyGenerationParameters) {
        initialize(keyGenerationParameters);
    }
}
