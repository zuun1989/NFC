package com.fis.ekyc.nfc.build_in.bouncycastle.pqc.jcajce.provider;

import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1ObjectIdentifier;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.pkcs.PKCSObjectIdentifiers;
import com.fis.ekyc.nfc.build_in.bouncycastle.jcajce.provider.config.ConfigurableProvider;
import com.fis.ekyc.nfc.build_in.bouncycastle.jcajce.provider.util.AsymmetricAlgorithmProvider;

public class LMS {
    private static final String PREFIX = "com.fis.ekyc.nfc.build_in.bouncycastle.pqc.jcajce.provider.lms.";

    public static class Mappings extends AsymmetricAlgorithmProvider {
        public void configure(ConfigurableProvider configurableProvider) {
            configurableProvider.addAlgorithm("KeyFactory.LMS", "com.fis.ekyc.nfc.build_in.bouncycastle.pqc.jcajce.provider.lms.LMSKeyFactorySpi");
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Alg.Alias.KeyFactory.");
            ASN1ObjectIdentifier aSN1ObjectIdentifier = PKCSObjectIdentifiers.id_alg_hss_lms_hashsig;
            sb2.append(aSN1ObjectIdentifier);
            configurableProvider.addAlgorithm(sb2.toString(), "LMS");
            configurableProvider.addAlgorithm("KeyPairGenerator.LMS", "com.fis.ekyc.nfc.build_in.bouncycastle.pqc.jcajce.provider.lms.LMSKeyPairGeneratorSpi");
            configurableProvider.addAlgorithm("Alg.Alias.KeyPairGenerator." + aSN1ObjectIdentifier, "LMS");
            configurableProvider.addAlgorithm("Signature.LMS", "com.fis.ekyc.nfc.build_in.bouncycastle.pqc.jcajce.provider.lms.LMSSignatureSpi$generic");
            configurableProvider.addAlgorithm("Alg.Alias.Signature." + aSN1ObjectIdentifier, "LMS");
        }
    }
}
