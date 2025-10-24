package com.fis.ekyc.nfc.build_in.bouncycastle.crypto.engines;

import com.fis.ekyc.nfc.build_in.bouncycastle.util.Memoable;

public final class Zuc128Engine extends Zuc128CoreEngine {
    public Zuc128Engine() {
    }

    public Memoable copy() {
        return new Zuc128Engine(this);
    }

    private Zuc128Engine(Zuc128Engine zuc128Engine) {
        super(zuc128Engine);
    }
}
