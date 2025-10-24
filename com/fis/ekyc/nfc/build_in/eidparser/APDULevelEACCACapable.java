package com.fis.ekyc.nfc.build_in.eidparser;

import com.fis.ekyc.nfc.build_in.scuba.smartcards.APDUWrapper;
import com.fis.ekyc.nfc.build_in.scuba.smartcards.CardServiceException;
import java.math.BigInteger;

public interface APDULevelEACCACapable {
    byte[] sendGeneralAuthenticate(APDUWrapper aPDUWrapper, byte[] bArr, boolean z) throws CardServiceException;

    void sendMSEKAT(APDUWrapper aPDUWrapper, byte[] bArr, byte[] bArr2) throws CardServiceException;

    void sendMSESetATIntAuth(APDUWrapper aPDUWrapper, String str, BigInteger bigInteger) throws CardServiceException;
}
