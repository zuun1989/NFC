package com.fis.ekyc.nfc.build_in.bouncycastle.jcajce.provider.asymmetric.edec;

import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.edec.EdECObjectIdentifiers;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.AsymmetricCipherKeyPair;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.AsymmetricCipherKeyPairGenerator;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.generators.Ed25519KeyPairGenerator;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.generators.Ed448KeyPairGenerator;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.generators.X25519KeyPairGenerator;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.generators.X448KeyPairGenerator;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.params.Ed25519KeyGenerationParameters;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.params.Ed448KeyGenerationParameters;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.params.X25519KeyGenerationParameters;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.params.X448KeyGenerationParameters;
import com.fis.ekyc.nfc.build_in.bouncycastle.jcajce.provider.asymmetric.util.ECUtil;
import com.fis.ekyc.nfc.build_in.bouncycastle.jcajce.spec.EdDSAParameterSpec;
import com.fis.ekyc.nfc.build_in.bouncycastle.jcajce.spec.XDHParameterSpec;
import com.fis.ekyc.nfc.build_in.bouncycastle.jce.spec.ECNamedCurveGenParameterSpec;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidParameterException;
import java.security.KeyPair;
import java.security.SecureRandom;
import java.security.spec.AlgorithmParameterSpec;
import java.security.spec.ECGenParameterSpec;

public class KeyPairGeneratorSpi extends java.security.KeyPairGeneratorSpi {
    private static final int Ed25519 = 1;
    private static final int Ed448 = 0;
    private static final int EdDSA = -1;
    private static final int X25519 = 3;
    private static final int X448 = 2;
    private static final int XDH = -2;
    private int algorithm;
    private AsymmetricCipherKeyPairGenerator generator;
    private boolean initialised;
    private SecureRandom secureRandom;

    public static final class Ed25519 extends KeyPairGeneratorSpi {
        public Ed25519() {
            super(1, new Ed25519KeyPairGenerator());
        }
    }

    public static final class Ed448 extends KeyPairGeneratorSpi {
        public Ed448() {
            super(0, new Ed448KeyPairGenerator());
        }
    }

    public static final class EdDSA extends KeyPairGeneratorSpi {
        public EdDSA() {
            super(-1, (AsymmetricCipherKeyPairGenerator) null);
        }
    }

    public static final class X25519 extends KeyPairGeneratorSpi {
        public X25519() {
            super(3, new X25519KeyPairGenerator());
        }
    }

    public static final class X448 extends KeyPairGeneratorSpi {
        public X448() {
            super(2, new X448KeyPairGenerator());
        }
    }

    public static final class XDH extends KeyPairGeneratorSpi {
        public XDH() {
            super(KeyPairGeneratorSpi.XDH, (AsymmetricCipherKeyPairGenerator) null);
        }
    }

    public KeyPairGeneratorSpi(int i, AsymmetricCipherKeyPairGenerator asymmetricCipherKeyPairGenerator) {
        this.algorithm = i;
        this.generator = asymmetricCipherKeyPairGenerator;
    }

    private void algorithmCheck(int i) throws InvalidAlgorithmParameterException {
        int i2 = this.algorithm;
        if (i2 == i) {
            return;
        }
        if (i2 == 1 || i2 == 0) {
            throw new InvalidAlgorithmParameterException("parameterSpec for wrong curve type");
        } else if (i2 == -1 && i != 1 && i != 0) {
            throw new InvalidAlgorithmParameterException("parameterSpec for wrong curve type");
        } else if (i2 == 3 || i2 == 2) {
            throw new InvalidAlgorithmParameterException("parameterSpec for wrong curve type");
        } else if (i2 == XDH && i != 3 && i != 2) {
            throw new InvalidAlgorithmParameterException("parameterSpec for wrong curve type");
        }
    }

    private void initializeGenerator(String str) throws InvalidAlgorithmParameterException {
        if (str.equalsIgnoreCase(EdDSAParameterSpec.Ed448) || str.equals(EdECObjectIdentifiers.id_Ed448.getId())) {
            algorithmCheck(0);
            this.generator = new Ed448KeyPairGenerator();
            setupGenerator(0);
        } else if (str.equalsIgnoreCase(EdDSAParameterSpec.Ed25519) || str.equals(EdECObjectIdentifiers.id_Ed25519.getId())) {
            algorithmCheck(1);
            this.generator = new Ed25519KeyPairGenerator();
            setupGenerator(1);
        } else if (str.equalsIgnoreCase(XDHParameterSpec.X448) || str.equals(EdECObjectIdentifiers.id_X448.getId())) {
            algorithmCheck(2);
            this.generator = new X448KeyPairGenerator();
            setupGenerator(2);
        } else if (str.equalsIgnoreCase(XDHParameterSpec.X25519) || str.equals(EdECObjectIdentifiers.id_X25519.getId())) {
            algorithmCheck(3);
            this.generator = new X25519KeyPairGenerator();
            setupGenerator(3);
        }
    }

    private void setupGenerator(int i) {
        this.initialised = true;
        if (i != XDH) {
            if (i != -1) {
                if (i == 0) {
                    this.generator.init(new Ed448KeyGenerationParameters(this.secureRandom));
                    return;
                } else if (i != 1) {
                    if (i == 2) {
                        this.generator.init(new X448KeyGenerationParameters(this.secureRandom));
                        return;
                    } else if (i != 3) {
                        return;
                    }
                }
            }
            this.generator.init(new Ed25519KeyGenerationParameters(this.secureRandom));
            return;
        }
        this.generator.init(new X25519KeyGenerationParameters(this.secureRandom));
    }

    public KeyPair generateKeyPair() {
        if (this.generator != null) {
            if (!this.initialised) {
                setupGenerator(this.algorithm);
            }
            AsymmetricCipherKeyPair generateKeyPair = this.generator.generateKeyPair();
            int i = this.algorithm;
            if (i == XDH || i == 2 || i == 3) {
                return new KeyPair(new BCXDHPublicKey(generateKeyPair.getPublic()), new BCXDHPrivateKey(generateKeyPair.getPrivate()));
            }
            return new KeyPair(new BCEdDSAPublicKey(generateKeyPair.getPublic()), new BCEdDSAPrivateKey(generateKeyPair.getPrivate()));
        }
        throw new IllegalStateException("generator not correctly initialized");
    }

    public void initialize(int i, SecureRandom secureRandom2) {
        this.secureRandom = secureRandom2;
        if (i == 255 || i == 256) {
            int i2 = this.algorithm;
            if (i2 != XDH) {
                if (i2 == -1 || i2 == 1) {
                    algorithmCheck(1);
                    this.generator = new Ed25519KeyPairGenerator();
                    setupGenerator(1);
                    return;
                } else if (i2 != 3) {
                    throw new InvalidParameterException("key size not configurable");
                }
            }
            algorithmCheck(3);
            this.generator = new X25519KeyPairGenerator();
            setupGenerator(3);
        } else if (i == 448) {
            try {
                int i3 = this.algorithm;
                if (i3 != XDH) {
                    if (i3 == -1 || i3 == 0) {
                        algorithmCheck(0);
                        this.generator = new Ed448KeyPairGenerator();
                        setupGenerator(0);
                        return;
                    } else if (i3 != 2) {
                        throw new InvalidParameterException("key size not configurable");
                    }
                }
                algorithmCheck(2);
                this.generator = new X448KeyPairGenerator();
                setupGenerator(2);
            } catch (InvalidAlgorithmParameterException e) {
                throw new InvalidParameterException(e.getMessage());
            }
        } else {
            throw new InvalidParameterException("unknown key size");
        }
    }

    public void initialize(AlgorithmParameterSpec algorithmParameterSpec, SecureRandom secureRandom2) throws InvalidAlgorithmParameterException {
        this.secureRandom = secureRandom2;
        if (algorithmParameterSpec instanceof ECGenParameterSpec) {
            initializeGenerator(((ECGenParameterSpec) algorithmParameterSpec).getName());
        } else if (algorithmParameterSpec instanceof ECNamedCurveGenParameterSpec) {
            initializeGenerator(((ECNamedCurveGenParameterSpec) algorithmParameterSpec).getName());
        } else if (algorithmParameterSpec instanceof EdDSAParameterSpec) {
            initializeGenerator(((EdDSAParameterSpec) algorithmParameterSpec).getCurveName());
        } else if (algorithmParameterSpec instanceof XDHParameterSpec) {
            initializeGenerator(((XDHParameterSpec) algorithmParameterSpec).getCurveName());
        } else {
            String nameFrom = ECUtil.getNameFrom(algorithmParameterSpec);
            if (nameFrom != null) {
                initializeGenerator(nameFrom);
                return;
            }
            throw new InvalidAlgorithmParameterException("invalid parameterSpec: " + algorithmParameterSpec);
        }
    }
}
