package com.fis.ekyc.nfc.build_in.bouncycastle.pqc.jcajce.provider.mceliece;

import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.AsymmetricCipherKeyPair;
import com.fis.ekyc.nfc.build_in.bouncycastle.pqc.crypto.mceliece.McElieceKeyGenerationParameters;
import com.fis.ekyc.nfc.build_in.bouncycastle.pqc.crypto.mceliece.McElieceKeyPairGenerator;
import com.fis.ekyc.nfc.build_in.bouncycastle.pqc.crypto.mceliece.McElieceParameters;
import com.fis.ekyc.nfc.build_in.bouncycastle.pqc.crypto.mceliece.McEliecePrivateKeyParameters;
import com.fis.ekyc.nfc.build_in.bouncycastle.pqc.crypto.mceliece.McEliecePublicKeyParameters;
import com.fis.ekyc.nfc.build_in.bouncycastle.pqc.jcajce.spec.McElieceKeyGenParameterSpec;
import java.security.InvalidAlgorithmParameterException;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.SecureRandom;
import java.security.spec.AlgorithmParameterSpec;

public class McElieceKeyPairGeneratorSpi extends KeyPairGenerator {
    McElieceKeyPairGenerator kpg;

    public McElieceKeyPairGeneratorSpi() {
        super("McEliece");
    }

    public KeyPair generateKeyPair() {
        AsymmetricCipherKeyPair generateKeyPair = this.kpg.generateKeyPair();
        return new KeyPair(new BCMcEliecePublicKey((McEliecePublicKeyParameters) generateKeyPair.getPublic()), new BCMcEliecePrivateKey((McEliecePrivateKeyParameters) generateKeyPair.getPrivate()));
    }

    public void initialize(AlgorithmParameterSpec algorithmParameterSpec, SecureRandom secureRandom) throws InvalidAlgorithmParameterException {
        this.kpg = new McElieceKeyPairGenerator();
        McElieceKeyGenParameterSpec mcElieceKeyGenParameterSpec = (McElieceKeyGenParameterSpec) algorithmParameterSpec;
        this.kpg.init(new McElieceKeyGenerationParameters(secureRandom, new McElieceParameters(mcElieceKeyGenParameterSpec.getM(), mcElieceKeyGenParameterSpec.getT())));
    }

    public void initialize(int i, SecureRandom secureRandom) {
        try {
            initialize((AlgorithmParameterSpec) new McElieceKeyGenParameterSpec(), secureRandom);
        } catch (InvalidAlgorithmParameterException unused) {
        }
    }
}
