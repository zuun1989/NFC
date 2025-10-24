package com.fis.ekyc.nfc.build_in.eidparser;

import com.fis.ekyc.nfc.build_in.scuba.smartcards.APDUWrapper;
import com.fis.ekyc.nfc.build_in.scuba.smartcards.CardServiceException;

public interface APDULevelAACapable {
    byte[] sendInternalAuthenticate(APDUWrapper aPDUWrapper, byte[] bArr) throws CardServiceException;
}
