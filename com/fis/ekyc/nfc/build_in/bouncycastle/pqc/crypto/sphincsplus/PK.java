package com.fis.ekyc.nfc.build_in.bouncycastle.pqc.crypto.sphincsplus;

class PK {
    final byte[] root;
    final byte[] seed;

    public PK(byte[] bArr, byte[] bArr2) {
        this.seed = bArr;
        this.root = bArr2;
    }
}
