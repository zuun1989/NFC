package com.fis.ekyc.nfc.build_in.bouncycastle.crypto.agreement;

import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.BasicAgreement;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.CipherParameters;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.params.ECDomainParameters;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.params.ECPrivateKeyParameters;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.params.ECPublicKeyParameters;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.params.MQVPrivateParameters;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.params.MQVPublicParameters;
import com.fis.ekyc.nfc.build_in.bouncycastle.math.ec.ECAlgorithms;
import com.fis.ekyc.nfc.build_in.bouncycastle.math.ec.ECConstants;
import com.fis.ekyc.nfc.build_in.bouncycastle.math.ec.ECCurve;
import com.fis.ekyc.nfc.build_in.bouncycastle.math.ec.ECPoint;
import com.fis.ekyc.nfc.build_in.bouncycastle.util.Properties;
import java.math.BigInteger;

public class ECMQVBasicAgreement implements BasicAgreement {
    MQVPrivateParameters privParams;

    private ECPoint calculateMqvAgreement(ECDomainParameters eCDomainParameters, ECPrivateKeyParameters eCPrivateKeyParameters, ECPrivateKeyParameters eCPrivateKeyParameters2, ECPublicKeyParameters eCPublicKeyParameters, ECPublicKeyParameters eCPublicKeyParameters2, ECPublicKeyParameters eCPublicKeyParameters3) {
        BigInteger n = eCDomainParameters.getN();
        int bitLength = (n.bitLength() + 1) / 2;
        BigInteger shiftLeft = ECConstants.ONE.shiftLeft(bitLength);
        ECCurve curve = eCDomainParameters.getCurve();
        ECPoint cleanPoint = ECAlgorithms.cleanPoint(curve, eCPublicKeyParameters.getQ());
        ECPoint cleanPoint2 = ECAlgorithms.cleanPoint(curve, eCPublicKeyParameters2.getQ());
        ECPoint cleanPoint3 = ECAlgorithms.cleanPoint(curve, eCPublicKeyParameters3.getQ());
        BigInteger mod = eCPrivateKeyParameters.getD().multiply(cleanPoint.getAffineXCoord().toBigInteger().mod(shiftLeft).setBit(bitLength)).add(eCPrivateKeyParameters2.getD()).mod(n);
        BigInteger bit = cleanPoint3.getAffineXCoord().toBigInteger().mod(shiftLeft).setBit(bitLength);
        BigInteger mod2 = eCDomainParameters.getH().multiply(mod).mod(n);
        return ECAlgorithms.sumOfTwoMultiplies(cleanPoint2, bit.multiply(mod2).mod(n), cleanPoint3, mod2);
    }

    public BigInteger calculateAgreement(CipherParameters cipherParameters) {
        if (!Properties.isOverrideSet("com.fis.ekyc.nfc.build_in.bouncycastle.ec.disable_mqv")) {
            MQVPublicParameters mQVPublicParameters = (MQVPublicParameters) cipherParameters;
            ECPrivateKeyParameters staticPrivateKey = this.privParams.getStaticPrivateKey();
            ECDomainParameters parameters = staticPrivateKey.getParameters();
            if (parameters.equals(mQVPublicParameters.getStaticPublicKey().getParameters())) {
                ECPoint normalize = calculateMqvAgreement(parameters, staticPrivateKey, this.privParams.getEphemeralPrivateKey(), this.privParams.getEphemeralPublicKey(), mQVPublicParameters.getStaticPublicKey(), mQVPublicParameters.getEphemeralPublicKey()).normalize();
                if (!normalize.isInfinity()) {
                    return normalize.getAffineXCoord().toBigInteger();
                }
                throw new IllegalStateException("Infinity is not a valid agreement value for MQV");
            }
            throw new IllegalStateException("ECMQV public key components have wrong domain parameters");
        }
        throw new IllegalStateException("ECMQV explicitly disabled");
    }

    public int getFieldSize() {
        return (this.privParams.getStaticPrivateKey().getParameters().getCurve().getFieldSize() + 7) / 8;
    }

    public void init(CipherParameters cipherParameters) {
        this.privParams = (MQVPrivateParameters) cipherParameters;
    }
}
