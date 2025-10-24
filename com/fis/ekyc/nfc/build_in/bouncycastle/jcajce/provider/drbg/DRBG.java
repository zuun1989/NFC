package com.fis.ekyc.nfc.build_in.bouncycastle.jcajce.provider.drbg;

import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.digests.SHA512Digest;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.macs.HMac;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.prng.EntropySource;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.prng.EntropySourceProvider;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.prng.SP800SecureRandom;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.prng.SP800SecureRandomBuilder;
import com.fis.ekyc.nfc.build_in.bouncycastle.jcajce.provider.config.ConfigurableProvider;
import com.fis.ekyc.nfc.build_in.bouncycastle.jcajce.provider.symmetric.util.ClassUtil;
import com.fis.ekyc.nfc.build_in.bouncycastle.jcajce.provider.util.AsymmetricAlgorithmProvider;
import com.fis.ekyc.nfc.build_in.bouncycastle.util.Arrays;
import com.fis.ekyc.nfc.build_in.bouncycastle.util.Pack;
import com.fis.ekyc.nfc.build_in.bouncycastle.util.Properties;
import com.fis.ekyc.nfc.build_in.bouncycastle.util.Strings;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.security.Provider;
import java.security.SecureRandom;
import java.security.SecureRandomSpi;
import java.security.Security;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public class DRBG {
    /* access modifiers changed from: private */
    public static final String PREFIX = "com.fis.ekyc.nfc.build_in.bouncycastle.jcajce.provider.drbg.DRBG";
    private static final String[][] initialEntropySourceNames = {new String[]{"sun.security.provider.Sun", "sun.security.provider.SecureRandom"}, new String[]{"com.fis.ekyc.sdk.nfc.build_in.apache.harmony.security.provider.crypto.CryptoProvider", "com.fis.ekyc.sdk.nfc.build_in.apache.harmony.security.provider.crypto.SHA1PRNG_SecureRandomImpl"}, new String[]{"com.android.com.fis.ekyc.sdk.nfc.build_in.conscrypt.OpenSSLProvider", "com.android.com.fis.ekyc.sdk.nfc.build_in.conscrypt.OpenSSLRandom"}, new String[]{"com.fis.ekyc.sdk.nfc.build_in.conscrypt.OpenSSLProvider", "com.fis.ekyc.sdk.nfc.build_in.conscrypt.OpenSSLRandom"}};

    public static class CoreSecureRandom extends SecureRandom {
        public CoreSecureRandom(Object[] objArr) {
            super(objArr[1], objArr[0]);
        }
    }

    public static class Default extends SecureRandomSpi {
        private static final SecureRandom random = DRBG.createBaseRandom(true);

        public byte[] engineGenerateSeed(int i) {
            return random.generateSeed(i);
        }

        public void engineNextBytes(byte[] bArr) {
            random.nextBytes(bArr);
        }

        public void engineSetSeed(byte[] bArr) {
            random.setSeed(bArr);
        }
    }

    public static class HybridRandomProvider extends Provider {
        public HybridRandomProvider() {
            super("BCHEP", 1.0d, "Bouncy Castle Hybrid Entropy Provider");
        }
    }

    public static class Mappings extends AsymmetricAlgorithmProvider {
        public void configure(ConfigurableProvider configurableProvider) {
            configurableProvider.addAlgorithm("SecureRandom.DEFAULT", DRBG.PREFIX + "$Default");
            configurableProvider.addAlgorithm("SecureRandom.NONCEANDIV", DRBG.PREFIX + "$NonceAndIV");
        }
    }

    public static class NonceAndIV extends SecureRandomSpi {
        private static final SecureRandom random = DRBG.createBaseRandom(false);

        public byte[] engineGenerateSeed(int i) {
            return random.generateSeed(i);
        }

        public void engineNextBytes(byte[] bArr) {
            random.nextBytes(bArr);
        }

        public void engineSetSeed(byte[] bArr) {
            random.setSeed(bArr);
        }
    }

    public static class URLSeededSecureRandom extends SecureRandom {
        /* access modifiers changed from: private */
        public final InputStream seedStream;

        public URLSeededSecureRandom(final URL url) {
            super((SecureRandomSpi) null, new HybridRandomProvider());
            this.seedStream = (InputStream) AccessController.doPrivileged(new PrivilegedAction<InputStream>() {
                public InputStream run() {
                    try {
                        return url.openStream();
                    } catch (IOException unused) {
                        throw new IllegalStateException("unable to open random source");
                    }
                }
            });
        }

        private int privilegedRead(final byte[] bArr, final int i, final int i2) {
            return ((Integer) AccessController.doPrivileged(new PrivilegedAction<Integer>() {
                public Integer run() {
                    try {
                        return Integer.valueOf(URLSeededSecureRandom.this.seedStream.read(bArr, i, i2));
                    } catch (IOException unused) {
                        throw new InternalError("unable to read random source");
                    }
                }
            })).intValue();
        }

        public byte[] generateSeed(int i) {
            byte[] bArr;
            synchronized (this) {
                try {
                    bArr = new byte[i];
                    int i2 = 0;
                    while (i2 != i) {
                        int privilegedRead = privilegedRead(bArr, i2, i - i2);
                        if (privilegedRead <= -1) {
                            break;
                        }
                        i2 += privilegedRead;
                    }
                    if (i2 != i) {
                        throw new InternalError("unable to fully read random source");
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            return bArr;
        }

        public void setSeed(long j) {
        }

        public void setSeed(byte[] bArr) {
        }
    }

    /* access modifiers changed from: private */
    public static SecureRandom createBaseRandom(boolean z) {
        byte[] bArr;
        byte[] bArr2;
        if (Properties.getPropertyValue("com.fis.ekyc.nfc.build_in.bouncycastle.drbg.entropysource") != null) {
            EntropySourceProvider createEntropySource = createEntropySource();
            EntropySource entropySource = createEntropySource.get(128);
            if (z) {
                bArr2 = generateDefaultPersonalizationString(entropySource.getEntropy());
            } else {
                bArr2 = generateNonceIVPersonalizationString(entropySource.getEntropy());
            }
            return new SP800SecureRandomBuilder(createEntropySource).setPersonalizationString(bArr2).buildHash(new SHA512Digest(), Arrays.concatenate(entropySource.getEntropy(), entropySource.getEntropy()), z);
        }
        HybridSecureRandom hybridSecureRandom = new HybridSecureRandom();
        if (z) {
            bArr = generateDefaultPersonalizationString(hybridSecureRandom.generateSeed(16));
        } else {
            bArr = generateNonceIVPersonalizationString(hybridSecureRandom.generateSeed(16));
        }
        return new SP800SecureRandomBuilder(hybridSecureRandom, true).setPersonalizationString(bArr).buildHash(new SHA512Digest(), hybridSecureRandom.generateSeed(32), z);
    }

    /* access modifiers changed from: private */
    public static SecureRandom createCoreSecureRandom() {
        if (Security.getProperty("securerandom.source") == null) {
            return new CoreSecureRandom(findSource());
        }
        try {
            return new URLSeededSecureRandom(new URL(Security.getProperty("securerandom.source")));
        } catch (Exception unused) {
            return new CoreSecureRandom(findSource());
        }
    }

    private static EntropySourceProvider createEntropySource() {
        final String propertyValue = Properties.getPropertyValue("com.fis.ekyc.nfc.build_in.bouncycastle.drbg.entropysource");
        return (EntropySourceProvider) AccessController.doPrivileged(new PrivilegedAction<EntropySourceProvider>() {
            public EntropySourceProvider run() {
                try {
                    return (EntropySourceProvider) ClassUtil.loadClass(DRBG.class, propertyValue).newInstance();
                } catch (Exception e) {
                    throw new IllegalStateException("entropy source " + propertyValue + " not created: " + e.getMessage(), e);
                }
            }
        });
    }

    /* access modifiers changed from: private */
    public static SecureRandom createInitialEntropySource() {
        if (((Boolean) AccessController.doPrivileged(new PrivilegedAction<Boolean>() {
            public Boolean run() {
                try {
                    return Boolean.valueOf(SecureRandom.class.getMethod("getInstanceStrong", (Class[]) null) != null);
                } catch (Exception unused) {
                    return Boolean.FALSE;
                }
            }
        })).booleanValue()) {
            return (SecureRandom) AccessController.doPrivileged(new PrivilegedAction<SecureRandom>() {
                public SecureRandom run() {
                    try {
                        return (SecureRandom) SecureRandom.class.getMethod("getInstanceStrong", (Class[]) null).invoke((Object) null, (Object[]) null);
                    } catch (Exception unused) {
                        return DRBG.createCoreSecureRandom();
                    }
                }
            });
        }
        return createCoreSecureRandom();
    }

    private static final Object[] findSource() {
        int i = 0;
        while (true) {
            String[][] strArr = initialEntropySourceNames;
            if (i >= strArr.length) {
                return null;
            }
            String[] strArr2 = strArr[i];
            try {
                return new Object[]{Class.forName(strArr2[0]).newInstance(), Class.forName(strArr2[1]).newInstance()};
            } catch (Throwable unused) {
                i++;
            }
        }
    }

    private static byte[] generateDefaultPersonalizationString(byte[] bArr) {
        return Arrays.concatenate(Strings.toByteArray("Default"), bArr, Pack.longToBigEndian(Thread.currentThread().getId()), Pack.longToBigEndian(System.currentTimeMillis()));
    }

    private static byte[] generateNonceIVPersonalizationString(byte[] bArr) {
        return Arrays.concatenate(Strings.toByteArray("Nonce"), bArr, Pack.longToLittleEndian(Thread.currentThread().getId()), Pack.longToLittleEndian(System.currentTimeMillis()));
    }

    public static class HybridSecureRandom extends SecureRandom {
        /* access modifiers changed from: private */
        public final SecureRandom baseRandom;
        private final SP800SecureRandom drbg;
        private final AtomicInteger samples = new AtomicInteger(0);
        /* access modifiers changed from: private */
        public final AtomicBoolean seedAvailable = new AtomicBoolean(false);

        public class SignallingEntropySource implements EntropySource {
            /* access modifiers changed from: private */
            public final int byteLength;
            /* access modifiers changed from: private */
            public final AtomicReference entropy = new AtomicReference();
            private final AtomicBoolean scheduled = new AtomicBoolean(false);

            public class EntropyGatherer implements Runnable {
                private final int numBytes;

                public EntropyGatherer(int i) {
                    this.numBytes = i;
                }

                private void sleep(long j) {
                    try {
                        Thread.sleep(j);
                    } catch (InterruptedException unused) {
                        Thread.currentThread().interrupt();
                    }
                }

                public void run() {
                    String propertyValue = Properties.getPropertyValue("com.fis.ekyc.nfc.build_in.bouncycastle.drbg.gather_pause_secs");
                    long j = 5000;
                    if (propertyValue != null) {
                        try {
                            j = Long.parseLong(propertyValue) * 1000;
                        } catch (Exception unused) {
                        }
                    }
                    int i = this.numBytes;
                    byte[] bArr = new byte[i];
                    for (int i2 = 0; i2 < SignallingEntropySource.this.byteLength / 8; i2++) {
                        sleep(j);
                        byte[] generateSeed = HybridSecureRandom.this.baseRandom.generateSeed(8);
                        System.arraycopy(generateSeed, 0, bArr, i2 * 8, generateSeed.length);
                    }
                    int access$600 = SignallingEntropySource.this.byteLength - ((SignallingEntropySource.this.byteLength / 8) * 8);
                    if (access$600 != 0) {
                        sleep(j);
                        byte[] generateSeed2 = HybridSecureRandom.this.baseRandom.generateSeed(access$600);
                        System.arraycopy(generateSeed2, 0, bArr, i - generateSeed2.length, generateSeed2.length);
                    }
                    SignallingEntropySource.this.entropy.set(bArr);
                    HybridSecureRandom.this.seedAvailable.set(true);
                }
            }

            public SignallingEntropySource(int i) {
                this.byteLength = (i + 7) / 8;
            }

            public int entropySize() {
                return this.byteLength * 8;
            }

            public byte[] getEntropy() {
                byte[] bArr = (byte[]) this.entropy.getAndSet((Object) null);
                if (bArr == null || bArr.length != this.byteLength) {
                    bArr = HybridSecureRandom.this.baseRandom.generateSeed(this.byteLength);
                } else {
                    this.scheduled.set(false);
                }
                if (!this.scheduled.getAndSet(true)) {
                    Thread thread = new Thread(new EntropyGatherer(this.byteLength));
                    thread.setDaemon(true);
                    thread.start();
                }
                return bArr;
            }

            public boolean isPredictionResistant() {
                return true;
            }
        }

        public HybridSecureRandom() {
            super((SecureRandomSpi) null, new HybridRandomProvider());
            SecureRandom access$400 = DRBG.createInitialEntropySource();
            this.baseRandom = access$400;
            this.drbg = new SP800SecureRandomBuilder(new EntropySourceProvider() {
                public EntropySource get(int i) {
                    return new SignallingEntropySource(i);
                }
            }).setPersonalizationString(Strings.toByteArray("Bouncy Castle Hybrid Entropy Source")).buildHMAC(new HMac(new SHA512Digest()), access$400.generateSeed(32), false);
        }

        public byte[] generateSeed(int i) {
            byte[] bArr = new byte[i];
            if (this.samples.getAndIncrement() > 20 && this.seedAvailable.getAndSet(false)) {
                this.samples.set(0);
                this.drbg.reseed((byte[]) null);
            }
            this.drbg.nextBytes(bArr);
            return bArr;
        }

        public void setSeed(byte[] bArr) {
            SP800SecureRandom sP800SecureRandom = this.drbg;
            if (sP800SecureRandom != null) {
                sP800SecureRandom.setSeed(bArr);
            }
        }

        public void setSeed(long j) {
            SP800SecureRandom sP800SecureRandom = this.drbg;
            if (sP800SecureRandom != null) {
                sP800SecureRandom.setSeed(j);
            }
        }
    }
}
