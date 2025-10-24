package com.fis.ekyc.nfc.build_in.bouncycastle.pqc.jcajce.provider.lms;

import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.Digest;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.digests.NullDigest;
import com.fis.ekyc.nfc.build_in.bouncycastle.pqc.crypto.ExhaustedPrivateKeyException;
import com.fis.ekyc.nfc.build_in.bouncycastle.pqc.crypto.MessageSigner;
import com.fis.ekyc.nfc.build_in.bouncycastle.pqc.crypto.lms.LMSContext;
import com.fis.ekyc.nfc.build_in.bouncycastle.pqc.crypto.lms.LMSContextBasedSigner;
import com.fis.ekyc.nfc.build_in.bouncycastle.pqc.crypto.lms.LMSContextBasedVerifier;
import java.security.InvalidKeyException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.Signature;
import java.security.SignatureException;
import java.security.spec.AlgorithmParameterSpec;

public class LMSSignatureSpi extends Signature {
    private Digest digest;
    private LMSContextBasedSigner lmOtsSigner;
    private LMSContextBasedVerifier lmOtsVerifier;
    private SecureRandom random;
    private MessageSigner signer;

    public static class generic extends LMSSignatureSpi {
        public generic() {
            super("LMS", new NullDigest());
        }
    }

    public LMSSignatureSpi(String str) {
        super(str);
    }

    private Digest getSigner() throws SignatureException {
        try {
            return this.lmOtsSigner.generateLMSContext();
        } catch (ExhaustedPrivateKeyException e) {
            throw new SignatureException(e.getMessage(), e);
        }
    }

    public Object engineGetParameter(String str) {
        throw new UnsupportedOperationException("engineSetParameter unsupported");
    }

    public void engineInitSign(PrivateKey privateKey, SecureRandom secureRandom) throws InvalidKeyException {
        this.random = secureRandom;
        engineInitSign(privateKey);
    }

    public void engineInitVerify(PublicKey publicKey) throws InvalidKeyException {
        if (publicKey instanceof BCLMSPublicKey) {
            NullDigest nullDigest = new NullDigest();
            this.digest = nullDigest;
            nullDigest.reset();
            this.lmOtsVerifier = (LMSContextBasedVerifier) ((BCLMSPublicKey) publicKey).getKeyParams();
            return;
        }
        throw new InvalidKeyException("unknown public key passed to XMSS");
    }

    public void engineSetParameter(AlgorithmParameterSpec algorithmParameterSpec) {
        throw new UnsupportedOperationException("engineSetParameter unsupported");
    }

    public byte[] engineSign() throws SignatureException {
        if (this.digest == null) {
            this.digest = getSigner();
        }
        try {
            byte[] generateSignature = this.lmOtsSigner.generateSignature((LMSContext) this.digest);
            this.digest = null;
            return generateSignature;
        } catch (Exception e) {
            if (e instanceof IllegalStateException) {
                throw new SignatureException(e.getMessage(), e);
            }
            throw new SignatureException(e.toString(), e);
        }
    }

    public void engineUpdate(byte b) throws SignatureException {
        if (this.digest == null) {
            this.digest = getSigner();
        }
        this.digest.update(b);
    }

    public boolean engineVerify(byte[] bArr) throws SignatureException {
        LMSContext generateLMSContext = this.lmOtsVerifier.generateLMSContext(bArr);
        byte[] digestResult = DigestUtil.getDigestResult(this.digest);
        generateLMSContext.update(digestResult, 0, digestResult.length);
        return this.lmOtsVerifier.verify(generateLMSContext);
    }

    public LMSSignatureSpi(String str, Digest digest2) {
        super(str);
        this.digest = digest2;
    }

    public void engineSetParameter(String str, Object obj) {
        throw new UnsupportedOperationException("engineSetParameter unsupported");
    }

    public void engineInitSign(PrivateKey privateKey) throws InvalidKeyException {
        if (privateKey instanceof BCLMSPrivateKey) {
            LMSContextBasedSigner lMSContextBasedSigner = (LMSContextBasedSigner) ((BCLMSPrivateKey) privateKey).getKeyParams();
            this.lmOtsSigner = lMSContextBasedSigner;
            if (lMSContextBasedSigner.getUsagesRemaining() != 0) {
                this.digest = null;
                return;
            }
            throw new InvalidKeyException("private key exhausted");
        }
        throw new InvalidKeyException("unknown private key passed to LMS");
    }

    public void engineUpdate(byte[] bArr, int i, int i2) throws SignatureException {
        if (this.digest == null) {
            this.digest = getSigner();
        }
        this.digest.update(bArr, i, i2);
    }
}
