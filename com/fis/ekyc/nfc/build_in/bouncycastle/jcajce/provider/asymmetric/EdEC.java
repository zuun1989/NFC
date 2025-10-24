package com.fis.ekyc.nfc.build_in.bouncycastle.jcajce.provider.asymmetric;

import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1ObjectIdentifier;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.edec.EdECObjectIdentifiers;
import com.fis.ekyc.nfc.build_in.bouncycastle.jcajce.provider.asymmetric.edec.KeyFactorySpi;
import com.fis.ekyc.nfc.build_in.bouncycastle.jcajce.provider.config.ConfigurableProvider;
import com.fis.ekyc.nfc.build_in.bouncycastle.jcajce.provider.util.AsymmetricAlgorithmProvider;
import java.util.HashMap;
import java.util.Map;

public class EdEC {
    private static final String PREFIX = "com.fis.ekyc.nfc.build_in.bouncycastle.jcajce.provider.asymmetric.edec.";
    private static final Map<String, String> edxAttributes;

    public static class Mappings extends AsymmetricAlgorithmProvider {
        public void configure(ConfigurableProvider configurableProvider) {
            configurableProvider.addAlgorithm("KeyFactory.XDH", "com.fis.ekyc.nfc.build_in.bouncycastle.jcajce.provider.asymmetric.edec.KeyFactorySpi$XDH");
            configurableProvider.addAlgorithm("KeyFactory.X448", "com.fis.ekyc.nfc.build_in.bouncycastle.jcajce.provider.asymmetric.edec.KeyFactorySpi$X448");
            configurableProvider.addAlgorithm("KeyFactory.X25519", "com.fis.ekyc.nfc.build_in.bouncycastle.jcajce.provider.asymmetric.edec.KeyFactorySpi$X25519");
            configurableProvider.addAlgorithm("KeyFactory.EDDSA", "com.fis.ekyc.nfc.build_in.bouncycastle.jcajce.provider.asymmetric.edec.KeyFactorySpi$EdDSA");
            configurableProvider.addAlgorithm("KeyFactory.ED448", "com.fis.ekyc.nfc.build_in.bouncycastle.jcajce.provider.asymmetric.edec.KeyFactorySpi$Ed448");
            configurableProvider.addAlgorithm("KeyFactory.ED25519", "com.fis.ekyc.nfc.build_in.bouncycastle.jcajce.provider.asymmetric.edec.KeyFactorySpi$Ed25519");
            configurableProvider.addAlgorithm("Signature.EDDSA", "com.fis.ekyc.nfc.build_in.bouncycastle.jcajce.provider.asymmetric.edec.SignatureSpi$EdDSA");
            configurableProvider.addAlgorithm("Signature.ED448", "com.fis.ekyc.nfc.build_in.bouncycastle.jcajce.provider.asymmetric.edec.SignatureSpi$Ed448");
            configurableProvider.addAlgorithm("Signature.ED25519", "com.fis.ekyc.nfc.build_in.bouncycastle.jcajce.provider.asymmetric.edec.SignatureSpi$Ed25519");
            ASN1ObjectIdentifier aSN1ObjectIdentifier = EdECObjectIdentifiers.id_Ed448;
            configurableProvider.addAlgorithm("Alg.Alias.Signature", aSN1ObjectIdentifier, "ED448");
            ASN1ObjectIdentifier aSN1ObjectIdentifier2 = EdECObjectIdentifiers.id_Ed25519;
            configurableProvider.addAlgorithm("Alg.Alias.Signature", aSN1ObjectIdentifier2, "ED25519");
            configurableProvider.addAlgorithm("KeyPairGenerator.EDDSA", "com.fis.ekyc.nfc.build_in.bouncycastle.jcajce.provider.asymmetric.edec.KeyPairGeneratorSpi$EdDSA");
            configurableProvider.addAlgorithm("KeyPairGenerator.ED448", "com.fis.ekyc.nfc.build_in.bouncycastle.jcajce.provider.asymmetric.edec.KeyPairGeneratorSpi$Ed448");
            configurableProvider.addAlgorithm("KeyPairGenerator.ED25519", "com.fis.ekyc.nfc.build_in.bouncycastle.jcajce.provider.asymmetric.edec.KeyPairGeneratorSpi$Ed25519");
            configurableProvider.addAlgorithm("KeyPairGenerator", aSN1ObjectIdentifier, "com.fis.ekyc.nfc.build_in.bouncycastle.jcajce.provider.asymmetric.edec.KeyPairGeneratorSpi$Ed448");
            configurableProvider.addAlgorithm("KeyPairGenerator", aSN1ObjectIdentifier2, "com.fis.ekyc.nfc.build_in.bouncycastle.jcajce.provider.asymmetric.edec.KeyPairGeneratorSpi$Ed25519");
            configurableProvider.addAlgorithm("KeyAgreement.XDH", "com.fis.ekyc.nfc.build_in.bouncycastle.jcajce.provider.asymmetric.edec.KeyAgreementSpi$XDH");
            configurableProvider.addAlgorithm("KeyAgreement.X448", "com.fis.ekyc.nfc.build_in.bouncycastle.jcajce.provider.asymmetric.edec.KeyAgreementSpi$X448");
            configurableProvider.addAlgorithm("KeyAgreement.X25519", "com.fis.ekyc.nfc.build_in.bouncycastle.jcajce.provider.asymmetric.edec.KeyAgreementSpi$X25519");
            ASN1ObjectIdentifier aSN1ObjectIdentifier3 = EdECObjectIdentifiers.id_X448;
            configurableProvider.addAlgorithm("KeyAgreement", aSN1ObjectIdentifier3, "com.fis.ekyc.nfc.build_in.bouncycastle.jcajce.provider.asymmetric.edec.KeyAgreementSpi$X448");
            ASN1ObjectIdentifier aSN1ObjectIdentifier4 = EdECObjectIdentifiers.id_X25519;
            configurableProvider.addAlgorithm("KeyAgreement", aSN1ObjectIdentifier4, "com.fis.ekyc.nfc.build_in.bouncycastle.jcajce.provider.asymmetric.edec.KeyAgreementSpi$X25519");
            configurableProvider.addAlgorithm("KeyAgreement.X25519WITHSHA256CKDF", "com.fis.ekyc.nfc.build_in.bouncycastle.jcajce.provider.asymmetric.edec.KeyAgreementSpi$X25519withSHA256CKDF");
            configurableProvider.addAlgorithm("KeyAgreement.X25519WITHSHA384CKDF", "com.fis.ekyc.nfc.build_in.bouncycastle.jcajce.provider.asymmetric.edec.KeyAgreementSpi$X25519withSHA384CKDF");
            configurableProvider.addAlgorithm("KeyAgreement.X25519WITHSHA512CKDF", "com.fis.ekyc.nfc.build_in.bouncycastle.jcajce.provider.asymmetric.edec.KeyAgreementSpi$X25519withSHA512CKDF");
            configurableProvider.addAlgorithm("KeyAgreement.X448WITHSHA256CKDF", "com.fis.ekyc.nfc.build_in.bouncycastle.jcajce.provider.asymmetric.edec.KeyAgreementSpi$X448withSHA256CKDF");
            configurableProvider.addAlgorithm("KeyAgreement.X448WITHSHA384CKDF", "com.fis.ekyc.nfc.build_in.bouncycastle.jcajce.provider.asymmetric.edec.KeyAgreementSpi$X448withSHA384CKDF");
            configurableProvider.addAlgorithm("KeyAgreement.X448WITHSHA512CKDF", "com.fis.ekyc.nfc.build_in.bouncycastle.jcajce.provider.asymmetric.edec.KeyAgreementSpi$X448withSHA512CKDF");
            configurableProvider.addAlgorithm("KeyAgreement.X25519WITHSHA256KDF", "com.fis.ekyc.nfc.build_in.bouncycastle.jcajce.provider.asymmetric.edec.KeyAgreementSpi$X25519withSHA256KDF");
            configurableProvider.addAlgorithm("KeyAgreement.X448WITHSHA512KDF", "com.fis.ekyc.nfc.build_in.bouncycastle.jcajce.provider.asymmetric.edec.KeyAgreementSpi$X448withSHA512KDF");
            configurableProvider.addAlgorithm("KeyAgreement.X25519UWITHSHA256KDF", "com.fis.ekyc.nfc.build_in.bouncycastle.jcajce.provider.asymmetric.edec.KeyAgreementSpi$X25519UwithSHA256KDF");
            configurableProvider.addAlgorithm("KeyAgreement.X448UWITHSHA512KDF", "com.fis.ekyc.nfc.build_in.bouncycastle.jcajce.provider.asymmetric.edec.KeyAgreementSpi$X448UwithSHA512KDF");
            configurableProvider.addAlgorithm("KeyPairGenerator.XDH", "com.fis.ekyc.nfc.build_in.bouncycastle.jcajce.provider.asymmetric.edec.KeyPairGeneratorSpi$XDH");
            configurableProvider.addAlgorithm("KeyPairGenerator.X448", "com.fis.ekyc.nfc.build_in.bouncycastle.jcajce.provider.asymmetric.edec.KeyPairGeneratorSpi$X448");
            configurableProvider.addAlgorithm("KeyPairGenerator.X25519", "com.fis.ekyc.nfc.build_in.bouncycastle.jcajce.provider.asymmetric.edec.KeyPairGeneratorSpi$X25519");
            configurableProvider.addAlgorithm("KeyPairGenerator", aSN1ObjectIdentifier3, "com.fis.ekyc.nfc.build_in.bouncycastle.jcajce.provider.asymmetric.edec.KeyPairGeneratorSpi$X448");
            configurableProvider.addAlgorithm("KeyPairGenerator", aSN1ObjectIdentifier4, "com.fis.ekyc.nfc.build_in.bouncycastle.jcajce.provider.asymmetric.edec.KeyPairGeneratorSpi$X25519");
            registerOid(configurableProvider, aSN1ObjectIdentifier3, "XDH", new KeyFactorySpi.X448());
            registerOid(configurableProvider, aSN1ObjectIdentifier4, "XDH", new KeyFactorySpi.X25519());
            registerOid(configurableProvider, aSN1ObjectIdentifier, "EDDSA", new KeyFactorySpi.Ed448());
            registerOid(configurableProvider, aSN1ObjectIdentifier2, "EDDSA", new KeyFactorySpi.Ed25519());
        }
    }

    static {
        HashMap hashMap = new HashMap();
        edxAttributes = hashMap;
        hashMap.put("SupportedKeyClasses", "java.security.interfaces.ECPublicKey|java.security.interfaces.ECPrivateKey");
        hashMap.put("SupportedKeyFormats", "PKCS#8|X.509");
    }
}
