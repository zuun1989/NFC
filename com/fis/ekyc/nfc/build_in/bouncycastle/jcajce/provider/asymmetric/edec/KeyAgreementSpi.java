package com.fis.ekyc.nfc.build_in.bouncycastle.jcajce.provider.asymmetric.edec;

import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.DerivationFunction;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.RawAgreement;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.agreement.X25519Agreement;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.agreement.X448Agreement;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.agreement.XDHUnifiedAgreement;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.agreement.kdf.ConcatenationKDFGenerator;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.generators.KDF2BytesGenerator;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.params.AsymmetricKeyParameter;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.params.X448PrivateKeyParameters;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.params.XDHUPrivateParameters;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.params.XDHUPublicParameters;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.util.DigestFactory;
import com.fis.ekyc.nfc.build_in.bouncycastle.jcajce.provider.asymmetric.util.BaseAgreementSpi;
import com.fis.ekyc.nfc.build_in.bouncycastle.jcajce.spec.DHUParameterSpec;
import com.fis.ekyc.nfc.build_in.bouncycastle.jcajce.spec.UserKeyingMaterialSpec;
import com.fis.ekyc.nfc.build_in.bouncycastle.jcajce.spec.XDHParameterSpec;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.SecureRandom;
import java.security.spec.AlgorithmParameterSpec;

public class KeyAgreementSpi extends BaseAgreementSpi {
    private RawAgreement agreement;
    private DHUParameterSpec dhuSpec;
    private byte[] result;

    public static final class X25519 extends KeyAgreementSpi {
        public X25519() {
            super(XDHParameterSpec.X25519);
        }
    }

    public static class X25519UwithSHA256CKDF extends KeyAgreementSpi {
        public X25519UwithSHA256CKDF() {
            super("X25519UwithSHA256CKDF", new ConcatenationKDFGenerator(DigestFactory.createSHA256()));
        }
    }

    public static class X25519UwithSHA256KDF extends KeyAgreementSpi {
        public X25519UwithSHA256KDF() {
            super("X25519UwithSHA256KDF", new KDF2BytesGenerator(DigestFactory.createSHA256()));
        }
    }

    public static final class X25519withSHA256CKDF extends KeyAgreementSpi {
        public X25519withSHA256CKDF() {
            super("X25519withSHA256CKDF", new ConcatenationKDFGenerator(DigestFactory.createSHA256()));
        }
    }

    public static final class X25519withSHA256KDF extends KeyAgreementSpi {
        public X25519withSHA256KDF() {
            super("X25519withSHA256KDF", new KDF2BytesGenerator(DigestFactory.createSHA256()));
        }
    }

    public static class X25519withSHA384CKDF extends KeyAgreementSpi {
        public X25519withSHA384CKDF() {
            super("X25519withSHA384CKDF", new ConcatenationKDFGenerator(DigestFactory.createSHA384()));
        }
    }

    public static class X25519withSHA512CKDF extends KeyAgreementSpi {
        public X25519withSHA512CKDF() {
            super("X25519withSHA512CKDF", new ConcatenationKDFGenerator(DigestFactory.createSHA512()));
        }
    }

    public static final class X448 extends KeyAgreementSpi {
        public X448() {
            super(XDHParameterSpec.X448);
        }
    }

    public static class X448UwithSHA512CKDF extends KeyAgreementSpi {
        public X448UwithSHA512CKDF() {
            super("X448UwithSHA512CKDF", new ConcatenationKDFGenerator(DigestFactory.createSHA512()));
        }
    }

    public static class X448UwithSHA512KDF extends KeyAgreementSpi {
        public X448UwithSHA512KDF() {
            super("X448UwithSHA512KDF", new KDF2BytesGenerator(DigestFactory.createSHA512()));
        }
    }

    public static final class X448withSHA256CKDF extends KeyAgreementSpi {
        public X448withSHA256CKDF() {
            super("X448withSHA256CKDF", new ConcatenationKDFGenerator(DigestFactory.createSHA256()));
        }
    }

    public static class X448withSHA384CKDF extends KeyAgreementSpi {
        public X448withSHA384CKDF() {
            super("X448withSHA384CKDF", new ConcatenationKDFGenerator(DigestFactory.createSHA384()));
        }
    }

    public static final class X448withSHA512CKDF extends KeyAgreementSpi {
        public X448withSHA512CKDF() {
            super("X448withSHA512CKDF", new ConcatenationKDFGenerator(DigestFactory.createSHA512()));
        }
    }

    public static final class X448withSHA512KDF extends KeyAgreementSpi {
        public X448withSHA512KDF() {
            super("X448withSHA512KDF", new KDF2BytesGenerator(DigestFactory.createSHA512()));
        }
    }

    public static final class XDH extends KeyAgreementSpi {
        public XDH() {
            super("XDH");
        }
    }

    public KeyAgreementSpi(String str) {
        super(str, (DerivationFunction) null);
    }

    private RawAgreement getAgreement(String str) throws InvalidKeyException {
        if (!this.kaAlgorithm.equals("XDH") && !this.kaAlgorithm.startsWith(str)) {
            throw new InvalidKeyException("inappropriate key for " + this.kaAlgorithm);
        } else if (this.kaAlgorithm.indexOf(85) > 0) {
            if (str.startsWith(XDHParameterSpec.X448)) {
                return new XDHUnifiedAgreement(new X448Agreement());
            }
            return new XDHUnifiedAgreement(new X25519Agreement());
        } else if (str.startsWith(XDHParameterSpec.X448)) {
            return new X448Agreement();
        } else {
            return new X25519Agreement();
        }
    }

    public byte[] calcSecret() {
        return this.result;
    }

    public Key engineDoPhase(Key key, boolean z) throws InvalidKeyException, IllegalStateException {
        if (this.agreement == null) {
            throw new IllegalStateException(this.kaAlgorithm + " not initialised.");
        } else if (!z) {
            throw new IllegalStateException(this.kaAlgorithm + " can only be between two parties.");
        } else if (key instanceof BCXDHPublicKey) {
            AsymmetricKeyParameter engineGetKeyParameters = ((BCXDHPublicKey) key).engineGetKeyParameters();
            byte[] bArr = new byte[this.agreement.getAgreementSize()];
            this.result = bArr;
            DHUParameterSpec dHUParameterSpec = this.dhuSpec;
            if (dHUParameterSpec != null) {
                this.agreement.calculateAgreement(new XDHUPublicParameters(engineGetKeyParameters, ((BCXDHPublicKey) dHUParameterSpec.getOtherPartyEphemeralKey()).engineGetKeyParameters()), this.result, 0);
                return null;
            }
            this.agreement.calculateAgreement(engineGetKeyParameters, bArr, 0);
            return null;
        } else {
            throw new InvalidKeyException("cannot identify XDH private key");
        }
    }

    public void engineInit(Key key, SecureRandom secureRandom) throws InvalidKeyException {
        if (key instanceof BCXDHPrivateKey) {
            AsymmetricKeyParameter engineGetKeyParameters = ((BCXDHPrivateKey) key).engineGetKeyParameters();
            if (engineGetKeyParameters instanceof X448PrivateKeyParameters) {
                this.agreement = getAgreement(XDHParameterSpec.X448);
            } else {
                this.agreement = getAgreement(XDHParameterSpec.X25519);
            }
            this.agreement.init(engineGetKeyParameters);
            if (this.kdf != null) {
                this.ukmParameters = new byte[0];
            } else {
                this.ukmParameters = null;
            }
        } else {
            throw new InvalidKeyException("cannot identify XDH private key");
        }
    }

    public KeyAgreementSpi(String str, DerivationFunction derivationFunction) {
        super(str, derivationFunction);
    }

    public void engineInit(Key key, AlgorithmParameterSpec algorithmParameterSpec, SecureRandom secureRandom) throws InvalidKeyException, InvalidAlgorithmParameterException {
        if (key instanceof BCXDHPrivateKey) {
            AsymmetricKeyParameter engineGetKeyParameters = ((BCXDHPrivateKey) key).engineGetKeyParameters();
            if (engineGetKeyParameters instanceof X448PrivateKeyParameters) {
                this.agreement = getAgreement(XDHParameterSpec.X448);
            } else {
                this.agreement = getAgreement(XDHParameterSpec.X25519);
            }
            this.ukmParameters = null;
            if (!(algorithmParameterSpec instanceof DHUParameterSpec)) {
                this.agreement.init(engineGetKeyParameters);
                if (!(algorithmParameterSpec instanceof UserKeyingMaterialSpec)) {
                    throw new InvalidAlgorithmParameterException("unknown ParameterSpec");
                } else if (this.kdf != null) {
                    this.ukmParameters = ((UserKeyingMaterialSpec) algorithmParameterSpec).getUserKeyingMaterial();
                } else {
                    throw new InvalidAlgorithmParameterException("no KDF specified for UserKeyingMaterialSpec");
                }
            } else if (this.kaAlgorithm.indexOf(85) >= 0) {
                DHUParameterSpec dHUParameterSpec = (DHUParameterSpec) algorithmParameterSpec;
                this.dhuSpec = dHUParameterSpec;
                this.ukmParameters = dHUParameterSpec.getUserKeyingMaterial();
                this.agreement.init(new XDHUPrivateParameters(engineGetKeyParameters, ((BCXDHPrivateKey) this.dhuSpec.getEphemeralPrivateKey()).engineGetKeyParameters(), ((BCXDHPublicKey) this.dhuSpec.getEphemeralPublicKey()).engineGetKeyParameters()));
            } else {
                throw new InvalidAlgorithmParameterException("agreement algorithm not DHU based");
            }
            if (this.kdf != null && this.ukmParameters == null) {
                this.ukmParameters = new byte[0];
                return;
            }
            return;
        }
        throw new InvalidKeyException("cannot identify XDH private key");
    }
}
