package com.fis.ekyc.nfc.build_in.bouncycastle.crypto;

public interface Committer {
    Commitment commit(byte[] bArr);

    boolean isRevealed(Commitment commitment, byte[] bArr);
}
