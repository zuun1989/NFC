package com.fis.ekyc.nfc.build_in.bouncycastle.pqc.jcajce.interfaces;

import com.fis.ekyc.nfc.build_in.bouncycastle.pqc.jcajce.spec.SPHINCSPlusParameterSpec;
import java.security.Key;

public interface SPHINCSPlusKey extends Key {
    SPHINCSPlusParameterSpec getParameterSpec();
}
