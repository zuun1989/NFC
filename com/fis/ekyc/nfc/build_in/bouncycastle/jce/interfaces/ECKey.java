package com.fis.ekyc.nfc.build_in.bouncycastle.jce.interfaces;

import com.fis.ekyc.nfc.build_in.bouncycastle.jce.spec.ECParameterSpec;

public interface ECKey {
    ECParameterSpec getParameters();
}
