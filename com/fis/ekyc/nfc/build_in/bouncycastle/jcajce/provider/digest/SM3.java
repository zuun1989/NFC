package com.fis.ekyc.nfc.build_in.bouncycastle.jcajce.provider.digest;

import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.gm.GMObjectIdentifiers;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.CipherKeyGenerator;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.digests.SM3Digest;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.macs.HMac;
import com.fis.ekyc.nfc.build_in.bouncycastle.jcajce.provider.config.ConfigurableProvider;
import com.fis.ekyc.nfc.build_in.bouncycastle.jcajce.provider.symmetric.util.BaseKeyGenerator;
import com.fis.ekyc.nfc.build_in.bouncycastle.jcajce.provider.symmetric.util.BaseMac;

public class SM3 {

    public static class Digest extends BCMessageDigest implements Cloneable {
        public Digest() {
            super(new SM3Digest());
        }

        public Object clone() throws CloneNotSupportedException {
            Digest digest = (Digest) super.clone();
            digest.digest = new SM3Digest((SM3Digest) this.digest);
            return digest;
        }
    }

    public static class HashMac extends BaseMac {
        public HashMac() {
            super(new HMac(new SM3Digest()));
        }
    }

    public static class KeyGenerator extends BaseKeyGenerator {
        public KeyGenerator() {
            super("HMACSM3", 256, new CipherKeyGenerator());
        }
    }

    public static class Mappings extends DigestAlgorithmProvider {
        private static final String PREFIX = SM3.class.getName();

        public void configure(ConfigurableProvider configurableProvider) {
            StringBuilder sb2 = new StringBuilder();
            String str = PREFIX;
            sb2.append(str);
            sb2.append("$Digest");
            configurableProvider.addAlgorithm("MessageDigest.SM3", sb2.toString());
            configurableProvider.addAlgorithm("Alg.Alias.MessageDigest.SM3", "SM3");
            configurableProvider.addAlgorithm("Alg.Alias.MessageDigest.1.2.156.197.1.401", "SM3");
            configurableProvider.addAlgorithm("Alg.Alias.MessageDigest." + GMObjectIdentifiers.sm3, "SM3");
            addHMACAlgorithm(configurableProvider, "SM3", str + "$HashMac", str + "$KeyGenerator");
            addHMACAlias(configurableProvider, "SM3", GMObjectIdentifiers.hmac_sm3);
        }
    }

    private SM3() {
    }
}
