package com.fis.ekyc.nfc.build_in.bouncycastle.pqc.jcajce.provider;

import com.fis.ekyc.nfc.build_in.bouncycastle.jcajce.provider.config.ConfigurableProvider;
import com.fis.ekyc.nfc.build_in.bouncycastle.jcajce.provider.util.AsymmetricAlgorithmProvider;
import com.fis.ekyc.nfc.build_in.bouncycastle.pqc.asn1.PQCObjectIdentifiers;
import com.fis.ekyc.nfc.build_in.bouncycastle.pqc.jcajce.provider.newhope.NHKeyFactorySpi;

public class NH {
    private static final String PREFIX = "com.fis.ekyc.nfc.build_in.bouncycastle.pqc.jcajce.provider.newhope.";

    public static class Mappings extends AsymmetricAlgorithmProvider {
        public void configure(ConfigurableProvider configurableProvider) {
            configurableProvider.addAlgorithm("KeyFactory.NH", "com.fis.ekyc.nfc.build_in.bouncycastle.pqc.jcajce.provider.newhope.NHKeyFactorySpi");
            configurableProvider.addAlgorithm("KeyPairGenerator.NH", "com.fis.ekyc.nfc.build_in.bouncycastle.pqc.jcajce.provider.newhope.NHKeyPairGeneratorSpi");
            configurableProvider.addAlgorithm("KeyAgreement.NH", "com.fis.ekyc.nfc.build_in.bouncycastle.pqc.jcajce.provider.newhope.KeyAgreementSpi");
            registerOid(configurableProvider, PQCObjectIdentifiers.newHope, "NH", new NHKeyFactorySpi());
        }
    }
}
