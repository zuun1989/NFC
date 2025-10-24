package com.fis.ekyc.nfc.build_in.bouncycastle.crypto;

import javax.security.auth.Destroyable;

public interface SecretWithEncapsulation extends Destroyable {
    byte[] getEncapsulation();

    byte[] getSecret();
}
