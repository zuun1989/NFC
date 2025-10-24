package com.fis.ekyc.nfc.build_in.bouncycastle.jce.interfaces;

import com.fis.ekyc.nfc.build_in.bouncycastle.jce.spec.ElGamalParameterSpec;
import javax.crypto.interfaces.DHKey;

public interface ElGamalKey extends DHKey {
    ElGamalParameterSpec getParameters();
}
