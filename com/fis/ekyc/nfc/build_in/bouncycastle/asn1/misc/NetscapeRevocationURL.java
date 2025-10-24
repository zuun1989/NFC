package com.fis.ekyc.nfc.build_in.bouncycastle.asn1.misc;

import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.DERIA5String;

public class NetscapeRevocationURL extends DERIA5String {
    public NetscapeRevocationURL(DERIA5String dERIA5String) {
        super(dERIA5String.getString());
    }

    public String toString() {
        return "NetscapeRevocationURL: " + getString();
    }
}
