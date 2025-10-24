package com.fis.ekyc.nfc.build_in.bouncycastle.util;

public interface Memoable {
    Memoable copy();

    void reset(Memoable memoable);
}
