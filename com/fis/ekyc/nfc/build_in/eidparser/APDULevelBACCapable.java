package com.fis.ekyc.nfc.build_in.eidparser;

import com.fis.ekyc.nfc.build_in.scuba.smartcards.CardServiceException;
import javax.crypto.SecretKey;

public interface APDULevelBACCapable {
    byte[] sendGetChallenge() throws CardServiceException;

    byte[] sendMutualAuth(byte[] bArr, byte[] bArr2, byte[] bArr3, SecretKey secretKey, SecretKey secretKey2) throws CardServiceException;
}
