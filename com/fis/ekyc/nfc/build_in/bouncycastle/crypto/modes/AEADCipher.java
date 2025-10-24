package com.fis.ekyc.nfc.build_in.bouncycastle.crypto.modes;

import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.CipherParameters;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.DataLengthException;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.InvalidCipherTextException;

public interface AEADCipher {
    int doFinal(byte[] bArr, int i) throws IllegalStateException, InvalidCipherTextException;

    String getAlgorithmName();

    byte[] getMac();

    int getOutputSize(int i);

    int getUpdateOutputSize(int i);

    void init(boolean z, CipherParameters cipherParameters) throws IllegalArgumentException;

    void processAADByte(byte b);

    void processAADBytes(byte[] bArr, int i, int i2);

    int processByte(byte b, byte[] bArr, int i) throws DataLengthException;

    int processBytes(byte[] bArr, int i, int i2, byte[] bArr2, int i3) throws DataLengthException;

    void reset();
}
