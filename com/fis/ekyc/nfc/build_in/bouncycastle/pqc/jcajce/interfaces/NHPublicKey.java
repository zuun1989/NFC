package com.fis.ekyc.nfc.build_in.bouncycastle.pqc.jcajce.interfaces;

import java.security.PublicKey;

public interface NHPublicKey extends NHKey, PublicKey {
    byte[] getPublicData();
}
