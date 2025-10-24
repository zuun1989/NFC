package com.fis.ekyc.nfc.build_in.bouncycastle.crypto.prng;

import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.BlockCipher;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.CryptoServicesRegistrar;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.Digest;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.Mac;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.engines.DESedeEngine;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.macs.HMac;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.prng.drbg.CTRSP800DRBG;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.prng.drbg.HMacSP800DRBG;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.prng.drbg.HashSP800DRBG;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.prng.drbg.SP80090DRBG;
import com.fis.ekyc.nfc.build_in.bouncycastle.util.Arrays;
import java.security.SecureRandom;

public class SP800SecureRandomBuilder {
    private int entropyBitsRequired;
    private final EntropySourceProvider entropySourceProvider;
    private byte[] personalizationString;
    private final SecureRandom random;
    private int securityStrength;

    public static class CTRDRBGProvider implements DRBGProvider {
        private final BlockCipher blockCipher;
        private final int keySizeInBits;
        private final byte[] nonce;
        private final byte[] personalizationString;
        private final int securityStrength;

        public CTRDRBGProvider(BlockCipher blockCipher2, int i, byte[] bArr, byte[] bArr2, int i2) {
            this.blockCipher = blockCipher2;
            this.keySizeInBits = i;
            this.nonce = bArr;
            this.personalizationString = bArr2;
            this.securityStrength = i2;
        }

        public SP80090DRBG get(EntropySource entropySource) {
            return new CTRSP800DRBG(this.blockCipher, this.keySizeInBits, this.securityStrength, entropySource, this.personalizationString, this.nonce);
        }

        public String getAlgorithm() {
            if (this.blockCipher instanceof DESedeEngine) {
                return "CTR-DRBG-3KEY-TDES";
            }
            return "CTR-DRBG-" + this.blockCipher.getAlgorithmName() + this.keySizeInBits;
        }
    }

    public static class HMacDRBGProvider implements DRBGProvider {
        private final Mac hMac;
        private final byte[] nonce;
        private final byte[] personalizationString;
        private final int securityStrength;

        public HMacDRBGProvider(Mac mac, byte[] bArr, byte[] bArr2, int i) {
            this.hMac = mac;
            this.nonce = bArr;
            this.personalizationString = bArr2;
            this.securityStrength = i;
        }

        public SP80090DRBG get(EntropySource entropySource) {
            return new HMacSP800DRBG(this.hMac, this.securityStrength, entropySource, this.personalizationString, this.nonce);
        }

        public String getAlgorithm() {
            if (this.hMac instanceof HMac) {
                return "HMAC-DRBG-" + SP800SecureRandomBuilder.getSimplifiedName(((HMac) this.hMac).getUnderlyingDigest());
            }
            return "HMAC-DRBG-" + this.hMac.getAlgorithmName();
        }
    }

    public static class HashDRBGProvider implements DRBGProvider {
        private final Digest digest;
        private final byte[] nonce;
        private final byte[] personalizationString;
        private final int securityStrength;

        public HashDRBGProvider(Digest digest2, byte[] bArr, byte[] bArr2, int i) {
            this.digest = digest2;
            this.nonce = bArr;
            this.personalizationString = bArr2;
            this.securityStrength = i;
        }

        public SP80090DRBG get(EntropySource entropySource) {
            return new HashSP800DRBG(this.digest, this.securityStrength, entropySource, this.personalizationString, this.nonce);
        }

        public String getAlgorithm() {
            return "HASH-DRBG-" + SP800SecureRandomBuilder.getSimplifiedName(this.digest);
        }
    }

    public SP800SecureRandomBuilder() {
        this(CryptoServicesRegistrar.getSecureRandom(), false);
    }

    /* access modifiers changed from: private */
    public static String getSimplifiedName(Digest digest) {
        String algorithmName = digest.getAlgorithmName();
        int indexOf = algorithmName.indexOf(45);
        if (indexOf <= 0 || algorithmName.startsWith("SHA3")) {
            return algorithmName;
        }
        return algorithmName.substring(0, indexOf) + algorithmName.substring(indexOf + 1);
    }

    public SP800SecureRandom buildCTR(BlockCipher blockCipher, int i, byte[] bArr, boolean z) {
        return new SP800SecureRandom(this.random, this.entropySourceProvider.get(this.entropyBitsRequired), new CTRDRBGProvider(blockCipher, i, bArr, this.personalizationString, this.securityStrength), z);
    }

    public SP800SecureRandom buildHMAC(Mac mac, byte[] bArr, boolean z) {
        return new SP800SecureRandom(this.random, this.entropySourceProvider.get(this.entropyBitsRequired), new HMacDRBGProvider(mac, bArr, this.personalizationString, this.securityStrength), z);
    }

    public SP800SecureRandom buildHash(Digest digest, byte[] bArr, boolean z) {
        return new SP800SecureRandom(this.random, this.entropySourceProvider.get(this.entropyBitsRequired), new HashDRBGProvider(digest, bArr, this.personalizationString, this.securityStrength), z);
    }

    public SP800SecureRandomBuilder setEntropyBitsRequired(int i) {
        this.entropyBitsRequired = i;
        return this;
    }

    public SP800SecureRandomBuilder setPersonalizationString(byte[] bArr) {
        this.personalizationString = Arrays.clone(bArr);
        return this;
    }

    public SP800SecureRandomBuilder setSecurityStrength(int i) {
        this.securityStrength = i;
        return this;
    }

    public SP800SecureRandomBuilder(SecureRandom secureRandom, boolean z) {
        this.securityStrength = 256;
        this.entropyBitsRequired = 256;
        this.random = secureRandom;
        this.entropySourceProvider = new BasicEntropySourceProvider(secureRandom, z);
    }

    public SP800SecureRandomBuilder(EntropySourceProvider entropySourceProvider2) {
        this.securityStrength = 256;
        this.entropyBitsRequired = 256;
        this.random = null;
        this.entropySourceProvider = entropySourceProvider2;
    }
}
