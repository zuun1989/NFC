package com.fis.ekyc.nfc.build_in.bouncycastle.jcajce.spec;

import com.fis.ekyc.nfc.build_in.bouncycastle.util.Arrays;
import java.security.spec.AlgorithmParameterSpec;

public class IESKEMParameterSpec implements AlgorithmParameterSpec {
    private final byte[] recipientInfo;
    private final boolean usePointCompression;

    public IESKEMParameterSpec(byte[] bArr) {
        this(bArr, false);
    }

    public byte[] getRecipientInfo() {
        return Arrays.clone(this.recipientInfo);
    }

    public boolean hasUsePointCompression() {
        return this.usePointCompression;
    }

    public IESKEMParameterSpec(byte[] bArr, boolean z) {
        this.recipientInfo = Arrays.clone(bArr);
        this.usePointCompression = z;
    }
}
