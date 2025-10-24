package com.fis.ekyc.nfc.build_in.bouncycastle.jcajce.io;

import java.io.IOException;
import java.io.OutputStream;
import java.security.MessageDigest;

class DigestUpdatingOutputStream extends OutputStream {
    private MessageDigest digest;

    public DigestUpdatingOutputStream(MessageDigest messageDigest) {
        this.digest = messageDigest;
    }

    public void write(byte[] bArr, int i, int i2) throws IOException {
        this.digest.update(bArr, i, i2);
    }

    public void write(byte[] bArr) throws IOException {
        this.digest.update(bArr);
    }

    public void write(int i) throws IOException {
        this.digest.update((byte) i);
    }
}
