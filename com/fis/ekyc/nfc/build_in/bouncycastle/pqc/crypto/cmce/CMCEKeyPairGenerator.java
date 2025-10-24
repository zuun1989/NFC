package com.fis.ekyc.nfc.build_in.bouncycastle.pqc.crypto.cmce;

import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.AsymmetricCipherKeyPair;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.AsymmetricCipherKeyPairGenerator;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.KeyGenerationParameters;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.params.AsymmetricKeyParameter;
import java.security.SecureRandom;

public class CMCEKeyPairGenerator implements AsymmetricCipherKeyPairGenerator {
    private CMCEKeyGenerationParameters cmceParams;
    private int m;
    private int n;
    private SecureRandom random;
    private int t;

    private AsymmetricCipherKeyPair genKeyPair() {
        CMCEEngine engine = this.cmceParams.getParameters().getEngine();
        byte[] bArr = new byte[engine.getPrivateKeySize()];
        byte[] bArr2 = new byte[engine.getPublicKeySize()];
        engine.kem_keypair(bArr2, bArr, this.random);
        return new AsymmetricCipherKeyPair((AsymmetricKeyParameter) new CMCEPublicKeyParameters(this.cmceParams.getParameters(), bArr2), (AsymmetricKeyParameter) new CMCEPrivateKeyParameters(this.cmceParams.getParameters(), bArr));
    }

    private void initialize(KeyGenerationParameters keyGenerationParameters) {
        this.cmceParams = (CMCEKeyGenerationParameters) keyGenerationParameters;
        this.random = keyGenerationParameters.getRandom();
        this.m = this.cmceParams.getParameters().getM();
        this.n = this.cmceParams.getParameters().getN();
        this.t = this.cmceParams.getParameters().getT();
    }

    public AsymmetricCipherKeyPair generateKeyPair() {
        return genKeyPair();
    }

    public void init(KeyGenerationParameters keyGenerationParameters) {
        initialize(keyGenerationParameters);
    }
}
