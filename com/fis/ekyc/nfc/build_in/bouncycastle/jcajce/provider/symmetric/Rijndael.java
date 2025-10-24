package com.fis.ekyc.nfc.build_in.bouncycastle.jcajce.provider.symmetric;

import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.eac.CertificateHolderAuthorization;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.BlockCipher;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.CipherKeyGenerator;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.engines.RijndaelEngine;
import com.fis.ekyc.nfc.build_in.bouncycastle.jcajce.provider.config.ConfigurableProvider;
import com.fis.ekyc.nfc.build_in.bouncycastle.jcajce.provider.symmetric.util.BaseBlockCipher;
import com.fis.ekyc.nfc.build_in.bouncycastle.jcajce.provider.symmetric.util.BaseKeyGenerator;
import com.fis.ekyc.nfc.build_in.bouncycastle.jcajce.provider.symmetric.util.BlockCipherProvider;
import com.fis.ekyc.nfc.build_in.bouncycastle.jcajce.provider.symmetric.util.IvAlgorithmParameters;
import com.fis.ekyc.nfc.build_in.bouncycastle.jcajce.provider.util.AlgorithmProvider;

public final class Rijndael {

    public static class AlgParams extends IvAlgorithmParameters {
        public String engineToString() {
            return "Rijndael IV";
        }
    }

    public static class ECB extends BaseBlockCipher {
        public ECB() {
            super((BlockCipherProvider) new BlockCipherProvider() {
                public BlockCipher get() {
                    return new RijndaelEngine();
                }
            });
        }
    }

    public static class KeyGen extends BaseKeyGenerator {
        public KeyGen() {
            super("Rijndael", CertificateHolderAuthorization.CVCA, new CipherKeyGenerator());
        }
    }

    public static class Mappings extends AlgorithmProvider {
        private static final String PREFIX = Rijndael.class.getName();

        public void configure(ConfigurableProvider configurableProvider) {
            StringBuilder sb2 = new StringBuilder();
            String str = PREFIX;
            sb2.append(str);
            sb2.append("$ECB");
            configurableProvider.addAlgorithm("Cipher.RIJNDAEL", sb2.toString());
            configurableProvider.addAlgorithm("KeyGenerator.RIJNDAEL", str + "$KeyGen");
            configurableProvider.addAlgorithm("AlgorithmParameters.RIJNDAEL", str + "$AlgParams");
        }
    }

    private Rijndael() {
    }
}
