package com.fis.ekyc.nfc.build_in.eidparser.cbeff;

import com.fis.ekyc.nfc.build_in.eidparser.cbeff.BiometricDataBlock;

public class SimpleCBEFFInfo<B extends BiometricDataBlock> implements CBEFFInfo {
    private B bdb;

    public SimpleCBEFFInfo(B b) {
        this.bdb = b;
    }

    public B getBiometricDataBlock() {
        return this.bdb;
    }
}
