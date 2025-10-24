package com.fis.ekyc.nfc.build_in.bouncycastle.jcajce.provider.symmetric;

import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1ObjectIdentifier;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.pkcs.PKCSObjectIdentifiers;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.CipherKeyGenerator;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.engines.ChaCha7539Engine;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.engines.ChaChaEngine;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.modes.AEADCipher;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.modes.ChaCha20Poly1305;
import com.fis.ekyc.nfc.build_in.bouncycastle.jcajce.provider.config.ConfigurableProvider;
import com.fis.ekyc.nfc.build_in.bouncycastle.jcajce.provider.symmetric.util.BaseBlockCipher;
import com.fis.ekyc.nfc.build_in.bouncycastle.jcajce.provider.symmetric.util.BaseKeyGenerator;
import com.fis.ekyc.nfc.build_in.bouncycastle.jcajce.provider.symmetric.util.BaseStreamCipher;
import com.fis.ekyc.nfc.build_in.bouncycastle.jcajce.provider.symmetric.util.IvAlgorithmParameters;
import com.fis.ekyc.nfc.build_in.bouncycastle.jcajce.provider.util.AlgorithmProvider;

public final class ChaCha {

    public static class AlgParams extends IvAlgorithmParameters {
        public String engineToString() {
            return "ChaCha7539 IV";
        }
    }

    public static class AlgParamsCC1305 extends IvAlgorithmParameters {
        public String engineToString() {
            return "ChaCha20-Poly1305 IV";
        }
    }

    public static class Base extends BaseStreamCipher {
        public Base() {
            super(new ChaChaEngine(), 8);
        }
    }

    public static class Base7539 extends BaseStreamCipher {
        public Base7539() {
            super(new ChaCha7539Engine(), 12);
        }
    }

    public static class BaseCC20P1305 extends BaseBlockCipher {
        public BaseCC20P1305() {
            super((AEADCipher) new ChaCha20Poly1305(), true, 12);
        }
    }

    public static class KeyGen extends BaseKeyGenerator {
        public KeyGen() {
            super("ChaCha", 128, new CipherKeyGenerator());
        }
    }

    public static class KeyGen7539 extends BaseKeyGenerator {
        public KeyGen7539() {
            super("ChaCha7539", 256, new CipherKeyGenerator());
        }
    }

    public static class Mappings extends AlgorithmProvider {
        private static final String PREFIX = ChaCha.class.getName();

        public void configure(ConfigurableProvider configurableProvider) {
            StringBuilder sb2 = new StringBuilder();
            String str = PREFIX;
            sb2.append(str);
            sb2.append("$Base");
            configurableProvider.addAlgorithm("Cipher.CHACHA", sb2.toString());
            configurableProvider.addAlgorithm("KeyGenerator.CHACHA", str + "$KeyGen");
            configurableProvider.addAlgorithm("Cipher.CHACHA7539", str + "$Base7539");
            configurableProvider.addAlgorithm("KeyGenerator.CHACHA7539", str + "$KeyGen7539");
            configurableProvider.addAlgorithm("AlgorithmParameters.CHACHA7539", str + "$AlgParams");
            configurableProvider.addAlgorithm("Alg.Alias.Cipher.CHACHA20", "CHACHA7539");
            configurableProvider.addAlgorithm("Alg.Alias.KeyGenerator.CHACHA20", "CHACHA7539");
            configurableProvider.addAlgorithm("Alg.Alias.AlgorithmParameters.CHACHA20", "CHACHA7539");
            configurableProvider.addAlgorithm("Alg.Alias.KeyGenerator.CHACHA20-POLY1305", "CHACHA7539");
            StringBuilder sb3 = new StringBuilder();
            sb3.append("Alg.Alias.KeyGenerator.");
            ASN1ObjectIdentifier aSN1ObjectIdentifier = PKCSObjectIdentifiers.id_alg_AEADChaCha20Poly1305;
            sb3.append(aSN1ObjectIdentifier);
            configurableProvider.addAlgorithm(sb3.toString(), "CHACHA7539");
            configurableProvider.addAlgorithm("Cipher.CHACHA20-POLY1305", str + "$BaseCC20P1305");
            configurableProvider.addAlgorithm("AlgorithmParameters.CHACHA20-POLY1305", str + "$AlgParamsCC1305");
            configurableProvider.addAlgorithm("Alg.Alias.Cipher." + aSN1ObjectIdentifier, "CHACHA20-POLY1305");
            configurableProvider.addAlgorithm("Alg.Alias.AlgorithmParameters." + aSN1ObjectIdentifier, "CHACHA20-POLY1305");
            configurableProvider.addAlgorithm("Alg.Alias.Cipher.OID." + aSN1ObjectIdentifier, "CHACHA20-POLY1305");
            configurableProvider.addAlgorithm("Alg.Alias.AlgorithmParameters.OID." + aSN1ObjectIdentifier, "CHACHA20-POLY1305");
        }
    }

    private ChaCha() {
    }
}
