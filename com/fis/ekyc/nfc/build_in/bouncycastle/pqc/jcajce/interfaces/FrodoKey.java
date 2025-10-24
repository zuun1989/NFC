package com.fis.ekyc.nfc.build_in.bouncycastle.pqc.jcajce.interfaces;

import com.fis.ekyc.nfc.build_in.bouncycastle.pqc.jcajce.spec.FrodoParameterSpec;
import java.security.Key;

public interface FrodoKey extends Key {
    FrodoParameterSpec getParameterSpec();
}
