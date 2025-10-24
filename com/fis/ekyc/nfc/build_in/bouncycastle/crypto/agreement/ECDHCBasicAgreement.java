package com.fis.ekyc.nfc.build_in.bouncycastle.crypto.agreement;

import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.BasicAgreement;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.CipherParameters;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.params.ECDomainParameters;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.params.ECPrivateKeyParameters;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.params.ECPublicKeyParameters;
import com.fis.ekyc.nfc.build_in.bouncycastle.math.ec.ECAlgorithms;
import com.fis.ekyc.nfc.build_in.bouncycastle.math.ec.ECPoint;
import java.math.BigInteger;

public class ECDHCBasicAgreement implements BasicAgreement {
    ECPrivateKeyParameters key;

    public BigInteger calculateAgreement(CipherParameters cipherParameters) {
        ECPublicKeyParameters eCPublicKeyParameters = (ECPublicKeyParameters) cipherParameters;
        ECDomainParameters parameters = this.key.getParameters();
        if (parameters.equals(eCPublicKeyParameters.getParameters())) {
            BigInteger mod = parameters.getH().multiply(this.key.getD()).mod(parameters.getN());
            ECPoint cleanPoint = ECAlgorithms.cleanPoint(parameters.getCurve(), eCPublicKeyParameters.getQ());
            if (!cleanPoint.isInfinity()) {
                ECPoint normalize = cleanPoint.multiply(mod).normalize();
                if (!normalize.isInfinity()) {
                    return normalize.getAffineXCoord().toBigInteger();
                }
                throw new IllegalStateException("Infinity is not a valid agreement value for ECDHC");
            }
            throw new IllegalStateException("Infinity is not a valid public key for ECDHC");
        }
        throw new IllegalStateException("ECDHC public key has wrong domain parameters");
    }

    public int getFieldSize() {
        return (this.key.getParameters().getCurve().getFieldSize() + 7) / 8;
    }

    public void init(CipherParameters cipherParameters) {
        this.key = (ECPrivateKeyParameters) cipherParameters;
    }
}
