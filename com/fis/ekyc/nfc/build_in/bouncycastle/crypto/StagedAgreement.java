package com.fis.ekyc.nfc.build_in.bouncycastle.crypto;

import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.params.AsymmetricKeyParameter;

public interface StagedAgreement extends BasicAgreement {
    AsymmetricKeyParameter calculateStage(CipherParameters cipherParameters);
}
