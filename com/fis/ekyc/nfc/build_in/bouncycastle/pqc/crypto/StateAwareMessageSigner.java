package com.fis.ekyc.nfc.build_in.bouncycastle.pqc.crypto;

import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.params.AsymmetricKeyParameter;

public interface StateAwareMessageSigner extends MessageSigner {
    AsymmetricKeyParameter getUpdatedPrivateKey();
}
