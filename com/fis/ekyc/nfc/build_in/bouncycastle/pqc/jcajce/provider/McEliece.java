package com.fis.ekyc.nfc.build_in.bouncycastle.pqc.jcajce.provider;

import com.fis.ekyc.nfc.build_in.bouncycastle.jcajce.provider.config.ConfigurableProvider;
import com.fis.ekyc.nfc.build_in.bouncycastle.jcajce.provider.util.AsymmetricAlgorithmProvider;
import com.fis.ekyc.nfc.build_in.bouncycastle.pqc.asn1.PQCObjectIdentifiers;

public class McEliece {
    private static final String PREFIX = "com.fis.ekyc.nfc.build_in.bouncycastle.pqc.jcajce.provider.mceliece.";

    public static class Mappings extends AsymmetricAlgorithmProvider {
        public void configure(ConfigurableProvider configurableProvider) {
            configurableProvider.addAlgorithm("KeyPairGenerator.McElieceKobaraImai", "com.fis.ekyc.nfc.build_in.bouncycastle.pqc.jcajce.provider.mceliece.McElieceCCA2KeyPairGeneratorSpi");
            configurableProvider.addAlgorithm("KeyPairGenerator.McEliecePointcheval", "com.fis.ekyc.nfc.build_in.bouncycastle.pqc.jcajce.provider.mceliece.McElieceCCA2KeyPairGeneratorSpi");
            configurableProvider.addAlgorithm("KeyPairGenerator.McElieceFujisaki", "com.fis.ekyc.nfc.build_in.bouncycastle.pqc.jcajce.provider.mceliece.McElieceCCA2KeyPairGeneratorSpi");
            configurableProvider.addAlgorithm("KeyPairGenerator.McEliece", "com.fis.ekyc.nfc.build_in.bouncycastle.pqc.jcajce.provider.mceliece.McElieceKeyPairGeneratorSpi");
            configurableProvider.addAlgorithm("KeyPairGenerator.McEliece-CCA2", "com.fis.ekyc.nfc.build_in.bouncycastle.pqc.jcajce.provider.mceliece.McElieceCCA2KeyPairGeneratorSpi");
            configurableProvider.addAlgorithm("KeyFactory.McElieceKobaraImai", "com.fis.ekyc.nfc.build_in.bouncycastle.pqc.jcajce.provider.mceliece.McElieceCCA2KeyFactorySpi");
            configurableProvider.addAlgorithm("KeyFactory.McEliecePointcheval", "com.fis.ekyc.nfc.build_in.bouncycastle.pqc.jcajce.provider.mceliece.McElieceCCA2KeyFactorySpi");
            configurableProvider.addAlgorithm("KeyFactory.McElieceFujisaki", "com.fis.ekyc.nfc.build_in.bouncycastle.pqc.jcajce.provider.mceliece.McElieceCCA2KeyFactorySpi");
            configurableProvider.addAlgorithm("KeyFactory.McEliece", "com.fis.ekyc.nfc.build_in.bouncycastle.pqc.jcajce.provider.mceliece.McElieceKeyFactorySpi");
            configurableProvider.addAlgorithm("KeyFactory.McEliece-CCA2", "com.fis.ekyc.nfc.build_in.bouncycastle.pqc.jcajce.provider.mceliece.McElieceCCA2KeyFactorySpi");
            configurableProvider.addAlgorithm("KeyFactory." + PQCObjectIdentifiers.mcElieceCca2, "com.fis.ekyc.nfc.build_in.bouncycastle.pqc.jcajce.provider.mceliece.McElieceCCA2KeyFactorySpi");
            configurableProvider.addAlgorithm("KeyFactory." + PQCObjectIdentifiers.mcEliece, "com.fis.ekyc.nfc.build_in.bouncycastle.pqc.jcajce.provider.mceliece.McElieceKeyFactorySpi");
            configurableProvider.addAlgorithm("Cipher.McEliece", "com.fis.ekyc.nfc.build_in.bouncycastle.pqc.jcajce.provider.mceliece.McEliecePKCSCipherSpi$McEliecePKCS");
            configurableProvider.addAlgorithm("Cipher.McEliecePointcheval", "com.fis.ekyc.nfc.build_in.bouncycastle.pqc.jcajce.provider.mceliece.McEliecePointchevalCipherSpi$McEliecePointcheval");
            configurableProvider.addAlgorithm("Cipher.McElieceKobaraImai", "com.fis.ekyc.nfc.build_in.bouncycastle.pqc.jcajce.provider.mceliece.McElieceKobaraImaiCipherSpi$McElieceKobaraImai");
            configurableProvider.addAlgorithm("Cipher.McElieceFujisaki", "com.fis.ekyc.nfc.build_in.bouncycastle.pqc.jcajce.provider.mceliece.McElieceFujisakiCipherSpi$McElieceFujisaki");
        }
    }
}
