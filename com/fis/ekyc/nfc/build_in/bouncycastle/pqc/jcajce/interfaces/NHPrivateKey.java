package com.fis.ekyc.nfc.build_in.bouncycastle.pqc.jcajce.interfaces;

import java.security.PrivateKey;

public interface NHPrivateKey extends NHKey, PrivateKey {
    short[] getSecretData();
}
