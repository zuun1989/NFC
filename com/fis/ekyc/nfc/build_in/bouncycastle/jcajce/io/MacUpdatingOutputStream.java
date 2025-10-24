package com.fis.ekyc.nfc.build_in.bouncycastle.jcajce.io;

import java.io.IOException;
import java.io.OutputStream;
import javax.crypto.Mac;

class MacUpdatingOutputStream extends OutputStream {
    private Mac mac;

    public MacUpdatingOutputStream(Mac mac2) {
        this.mac = mac2;
    }

    public void write(byte[] bArr, int i, int i2) throws IOException {
        this.mac.update(bArr, i, i2);
    }

    public void write(byte[] bArr) throws IOException {
        this.mac.update(bArr);
    }

    public void write(int i) throws IOException {
        this.mac.update((byte) i);
    }
}
