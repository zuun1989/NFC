package com.fis.ekyc.nfc.build_in.bouncycastle.pqc.crypto.sphincsplus;

class NodeEntry {
    final int nodeHeight;
    final byte[] nodeValue;

    public NodeEntry(byte[] bArr, int i) {
        this.nodeValue = bArr;
        this.nodeHeight = i;
    }
}
