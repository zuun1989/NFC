package com.fis.ekyc.nfc.build_in.bouncycastle.pqc.jcajce.interfaces;

import com.fis.ekyc.nfc.build_in.bouncycastle.pqc.jcajce.spec.SABERParameterSpec;
import java.security.Key;

public interface SABERKey extends Key {
    SABERParameterSpec getParameterSpec();
}
