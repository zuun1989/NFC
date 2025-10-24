package com.fis.ekyc.nfc.build_in.eidparser;

import com.fis.ekyc.nfc.build_in.scuba.smartcards.APDUWrapper;
import com.fis.ekyc.nfc.build_in.scuba.smartcards.CardServiceException;

public interface APDULevelPACECapable {
    byte[] sendGeneralAuthenticate(APDUWrapper aPDUWrapper, byte[] bArr, int i, boolean z) throws CardServiceException;

    void sendMSESetATMutualAuth(APDUWrapper aPDUWrapper, String str, int i, byte[] bArr) throws CardServiceException;
}
