package com.fis.ekyc.nfc.build_in.bouncycastle.jcajce.spec;

import com.fis.ekyc.nfc.build_in.bouncycastle.util.Arrays;
import java.security.spec.AlgorithmParameterSpec;

public class UserKeyingMaterialSpec implements AlgorithmParameterSpec {
    private final byte[] userKeyingMaterial;

    public UserKeyingMaterialSpec(byte[] bArr) {
        this.userKeyingMaterial = Arrays.clone(bArr);
    }

    public byte[] getUserKeyingMaterial() {
        return Arrays.clone(this.userKeyingMaterial);
    }
}
