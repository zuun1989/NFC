package com.fis.ekyc.nfc.build_in.bouncycastle.crypto;

public interface SignerWithRecovery extends Signer {
    byte[] getRecoveredMessage();

    boolean hasFullMessage();

    void updateWithRecoveredMessage(byte[] bArr) throws InvalidCipherTextException;
}
