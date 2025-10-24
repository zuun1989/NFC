package com.fis.ekyc.nfc.build_in.bouncycastle.jcajce.provider.asymmetric.elgamal;

import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.AsymmetricCipherKeyPair;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.CryptoServicesRegistrar;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.generators.ElGamalKeyPairGenerator;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.generators.ElGamalParametersGenerator;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.params.ElGamalKeyGenerationParameters;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.params.ElGamalParameters;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.params.ElGamalPrivateKeyParameters;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.params.ElGamalPublicKeyParameters;
import com.fis.ekyc.nfc.build_in.bouncycastle.jce.provider.BouncyCastleProvider;
import com.fis.ekyc.nfc.build_in.bouncycastle.jce.spec.ElGamalParameterSpec;
import java.security.InvalidAlgorithmParameterException;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.SecureRandom;
import java.security.spec.AlgorithmParameterSpec;
import javax.crypto.spec.DHParameterSpec;

public class KeyPairGeneratorSpi extends KeyPairGenerator {
    int certainty = 20;
    ElGamalKeyPairGenerator engine = new ElGamalKeyPairGenerator();
    boolean initialised = false;
    ElGamalKeyGenerationParameters param;
    SecureRandom random = CryptoServicesRegistrar.getSecureRandom();
    int strength = 1024;

    public KeyPairGeneratorSpi() {
        super("ElGamal");
    }

    public KeyPair generateKeyPair() {
        if (!this.initialised) {
            DHParameterSpec dHDefaultParameters = BouncyCastleProvider.CONFIGURATION.getDHDefaultParameters(this.strength);
            if (dHDefaultParameters != null) {
                this.param = new ElGamalKeyGenerationParameters(this.random, new ElGamalParameters(dHDefaultParameters.getP(), dHDefaultParameters.getG(), dHDefaultParameters.getL()));
            } else {
                ElGamalParametersGenerator elGamalParametersGenerator = new ElGamalParametersGenerator();
                elGamalParametersGenerator.init(this.strength, this.certainty, this.random);
                this.param = new ElGamalKeyGenerationParameters(this.random, elGamalParametersGenerator.generateParameters());
            }
            this.engine.init(this.param);
            this.initialised = true;
        }
        AsymmetricCipherKeyPair generateKeyPair = this.engine.generateKeyPair();
        return new KeyPair(new BCElGamalPublicKey((ElGamalPublicKeyParameters) generateKeyPair.getPublic()), new BCElGamalPrivateKey((ElGamalPrivateKeyParameters) generateKeyPair.getPrivate()));
    }

    public void initialize(int i, SecureRandom secureRandom) {
        this.strength = i;
        this.random = secureRandom;
    }

    public void initialize(AlgorithmParameterSpec algorithmParameterSpec, SecureRandom secureRandom) throws InvalidAlgorithmParameterException {
        boolean z = algorithmParameterSpec instanceof ElGamalParameterSpec;
        if (z || (algorithmParameterSpec instanceof DHParameterSpec)) {
            if (z) {
                ElGamalParameterSpec elGamalParameterSpec = (ElGamalParameterSpec) algorithmParameterSpec;
                this.param = new ElGamalKeyGenerationParameters(secureRandom, new ElGamalParameters(elGamalParameterSpec.getP(), elGamalParameterSpec.getG()));
            } else {
                DHParameterSpec dHParameterSpec = (DHParameterSpec) algorithmParameterSpec;
                this.param = new ElGamalKeyGenerationParameters(secureRandom, new ElGamalParameters(dHParameterSpec.getP(), dHParameterSpec.getG(), dHParameterSpec.getL()));
            }
            this.engine.init(this.param);
            this.initialised = true;
            return;
        }
        throw new InvalidAlgorithmParameterException("parameter object not a DHParameterSpec or an ElGamalParameterSpec");
    }
}
