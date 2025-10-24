package com.fis.ekyc.nfc.build_in.eidparser;

import com.fis.ekyc.nfc.build_in.scuba.smartcards.APDUWrapper;
import com.fis.ekyc.nfc.build_in.scuba.smartcards.CardServiceException;

public interface APDULevelReadBinaryCapable {
    byte[] sendReadBinary(APDUWrapper aPDUWrapper, int i, int i2, int i3, boolean z, boolean z2) throws CardServiceException;

    void sendSelectApplet(APDUWrapper aPDUWrapper, byte[] bArr) throws CardServiceException;

    void sendSelectFile(APDUWrapper aPDUWrapper, short s) throws CardServiceException;

    void sendSelectMF() throws CardServiceException;
}
