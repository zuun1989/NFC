package com.fis.ekyc.nfc.build_in.bouncycastle.math.ec;

public class WNafPreCompInfo implements PreCompInfo {
    protected int confWidth = -1;
    protected ECPoint[] preComp = null;
    protected ECPoint[] preCompNeg = null;
    volatile int promotionCountdown = 4;
    protected ECPoint twice = null;
    protected int width = -1;

    public int decrementPromotionCountdown() {
        int i = this.promotionCountdown;
        if (i <= 0) {
            return i;
        }
        int i2 = i - 1;
        this.promotionCountdown = i2;
        return i2;
    }

    public int getConfWidth() {
        return this.confWidth;
    }

    public ECPoint[] getPreComp() {
        return this.preComp;
    }

    public ECPoint[] getPreCompNeg() {
        return this.preCompNeg;
    }

    public int getPromotionCountdown() {
        return this.promotionCountdown;
    }

    public ECPoint getTwice() {
        return this.twice;
    }

    public int getWidth() {
        return this.width;
    }

    public boolean isPromoted() {
        if (this.promotionCountdown <= 0) {
            return true;
        }
        return false;
    }

    public void setConfWidth(int i) {
        this.confWidth = i;
    }

    public void setPreComp(ECPoint[] eCPointArr) {
        this.preComp = eCPointArr;
    }

    public void setPreCompNeg(ECPoint[] eCPointArr) {
        this.preCompNeg = eCPointArr;
    }

    public void setPromotionCountdown(int i) {
        this.promotionCountdown = i;
    }

    public void setTwice(ECPoint eCPoint) {
        this.twice = eCPoint;
    }

    public void setWidth(int i) {
        this.width = i;
    }
}
