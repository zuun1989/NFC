package com.fis.ekyc.nfc.build_in.bouncycastle.jcajce.provider.symmetric;

import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.CipherKeyGenerator;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.engines.Grain128Engine;
import com.fis.ekyc.nfc.build_in.bouncycastle.jcajce.provider.config.ConfigurableProvider;
import com.fis.ekyc.nfc.build_in.bouncycastle.jcajce.provider.symmetric.util.BaseKeyGenerator;
import com.fis.ekyc.nfc.build_in.bouncycastle.jcajce.provider.symmetric.util.BaseStreamCipher;
import com.fis.ekyc.nfc.build_in.bouncycastle.jcajce.provider.util.AlgorithmProvider;

public final class Grain128 {

    public static class Base extends BaseStreamCipher {
        public Base() {
            super(new Grain128Engine(), 12);
        }
    }

    public static class KeyGen extends BaseKeyGenerator {
        public KeyGen() {
            super("Grain128", 128, new CipherKeyGenerator());
        }
    }

    public static class Mappings extends AlgorithmProvider {
        private static final String PREFIX = Grain128.class.getName();

        public void configure(ConfigurableProvider configurableProvider) {
            StringBuilder sb2 = new StringBuilder();
            String str = PREFIX;
            sb2.append(str);
            sb2.append("$Base");
            configurableProvider.addAlgorithm("Cipher.Grain128", sb2.toString());
            configurableProvider.addAlgorithm("KeyGenerator.Grain128", str + "$KeyGen");
        }
    }

    private Grain128() {
    }
}
