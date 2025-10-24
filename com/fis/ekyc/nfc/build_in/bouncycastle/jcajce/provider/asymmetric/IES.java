package com.fis.ekyc.nfc.build_in.bouncycastle.jcajce.provider.asymmetric;

import com.fis.ekyc.nfc.build_in.bouncycastle.jcajce.provider.config.ConfigurableProvider;
import com.fis.ekyc.nfc.build_in.bouncycastle.jcajce.provider.util.AsymmetricAlgorithmProvider;

public class IES {
    private static final String PREFIX = "com.fis.ekyc.nfc.build_in.bouncycastle.jcajce.provider.asymmetric.ies.";

    public static class Mappings extends AsymmetricAlgorithmProvider {
        public void configure(ConfigurableProvider configurableProvider) {
            configurableProvider.addAlgorithm("AlgorithmParameters.IES", "com.fis.ekyc.nfc.build_in.bouncycastle.jcajce.provider.asymmetric.ies.AlgorithmParametersSpi");
            configurableProvider.addAlgorithm("AlgorithmParameters.ECIES", "com.fis.ekyc.nfc.build_in.bouncycastle.jcajce.provider.asymmetric.ies.AlgorithmParametersSpi");
        }
    }
}
