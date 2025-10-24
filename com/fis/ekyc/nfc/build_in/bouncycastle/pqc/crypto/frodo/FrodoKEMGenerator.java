package com.fis.ekyc.nfc.build_in.bouncycastle.pqc.crypto.frodo;

import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.EncapsulatedSecretGenerator;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.SecretWithEncapsulation;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.params.AsymmetricKeyParameter;
import com.fis.ekyc.nfc.build_in.bouncycastle.pqc.crypto.util.SecretWithEncapsulationImpl;
import java.security.SecureRandom;

public class FrodoKEMGenerator implements EncapsulatedSecretGenerator {
    private final SecureRandom sr;

    public FrodoKEMGenerator(SecureRandom secureRandom) {
        this.sr = secureRandom;
    }

    public SecretWithEncapsulation generateEncapsulated(AsymmetricKeyParameter asymmetricKeyParameter) {
        FrodoPublicKeyParameters frodoPublicKeyParameters = (FrodoPublicKeyParameters) asymmetricKeyParameter;
        FrodoEngine engine = frodoPublicKeyParameters.getParameters().getEngine();
        byte[] bArr = new byte[engine.getCipherTextSize()];
        byte[] bArr2 = new byte[engine.getSessionKeySize()];
        engine.kem_enc(bArr, bArr2, frodoPublicKeyParameters.getPublicKey(), this.sr);
        return new SecretWithEncapsulationImpl(bArr2, bArr);
    }
}
