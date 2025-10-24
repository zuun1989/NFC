package com.fis.ekyc.nfc.build_in.bouncycastle.jcajce.provider.symmetric;

import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.CipherKeyGenerator;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.engines.HC128Engine;
import com.fis.ekyc.nfc.build_in.bouncycastle.jcajce.provider.config.ConfigurableProvider;
import com.fis.ekyc.nfc.build_in.bouncycastle.jcajce.provider.symmetric.util.BaseKeyGenerator;
import com.fis.ekyc.nfc.build_in.bouncycastle.jcajce.provider.symmetric.util.BaseStreamCipher;
import com.fis.ekyc.nfc.build_in.bouncycastle.jcajce.provider.symmetric.util.IvAlgorithmParameters;
import com.fis.ekyc.nfc.build_in.bouncycastle.jcajce.provider.util.AlgorithmProvider;

public final class HC128 {

    public static class AlgParams extends IvAlgorithmParameters {
        public String engineToString() {
            return "HC128 IV";
        }
    }

    public static class Base extends BaseStreamCipher {
        public Base() {
            super(new HC128Engine(), 16);
        }
    }

    public static class KeyGen extends BaseKeyGenerator {
        public KeyGen() {
            super("HC128", 128, new CipherKeyGenerator());
        }
    }

    public static class Mappings extends AlgorithmProvider {
        private static final String PREFIX = HC128.class.getName();

        public void configure(ConfigurableProvider configurableProvider) {
            StringBuilder sb2 = new StringBuilder();
            String str = PREFIX;
            sb2.append(str);
            sb2.append("$Base");
            configurableProvider.addAlgorithm("Cipher.HC128", sb2.toString());
            configurableProvider.addAlgorithm("KeyGenerator.HC128", str + "$KeyGen");
            configurableProvider.addAlgorithm("AlgorithmParameters.HC128", str + "$AlgParams");
        }
    }

    private HC128() {
    }
}
