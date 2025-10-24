package com.fis.ekyc.nfc.build_in.bouncycastle.jcajce.provider.asymmetric.rsa;

import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.pkcs.PKCSObjectIdentifiers;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.AsymmetricBlockCipher;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.CryptoException;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.Digest;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.engines.RSABlindedEngine;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.params.ParametersWithRandom;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.params.RSAKeyParameters;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.signers.PSSSigner;
import com.fis.ekyc.nfc.build_in.bouncycastle.jcajce.provider.util.DigestFactory;
import com.fis.ekyc.nfc.build_in.bouncycastle.jcajce.util.BCJcaJceHelper;
import com.fis.ekyc.nfc.build_in.bouncycastle.jcajce.util.JcaJceHelper;
import com.fis.ekyc.nfc.build_in.bouncycastle.pqc.jcajce.spec.McElieceCCA2KeyGenParameterSpec;
import java.io.ByteArrayOutputStream;
import java.security.AlgorithmParameters;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.PrivateKey;
import java.security.ProviderException;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.SignatureException;
import java.security.SignatureSpi;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.AlgorithmParameterSpec;
import java.security.spec.MGF1ParameterSpec;
import java.security.spec.PSSParameterSpec;

public class PSSSignatureSpi extends SignatureSpi {
    private Digest contentDigest;
    private AlgorithmParameters engineParams;
    private final JcaJceHelper helper;
    private boolean isInitState;
    private boolean isRaw;
    private RSAKeyParameters key;
    private Digest mgfDigest;
    private PSSParameterSpec originalSpec;
    private PSSParameterSpec paramSpec;
    private PSSSigner pss;
    private SecureRandom random;
    private int saltLength;
    private AsymmetricBlockCipher signer;
    private byte trailer;

    public class NullPssDigest implements Digest {
        private ByteArrayOutputStream bOut = new ByteArrayOutputStream();
        private Digest baseDigest;
        private boolean oddTime = true;

        public NullPssDigest(Digest digest) {
            this.baseDigest = digest;
        }

        public int doFinal(byte[] bArr, int i) {
            byte[] byteArray = this.bOut.toByteArray();
            if (this.oddTime) {
                System.arraycopy(byteArray, 0, bArr, i, byteArray.length);
            } else {
                this.baseDigest.update(byteArray, 0, byteArray.length);
                this.baseDigest.doFinal(bArr, i);
            }
            reset();
            this.oddTime = !this.oddTime;
            return byteArray.length;
        }

        public String getAlgorithmName() {
            return "NULL";
        }

        public int getByteLength() {
            return 0;
        }

        public int getDigestSize() {
            return this.baseDigest.getDigestSize();
        }

        public void reset() {
            this.bOut.reset();
            this.baseDigest.reset();
        }

        public void update(byte b) {
            this.bOut.write(b);
        }

        public void update(byte[] bArr, int i, int i2) {
            this.bOut.write(bArr, i, i2);
        }
    }

    public static class PSSwithRSA extends PSSSignatureSpi {
        public PSSwithRSA() {
            super(new RSABlindedEngine(), (PSSParameterSpec) null);
        }
    }

    public static class SHA1withRSA extends PSSSignatureSpi {
        public SHA1withRSA() {
            super(new RSABlindedEngine(), PSSParameterSpec.DEFAULT);
        }
    }

    public static class SHA224withRSA extends PSSSignatureSpi {
        public SHA224withRSA() {
            super(new RSABlindedEngine(), new PSSParameterSpec(McElieceCCA2KeyGenParameterSpec.SHA224, "MGF1", new MGF1ParameterSpec(McElieceCCA2KeyGenParameterSpec.SHA224), 28, 1));
        }
    }

    public static class SHA256withRSA extends PSSSignatureSpi {
        public SHA256withRSA() {
            super(new RSABlindedEngine(), new PSSParameterSpec("SHA-256", "MGF1", new MGF1ParameterSpec("SHA-256"), 32, 1));
        }
    }

    public static class SHA384withRSA extends PSSSignatureSpi {
        public SHA384withRSA() {
            super(new RSABlindedEngine(), new PSSParameterSpec(McElieceCCA2KeyGenParameterSpec.SHA384, "MGF1", new MGF1ParameterSpec(McElieceCCA2KeyGenParameterSpec.SHA384), 48, 1));
        }
    }

    public static class SHA3_224withRSA extends PSSSignatureSpi {
        public SHA3_224withRSA() {
            super(new RSABlindedEngine(), new PSSParameterSpec("SHA3-224", "MGF1", new MGF1ParameterSpec("SHA3-224"), 28, 1));
        }
    }

    public static class SHA3_256withRSA extends PSSSignatureSpi {
        public SHA3_256withRSA() {
            super(new RSABlindedEngine(), new PSSParameterSpec("SHA3-256", "MGF1", new MGF1ParameterSpec("SHA3-256"), 32, 1));
        }
    }

    public static class SHA3_384withRSA extends PSSSignatureSpi {
        public SHA3_384withRSA() {
            super(new RSABlindedEngine(), new PSSParameterSpec("SHA3-384", "MGF1", new MGF1ParameterSpec("SHA3-384"), 48, 1));
        }
    }

    public static class SHA3_512withRSA extends PSSSignatureSpi {
        public SHA3_512withRSA() {
            super(new RSABlindedEngine(), new PSSParameterSpec("SHA3-512", "MGF1", new MGF1ParameterSpec("SHA3-512"), 64, 1));
        }
    }

    public static class SHA512_224withRSA extends PSSSignatureSpi {
        public SHA512_224withRSA() {
            super(new RSABlindedEngine(), new PSSParameterSpec("SHA-512(224)", "MGF1", new MGF1ParameterSpec("SHA-512(224)"), 28, 1));
        }
    }

    public static class SHA512_256withRSA extends PSSSignatureSpi {
        public SHA512_256withRSA() {
            super(new RSABlindedEngine(), new PSSParameterSpec("SHA-512(256)", "MGF1", new MGF1ParameterSpec("SHA-512(256)"), 32, 1));
        }
    }

    public static class SHA512withRSA extends PSSSignatureSpi {
        public SHA512withRSA() {
            super(new RSABlindedEngine(), new PSSParameterSpec("SHA-512", "MGF1", new MGF1ParameterSpec("SHA-512"), 64, 1));
        }
    }

    public static class nonePSS extends PSSSignatureSpi {
        public nonePSS() {
            super(new RSABlindedEngine(), (PSSParameterSpec) null, true);
        }
    }

    public PSSSignatureSpi(AsymmetricBlockCipher asymmetricBlockCipher, PSSParameterSpec pSSParameterSpec) {
        this(asymmetricBlockCipher, pSSParameterSpec, false);
    }

    private byte getTrailer(int i) {
        if (i == 1) {
            return PSSSigner.TRAILER_IMPLICIT;
        }
        throw new IllegalArgumentException("unknown trailer field");
    }

    private void setupContentDigest() {
        if (this.isRaw) {
            this.contentDigest = new NullPssDigest(this.mgfDigest);
        } else {
            this.contentDigest = this.mgfDigest;
        }
    }

    public Object engineGetParameter(String str) {
        throw new UnsupportedOperationException("engineGetParameter unsupported");
    }

    public AlgorithmParameters engineGetParameters() {
        if (this.engineParams == null && this.paramSpec != null) {
            try {
                AlgorithmParameters createAlgorithmParameters = this.helper.createAlgorithmParameters("PSS");
                this.engineParams = createAlgorithmParameters;
                createAlgorithmParameters.init(this.paramSpec);
            } catch (Exception e) {
                throw new RuntimeException(e.toString());
            }
        }
        return this.engineParams;
    }

    public void engineInitSign(PrivateKey privateKey, SecureRandom secureRandom) throws InvalidKeyException {
        this.random = secureRandom;
        engineInitSign(privateKey);
    }

    public void engineInitVerify(PublicKey publicKey) throws InvalidKeyException {
        if (publicKey instanceof RSAPublicKey) {
            this.key = RSAUtil.generatePublicKeyParameter((RSAPublicKey) publicKey);
            PSSSigner pSSSigner = new PSSSigner(this.signer, this.contentDigest, this.mgfDigest, this.saltLength, this.trailer);
            this.pss = pSSSigner;
            pSSSigner.init(false, this.key);
            this.isInitState = true;
            return;
        }
        throw new InvalidKeyException("Supplied key is not a RSAPublicKey instance");
    }

    public void engineSetParameter(AlgorithmParameterSpec algorithmParameterSpec) throws InvalidAlgorithmParameterException {
        if (algorithmParameterSpec != null || (algorithmParameterSpec = this.originalSpec) != null) {
            if (!this.isInitState) {
                throw new ProviderException("cannot call setParameter in the middle of update");
            } else if (algorithmParameterSpec instanceof PSSParameterSpec) {
                PSSParameterSpec pSSParameterSpec = (PSSParameterSpec) algorithmParameterSpec;
                PSSParameterSpec pSSParameterSpec2 = this.originalSpec;
                if (pSSParameterSpec2 != null && !DigestFactory.isSameDigest(pSSParameterSpec2.getDigestAlgorithm(), pSSParameterSpec.getDigestAlgorithm())) {
                    throw new InvalidAlgorithmParameterException("parameter must be using " + this.originalSpec.getDigestAlgorithm());
                } else if (!pSSParameterSpec.getMGFAlgorithm().equalsIgnoreCase("MGF1") && !pSSParameterSpec.getMGFAlgorithm().equals(PKCSObjectIdentifiers.id_mgf1.getId())) {
                    throw new InvalidAlgorithmParameterException("unknown mask generation function specified");
                } else if (pSSParameterSpec.getMGFParameters() instanceof MGF1ParameterSpec) {
                    MGF1ParameterSpec mGF1ParameterSpec = (MGF1ParameterSpec) pSSParameterSpec.getMGFParameters();
                    if (DigestFactory.isSameDigest(mGF1ParameterSpec.getDigestAlgorithm(), pSSParameterSpec.getDigestAlgorithm())) {
                        Digest digest = DigestFactory.getDigest(mGF1ParameterSpec.getDigestAlgorithm());
                        if (digest != null) {
                            this.engineParams = null;
                            this.paramSpec = pSSParameterSpec;
                            this.mgfDigest = digest;
                            this.saltLength = pSSParameterSpec.getSaltLength();
                            this.trailer = getTrailer(this.paramSpec.getTrailerField());
                            setupContentDigest();
                            if (this.key != null) {
                                this.pss = new PSSSigner(this.signer, this.contentDigest, this.mgfDigest, this.saltLength, this.trailer);
                                if (this.key.isPrivate()) {
                                    this.pss.init(true, this.key);
                                } else {
                                    this.pss.init(false, this.key);
                                }
                            }
                        } else {
                            throw new InvalidAlgorithmParameterException("no match on MGF digest algorithm: " + mGF1ParameterSpec.getDigestAlgorithm());
                        }
                    } else {
                        throw new InvalidAlgorithmParameterException("digest algorithm for MGF should be the same as for PSS parameters.");
                    }
                } else {
                    throw new InvalidAlgorithmParameterException("unknown MGF parameters");
                }
            } else {
                throw new InvalidAlgorithmParameterException("Only PSSParameterSpec supported");
            }
        }
    }

    public byte[] engineSign() throws SignatureException {
        this.isInitState = true;
        try {
            return this.pss.generateSignature();
        } catch (CryptoException e) {
            throw new SignatureException(e.getMessage());
        }
    }

    public void engineUpdate(byte b) throws SignatureException {
        this.pss.update(b);
        this.isInitState = false;
    }

    public boolean engineVerify(byte[] bArr) throws SignatureException {
        this.isInitState = true;
        return this.pss.verifySignature(bArr);
    }

    public PSSSignatureSpi(AsymmetricBlockCipher asymmetricBlockCipher, PSSParameterSpec pSSParameterSpec, boolean z) {
        this.helper = new BCJcaJceHelper();
        this.isInitState = true;
        this.signer = asymmetricBlockCipher;
        this.originalSpec = pSSParameterSpec;
        if (pSSParameterSpec == null) {
            this.paramSpec = PSSParameterSpec.DEFAULT;
        } else {
            this.paramSpec = pSSParameterSpec;
        }
        this.mgfDigest = DigestFactory.getDigest(this.paramSpec.getDigestAlgorithm());
        this.saltLength = this.paramSpec.getSaltLength();
        this.trailer = getTrailer(this.paramSpec.getTrailerField());
        this.isRaw = z;
        setupContentDigest();
    }

    public void engineInitSign(PrivateKey privateKey) throws InvalidKeyException {
        if (privateKey instanceof RSAPrivateKey) {
            this.key = RSAUtil.generatePrivateKeyParameter((RSAPrivateKey) privateKey);
            PSSSigner pSSSigner = new PSSSigner(this.signer, this.contentDigest, this.mgfDigest, this.saltLength, this.trailer);
            this.pss = pSSSigner;
            SecureRandom secureRandom = this.random;
            if (secureRandom != null) {
                pSSSigner.init(true, new ParametersWithRandom(this.key, secureRandom));
            } else {
                pSSSigner.init(true, this.key);
            }
            this.isInitState = true;
            return;
        }
        throw new InvalidKeyException("Supplied key is not a RSAPrivateKey instance");
    }

    public void engineUpdate(byte[] bArr, int i, int i2) throws SignatureException {
        this.pss.update(bArr, i, i2);
        this.isInitState = false;
    }

    public void engineSetParameter(String str, Object obj) {
        throw new UnsupportedOperationException("engineSetParameter unsupported");
    }
}
