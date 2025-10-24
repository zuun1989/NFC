package com.fis.ekyc.nfc.build_in.bouncycastle.math.ec.endo;

import com.fis.ekyc.nfc.build_in.bouncycastle.math.ec.ECConstants;
import com.fis.ekyc.nfc.build_in.bouncycastle.math.ec.ECPoint;
import com.fis.ekyc.nfc.build_in.bouncycastle.math.ec.PreCompCallback;
import com.fis.ekyc.nfc.build_in.bouncycastle.math.ec.PreCompInfo;
import java.math.BigInteger;

public abstract class EndoUtil {
    public static final String PRECOMP_NAME = "bc_endo";

    private static BigInteger calculateB(BigInteger bigInteger, BigInteger bigInteger2, int i) {
        boolean z;
        if (bigInteger2.signum() < 0) {
            z = true;
        } else {
            z = false;
        }
        BigInteger multiply = bigInteger.multiply(bigInteger2.abs());
        boolean testBit = multiply.testBit(i - 1);
        BigInteger shiftRight = multiply.shiftRight(i);
        if (testBit) {
            shiftRight = shiftRight.add(ECConstants.ONE);
        }
        if (z) {
            return shiftRight.negate();
        }
        return shiftRight;
    }

    public static BigInteger[] decomposeScalar(ScalarSplitParameters scalarSplitParameters, BigInteger bigInteger) {
        int bits = scalarSplitParameters.getBits();
        BigInteger calculateB = calculateB(bigInteger, scalarSplitParameters.getG1(), bits);
        BigInteger calculateB2 = calculateB(bigInteger, scalarSplitParameters.getG2(), bits);
        return new BigInteger[]{bigInteger.subtract(calculateB.multiply(scalarSplitParameters.getV1A()).add(calculateB2.multiply(scalarSplitParameters.getV2A()))), calculateB.multiply(scalarSplitParameters.getV1B()).add(calculateB2.multiply(scalarSplitParameters.getV2B())).negate()};
    }

    public static ECPoint mapPoint(final ECEndomorphism eCEndomorphism, final ECPoint eCPoint) {
        return ((EndoPreCompInfo) eCPoint.getCurve().precompute(eCPoint, PRECOMP_NAME, new PreCompCallback() {
            private boolean checkExisting(EndoPreCompInfo endoPreCompInfo, ECEndomorphism eCEndomorphism) {
                if (endoPreCompInfo == null || endoPreCompInfo.getEndomorphism() != eCEndomorphism || endoPreCompInfo.getMappedPoint() == null) {
                    return false;
                }
                return true;
            }

            public PreCompInfo precompute(PreCompInfo preCompInfo) {
                EndoPreCompInfo endoPreCompInfo;
                if (preCompInfo instanceof EndoPreCompInfo) {
                    endoPreCompInfo = (EndoPreCompInfo) preCompInfo;
                } else {
                    endoPreCompInfo = null;
                }
                if (checkExisting(endoPreCompInfo, ECEndomorphism.this)) {
                    return endoPreCompInfo;
                }
                ECPoint map = ECEndomorphism.this.getPointMap().map(eCPoint);
                EndoPreCompInfo endoPreCompInfo2 = new EndoPreCompInfo();
                endoPreCompInfo2.setEndomorphism(ECEndomorphism.this);
                endoPreCompInfo2.setMappedPoint(map);
                return endoPreCompInfo2;
            }
        })).getMappedPoint();
    }
}
