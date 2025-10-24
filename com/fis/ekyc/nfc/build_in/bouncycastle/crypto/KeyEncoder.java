package com.fis.ekyc.nfc.build_in.bouncycastle.crypto;

import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.params.AsymmetricKeyParameter;

public interface KeyEncoder {
    byte[] getEncoded(AsymmetricKeyParameter asymmetricKeyParameter);
}
