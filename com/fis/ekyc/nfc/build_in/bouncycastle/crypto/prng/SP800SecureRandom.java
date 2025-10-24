package com.fis.ekyc.nfc.build_in.bouncycastle.crypto.prng;

import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.prng.drbg.SP80090DRBG;
import java.security.SecureRandom;

public class SP800SecureRandom extends SecureRandom {
    private SP80090DRBG drbg;
    private final DRBGProvider drbgProvider;
    private final EntropySource entropySource;
    private final boolean predictionResistant;
    private final SecureRandom randomSource;

    public SP800SecureRandom(SecureRandom secureRandom, EntropySource entropySource2, DRBGProvider dRBGProvider, boolean z) {
        this.randomSource = secureRandom;
        this.entropySource = entropySource2;
        this.drbgProvider = dRBGProvider;
        this.predictionResistant = z;
    }

    public byte[] generateSeed(int i) {
        return EntropyUtil.generateSeed(this.entropySource, i);
    }

    public String getAlgorithm() {
        return this.drbgProvider.getAlgorithm();
    }

    public void nextBytes(byte[] bArr) {
        synchronized (this) {
            try {
                if (this.drbg == null) {
                    this.drbg = this.drbgProvider.get(this.entropySource);
                }
                if (this.drbg.generate(bArr, (byte[]) null, this.predictionResistant) < 0) {
                    this.drbg.reseed((byte[]) null);
                    this.drbg.generate(bArr, (byte[]) null, this.predictionResistant);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void reseed(byte[] bArr) {
        synchronized (this) {
            try {
                if (this.drbg == null) {
                    this.drbg = this.drbgProvider.get(this.entropySource);
                }
                this.drbg.reseed(bArr);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void setSeed(byte[] bArr) {
        synchronized (this) {
            try {
                SecureRandom secureRandom = this.randomSource;
                if (secureRandom != null) {
                    secureRandom.setSeed(bArr);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void setSeed(long j) {
        synchronized (this) {
            try {
                SecureRandom secureRandom = this.randomSource;
                if (secureRandom != null) {
                    secureRandom.setSeed(j);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
