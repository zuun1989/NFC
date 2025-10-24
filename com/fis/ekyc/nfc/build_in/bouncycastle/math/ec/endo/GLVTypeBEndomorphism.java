package com.fis.ekyc.nfc.build_in.bouncycastle.math.ec.endo;

import com.fis.ekyc.nfc.build_in.bouncycastle.math.ec.ECCurve;
import com.fis.ekyc.nfc.build_in.bouncycastle.math.ec.ECPointMap;
import com.fis.ekyc.nfc.build_in.bouncycastle.math.ec.ScaleXPointMap;
import java.math.BigInteger;

public class GLVTypeBEndomorphism implements GLVEndomorphism {
    protected final GLVTypeBParameters parameters;
    protected final ECPointMap pointMap;

    public GLVTypeBEndomorphism(ECCurve eCCurve, GLVTypeBParameters gLVTypeBParameters) {
        this.parameters = gLVTypeBParameters;
        this.pointMap = new ScaleXPointMap(eCCurve.fromBigInteger(gLVTypeBParameters.getBeta()));
    }

    public BigInteger[] decomposeScalar(BigInteger bigInteger) {
        return EndoUtil.decomposeScalar(this.parameters.getSplitParams(), bigInteger);
    }

    public ECPointMap getPointMap() {
        return this.pointMap;
    }

    public boolean hasEfficientPointMap() {
        return true;
    }
}
