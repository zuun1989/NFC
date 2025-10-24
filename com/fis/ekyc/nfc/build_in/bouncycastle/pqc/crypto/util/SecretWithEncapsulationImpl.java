package com.fis.ekyc.nfc.build_in.bouncycastle.pqc.crypto.util;

import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.SecretWithEncapsulation;
import com.fis.ekyc.nfc.build_in.bouncycastle.util.Arrays;
import java.util.concurrent.atomic.AtomicBoolean;
import javax.security.auth.DestroyFailedException;

public class SecretWithEncapsulationImpl implements SecretWithEncapsulation {
    private final byte[] cipher_text;
    private final AtomicBoolean hasBeenDestroyed = new AtomicBoolean(false);
    private final byte[] sessionKey;

    public SecretWithEncapsulationImpl(byte[] bArr, byte[] bArr2) {
        this.sessionKey = bArr;
        this.cipher_text = bArr2;
    }

    public void checkDestroyed() {
        if (isDestroyed()) {
            throw new IllegalStateException("data has been destroyed");
        }
    }

    public void destroy() throws DestroyFailedException {
        if (!this.hasBeenDestroyed.getAndSet(true)) {
            Arrays.clear(this.sessionKey);
            Arrays.clear(this.cipher_text);
        }
    }

    public byte[] getEncapsulation() {
        checkDestroyed();
        return Arrays.clone(this.cipher_text);
    }

    public byte[] getSecret() {
        checkDestroyed();
        return Arrays.clone(this.sessionKey);
    }

    public boolean isDestroyed() {
        return this.hasBeenDestroyed.get();
    }
}
