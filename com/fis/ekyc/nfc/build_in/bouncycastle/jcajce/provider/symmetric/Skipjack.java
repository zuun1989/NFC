package com.fis.ekyc.nfc.build_in.bouncycastle.jcajce.provider.symmetric;

import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.BlockCipher;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.CipherKeyGenerator;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.engines.SkipjackEngine;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.macs.CBCBlockCipherMac;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.macs.CFBBlockCipherMac;
import com.fis.ekyc.nfc.build_in.bouncycastle.jcajce.provider.config.ConfigurableProvider;
import com.fis.ekyc.nfc.build_in.bouncycastle.jcajce.provider.symmetric.util.BaseBlockCipher;
import com.fis.ekyc.nfc.build_in.bouncycastle.jcajce.provider.symmetric.util.BaseKeyGenerator;
import com.fis.ekyc.nfc.build_in.bouncycastle.jcajce.provider.symmetric.util.BaseMac;
import com.fis.ekyc.nfc.build_in.bouncycastle.jcajce.provider.symmetric.util.IvAlgorithmParameters;
import com.fis.ekyc.nfc.build_in.bouncycastle.jcajce.provider.util.AlgorithmProvider;

public final class Skipjack {

    public static class AlgParams extends IvAlgorithmParameters {
        public String engineToString() {
            return "Skipjack IV";
        }
    }

    public static class ECB extends BaseBlockCipher {
        public ECB() {
            super((BlockCipher) new SkipjackEngine());
        }
    }

    public static class KeyGen extends BaseKeyGenerator {
        public KeyGen() {
            super("Skipjack", 80, new CipherKeyGenerator());
        }
    }

    public static class Mac extends BaseMac {
        public Mac() {
            super(new CBCBlockCipherMac(new SkipjackEngine()));
        }
    }

    public static class MacCFB8 extends BaseMac {
        public MacCFB8() {
            super(new CFBBlockCipherMac(new SkipjackEngine()));
        }
    }

    public static class Mappings extends AlgorithmProvider {
        private static final String PREFIX = Skipjack.class.getName();

        public void configure(ConfigurableProvider configurableProvider) {
            StringBuilder sb2 = new StringBuilder();
            String str = PREFIX;
            sb2.append(str);
            sb2.append("$ECB");
            configurableProvider.addAlgorithm("Cipher.SKIPJACK", sb2.toString());
            configurableProvider.addAlgorithm("KeyGenerator.SKIPJACK", str + "$KeyGen");
            configurableProvider.addAlgorithm("AlgorithmParameters.SKIPJACK", str + "$AlgParams");
            configurableProvider.addAlgorithm("Mac.SKIPJACKMAC", str + "$Mac");
            configurableProvider.addAlgorithm("Alg.Alias.Mac.SKIPJACK", "SKIPJACKMAC");
            configurableProvider.addAlgorithm("Mac.SKIPJACKMAC/CFB8", str + "$MacCFB8");
            configurableProvider.addAlgorithm("Alg.Alias.Mac.SKIPJACK/CFB8", "SKIPJACKMAC/CFB8");
        }
    }

    private Skipjack() {
    }
}
