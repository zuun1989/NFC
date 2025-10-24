package com.fis.ekyc.nfc.build_in.bouncycastle.crypto.engines;

public class SEEDWrapEngine extends RFC3394WrapEngine {
    public SEEDWrapEngine() {
        super(new SEEDEngine());
    }
}
