package com.fis.ekyc.nfc.build_in.bouncycastle.jcajce.provider.keystore;

import com.fis.ekyc.nfc.build_in.bouncycastle.jcajce.provider.config.ConfigurableProvider;
import com.fis.ekyc.nfc.build_in.bouncycastle.jcajce.provider.util.AsymmetricAlgorithmProvider;

public class BCFKS {
    private static final String PREFIX = "com.fis.ekyc.nfc.build_in.bouncycastle.jcajce.provider.keystore.bcfks.";

    public static class Mappings extends AsymmetricAlgorithmProvider {
        public void configure(ConfigurableProvider configurableProvider) {
            configurableProvider.addAlgorithm("KeyStore.BCFKS", "com.fis.ekyc.nfc.build_in.bouncycastle.jcajce.provider.keystore.bcfks.BcFKSKeyStoreSpi$Std");
            configurableProvider.addAlgorithm("KeyStore.BCFKS-DEF", "com.fis.ekyc.nfc.build_in.bouncycastle.jcajce.provider.keystore.bcfks.BcFKSKeyStoreSpi$Def");
            configurableProvider.addAlgorithm("KeyStore.IBCFKS", "com.fis.ekyc.nfc.build_in.bouncycastle.jcajce.provider.keystore.bcfks.BcFKSKeyStoreSpi$StdShared");
            configurableProvider.addAlgorithm("KeyStore.IBCFKS-DEF", "com.fis.ekyc.nfc.build_in.bouncycastle.jcajce.provider.keystore.bcfks.BcFKSKeyStoreSpi$DefShared");
        }
    }
}
