package com.fis.ekyc.nfc.build_in.bouncycastle.pqc.jcajce.provider;

import com.fis.ekyc.nfc.build_in.bouncycastle.jcajce.provider.config.ConfigurableProvider;
import com.fis.ekyc.nfc.build_in.bouncycastle.jcajce.provider.util.AsymmetricAlgorithmProvider;
import com.fis.ekyc.nfc.build_in.bouncycastle.pqc.asn1.PQCObjectIdentifiers;
import com.fis.ekyc.nfc.build_in.bouncycastle.pqc.jcajce.provider.rainbow.RainbowKeyFactorySpi;

public class Rainbow {
    private static final String PREFIX = "com.fis.ekyc.nfc.build_in.bouncycastle.pqc.jcajce.provider.rainbow.";

    public static class Mappings extends AsymmetricAlgorithmProvider {
        public void configure(ConfigurableProvider configurableProvider) {
            configurableProvider.addAlgorithm("KeyFactory.Rainbow", "com.fis.ekyc.nfc.build_in.bouncycastle.pqc.jcajce.provider.rainbow.RainbowKeyFactorySpi");
            configurableProvider.addAlgorithm("KeyPairGenerator.Rainbow", "com.fis.ekyc.nfc.build_in.bouncycastle.pqc.jcajce.provider.rainbow.RainbowKeyPairGeneratorSpi");
            addSignatureAlgorithm(configurableProvider, "SHA224", "Rainbow", "com.fis.ekyc.nfc.build_in.bouncycastle.pqc.jcajce.provider.rainbow.SignatureSpi$withSha224", PQCObjectIdentifiers.rainbowWithSha224);
            addSignatureAlgorithm(configurableProvider, "SHA256", "Rainbow", "com.fis.ekyc.nfc.build_in.bouncycastle.pqc.jcajce.provider.rainbow.SignatureSpi$withSha256", PQCObjectIdentifiers.rainbowWithSha256);
            addSignatureAlgorithm(configurableProvider, "SHA384", "Rainbow", "com.fis.ekyc.nfc.build_in.bouncycastle.pqc.jcajce.provider.rainbow.SignatureSpi$withSha384", PQCObjectIdentifiers.rainbowWithSha384);
            addSignatureAlgorithm(configurableProvider, "SHA512", "Rainbow", "com.fis.ekyc.nfc.build_in.bouncycastle.pqc.jcajce.provider.rainbow.SignatureSpi$withSha512", PQCObjectIdentifiers.rainbowWithSha512);
            registerOid(configurableProvider, PQCObjectIdentifiers.rainbow, "Rainbow", new RainbowKeyFactorySpi());
        }
    }
}
