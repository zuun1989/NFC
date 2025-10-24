package com.fis.ekyc.nfc.build_in.bouncycastle.math.ec;

public class ScaleYPointMap implements ECPointMap {
    protected final ECFieldElement scale;

    public ScaleYPointMap(ECFieldElement eCFieldElement) {
        this.scale = eCFieldElement;
    }

    public ECPoint map(ECPoint eCPoint) {
        return eCPoint.scaleY(this.scale);
    }
}
