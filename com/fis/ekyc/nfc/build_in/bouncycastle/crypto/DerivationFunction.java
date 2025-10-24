package com.fis.ekyc.nfc.build_in.bouncycastle.crypto;

public interface DerivationFunction {
    int generateBytes(byte[] bArr, int i, int i2) throws DataLengthException, IllegalArgumentException;

    void init(DerivationParameters derivationParameters);
}
