package com.fis.ekyc.nfc.build_in.bouncycastle.jcajce.spec;

import com.fis.ekyc.nfc.build_in.bouncycastle.util.Arrays;
import java.security.spec.AlgorithmParameterSpec;
import java.util.concurrent.atomic.AtomicBoolean;
import javax.security.auth.Destroyable;

public class HybridValueParameterSpec implements AlgorithmParameterSpec, Destroyable {
    private volatile AlgorithmParameterSpec baseSpec;
    private final AtomicBoolean hasBeenDestroyed = new AtomicBoolean(false);
    private volatile byte[] t;

    public HybridValueParameterSpec(byte[] bArr, AlgorithmParameterSpec algorithmParameterSpec) {
        this.t = bArr;
        this.baseSpec = algorithmParameterSpec;
    }

    private void checkDestroyed() {
        if (isDestroyed()) {
            throw new IllegalStateException("spec has been destroyed");
        }
    }

    public void destroy() {
        if (!this.hasBeenDestroyed.getAndSet(true)) {
            Arrays.clear(this.t);
            this.t = null;
            this.baseSpec = null;
        }
    }

    public AlgorithmParameterSpec getBaseParameterSpec() {
        checkDestroyed();
        return this.baseSpec;
    }

    public byte[] getT() {
        checkDestroyed();
        return this.t;
    }

    public boolean isDestroyed() {
        return this.hasBeenDestroyed.get();
    }
}
