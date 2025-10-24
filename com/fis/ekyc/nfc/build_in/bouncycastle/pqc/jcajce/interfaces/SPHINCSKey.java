package com.fis.ekyc.nfc.build_in.bouncycastle.pqc.jcajce.interfaces;

import java.security.Key;

public interface SPHINCSKey extends Key {
    byte[] getKeyData();
}
