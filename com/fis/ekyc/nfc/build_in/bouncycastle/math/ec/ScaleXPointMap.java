package com.fis.ekyc.nfc.build_in.bouncycastle.math.ec;

public class ScaleXPointMap implements ECPointMap {
    protected final ECFieldElement scale;

    public ScaleXPointMap(ECFieldElement eCFieldElement) {
        this.scale = eCFieldElement;
    }

    public ECPoint map(ECPoint eCPoint) {
        return eCPoint.scaleX(this.scale);
    }
}
