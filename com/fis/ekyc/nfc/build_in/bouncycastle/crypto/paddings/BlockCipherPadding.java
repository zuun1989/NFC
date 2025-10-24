package com.fis.ekyc.nfc.build_in.bouncycastle.crypto.paddings;

import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.InvalidCipherTextException;
import java.security.SecureRandom;

public interface BlockCipherPadding {
    int addPadding(byte[] bArr, int i);

    String getPaddingName();

    void init(SecureRandom secureRandom) throws IllegalArgumentException;

    int padCount(byte[] bArr) throws InvalidCipherTextException;
}
