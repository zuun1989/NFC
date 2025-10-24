package com.fis.ekyc.nfc.build_in.bouncycastle.jcajce.provider.symmetric;

import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1ObjectIdentifier;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.misc.IDEACBCPar;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.misc.MiscObjectIdentifiers;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.BlockCipher;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.CipherKeyGenerator;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.CryptoServicesRegistrar;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.engines.IDEAEngine;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.macs.CBCBlockCipherMac;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.macs.CFBBlockCipherMac;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.modes.CBCBlockCipher;
import com.fis.ekyc.nfc.build_in.bouncycastle.jcajce.provider.config.ConfigurableProvider;
import com.fis.ekyc.nfc.build_in.bouncycastle.jcajce.provider.symmetric.util.BaseAlgorithmParameterGenerator;
import com.fis.ekyc.nfc.build_in.bouncycastle.jcajce.provider.symmetric.util.BaseAlgorithmParameters;
import com.fis.ekyc.nfc.build_in.bouncycastle.jcajce.provider.symmetric.util.BaseBlockCipher;
import com.fis.ekyc.nfc.build_in.bouncycastle.jcajce.provider.symmetric.util.BaseKeyGenerator;
import com.fis.ekyc.nfc.build_in.bouncycastle.jcajce.provider.symmetric.util.BaseMac;
import com.fis.ekyc.nfc.build_in.bouncycastle.jcajce.provider.symmetric.util.PBESecretKeyFactory;
import com.fis.ekyc.nfc.build_in.bouncycastle.jcajce.provider.util.AlgorithmProvider;
import java.io.IOException;
import java.security.AlgorithmParameters;
import java.security.InvalidAlgorithmParameterException;
import java.security.SecureRandom;
import java.security.spec.AlgorithmParameterSpec;
import java.security.spec.InvalidParameterSpecException;
import javax.crypto.spec.IvParameterSpec;

public final class IDEA {

    public static class AlgParamGen extends BaseAlgorithmParameterGenerator {
        public AlgorithmParameters engineGenerateParameters() {
            byte[] bArr = new byte[8];
            if (this.random == null) {
                this.random = CryptoServicesRegistrar.getSecureRandom();
            }
            this.random.nextBytes(bArr);
            try {
                AlgorithmParameters createParametersInstance = createParametersInstance("IDEA");
                createParametersInstance.init(new IvParameterSpec(bArr));
                return createParametersInstance;
            } catch (Exception e) {
                throw new RuntimeException(e.getMessage());
            }
        }

        public void engineInit(AlgorithmParameterSpec algorithmParameterSpec, SecureRandom secureRandom) throws InvalidAlgorithmParameterException {
            throw new InvalidAlgorithmParameterException("No supported AlgorithmParameterSpec for IDEA parameter generation.");
        }
    }

    public static class AlgParams extends BaseAlgorithmParameters {
        private byte[] iv;

        public byte[] engineGetEncoded() throws IOException {
            return engineGetEncoded("ASN.1");
        }

        public void engineInit(AlgorithmParameterSpec algorithmParameterSpec) throws InvalidParameterSpecException {
            if (algorithmParameterSpec instanceof IvParameterSpec) {
                this.iv = ((IvParameterSpec) algorithmParameterSpec).getIV();
                return;
            }
            throw new InvalidParameterSpecException("IvParameterSpec required to initialise a IV parameters algorithm parameters object");
        }

        public String engineToString() {
            return "IDEA Parameters";
        }

        public AlgorithmParameterSpec localEngineGetParameterSpec(Class cls) throws InvalidParameterSpecException {
            if (cls == IvParameterSpec.class || cls == AlgorithmParameterSpec.class) {
                return new IvParameterSpec(this.iv);
            }
            throw new InvalidParameterSpecException("unknown parameter spec passed to IV parameters object.");
        }

        public byte[] engineGetEncoded(String str) throws IOException {
            if (isASN1FormatString(str)) {
                return new IDEACBCPar(engineGetEncoded("RAW")).getEncoded();
            }
            if (!str.equals("RAW")) {
                return null;
            }
            byte[] bArr = this.iv;
            byte[] bArr2 = new byte[bArr.length];
            System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
            return bArr2;
        }

        public void engineInit(byte[] bArr) throws IOException {
            byte[] bArr2 = new byte[bArr.length];
            this.iv = bArr2;
            System.arraycopy(bArr, 0, bArr2, 0, bArr2.length);
        }

        public void engineInit(byte[] bArr, String str) throws IOException {
            if (str.equals("RAW")) {
                engineInit(bArr);
            } else if (str.equals("ASN.1")) {
                engineInit(IDEACBCPar.getInstance(bArr).getIV());
            } else {
                throw new IOException("Unknown parameters format in IV parameters object");
            }
        }
    }

    public static class CBC extends BaseBlockCipher {
        public CBC() {
            super((BlockCipher) new CBCBlockCipher(new IDEAEngine()), 64);
        }
    }

    public static class CFB8Mac extends BaseMac {
        public CFB8Mac() {
            super(new CFBBlockCipherMac(new IDEAEngine()));
        }
    }

    public static class ECB extends BaseBlockCipher {
        public ECB() {
            super((BlockCipher) new IDEAEngine());
        }
    }

    public static class KeyGen extends BaseKeyGenerator {
        public KeyGen() {
            super("IDEA", 128, new CipherKeyGenerator());
        }
    }

    public static class Mac extends BaseMac {
        public Mac() {
            super(new CBCBlockCipherMac(new IDEAEngine()));
        }
    }

    public static class Mappings extends AlgorithmProvider {
        private static final String PREFIX = IDEA.class.getName();

        public void configure(ConfigurableProvider configurableProvider) {
            StringBuilder sb2 = new StringBuilder();
            String str = PREFIX;
            sb2.append(str);
            sb2.append("$AlgParamGen");
            configurableProvider.addAlgorithm("AlgorithmParameterGenerator.IDEA", sb2.toString());
            configurableProvider.addAlgorithm("AlgorithmParameterGenerator.1.3.6.1.4.1.188.7.1.1.2", str + "$AlgParamGen");
            configurableProvider.addAlgorithm("AlgorithmParameters.IDEA", str + "$AlgParams");
            configurableProvider.addAlgorithm("AlgorithmParameters.1.3.6.1.4.1.188.7.1.1.2", str + "$AlgParams");
            configurableProvider.addAlgorithm("Alg.Alias.AlgorithmParameters.PBEWITHSHAANDIDEA", "PKCS12PBE");
            configurableProvider.addAlgorithm("Alg.Alias.AlgorithmParameters.PBEWITHSHAANDIDEA-CBC", "PKCS12PBE");
            configurableProvider.addAlgorithm("Cipher.IDEA", str + "$ECB");
            ASN1ObjectIdentifier aSN1ObjectIdentifier = MiscObjectIdentifiers.as_sys_sec_alg_ideaCBC;
            configurableProvider.addAlgorithm("Cipher", aSN1ObjectIdentifier, str + "$CBC");
            configurableProvider.addAlgorithm("Cipher.PBEWITHSHAANDIDEA-CBC", str + "$PBEWithSHAAndIDEA");
            configurableProvider.addAlgorithm("KeyGenerator.IDEA", str + "$KeyGen");
            configurableProvider.addAlgorithm("KeyGenerator", aSN1ObjectIdentifier, str + "$KeyGen");
            configurableProvider.addAlgorithm("SecretKeyFactory.PBEWITHSHAANDIDEA-CBC", str + "$PBEWithSHAAndIDEAKeyGen");
            configurableProvider.addAlgorithm("Mac.IDEAMAC", str + "$Mac");
            configurableProvider.addAlgorithm("Alg.Alias.Mac.IDEA", "IDEAMAC");
            configurableProvider.addAlgorithm("Mac.IDEAMAC/CFB8", str + "$CFB8Mac");
            configurableProvider.addAlgorithm("Alg.Alias.Mac.IDEA/CFB8", "IDEAMAC/CFB8");
        }
    }

    public static class PBEWithSHAAndIDEA extends BaseBlockCipher {
        public PBEWithSHAAndIDEA() {
            super((BlockCipher) new CBCBlockCipher(new IDEAEngine()));
        }
    }

    public static class PBEWithSHAAndIDEAKeyGen extends PBESecretKeyFactory {
        public PBEWithSHAAndIDEAKeyGen() {
            super("PBEwithSHAandIDEA-CBC", (ASN1ObjectIdentifier) null, true, 2, 1, 128, 64);
        }
    }

    private IDEA() {
    }
}
