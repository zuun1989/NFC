package com.fis.ekyc.nfc.build_in.bouncycastle.pqc.crypto;

import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.CipherParameters;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.InvalidCipherTextException;

public interface MessageEncryptor {
    void init(boolean z, CipherParameters cipherParameters);

    byte[] messageDecrypt(byte[] bArr) throws InvalidCipherTextException;

    byte[] messageEncrypt(byte[] bArr);
}
