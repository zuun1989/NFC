package com.fis.ekyc.nfc.build_in.eidparser.protocol;

import com.fis.ekyc.nfc.build_in.eidparser.APDULevelAACapable;
import com.fis.ekyc.nfc.build_in.eidparser.CardServiceProtocolException;
import com.fis.ekyc.nfc.build_in.scuba.smartcards.CardServiceException;
import java.security.PublicKey;

public class AAProtocol {
    private APDULevelAACapable service;
    private SecureMessagingWrapper wrapper;

    public AAProtocol(APDULevelAACapable aPDULevelAACapable, SecureMessagingWrapper secureMessagingWrapper) {
        this.service = aPDULevelAACapable;
        this.wrapper = secureMessagingWrapper;
    }

    public AAResult doAA(PublicKey publicKey, String str, String str2, byte[] bArr) throws CardServiceException {
        if (bArr != null) {
            try {
                if (bArr.length == 8) {
                    return new AAResult(publicKey, str, str2, bArr, this.service.sendInternalAuthenticate(this.wrapper, bArr));
                }
            } catch (Exception e) {
                throw new CardServiceProtocolException("Exception", 1, (Throwable) e);
            }
        }
        throw new IllegalArgumentException("AA failed: bad challenge");
    }
}
