package com.fis.ekyc.nfc.build_in.bouncycastle.jcajce.spec;

import java.security.spec.EncodedKeySpec;

public class OpenSSHPrivateKeySpec extends EncodedKeySpec {
    private final String format;

    public OpenSSHPrivateKeySpec(byte[] bArr) {
        super(bArr);
        byte b = bArr[0];
        if (b == 48) {
            this.format = "ASN.1";
        } else if (b == 111) {
            this.format = "OpenSSH";
        } else {
            throw new IllegalArgumentException("unknown byte encoding");
        }
    }

    public String getFormat() {
        return this.format;
    }
}
