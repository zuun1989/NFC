package com.fis.ekyc.nfc.build_in.bouncycastle.pqc.crypto.sphincsplus;

class IndexedDigest {
    final byte[] digest;
    final int idx_leaf;
    final long idx_tree;

    public IndexedDigest(long j, int i, byte[] bArr) {
        this.idx_tree = j;
        this.idx_leaf = i;
        this.digest = bArr;
    }
}
