package com.fis.ekyc.nfc.build_in.bouncycastle.math.ec;

public class ScaleYNegateXPointMap implements ECPointMap {
    protected final ECFieldElement scale;

    public ScaleYNegateXPointMap(ECFieldElement eCFieldElement) {
        this.scale = eCFieldElement;
    }

    public ECPoint map(ECPoint eCPoint) {
        return eCPoint.scaleYNegateX(this.scale);
    }
}
