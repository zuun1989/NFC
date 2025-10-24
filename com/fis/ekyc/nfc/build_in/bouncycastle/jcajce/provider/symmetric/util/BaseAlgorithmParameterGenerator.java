package com.fis.ekyc.nfc.build_in.bouncycastle.jcajce.provider.symmetric.util;

import com.fis.ekyc.nfc.build_in.bouncycastle.jcajce.util.BCJcaJceHelper;
import com.fis.ekyc.nfc.build_in.bouncycastle.jcajce.util.JcaJceHelper;
import java.security.AlgorithmParameterGeneratorSpi;
import java.security.AlgorithmParameters;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.SecureRandom;

public abstract class BaseAlgorithmParameterGenerator extends AlgorithmParameterGeneratorSpi {
    private final JcaJceHelper helper = new BCJcaJceHelper();
    protected SecureRandom random;
    protected int strength = 1024;

    public final AlgorithmParameters createParametersInstance(String str) throws NoSuchAlgorithmException, NoSuchProviderException {
        return this.helper.createAlgorithmParameters(str);
    }

    public void engineInit(int i, SecureRandom secureRandom) {
        this.strength = i;
        this.random = secureRandom;
    }
}
