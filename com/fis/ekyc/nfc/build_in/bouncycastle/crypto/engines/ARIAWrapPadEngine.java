package com.fis.ekyc.nfc.build_in.bouncycastle.crypto.engines;

public class ARIAWrapPadEngine extends RFC5649WrapEngine {
    public ARIAWrapPadEngine() {
        super(new ARIAEngine());
    }
}
