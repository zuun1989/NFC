package com.fis.ekyc.nfc.build_in.bouncycastle.jcajce.provider.symmetric;

import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.BlockCipher;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.BufferedBlockCipher;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.CipherKeyGenerator;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.CryptoServicesRegistrar;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.engines.RC6Engine;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.generators.Poly1305KeyGenerator;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.macs.GMac;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.modes.CBCBlockCipher;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.modes.CFBBlockCipher;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.modes.GCMBlockCipher;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.modes.OFBBlockCipher;
import com.fis.ekyc.nfc.build_in.bouncycastle.jcajce.provider.config.ConfigurableProvider;
import com.fis.ekyc.nfc.build_in.bouncycastle.jcajce.provider.symmetric.util.BaseAlgorithmParameterGenerator;
import com.fis.ekyc.nfc.build_in.bouncycastle.jcajce.provider.symmetric.util.BaseBlockCipher;
import com.fis.ekyc.nfc.build_in.bouncycastle.jcajce.provider.symmetric.util.BaseKeyGenerator;
import com.fis.ekyc.nfc.build_in.bouncycastle.jcajce.provider.symmetric.util.BaseMac;
import com.fis.ekyc.nfc.build_in.bouncycastle.jcajce.provider.symmetric.util.BlockCipherProvider;
import com.fis.ekyc.nfc.build_in.bouncycastle.jcajce.provider.symmetric.util.IvAlgorithmParameters;
import java.security.AlgorithmParameters;
import java.security.InvalidAlgorithmParameterException;
import java.security.SecureRandom;
import java.security.spec.AlgorithmParameterSpec;
import javax.crypto.spec.IvParameterSpec;

public final class RC6 {

    public static class AlgParamGen extends BaseAlgorithmParameterGenerator {
        public AlgorithmParameters engineGenerateParameters() {
            byte[] bArr = new byte[16];
            if (this.random == null) {
                this.random = CryptoServicesRegistrar.getSecureRandom();
            }
            this.random.nextBytes(bArr);
            try {
                AlgorithmParameters createParametersInstance = createParametersInstance("RC6");
                createParametersInstance.init(new IvParameterSpec(bArr));
                return createParametersInstance;
            } catch (Exception e) {
                throw new RuntimeException(e.getMessage());
            }
        }

        public void engineInit(AlgorithmParameterSpec algorithmParameterSpec, SecureRandom secureRandom) throws InvalidAlgorithmParameterException {
            throw new InvalidAlgorithmParameterException("No supported AlgorithmParameterSpec for RC6 parameter generation.");
        }
    }

    public static class AlgParams extends IvAlgorithmParameters {
        public String engineToString() {
            return "RC6 IV";
        }
    }

    public static class CBC extends BaseBlockCipher {
        public CBC() {
            super((BlockCipher) new CBCBlockCipher(new RC6Engine()), 128);
        }
    }

    public static class CFB extends BaseBlockCipher {
        public CFB() {
            super(new BufferedBlockCipher(new CFBBlockCipher(new RC6Engine(), 128)), 128);
        }
    }

    public static class ECB extends BaseBlockCipher {
        public ECB() {
            super((BlockCipherProvider) new BlockCipherProvider() {
                public BlockCipher get() {
                    return new RC6Engine();
                }
            });
        }
    }

    public static class GMAC extends BaseMac {
        public GMAC() {
            super(new GMac(new GCMBlockCipher(new RC6Engine())));
        }
    }

    public static class KeyGen extends BaseKeyGenerator {
        public KeyGen() {
            super("RC6", 256, new CipherKeyGenerator());
        }
    }

    public static class Mappings extends SymmetricAlgorithmProvider {
        private static final String PREFIX = RC6.class.getName();

        public void configure(ConfigurableProvider configurableProvider) {
            StringBuilder sb2 = new StringBuilder();
            String str = PREFIX;
            sb2.append(str);
            sb2.append("$ECB");
            configurableProvider.addAlgorithm("Cipher.RC6", sb2.toString());
            configurableProvider.addAlgorithm("KeyGenerator.RC6", str + "$KeyGen");
            configurableProvider.addAlgorithm("AlgorithmParameters.RC6", str + "$AlgParams");
            addGMacAlgorithm(configurableProvider, "RC6", str + "$GMAC", str + "$KeyGen");
            addPoly1305Algorithm(configurableProvider, "RC6", str + "$Poly1305", str + "$Poly1305KeyGen");
        }
    }

    public static class OFB extends BaseBlockCipher {
        public OFB() {
            super(new BufferedBlockCipher(new OFBBlockCipher(new RC6Engine(), 128)), 128);
        }
    }

    public static class Poly1305 extends BaseMac {
        public Poly1305() {
            super(new com.fis.ekyc.nfc.build_in.bouncycastle.crypto.macs.Poly1305(new RC6Engine()));
        }
    }

    public static class Poly1305KeyGen extends BaseKeyGenerator {
        public Poly1305KeyGen() {
            super("Poly1305-RC6", 256, new Poly1305KeyGenerator());
        }
    }

    private RC6() {
    }
}
