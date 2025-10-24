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

public class ECNewRandomnessTransform implements ECPairFactorTransform {
    private ECPublicKeyParameters key;
    private BigInteger lastK;
    private SecureRandom random;

    public ECMultiplier createBasePointMultiplier() {
        return new FixedPointCombMultiplier();
    }

    public BigInteger getTransformValue() {
        return this.lastK;
    }

    public void init(CipherParameters cipherParameters) {
        if (cipherParameters instanceof ParametersWithRandom) {
            ParametersWithRandom parametersWithRandom = (ParametersWithRandom) cipherParameters;
            if (parametersWithRandom.getParameters() instanceof ECPublicKeyParameters) {
                this.key = (ECPublicKeyParameters) parametersWithRandom.getParameters();
                this.random = parametersWithRandom.getRandom();
                return;
            }
            throw new IllegalArgumentException("ECPublicKeyParameters are required for new randomness transform.");
        } else if (cipherParameters instanceof ECPublicKeyParameters) {
            this.key = (ECPublicKeyParameters) cipherParameters;
            this.random = CryptoServicesRegistrar.getSecureRandom();
        } else {
            throw new IllegalArgumentException("ECPublicKeyParameters are required for new randomness transform.");
        }
    }

    public ECPair transform(ECPair eCPair) {
        ECPublicKeyParameters eCPublicKeyParameters = this.key;
        if (eCPublicKeyParameters != null) {
            ECDomainParameters parameters = eCPublicKeyParameters.getParameters();
            BigInteger n = parameters.getN();
            ECMultiplier createBasePointMultiplier = createBasePointMultiplier();
            BigInteger generateK = ECUtil.generateK(n, this.random);
            ECPoint[] eCPointArr = {createBasePointMultiplier.multiply(parameters.getG(), generateK).add(ECAlgorithms.cleanPoint(parameters.getCurve(), eCPair.getX())), this.key.getQ().multiply(generateK).add(ECAlgorithms.cleanPoint(parameters.getCurve(), eCPair.getY()))};
            parameters.getCurve().normalizeAll(eCPointArr);
            this.lastK = generateK;
            return new ECPair(eCPointArr[0], eCPointArr[1]);
        }
        throw new IllegalStateException("ECNewRandomnessTransform not initialised");
    }
}
