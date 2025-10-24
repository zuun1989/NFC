package com.fis.ekyc.nfc.build_in.bouncycastle.jcajce.provider.keystore;

import com.fis.ekyc.nfc.build_in.bouncycastle.jcajce.provider.config.ConfigurableProvider;
import com.fis.ekyc.nfc.build_in.bouncycastle.jcajce.provider.util.AsymmetricAlgorithmProvider;

public class PKCS12 {
    private static final String PREFIX = "com.fis.ekyc.nfc.build_in.bouncycastle.jcajce.provider.keystore.pkcs12.";

    public static class Mappings extends AsymmetricAlgorithmProvider {
        public void configure(ConfigurableProvider configurableProvider) {
            configurableProvider.addAlgorithm("KeyStore.PKCS12", "com.fis.ekyc.nfc.build_in.bouncycastle.jcajce.provider.keystore.pkcs12.PKCS12KeyStoreSpi$BCPKCS12KeyStore");
            configurableProvider.addAlgorithm("KeyStore.BCPKCS12", "com.fis.ekyc.nfc.build_in.bouncycastle.jcajce.provider.keystore.pkcs12.PKCS12KeyStoreSpi$BCPKCS12KeyStore");
            configurableProvider.addAlgorithm("KeyStore.PKCS12-DEF", "com.fis.ekyc.nfc.build_in.bouncycastle.jcajce.provider.keystore.pkcs12.PKCS12KeyStoreSpi$DefPKCS12KeyStore");
            configurableProvider.addAlgorithm("KeyStore.PKCS12-3DES-40RC2", "com.fis.ekyc.nfc.build_in.bouncycastle.jcajce.provider.keystore.pkcs12.PKCS12KeyStoreSpi$BCPKCS12KeyStore");
            configurableProvider.addAlgorithm("KeyStore.PKCS12-3DES-3DES", "com.fis.ekyc.nfc.build_in.bouncycastle.jcajce.provider.keystore.pkcs12.PKCS12KeyStoreSpi$BCPKCS12KeyStore3DES");
            configurableProvider.addAlgorithm("KeyStore.PKCS12-DEF-3DES-40RC2", "com.fis.ekyc.nfc.build_in.bouncycastle.jcajce.provider.keystore.pkcs12.PKCS12KeyStoreSpi$DefPKCS12KeyStore");
            configurableProvider.addAlgorithm("KeyStore.PKCS12-DEF-3DES-3DES", "com.fis.ekyc.nfc.build_in.bouncycastle.jcajce.provider.keystore.pkcs12.PKCS12KeyStoreSpi$DefPKCS12KeyStore3DES");
        }
    }
}
