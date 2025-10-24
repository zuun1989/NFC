package com.fis.ekyc.nfc.build_in.bouncycastle.jcajce.provider.symmetric.util;

import java.security.AlgorithmParametersSpi;
import java.security.spec.AlgorithmParameterSpec;
import java.security.spec.InvalidParameterSpecException;

public abstract class BaseAlgorithmParameters extends AlgorithmParametersSpi {
    public AlgorithmParameterSpec engineGetParameterSpec(Class cls) throws InvalidParameterSpecException {
        if (cls != null) {
            return localEngineGetParameterSpec(cls);
        }
        throw new NullPointerException("argument to getParameterSpec must not be null");
    }

    public boolean isASN1FormatString(String str) {
        if (str == null || str.equals("ASN.1")) {
            return true;
        }
        return false;
    }

    public abstract AlgorithmParameterSpec localEngineGetParameterSpec(Class cls) throws InvalidParameterSpecException;
}
