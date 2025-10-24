package com.fis.ekyc.nfc.build_in.bouncycastle.crypto;

public interface SkippingCipher {
    long getPosition();

    long seekTo(long j);

    long skip(long j);
}
