package com.fis.ekyc.nfc.build_in.bouncycastle.pqc.jcajce.provider;

import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1ObjectIdentifier;
import com.fis.ekyc.nfc.build_in.bouncycastle.jcajce.provider.config.ConfigurableProvider;
import com.fis.ekyc.nfc.build_in.bouncycastle.jcajce.provider.util.AsymmetricAlgorithmProvider;
import com.fis.ekyc.nfc.build_in.bouncycastle.pqc.asn1.PQCObjectIdentifiers;
import com.fis.ekyc.nfc.build_in.bouncycastle.pqc.jcajce.provider.sphincs.Sphincs256KeyFactorySpi;

public class SPHINCS {
    private static final String PREFIX = "com.fis.ekyc.nfc.build_in.bouncycastle.pqc.jcajce.provider.sphincs.";

    public static class Mappings extends AsymmetricAlgorithmProvider {
        public void configure(ConfigurableProvider configurableProvider) {
            configurableProvider.addAlgorithm("KeyFactory.SPHINCS256", "com.fis.ekyc.nfc.build_in.bouncycastle.pqc.jcajce.provider.sphincs.Sphincs256KeyFactorySpi");
            configurableProvider.addAlgorithm("KeyPairGenerator.SPHINCS256", "com.fis.ekyc.nfc.build_in.bouncycastle.pqc.jcajce.provider.sphincs.Sphincs256KeyPairGeneratorSpi");
            addSignatureAlgorithm(configurableProvider, "SHA512", "SPHINCS256", "com.fis.ekyc.nfc.build_in.bouncycastle.pqc.jcajce.provider.sphincs.SignatureSpi$withSha512", PQCObjectIdentifiers.sphincs256_with_SHA512);
            addSignatureAlgorithm(configurableProvider, "SHA3-512", "SPHINCS256", "com.fis.ekyc.nfc.build_in.bouncycastle.pqc.jcajce.provider.sphincs.SignatureSpi$withSha3_512", PQCObjectIdentifiers.sphincs256_with_SHA3_512);
            Sphincs256KeyFactorySpi sphincs256KeyFactorySpi = new Sphincs256KeyFactorySpi();
            ASN1ObjectIdentifier aSN1ObjectIdentifier = PQCObjectIdentifiers.sphincs256;
            registerOid(configurableProvider, aSN1ObjectIdentifier, "SPHINCS256", sphincs256KeyFactorySpi);
            registerOidAlgorithmParameters(configurableProvider, aSN1ObjectIdentifier, "SPHINCS256");
        }
    }
}
