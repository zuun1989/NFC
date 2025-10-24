package com.fis.ekyc.nfc.build_in.bouncycastle.jcajce;

import com.fis.ekyc.nfc.build_in.bouncycastle.util.Arrays;
import javax.crypto.SecretKey;

public final class SecretKeyWithEncapsulation implements SecretKey {
    private final byte[] encapsulation;
    private final SecretKey secretKey;

    public SecretKeyWithEncapsulation(SecretKey secretKey2, byte[] bArr) {
        this.secretKey = secretKey2;
        this.encapsulation = Arrays.clone(bArr);
    }

    public boolean equals(Object obj) {
        return this.secretKey.equals(obj);
    }

    public String getAlgorithm() {
        return this.secretKey.getAlgorithm();
    }

    public byte[] getEncapsulation() {
        return Arrays.clone(this.encapsulation);
    }

    public byte[] getEncoded() {
        return this.secretKey.getEncoded();
    }

    public String getFormat() {
        return this.secretKey.getFormat();
    }

    public int hashCode() {
        return this.secretKey.hashCode();
    }
}
