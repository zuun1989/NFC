package com.fis.ekyc.nfc.build_in.bouncycastle.crypto.engines;

public class AESWrapEngine extends RFC3394WrapEngine {
    public AESWrapEngine() {
        super(new AESEngine());
    }

    public AESWrapEngine(boolean z) {
        super(new AESEngine(), z);
    }
}
