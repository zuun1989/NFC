package com.fis.ekyc.nfc.build_in.bouncycastle.jcajce.provider.asymmetric;

import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1ObjectIdentifier;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.nist.NISTObjectIdentifiers;
import com.fis.ekyc.nfc.build_in.bouncycastle.jcajce.provider.asymmetric.dsa.DSAUtil;
import com.fis.ekyc.nfc.build_in.bouncycastle.jcajce.provider.asymmetric.dsa.KeyFactorySpi;
import com.fis.ekyc.nfc.build_in.bouncycastle.jcajce.provider.config.ConfigurableProvider;
import com.fis.ekyc.nfc.build_in.bouncycastle.jcajce.provider.util.AsymmetricAlgorithmProvider;

public class DSA {
    private static final String PREFIX = "com.fis.ekyc.nfc.build_in.bouncycastle.jcajce.provider.asymmetric.dsa.";

    public static class Mappings extends AsymmetricAlgorithmProvider {
        public void configure(ConfigurableProvider configurableProvider) {
            configurableProvider.addAlgorithm("AlgorithmParameters.DSA", "com.fis.ekyc.nfc.build_in.bouncycastle.jcajce.provider.asymmetric.dsa.AlgorithmParametersSpi");
            configurableProvider.addAlgorithm("AlgorithmParameterGenerator.DSA", "com.fis.ekyc.nfc.build_in.bouncycastle.jcajce.provider.asymmetric.dsa.AlgorithmParameterGeneratorSpi");
            configurableProvider.addAlgorithm("KeyPairGenerator.DSA", "com.fis.ekyc.nfc.build_in.bouncycastle.jcajce.provider.asymmetric.dsa.KeyPairGeneratorSpi");
            configurableProvider.addAlgorithm("KeyFactory.DSA", "com.fis.ekyc.nfc.build_in.bouncycastle.jcajce.provider.asymmetric.dsa.KeyFactorySpi");
            configurableProvider.addAlgorithm("Signature.DSA", "com.fis.ekyc.nfc.build_in.bouncycastle.jcajce.provider.asymmetric.dsa.DSASigner$stdDSA");
            configurableProvider.addAlgorithm("Signature.NONEWITHDSA", "com.fis.ekyc.nfc.build_in.bouncycastle.jcajce.provider.asymmetric.dsa.DSASigner$noneDSA");
            configurableProvider.addAlgorithm("Alg.Alias.Signature.RAWDSA", "NONEWITHDSA");
            configurableProvider.addAlgorithm("Signature.DETDSA", "com.fis.ekyc.nfc.build_in.bouncycastle.jcajce.provider.asymmetric.dsa.DSASigner$detDSA");
            configurableProvider.addAlgorithm("Signature.SHA1WITHDETDSA", "com.fis.ekyc.nfc.build_in.bouncycastle.jcajce.provider.asymmetric.dsa.DSASigner$detDSA");
            configurableProvider.addAlgorithm("Signature.SHA224WITHDETDSA", "com.fis.ekyc.nfc.build_in.bouncycastle.jcajce.provider.asymmetric.dsa.DSASigner$detDSA224");
            configurableProvider.addAlgorithm("Signature.SHA256WITHDETDSA", "com.fis.ekyc.nfc.build_in.bouncycastle.jcajce.provider.asymmetric.dsa.DSASigner$detDSA256");
            configurableProvider.addAlgorithm("Signature.SHA384WITHDETDSA", "com.fis.ekyc.nfc.build_in.bouncycastle.jcajce.provider.asymmetric.dsa.DSASigner$detDSA384");
            configurableProvider.addAlgorithm("Signature.SHA512WITHDETDSA", "com.fis.ekyc.nfc.build_in.bouncycastle.jcajce.provider.asymmetric.dsa.DSASigner$detDSA512");
            configurableProvider.addAlgorithm("Signature.DDSA", "com.fis.ekyc.nfc.build_in.bouncycastle.jcajce.provider.asymmetric.dsa.DSASigner$detDSA");
            configurableProvider.addAlgorithm("Signature.SHA1WITHDDSA", "com.fis.ekyc.nfc.build_in.bouncycastle.jcajce.provider.asymmetric.dsa.DSASigner$detDSA");
            configurableProvider.addAlgorithm("Signature.SHA224WITHDDSA", "com.fis.ekyc.nfc.build_in.bouncycastle.jcajce.provider.asymmetric.dsa.DSASigner$detDSA224");
            configurableProvider.addAlgorithm("Signature.SHA256WITHDDSA", "com.fis.ekyc.nfc.build_in.bouncycastle.jcajce.provider.asymmetric.dsa.DSASigner$detDSA256");
            configurableProvider.addAlgorithm("Signature.SHA384WITHDDSA", "com.fis.ekyc.nfc.build_in.bouncycastle.jcajce.provider.asymmetric.dsa.DSASigner$detDSA384");
            configurableProvider.addAlgorithm("Signature.SHA512WITHDDSA", "com.fis.ekyc.nfc.build_in.bouncycastle.jcajce.provider.asymmetric.dsa.DSASigner$detDSA512");
            configurableProvider.addAlgorithm("Signature.SHA3-224WITHDDSA", "com.fis.ekyc.nfc.build_in.bouncycastle.jcajce.provider.asymmetric.dsa.DSASigner$detDSASha3_224");
            configurableProvider.addAlgorithm("Signature.SHA3-256WITHDDSA", "com.fis.ekyc.nfc.build_in.bouncycastle.jcajce.provider.asymmetric.dsa.DSASigner$detDSASha3_256");
            configurableProvider.addAlgorithm("Signature.SHA3-384WITHDDSA", "com.fis.ekyc.nfc.build_in.bouncycastle.jcajce.provider.asymmetric.dsa.DSASigner$detDSASha3_384");
            configurableProvider.addAlgorithm("Signature.SHA3-512WITHDDSA", "com.fis.ekyc.nfc.build_in.bouncycastle.jcajce.provider.asymmetric.dsa.DSASigner$detDSASha3_512");
            addSignatureAlgorithm(configurableProvider, "SHA224", "DSA", "com.fis.ekyc.nfc.build_in.bouncycastle.jcajce.provider.asymmetric.dsa.DSASigner$dsa224", NISTObjectIdentifiers.dsa_with_sha224);
            addSignatureAlgorithm(configurableProvider, "SHA256", "DSA", "com.fis.ekyc.nfc.build_in.bouncycastle.jcajce.provider.asymmetric.dsa.DSASigner$dsa256", NISTObjectIdentifiers.dsa_with_sha256);
            ConfigurableProvider configurableProvider2 = configurableProvider;
            addSignatureAlgorithm(configurableProvider2, "SHA384", "DSA", "com.fis.ekyc.nfc.build_in.bouncycastle.jcajce.provider.asymmetric.dsa.DSASigner$dsa384", NISTObjectIdentifiers.dsa_with_sha384);
            ConfigurableProvider configurableProvider3 = configurableProvider;
            addSignatureAlgorithm(configurableProvider3, "SHA512", "DSA", "com.fis.ekyc.nfc.build_in.bouncycastle.jcajce.provider.asymmetric.dsa.DSASigner$dsa512", NISTObjectIdentifiers.dsa_with_sha512);
            addSignatureAlgorithm(configurableProvider2, "SHA3-224", "DSA", "com.fis.ekyc.nfc.build_in.bouncycastle.jcajce.provider.asymmetric.dsa.DSASigner$dsaSha3_224", NISTObjectIdentifiers.id_dsa_with_sha3_224);
            addSignatureAlgorithm(configurableProvider3, "SHA3-256", "DSA", "com.fis.ekyc.nfc.build_in.bouncycastle.jcajce.provider.asymmetric.dsa.DSASigner$dsaSha3_256", NISTObjectIdentifiers.id_dsa_with_sha3_256);
            addSignatureAlgorithm(configurableProvider2, "SHA3-384", "DSA", "com.fis.ekyc.nfc.build_in.bouncycastle.jcajce.provider.asymmetric.dsa.DSASigner$dsaSha3_384", NISTObjectIdentifiers.id_dsa_with_sha3_384);
            addSignatureAlgorithm(configurableProvider3, "SHA3-512", "DSA", "com.fis.ekyc.nfc.build_in.bouncycastle.jcajce.provider.asymmetric.dsa.DSASigner$dsaSha3_512", NISTObjectIdentifiers.id_dsa_with_sha3_512);
            configurableProvider.addAlgorithm("Alg.Alias.Signature.SHA/DSA", "DSA");
            configurableProvider.addAlgorithm("Alg.Alias.Signature.SHA1withDSA", "DSA");
            configurableProvider.addAlgorithm("Alg.Alias.Signature.SHA1WITHDSA", "DSA");
            configurableProvider.addAlgorithm("Alg.Alias.Signature.1.3.14.3.2.26with1.2.840.10040.4.1", "DSA");
            configurableProvider.addAlgorithm("Alg.Alias.Signature.1.3.14.3.2.26with1.2.840.10040.4.3", "DSA");
            configurableProvider.addAlgorithm("Alg.Alias.Signature.DSAwithSHA1", "DSA");
            configurableProvider.addAlgorithm("Alg.Alias.Signature.DSAWITHSHA1", "DSA");
            configurableProvider.addAlgorithm("Alg.Alias.Signature.SHA1WithDSA", "DSA");
            configurableProvider.addAlgorithm("Alg.Alias.Signature.DSAWithSHA1", "DSA");
            KeyFactorySpi keyFactorySpi = new KeyFactorySpi();
            int i = 0;
            while (true) {
                ASN1ObjectIdentifier[] aSN1ObjectIdentifierArr = DSAUtil.dsaOids;
                if (i != aSN1ObjectIdentifierArr.length) {
                    configurableProvider.addAlgorithm("Alg.Alias.Signature." + aSN1ObjectIdentifierArr[i], "DSA");
                    registerOid(configurableProvider, aSN1ObjectIdentifierArr[i], "DSA", keyFactorySpi);
                    registerOidAlgorithmParameterGenerator(configurableProvider, aSN1ObjectIdentifierArr[i], "DSA");
                    i++;
                } else {
                    return;
                }
            }
        }
    }
}
