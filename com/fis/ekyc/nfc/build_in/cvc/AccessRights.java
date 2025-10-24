package com.fis.ekyc.nfc.build_in.cvc;

public interface AccessRights {
    byte[] getEncoded();

    String name();
}
