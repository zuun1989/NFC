package com.fis.ekyc.nfc.build_in.bouncycastle.jcajce.provider.digest;

import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.pkcs.PKCSObjectIdentifiers;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.CipherKeyGenerator;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.digests.MD2Digest;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.macs.HMac;
import com.fis.ekyc.nfc.build_in.bouncycastle.jcajce.provider.config.ConfigurableProvider;
import com.fis.ekyc.nfc.build_in.bouncycastle.jcajce.provider.symmetric.util.BaseKeyGenerator;
import com.fis.ekyc.nfc.build_in.bouncycastle.jcajce.provider.symmetric.util.BaseMac;

public class MD2 {

    public static class Digest extends BCMessageDigest implements Cloneable {
        public Digest() {
            super(new MD2Digest());
        }

        public Object clone() throws CloneNotSupportedException {
            Digest digest = (Digest) super.clone();
            digest.digest = new MD2Digest((MD2Digest) this.digest);
            return digest;
        }
    }

    public static class HashMac extends BaseMac {
        public HashMac() {
            super(new HMac(new MD2Digest()));
        }
    }

    public static class KeyGenerator extends BaseKeyGenerator {
        public KeyGenerator() {
            super("HMACMD2", 128, new CipherKeyGenerator());
        }
    }

    public static class Mappings extends DigestAlgorithmProvider {
        private static final String PREFIX = MD2.class.getName();

        public void configure(ConfigurableProvider configurableProvider) {
            StringBuilder sb2 = new StringBuilder();
            String str = PREFIX;
            sb2.append(str);
            sb2.append("$Digest");
            configurableProvider.addAlgorithm("MessageDigest.MD2", sb2.toString());
            configurableProvider.addAlgorithm("Alg.Alias.MessageDigest." + PKCSObjectIdentifiers.md2, "MD2");
            addHMACAlgorithm(configurableProvider, "MD2", str + "$HashMac", str + "$KeyGenerator");
        }
    }

    private MD2() {
    }
}
