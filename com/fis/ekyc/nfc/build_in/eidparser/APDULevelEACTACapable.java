package com.fis.ekyc.nfc.build_in.eidparser;

import com.fis.ekyc.nfc.build_in.scuba.smartcards.APDUWrapper;
import com.fis.ekyc.nfc.build_in.scuba.smartcards.CardServiceException;

public interface APDULevelEACTACapable {
    byte[] sendGetChallenge(APDUWrapper aPDUWrapper) throws CardServiceException;

    void sendMSESetATExtAuth(APDUWrapper aPDUWrapper, byte[] bArr) throws CardServiceException;

    void sendMSESetDST(APDUWrapper aPDUWrapper, byte[] bArr) throws CardServiceException;

    void sendMutualAuthenticate(APDUWrapper aPDUWrapper, byte[] bArr) throws CardServiceException;

    void sendPSOExtendedLengthMode(APDUWrapper aPDUWrapper, byte[] bArr, byte[] bArr2) throws CardServiceException;
}
