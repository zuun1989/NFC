package com.fis.ekyc.nfc.build_in.bouncycastle.pqc.jcajce.provider;

import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1ObjectIdentifier;
import com.fis.ekyc.nfc.build_in.bouncycastle.jcajce.provider.config.ConfigurableProvider;
import com.fis.ekyc.nfc.build_in.bouncycastle.jcajce.provider.util.AsymmetricAlgorithmProvider;
import com.fis.ekyc.nfc.build_in.bouncycastle.pqc.asn1.PQCObjectIdentifiers;
import com.fis.ekyc.nfc.build_in.bouncycastle.pqc.jcajce.provider.qtesla.QTESLAKeyFactorySpi;

public class QTESLA {
    private static final String PREFIX = "com.fis.ekyc.nfc.build_in.bouncycastle.pqc.jcajce.provider.qtesla.";

    public static class Mappings extends AsymmetricAlgorithmProvider {
        public void configure(ConfigurableProvider configurableProvider) {
            configurableProvider.addAlgorithm("KeyFactory.QTESLA", "com.fis.ekyc.nfc.build_in.bouncycastle.pqc.jcajce.provider.qtesla.QTESLAKeyFactorySpi");
            configurableProvider.addAlgorithm("KeyPairGenerator.QTESLA", "com.fis.ekyc.nfc.build_in.bouncycastle.pqc.jcajce.provider.qtesla.KeyPairGeneratorSpi");
            configurableProvider.addAlgorithm("Signature.QTESLA", "com.fis.ekyc.nfc.build_in.bouncycastle.pqc.jcajce.provider.qtesla.SignatureSpi$qTESLA");
            ASN1ObjectIdentifier aSN1ObjectIdentifier = PQCObjectIdentifiers.qTESLA_p_I;
            addSignatureAlgorithm(configurableProvider, "QTESLA-P-I", "com.fis.ekyc.nfc.build_in.bouncycastle.pqc.jcajce.provider.qtesla.SignatureSpi$PI", aSN1ObjectIdentifier);
            ASN1ObjectIdentifier aSN1ObjectIdentifier2 = PQCObjectIdentifiers.qTESLA_p_III;
            addSignatureAlgorithm(configurableProvider, "QTESLA-P-III", "com.fis.ekyc.nfc.build_in.bouncycastle.pqc.jcajce.provider.qtesla.SignatureSpi$PIII", aSN1ObjectIdentifier2);
            QTESLAKeyFactorySpi qTESLAKeyFactorySpi = new QTESLAKeyFactorySpi();
            registerOid(configurableProvider, aSN1ObjectIdentifier, "QTESLA-P-I", qTESLAKeyFactorySpi);
            registerOid(configurableProvider, aSN1ObjectIdentifier2, "QTESLA-P-III", qTESLAKeyFactorySpi);
        }
    }
}
