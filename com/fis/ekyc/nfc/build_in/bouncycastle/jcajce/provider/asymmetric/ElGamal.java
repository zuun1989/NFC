package com.fis.ekyc.nfc.build_in.bouncycastle.jcajce.provider.asymmetric;

import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1ObjectIdentifier;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.oiw.OIWObjectIdentifiers;
import com.fis.ekyc.nfc.build_in.bouncycastle.jcajce.provider.asymmetric.elgamal.KeyFactorySpi;
import com.fis.ekyc.nfc.build_in.bouncycastle.jcajce.provider.config.ConfigurableProvider;
import com.fis.ekyc.nfc.build_in.bouncycastle.jcajce.provider.util.AsymmetricAlgorithmProvider;

public class ElGamal {
    private static final String PREFIX = "com.fis.ekyc.nfc.build_in.bouncycastle.jcajce.provider.asymmetric.elgamal.";

    public static class Mappings extends AsymmetricAlgorithmProvider {
        public void configure(ConfigurableProvider configurableProvider) {
            configurableProvider.addAlgorithm("AlgorithmParameterGenerator.ELGAMAL", "com.fis.ekyc.nfc.build_in.bouncycastle.jcajce.provider.asymmetric.elgamal.AlgorithmParameterGeneratorSpi");
            configurableProvider.addAlgorithm("AlgorithmParameterGenerator.ElGamal", "com.fis.ekyc.nfc.build_in.bouncycastle.jcajce.provider.asymmetric.elgamal.AlgorithmParameterGeneratorSpi");
            configurableProvider.addAlgorithm("AlgorithmParameters.ELGAMAL", "com.fis.ekyc.nfc.build_in.bouncycastle.jcajce.provider.asymmetric.elgamal.AlgorithmParametersSpi");
            configurableProvider.addAlgorithm("AlgorithmParameters.ElGamal", "com.fis.ekyc.nfc.build_in.bouncycastle.jcajce.provider.asymmetric.elgamal.AlgorithmParametersSpi");
            configurableProvider.addAlgorithm("Cipher.ELGAMAL", "com.fis.ekyc.nfc.build_in.bouncycastle.jcajce.provider.asymmetric.elgamal.CipherSpi$NoPadding");
            configurableProvider.addAlgorithm("Cipher.ElGamal", "com.fis.ekyc.nfc.build_in.bouncycastle.jcajce.provider.asymmetric.elgamal.CipherSpi$NoPadding");
            configurableProvider.addAlgorithm("Alg.Alias.Cipher.ELGAMAL/ECB/PKCS1PADDING", "ELGAMAL/PKCS1");
            configurableProvider.addAlgorithm("Alg.Alias.Cipher.ELGAMAL/NONE/PKCS1PADDING", "ELGAMAL/PKCS1");
            configurableProvider.addAlgorithm("Alg.Alias.Cipher.ELGAMAL/NONE/NOPADDING", "ELGAMAL");
            configurableProvider.addAlgorithm("Cipher.ELGAMAL/PKCS1", "com.fis.ekyc.nfc.build_in.bouncycastle.jcajce.provider.asymmetric.elgamal.CipherSpi$PKCS1v1_5Padding");
            configurableProvider.addAlgorithm("KeyFactory.ELGAMAL", "com.fis.ekyc.nfc.build_in.bouncycastle.jcajce.provider.asymmetric.elgamal.KeyFactorySpi");
            configurableProvider.addAlgorithm("KeyFactory.ElGamal", "com.fis.ekyc.nfc.build_in.bouncycastle.jcajce.provider.asymmetric.elgamal.KeyFactorySpi");
            configurableProvider.addAlgorithm("KeyPairGenerator.ELGAMAL", "com.fis.ekyc.nfc.build_in.bouncycastle.jcajce.provider.asymmetric.elgamal.KeyPairGeneratorSpi");
            configurableProvider.addAlgorithm("KeyPairGenerator.ElGamal", "com.fis.ekyc.nfc.build_in.bouncycastle.jcajce.provider.asymmetric.elgamal.KeyPairGeneratorSpi");
            KeyFactorySpi keyFactorySpi = new KeyFactorySpi();
            ASN1ObjectIdentifier aSN1ObjectIdentifier = OIWObjectIdentifiers.elGamalAlgorithm;
            registerOid(configurableProvider, aSN1ObjectIdentifier, "ELGAMAL", keyFactorySpi);
            registerOidAlgorithmParameterGenerator(configurableProvider, aSN1ObjectIdentifier, "ELGAMAL");
        }
    }
}
