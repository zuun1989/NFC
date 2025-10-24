package com.fis.ekyc.nfc.build_in.bouncycastle.crypto.ec;

import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.CipherParameters;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.CryptoServicesRegistrar;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.params.ECDomainParameters;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.params.ECPublicKeyParameters;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.params.ParametersWithRandom;
import com.fis.ekyc.nfc.build_in.bouncycastle.math.ec.ECAlgorithms;
import com.fis.ekyc.nfc.build_in.bouncycastle.math.ec.ECMultiplier;
import com.fis.ekyc.nfc.build_in.bouncycastle.math.ec.ECPoint;
import com.fis.ekyc.nfc.build_in.bouncycastle.math.ec.FixedPointCombMultiplier;
import java.math.BigInteger;
import java.security.SecureRandom;

public class ECElGamalEncryptor implements ECEncryptor {
    private ECPublicKeyParameters key;
    private SecureRandom random;

    public ECMultiplier createBasePointMultiplier() {
        return new FixedPointCombMultiplier();
    }

    public ECPair encrypt(ECPoint eCPoint) {
        ECPublicKeyParameters eCPublicKeyParameters = this.key;
        if (eCPublicKeyParameters != null) {
            ECDomainParameters parameters = eCPublicKeyParameters.getParameters();
            BigInteger generateK = ECUtil.generateK(parameters.getN(), this.random);
            ECPoint[] eCPointArr = {createBasePointMultiplier().multiply(parameters.getG(), generateK), this.key.getQ().multiply(generateK).add(ECAlgorithms.cleanPoint(parameters.getCurve(), eCPoint))};
            parameters.getCurve().normalizeAll(eCPointArr);
            return new ECPair(eCPointArr[0], eCPointArr[1]);
        }
        throw new IllegalStateException("ECElGamalEncryptor not initialised");
    }

    public void init(CipherParameters cipherParameters) {
        if (cipherParameters instanceof ParametersWithRandom) {
            ParametersWithRandom parametersWithRandom = (ParametersWithRandom) cipherParameters;
            if (parametersWithRandom.getParameters() instanceof ECPublicKeyParameters) {
                this.key = (ECPublicKeyParameters) parametersWithRandom.getParameters();
                this.random = parametersWithRandom.getRandom();
                return;
            }
            throw new IllegalArgumentException("ECPublicKeyParameters are required for encryption.");
        } else if (cipherParameters instanceof ECPublicKeyParameters) {
            this.key = (ECPublicKeyParameters) cipherParameters;
            this.random = CryptoServicesRegistrar.getSecureRandom();
        } else {
            throw new IllegalArgumentException("ECPublicKeyParameters are required for encryption.");
        }
    }
}
