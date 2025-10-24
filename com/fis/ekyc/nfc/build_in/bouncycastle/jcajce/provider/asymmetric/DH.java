package com.fis.ekyc.nfc.build_in.bouncycastle.jcajce.provider.asymmetric;

import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.pkcs.PKCSObjectIdentifiers;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.x9.X9ObjectIdentifiers;
import com.fis.ekyc.nfc.build_in.bouncycastle.jcajce.provider.asymmetric.dh.KeyFactorySpi;
import com.fis.ekyc.nfc.build_in.bouncycastle.jcajce.provider.config.ConfigurableProvider;
import com.fis.ekyc.nfc.build_in.bouncycastle.jcajce.provider.util.AsymmetricAlgorithmProvider;
import java.util.HashMap;
import java.util.Map;

public class DH {
    private static final String PREFIX = "com.fis.ekyc.nfc.build_in.bouncycastle.jcajce.provider.asymmetric.dh.";
    /* access modifiers changed from: private */
    public static final Map<String, String> generalDhAttributes;

    public static class Mappings extends AsymmetricAlgorithmProvider {
        public void configure(ConfigurableProvider configurableProvider) {
            configurableProvider.addAlgorithm("KeyPairGenerator.DH", "com.fis.ekyc.nfc.build_in.bouncycastle.jcajce.provider.asymmetric.dh.KeyPairGeneratorSpi");
            configurableProvider.addAlgorithm("Alg.Alias.KeyPairGenerator.DIFFIEHELLMAN", "DH");
            configurableProvider.addAttributes("KeyAgreement.DH", DH.generalDhAttributes);
            configurableProvider.addAlgorithm("KeyAgreement.DH", "com.fis.ekyc.nfc.build_in.bouncycastle.jcajce.provider.asymmetric.dh.KeyAgreementSpi");
            configurableProvider.addAlgorithm("Alg.Alias.KeyAgreement.DIFFIEHELLMAN", "DH");
            configurableProvider.addAlgorithm("KeyAgreement", PKCSObjectIdentifiers.id_alg_ESDH, "com.fis.ekyc.nfc.build_in.bouncycastle.jcajce.provider.asymmetric.dh.KeyAgreementSpi$DHwithRFC2631KDF");
            configurableProvider.addAlgorithm("KeyAgreement", PKCSObjectIdentifiers.id_alg_SSDH, "com.fis.ekyc.nfc.build_in.bouncycastle.jcajce.provider.asymmetric.dh.KeyAgreementSpi$DHwithRFC2631KDF");
            configurableProvider.addAlgorithm("KeyFactory.DH", "com.fis.ekyc.nfc.build_in.bouncycastle.jcajce.provider.asymmetric.dh.KeyFactorySpi");
            configurableProvider.addAlgorithm("Alg.Alias.KeyFactory.DIFFIEHELLMAN", "DH");
            configurableProvider.addAlgorithm("AlgorithmParameters.DH", "com.fis.ekyc.nfc.build_in.bouncycastle.jcajce.provider.asymmetric.dh.AlgorithmParametersSpi");
            configurableProvider.addAlgorithm("Alg.Alias.AlgorithmParameters.DIFFIEHELLMAN", "DH");
            configurableProvider.addAlgorithm("Alg.Alias.AlgorithmParameterGenerator.DIFFIEHELLMAN", "DH");
            configurableProvider.addAlgorithm("AlgorithmParameterGenerator.DH", "com.fis.ekyc.nfc.build_in.bouncycastle.jcajce.provider.asymmetric.dh.AlgorithmParameterGeneratorSpi");
            configurableProvider.addAlgorithm("Cipher.IES", "com.fis.ekyc.nfc.build_in.bouncycastle.jcajce.provider.asymmetric.dh.IESCipher$IES");
            configurableProvider.addAlgorithm("Cipher.IESwithAES-CBC", "com.fis.ekyc.nfc.build_in.bouncycastle.jcajce.provider.asymmetric.dh.IESCipher$IESwithAESCBC");
            configurableProvider.addAlgorithm("Cipher.IESWITHAES-CBC", "com.fis.ekyc.nfc.build_in.bouncycastle.jcajce.provider.asymmetric.dh.IESCipher$IESwithAESCBC");
            configurableProvider.addAlgorithm("Cipher.IESWITHDESEDE-CBC", "com.fis.ekyc.nfc.build_in.bouncycastle.jcajce.provider.asymmetric.dh.IESCipher$IESwithDESedeCBC");
            configurableProvider.addAlgorithm("Cipher.DHIES", "com.fis.ekyc.nfc.build_in.bouncycastle.jcajce.provider.asymmetric.dh.IESCipher$IES");
            configurableProvider.addAlgorithm("Cipher.DHIESwithAES-CBC", "com.fis.ekyc.nfc.build_in.bouncycastle.jcajce.provider.asymmetric.dh.IESCipher$IESwithAESCBC");
            configurableProvider.addAlgorithm("Cipher.DHIESWITHAES-CBC", "com.fis.ekyc.nfc.build_in.bouncycastle.jcajce.provider.asymmetric.dh.IESCipher$IESwithAESCBC");
            configurableProvider.addAlgorithm("Cipher.DHIESWITHDESEDE-CBC", "com.fis.ekyc.nfc.build_in.bouncycastle.jcajce.provider.asymmetric.dh.IESCipher$IESwithDESedeCBC");
            configurableProvider.addAlgorithm("KeyAgreement.DHWITHSHA1KDF", "com.fis.ekyc.nfc.build_in.bouncycastle.jcajce.provider.asymmetric.dh.KeyAgreementSpi$DHwithSHA1KDF");
            configurableProvider.addAlgorithm("KeyAgreement.DHWITHSHA224KDF", "com.fis.ekyc.nfc.build_in.bouncycastle.jcajce.provider.asymmetric.dh.KeyAgreementSpi$DHwithSHA224KDF");
            configurableProvider.addAlgorithm("KeyAgreement.DHWITHSHA256KDF", "com.fis.ekyc.nfc.build_in.bouncycastle.jcajce.provider.asymmetric.dh.KeyAgreementSpi$DHwithSHA256KDF");
            configurableProvider.addAlgorithm("KeyAgreement.DHWITHSHA384KDF", "com.fis.ekyc.nfc.build_in.bouncycastle.jcajce.provider.asymmetric.dh.KeyAgreementSpi$DHwithSHA384KDF");
            configurableProvider.addAlgorithm("KeyAgreement.DHWITHSHA512KDF", "com.fis.ekyc.nfc.build_in.bouncycastle.jcajce.provider.asymmetric.dh.KeyAgreementSpi$DHwithSHA512KDF");
            configurableProvider.addAlgorithm("KeyAgreement.DHUWITHSHA1KDF", "com.fis.ekyc.nfc.build_in.bouncycastle.jcajce.provider.asymmetric.dh.KeyAgreementSpi$DHUwithSHA1KDF");
            configurableProvider.addAlgorithm("KeyAgreement.DHUWITHSHA224KDF", "com.fis.ekyc.nfc.build_in.bouncycastle.jcajce.provider.asymmetric.dh.KeyAgreementSpi$DHUwithSHA224KDF");
            configurableProvider.addAlgorithm("KeyAgreement.DHUWITHSHA256KDF", "com.fis.ekyc.nfc.build_in.bouncycastle.jcajce.provider.asymmetric.dh.KeyAgreementSpi$DHUwithSHA256KDF");
            configurableProvider.addAlgorithm("KeyAgreement.DHUWITHSHA384KDF", "com.fis.ekyc.nfc.build_in.bouncycastle.jcajce.provider.asymmetric.dh.KeyAgreementSpi$DHUwithSHA384KDF");
            configurableProvider.addAlgorithm("KeyAgreement.DHUWITHSHA512KDF", "com.fis.ekyc.nfc.build_in.bouncycastle.jcajce.provider.asymmetric.dh.KeyAgreementSpi$DHUwithSHA512KDF");
            configurableProvider.addAlgorithm("KeyAgreement.DHUWITHSHA1CKDF", "com.fis.ekyc.nfc.build_in.bouncycastle.jcajce.provider.asymmetric.dh.KeyAgreementSpi$DHUwithSHA1CKDF");
            configurableProvider.addAlgorithm("KeyAgreement.DHUWITHSHA224CKDF", "com.fis.ekyc.nfc.build_in.bouncycastle.jcajce.provider.asymmetric.dh.KeyAgreementSpi$DHUwithSHA224CKDF");
            configurableProvider.addAlgorithm("KeyAgreement.DHUWITHSHA256CKDF", "com.fis.ekyc.nfc.build_in.bouncycastle.jcajce.provider.asymmetric.dh.KeyAgreementSpi$DHUwithSHA256CKDF");
            configurableProvider.addAlgorithm("KeyAgreement.DHUWITHSHA384CKDF", "com.fis.ekyc.nfc.build_in.bouncycastle.jcajce.provider.asymmetric.dh.KeyAgreementSpi$DHUwithSHA384CKDF");
            configurableProvider.addAlgorithm("KeyAgreement.DHUWITHSHA512CKDF", "com.fis.ekyc.nfc.build_in.bouncycastle.jcajce.provider.asymmetric.dh.KeyAgreementSpi$DHUwithSHA512CKDF");
            configurableProvider.addAlgorithm("KeyAgreement.MQVWITHSHA1KDF", "com.fis.ekyc.nfc.build_in.bouncycastle.jcajce.provider.asymmetric.dh.KeyAgreementSpi$MQVwithSHA1KDF");
            configurableProvider.addAlgorithm("KeyAgreement.MQVWITHSHA224KDF", "com.fis.ekyc.nfc.build_in.bouncycastle.jcajce.provider.asymmetric.dh.KeyAgreementSpi$MQVwithSHA224KDF");
            configurableProvider.addAlgorithm("KeyAgreement.MQVWITHSHA256KDF", "com.fis.ekyc.nfc.build_in.bouncycastle.jcajce.provider.asymmetric.dh.KeyAgreementSpi$MQVwithSHA256KDF");
            configurableProvider.addAlgorithm("KeyAgreement.MQVWITHSHA384KDF", "com.fis.ekyc.nfc.build_in.bouncycastle.jcajce.provider.asymmetric.dh.KeyAgreementSpi$MQVwithSHA384KDF");
            configurableProvider.addAlgorithm("KeyAgreement.MQVWITHSHA512KDF", "com.fis.ekyc.nfc.build_in.bouncycastle.jcajce.provider.asymmetric.dh.KeyAgreementSpi$MQVwithSHA512KDF");
            configurableProvider.addAlgorithm("KeyAgreement.MQVWITHSHA1CKDF", "com.fis.ekyc.nfc.build_in.bouncycastle.jcajce.provider.asymmetric.dh.KeyAgreementSpi$MQVwithSHA1CKDF");
            configurableProvider.addAlgorithm("KeyAgreement.MQVWITHSHA224CKDF", "com.fis.ekyc.nfc.build_in.bouncycastle.jcajce.provider.asymmetric.dh.KeyAgreementSpi$MQVwithSHA224CKDF");
            configurableProvider.addAlgorithm("KeyAgreement.MQVWITHSHA256CKDF", "com.fis.ekyc.nfc.build_in.bouncycastle.jcajce.provider.asymmetric.dh.KeyAgreementSpi$MQVwithSHA256CKDF");
            configurableProvider.addAlgorithm("KeyAgreement.MQVWITHSHA384CKDF", "com.fis.ekyc.nfc.build_in.bouncycastle.jcajce.provider.asymmetric.dh.KeyAgreementSpi$MQVwithSHA384CKDF");
            configurableProvider.addAlgorithm("KeyAgreement.MQVWITHSHA512CKDF", "com.fis.ekyc.nfc.build_in.bouncycastle.jcajce.provider.asymmetric.dh.KeyAgreementSpi$MQVwithSHA512CKDF");
            registerOid(configurableProvider, PKCSObjectIdentifiers.dhKeyAgreement, "DH", new KeyFactorySpi());
            registerOid(configurableProvider, X9ObjectIdentifiers.dhpublicnumber, "DH", new KeyFactorySpi());
        }
    }

    static {
        HashMap hashMap = new HashMap();
        generalDhAttributes = hashMap;
        hashMap.put("SupportedKeyClasses", "javax.crypto.interfaces.DHPublicKey|javax.crypto.interfaces.DHPrivateKey");
        hashMap.put("SupportedKeyFormats", "PKCS#8|X.509");
    }
}
