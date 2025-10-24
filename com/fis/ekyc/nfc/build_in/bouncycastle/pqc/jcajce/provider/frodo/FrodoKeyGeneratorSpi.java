package com.fis.ekyc.nfc.build_in.bouncycastle.pqc.jcajce.provider.frodo;

import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.SecretWithEncapsulation;
import com.fis.ekyc.nfc.build_in.bouncycastle.jcajce.SecretKeyWithEncapsulation;
import com.fis.ekyc.nfc.build_in.bouncycastle.jcajce.spec.KEMExtractSpec;
import com.fis.ekyc.nfc.build_in.bouncycastle.jcajce.spec.KEMGenerateSpec;
import com.fis.ekyc.nfc.build_in.bouncycastle.pqc.crypto.frodo.FrodoKEMExtractor;
import com.fis.ekyc.nfc.build_in.bouncycastle.pqc.crypto.frodo.FrodoKEMGenerator;
import com.fis.ekyc.nfc.build_in.bouncycastle.util.Arrays;
import java.security.InvalidAlgorithmParameterException;
import java.security.SecureRandom;
import java.security.spec.AlgorithmParameterSpec;
import javax.crypto.KeyGeneratorSpi;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import javax.security.auth.DestroyFailedException;

public class FrodoKeyGeneratorSpi extends KeyGeneratorSpi {
    private KEMExtractSpec extSpec;
    private KEMGenerateSpec genSpec;
    private SecureRandom random;

    public SecretKey engineGenerateKey() {
        KEMGenerateSpec kEMGenerateSpec = this.genSpec;
        if (kEMGenerateSpec != null) {
            SecretWithEncapsulation generateEncapsulated = new FrodoKEMGenerator(this.random).generateEncapsulated(((BCFrodoPublicKey) kEMGenerateSpec.getPublicKey()).getKeyParams());
            SecretKeyWithEncapsulation secretKeyWithEncapsulation = new SecretKeyWithEncapsulation(new SecretKeySpec(generateEncapsulated.getSecret(), this.genSpec.getKeyAlgorithmName()), generateEncapsulated.getEncapsulation());
            try {
                generateEncapsulated.destroy();
                return secretKeyWithEncapsulation;
            } catch (DestroyFailedException unused) {
                throw new IllegalStateException("key cleanup failed");
            }
        } else {
            FrodoKEMExtractor frodoKEMExtractor = new FrodoKEMExtractor(((BCFrodoPrivateKey) this.extSpec.getPrivateKey()).getKeyParams());
            byte[] encapsulation = this.extSpec.getEncapsulation();
            byte[] extractSecret = frodoKEMExtractor.extractSecret(encapsulation);
            SecretKeyWithEncapsulation secretKeyWithEncapsulation2 = new SecretKeyWithEncapsulation(new SecretKeySpec(extractSecret, this.extSpec.getKeyAlgorithmName()), encapsulation);
            Arrays.clear(extractSecret);
            return secretKeyWithEncapsulation2;
        }
    }

    public void engineInit(SecureRandom secureRandom) {
        throw new UnsupportedOperationException("Operation not supported");
    }

    public void engineInit(AlgorithmParameterSpec algorithmParameterSpec, SecureRandom secureRandom) throws InvalidAlgorithmParameterException {
        this.random = secureRandom;
        if (algorithmParameterSpec instanceof KEMGenerateSpec) {
            this.genSpec = (KEMGenerateSpec) algorithmParameterSpec;
            this.extSpec = null;
        } else if (algorithmParameterSpec instanceof KEMExtractSpec) {
            this.genSpec = null;
            this.extSpec = (KEMExtractSpec) algorithmParameterSpec;
        } else {
            throw new InvalidAlgorithmParameterException("unknown spec");
        }
    }

    public void engineInit(int i, SecureRandom secureRandom) {
        throw new UnsupportedOperationException("Operation not supported");
    }
}
