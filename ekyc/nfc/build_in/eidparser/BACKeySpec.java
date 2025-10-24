package com.fis.ekyc.nfc.build_in.eidparser;

public interface BACKeySpec extends AccessKeySpec {
    String getDateOfBirth();

    String getDateOfExpiry();

    String getDocumentNumber();
}
