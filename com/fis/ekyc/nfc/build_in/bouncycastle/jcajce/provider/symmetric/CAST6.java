package com.fis.ekyc.nfc.build_in.bouncycastle.jcajce.provider.symmetric;

import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.BlockCipher;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.CipherKeyGenerator;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.engines.CAST6Engine;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.generators.Poly1305KeyGenerator;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.macs.GMac;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.modes.GCMBlockCipher;
import com.fis.ekyc.nfc.build_in.bouncycastle.jcajce.provider.config.ConfigurableProvider;
import com.fis.ekyc.nfc.build_in.bouncycastle.jcajce.provider.symmetric.util.BaseBlockCipher;
import com.fis.ekyc.nfc.build_in.bouncycastle.jcajce.provider.symmetric.util.BaseKeyGenerator;
import com.fis.ekyc.nfc.build_in.bouncycastle.jcajce.provider.symmetric.util.BaseMac;
import com.fis.ekyc.nfc.build_in.bouncycastle.jcajce.provider.symmetric.util.BlockCipherProvider;
import com.fis.ekyc.nfc.build_in.bouncycastle.jcajce.provider.symmetric.util.IvAlgorithmParameters;

public final class CAST6 {

    public static class AlgParams extends IvAlgorithmParameters {
        public String engineToString() {
            return "CAST6 IV";
        }
    }

    public static class ECB extends BaseBlockCipher {
        public ECB() {
            super((BlockCipherProvider) new BlockCipherProvider() {
                public BlockCipher get() {
                    return new CAST6Engine();
                }
            });
        }
    }

    public static class GMAC extends BaseMac {
        public GMAC() {
            super(new GMac(new GCMBlockCipher(new CAST6Engine())));
        }
    }

    public static class KeyGen extends BaseKeyGenerator {
        public KeyGen() {
            super("CAST6", 256, new CipherKeyGenerator());
        }
    }

    public static class Mappings extends SymmetricAlgorithmProvider {
        private static final String PREFIX = CAST6.class.getName();

        public void configure(ConfigurableProvider configurableProvider) {
            StringBuilder sb2 = new StringBuilder();
            String str = PREFIX;
            sb2.append(str);
            sb2.append("$ECB");
            configurableProvider.addAlgorithm("Cipher.CAST6", sb2.toString());
            configurableProvider.addAlgorithm("KeyGenerator.CAST6", str + "$KeyGen");
            configurableProvider.addAlgorithm("AlgorithmParameters.CAST6", str + "$AlgParams");
            addGMacAlgorithm(configurableProvider, "CAST6", str + "$GMAC", str + "$KeyGen");
            addPoly1305Algorithm(configurableProvider, "CAST6", str + "$Poly1305", str + "$Poly1305KeyGen");
        }
    }

    public static class Poly1305 extends BaseMac {
        public Poly1305() {
            super(new com.fis.ekyc.nfc.build_in.bouncycastle.crypto.macs.Poly1305(new CAST6Engine()));
        }
    }

    public static class Poly1305KeyGen extends BaseKeyGenerator {
        public Poly1305KeyGen() {
            super("Poly1305-CAST6", 256, new Poly1305KeyGenerator());
        }
    }

    private CAST6() {
    }
}
