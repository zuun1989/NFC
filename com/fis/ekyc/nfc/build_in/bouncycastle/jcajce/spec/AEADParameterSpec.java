package com.fis.ekyc.nfc.build_in.bouncycastle.jcajce.spec;

import com.fis.ekyc.nfc.build_in.bouncycastle.util.Arrays;
import javax.crypto.spec.IvParameterSpec;

public class AEADParameterSpec extends IvParameterSpec {
    private final byte[] associatedData;
    private final int macSizeInBits;

    public AEADParameterSpec(byte[] bArr, int i) {
        this(bArr, i, (byte[]) null);
    }

    public byte[] getAssociatedData() {
        return Arrays.clone(this.associatedData);
    }

    public int getMacSizeInBits() {
        return this.macSizeInBits;
    }

    public byte[] getNonce() {
        return getIV();
    }

    public AEADParameterSpec(byte[] bArr, int i, byte[] bArr2) {
        super(bArr);
        this.macSizeInBits = i;
        this.associatedData = Arrays.clone(bArr2);
    }
}
