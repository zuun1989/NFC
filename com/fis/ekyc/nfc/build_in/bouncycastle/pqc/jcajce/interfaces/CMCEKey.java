package com.fis.ekyc.nfc.build_in.bouncycastle.pqc.jcajce.interfaces;

import com.fis.ekyc.nfc.build_in.bouncycastle.pqc.jcajce.spec.CMCEParameterSpec;
import java.security.Key;

public interface CMCEKey extends Key {
    CMCEParameterSpec getParameterSpec();
}
