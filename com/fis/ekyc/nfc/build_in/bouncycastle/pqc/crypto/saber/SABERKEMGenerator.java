package com.fis.ekyc.nfc.build_in.bouncycastle.pqc.crypto.saber;

import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.EncapsulatedSecretGenerator;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.SecretWithEncapsulation;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.params.AsymmetricKeyParameter;
import com.fis.ekyc.nfc.build_in.bouncycastle.pqc.crypto.util.SecretWithEncapsulationImpl;
import java.security.SecureRandom;

public class SABERKEMGenerator implements EncapsulatedSecretGenerator {
    private final SecureRandom sr;

    public SABERKEMGenerator(SecureRandom secureRandom) {
        this.sr = secureRandom;
    }

    public SecretWithEncapsulation generateEncapsulated(AsymmetricKeyParameter asymmetricKeyParameter) {
        SABERPublicKeyParameters sABERPublicKeyParameters = (SABERPublicKeyParameters) asymmetricKeyParameter;
        SABEREngine engine = sABERPublicKeyParameters.getParameters().getEngine();
        byte[] bArr = new byte[engine.getCipherTextSize()];
        byte[] bArr2 = new byte[engine.getSessionKeySize()];
        engine.crypto_kem_enc(bArr, bArr2, sABERPublicKeyParameters.getPublicKey(), this.sr);
        return new SecretWithEncapsulationImpl(bArr2, bArr);
    }
}
