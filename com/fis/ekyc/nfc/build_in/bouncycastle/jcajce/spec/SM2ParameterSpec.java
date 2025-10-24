package com.fis.ekyc.nfc.build_in.bouncycastle.jcajce.spec;

import com.fis.ekyc.nfc.build_in.bouncycastle.util.Arrays;
import java.security.spec.AlgorithmParameterSpec;

public class SM2ParameterSpec implements AlgorithmParameterSpec {
    private byte[] id;

    public SM2ParameterSpec(byte[] bArr) {
        if (bArr != null) {
            this.id = Arrays.clone(bArr);
            return;
        }
        throw new NullPointerException("id string cannot be null");
    }

    public byte[] getID() {
        return Arrays.clone(this.id);
    }
}
