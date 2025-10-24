package com.fis.ekyc.nfc.build_in.bouncycastle.jce.interfaces;

import java.security.SecureRandom;

public interface BCKeyStore {
    void setRandom(SecureRandom secureRandom);
}
