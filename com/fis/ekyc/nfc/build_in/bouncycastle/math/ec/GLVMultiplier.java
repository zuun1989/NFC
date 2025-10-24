package com.fis.ekyc.nfc.build_in.bouncycastle.math.ec;

import com.fis.ekyc.nfc.build_in.bouncycastle.math.ec.endo.ECEndomorphism;
import com.fis.ekyc.nfc.build_in.bouncycastle.math.ec.endo.EndoUtil;
import com.fis.ekyc.nfc.build_in.bouncycastle.math.ec.endo.GLVEndomorphism;
import java.math.BigInteger;

public class GLVMultiplier extends AbstractECMultiplier {
    protected final ECCurve curve;
    protected final GLVEndomorphism glvEndomorphism;

    public GLVMultiplier(ECCurve eCCurve, GLVEndomorphism gLVEndomorphism) {
        if (eCCurve == null || eCCurve.getOrder() == null) {
            throw new IllegalArgumentException("Need curve with known group order");
        }
        this.curve = eCCurve;
        this.glvEndomorphism = gLVEndomorphism;
    }

    public ECPoint multiplyPositive(ECPoint eCPoint, BigInteger bigInteger) {
        if (this.curve.equals(eCPoint.getCurve())) {
            BigInteger[] decomposeScalar = this.glvEndomorphism.decomposeScalar(bigInteger.mod(eCPoint.getCurve().getOrder()));
            BigInteger bigInteger2 = decomposeScalar[0];
            BigInteger bigInteger3 = decomposeScalar[1];
            if (this.glvEndomorphism.hasEfficientPointMap()) {
                return ECAlgorithms.implShamirsTrickWNaf((ECEndomorphism) this.glvEndomorphism, eCPoint, bigInteger2, bigInteger3);
            }
            return ECAlgorithms.implShamirsTrickWNaf(eCPoint, bigInteger2, EndoUtil.mapPoint(this.glvEndomorphism, eCPoint), bigInteger3);
        }
        throw new IllegalStateException();
    }
}
