package com.fis.ekyc.nfc.build_in.bouncycastle.jcajce.interfaces;

import java.security.PrivateKey;

public interface EdDSAPrivateKey extends EdDSAKey, PrivateKey {
    EdDSAPublicKey getPublicKey();
}
