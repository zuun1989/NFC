package com.fis.ekyc.nfc.build_in.bouncycastle.jcajce.provider.symmetric;

import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.BlockCipher;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.CipherKeyGenerator;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.CryptoServicesRegistrar;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.engines.RC532Engine;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.engines.RC564Engine;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.macs.CBCBlockCipherMac;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.macs.CFBBlockCipherMac;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.modes.CBCBlockCipher;
import com.fis.ekyc.nfc.build_in.bouncycastle.jcajce.provider.config.ConfigurableProvider;
import com.fis.ekyc.nfc.build_in.bouncycastle.jcajce.provider.symmetric.util.BaseAlgorithmParameterGenerator;
import com.fis.ekyc.nfc.build_in.bouncycastle.jcajce.provider.symmetric.util.BaseBlockCipher;
import com.fis.ekyc.nfc.build_in.bouncycastle.jcajce.provider.symmetric.util.BaseKeyGenerator;
import com.fis.ekyc.nfc.build_in.bouncycastle.jcajce.provider.symmetric.util.BaseMac;
import com.fis.ekyc.nfc.build_in.bouncycastle.jcajce.provider.symmetric.util.IvAlgorithmParameters;
import com.fis.ekyc.nfc.build_in.bouncycastle.jcajce.provider.util.AlgorithmProvider;
import java.security.AlgorithmParameters;
import java.security.InvalidAlgorithmParameterException;
import java.security.SecureRandom;
import java.security.spec.AlgorithmParameterSpec;
import javax.crypto.spec.IvParameterSpec;

public final class RC5 {

    public static class AlgParamGen extends BaseAlgorithmParameterGenerator {
        public AlgorithmParameters engineGenerateParameters() {
            byte[] bArr = new byte[8];
            if (this.random == null) {
                this.random = CryptoServicesRegistrar.getSecureRandom();
            }
            this.random.nextBytes(bArr);
            try {
                AlgorithmParameters createParametersInstance = createParametersInstance("RC5");
                createParametersInstance.init(new IvParameterSpec(bArr));
                return createParametersInstance;
            } catch (Exception e) {
                throw new RuntimeException(e.getMessage());
            }
        }

        public void engineInit(AlgorithmParameterSpec algorithmParameterSpec, SecureRandom secureRandom) throws InvalidAlgorithmParameterException {
            throw new InvalidAlgorithmParameterException("No supported AlgorithmParameterSpec for RC5 parameter generation.");
        }
    }

    public static class AlgParams extends IvAlgorithmParameters {
        public String engineToString() {
            return "RC5 IV";
        }
    }

    public static class CBC32 extends BaseBlockCipher {
        public CBC32() {
            super((BlockCipher) new CBCBlockCipher(new RC532Engine()), 64);
        }
    }

    public static class CFB8Mac32 extends BaseMac {
        public CFB8Mac32() {
            super(new CFBBlockCipherMac(new RC532Engine()));
        }
    }

    public static class ECB32 extends BaseBlockCipher {
        public ECB32() {
            super((BlockCipher) new RC532Engine());
        }
    }

    public static class ECB64 extends BaseBlockCipher {
        public ECB64() {
            super((BlockCipher) new RC564Engine());
        }
    }

    public static class KeyGen32 extends BaseKeyGenerator {
        public KeyGen32() {
            super("RC5", 128, new CipherKeyGenerator());
        }
    }

    public static class KeyGen64 extends BaseKeyGenerator {
        public KeyGen64() {
            super("RC5-64", 256, new CipherKeyGenerator());
        }
    }

    public static class Mac32 extends BaseMac {
        public Mac32() {
            super(new CBCBlockCipherMac(new RC532Engine()));
        }
    }

    public static class Mappings extends AlgorithmProvider {
        private static final String PREFIX = RC5.class.getName();

        public void configure(ConfigurableProvider configurableProvider) {
            StringBuilder sb2 = new StringBuilder();
            String str = PREFIX;
            sb2.append(str);
            sb2.append("$ECB32");
            configurableProvider.addAlgorithm("Cipher.RC5", sb2.toString());
            configurableProvider.addAlgorithm("Alg.Alias.Cipher.RC5-32", "RC5");
            configurableProvider.addAlgorithm("Cipher.RC5-64", str + "$ECB64");
            configurableProvider.addAlgorithm("KeyGenerator.RC5", str + "$KeyGen32");
            configurableProvider.addAlgorithm("Alg.Alias.KeyGenerator.RC5-32", "RC5");
            configurableProvider.addAlgorithm("KeyGenerator.RC5-64", str + "$KeyGen64");
            configurableProvider.addAlgorithm("AlgorithmParameters.RC5", str + "$AlgParams");
            configurableProvider.addAlgorithm("AlgorithmParameters.RC5-64", str + "$AlgParams");
            configurableProvider.addAlgorithm("Mac.RC5MAC", str + "$Mac32");
            configurableProvider.addAlgorithm("Alg.Alias.Mac.RC5", "RC5MAC");
            configurableProvider.addAlgorithm("Mac.RC5MAC/CFB8", str + "$CFB8Mac32");
            configurableProvider.addAlgorithm("Alg.Alias.Mac.RC5/CFB8", "RC5MAC/CFB8");
        }
    }

    private RC5() {
    }
}
