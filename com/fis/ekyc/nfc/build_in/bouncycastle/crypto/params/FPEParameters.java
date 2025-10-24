package com.fis.ekyc.nfc.build_in.bouncycastle.crypto.params;

import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.CipherParameters;
import com.fis.ekyc.nfc.build_in.bouncycastle.util.Arrays;

public final class FPEParameters implements CipherParameters {
    private final KeyParameter key;
    private final int radix;
    private final byte[] tweak;
    private final boolean useInverse;

    public FPEParameters(KeyParameter keyParameter, int i, byte[] bArr) {
        this(keyParameter, i, bArr, false);
    }

    public KeyParameter getKey() {
        return this.key;
    }

    public int getRadix() {
        return this.radix;
    }

    public byte[] getTweak() {
        return Arrays.clone(this.tweak);
    }

    public boolean isUsingInverseFunction() {
        return this.useInverse;
    }

    public FPEParameters(KeyParameter keyParameter, int i, byte[] bArr, boolean z) {
        this.key = keyParameter;
        this.radix = i;
        this.tweak = Arrays.clone(bArr);
        this.useInverse = z;
    }
}
