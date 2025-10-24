package com.fis.ekyc.nfc.build_in.bouncycastle.pqc.crypto.sphincsplus;

class SK {
    final byte[] prf;
    final byte[] seed;

    public SK(byte[] bArr, byte[] bArr2) {
        this.seed = bArr;
        this.prf = bArr2;
    }
}
