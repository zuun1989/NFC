package com.fis.ekyc.nfc.build_in.bouncycastle.jce.provider;

import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.x509.ReasonFlags;

class ReasonsMask {
    static final ReasonsMask allReasons = new ReasonsMask(33023);
    private int _reasons;

    public ReasonsMask(ReasonFlags reasonFlags) {
        this._reasons = reasonFlags.intValue();
    }

    public void addReasons(ReasonsMask reasonsMask) {
        this._reasons = reasonsMask.getReasons() | this._reasons;
    }

    public int getReasons() {
        return this._reasons;
    }

    public boolean hasNewReasons(ReasonsMask reasonsMask) {
        if (((reasonsMask.getReasons() ^ this._reasons) | this._reasons) != 0) {
            return true;
        }
        return false;
    }

    public ReasonsMask intersect(ReasonsMask reasonsMask) {
        ReasonsMask reasonsMask2 = new ReasonsMask();
        reasonsMask2.addReasons(new ReasonsMask(reasonsMask.getReasons() & this._reasons));
        return reasonsMask2;
    }

    public boolean isAllReasons() {
        if (this._reasons == allReasons._reasons) {
            return true;
        }
        return false;
    }

    private ReasonsMask(int i) {
        this._reasons = i;
    }

    public ReasonsMask() {
        this(0);
    }
}
