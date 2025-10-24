package com.fis.ekyc.nfc.build_in.bouncycastle.crypto.agreement;

import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.BasicAgreement;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.CipherParameters;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.params.ECDomainParameters;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.params.ECPrivateKeyParameters;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.params.ECPublicKeyParameters;
import com.fis.ekyc.nfc.build_in.bouncycastle.math.ec.ECAlgorithms;
import com.fis.ekyc.nfc.build_in.bouncycastle.math.ec.ECConstants;
import com.fis.ekyc.nfc.build_in.bouncycastle.math.ec.ECPoint;
import java.math.BigInteger;

public class ECDHBasicAgreement implements BasicAgreement {
    private ECPrivateKeyParameters key;

    public BigInteger calculateAgreement(CipherParameters cipherParameters) {
        ECPublicKeyParameters eCPublicKeyParameters = (ECPublicKeyParameters) cipherParameters;
        ECDomainParameters parameters = this.key.getParameters();
        if (parameters.equals(eCPublicKeyParameters.getParameters())) {
            BigInteger d = this.key.getD();
            ECPoint cleanPoint = ECAlgorithms.cleanPoint(parameters.getCurve(), eCPublicKeyParameters.getQ());
            if (!cleanPoint.isInfinity()) {
                BigInteger h = parameters.getH();
                if (!h.equals(ECConstants.ONE)) {
                    d = parameters.getHInv().multiply(d).mod(parameters.getN());
                    cleanPoint = ECAlgorithms.referenceMultiply(cleanPoint, h);
                }
                ECPoint normalize = cleanPoint.multiply(d).normalize();
                if (!normalize.isInfinity()) {
                    return normalize.getAffineXCoord().toBigInteger();
                }
                throw new IllegalStateException("Infinity is not a valid agreement value for ECDH");
            }
            throw new IllegalStateException("Infinity is not a valid public key for ECDH");
        }
        throw new IllegalStateException("ECDH public key has wrong domain parameters");
    }

    public int getFieldSize() {
        return (this.key.getParameters().getCurve().getFieldSize() + 7) / 8;
    }

    public void init(CipherParameters cipherParameters) {
        this.key = (ECPrivateKeyParameters) cipherParameters;
    }
}
