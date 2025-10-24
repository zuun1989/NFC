package com.fis.ekyc.nfc.build_in.bouncycastle.pqc.jcajce.provider.qtesla;

import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.CipherParameters;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.Digest;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.digests.NullDigest;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.params.ParametersWithRandom;
import com.fis.ekyc.nfc.build_in.bouncycastle.pqc.crypto.qtesla.QTESLASecurityCategory;
import com.fis.ekyc.nfc.build_in.bouncycastle.pqc.crypto.qtesla.QTESLASigner;
import java.security.InvalidKeyException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.Signature;
import java.security.SignatureException;
import java.security.spec.AlgorithmParameterSpec;

public class SignatureSpi extends Signature {
    private Digest digest;
    private SecureRandom random;
    private QTESLASigner signer;

    public static class PI extends SignatureSpi {
        public PI() {
            super(QTESLASecurityCategory.getName(5), new NullDigest(), new QTESLASigner());
        }
    }

    public static class PIII extends SignatureSpi {
        public PIII() {
            super(QTESLASecurityCategory.getName(6), new NullDigest(), new QTESLASigner());
        }
    }

    public static class qTESLA extends SignatureSpi {
        public qTESLA() {
            super("qTESLA", new NullDigest(), new QTESLASigner());
        }
    }

    public SignatureSpi(String str) {
        super(str);
    }

    public Object engineGetParameter(String str) {
        throw new UnsupportedOperationException("engineSetParameter unsupported");
    }

    public void engineInitSign(PrivateKey privateKey, SecureRandom secureRandom) throws InvalidKeyException {
        this.random = secureRandom;
        engineInitSign(privateKey);
    }

    public void engineInitVerify(PublicKey publicKey) throws InvalidKeyException {
        if (publicKey instanceof BCqTESLAPublicKey) {
            CipherParameters keyParams = ((BCqTESLAPublicKey) publicKey).getKeyParams();
            this.digest.reset();
            this.signer.init(false, keyParams);
            return;
        }
        throw new InvalidKeyException("unknown public key passed to qTESLA");
    }

    public void engineSetParameter(AlgorithmParameterSpec algorithmParameterSpec) {
        throw new UnsupportedOperationException("engineSetParameter unsupported");
    }

    public byte[] engineSign() throws SignatureException {
        try {
            return this.signer.generateSignature(DigestUtil.getDigestResult(this.digest));
        } catch (Exception e) {
            if (e instanceof IllegalStateException) {
                throw new SignatureException(e.getMessage());
            }
            throw new SignatureException(e.toString());
        }
    }

    public void engineUpdate(byte b) throws SignatureException {
        this.digest.update(b);
    }

    public boolean engineVerify(byte[] bArr) throws SignatureException {
        return this.signer.verifySignature(DigestUtil.getDigestResult(this.digest), bArr);
    }

    public SignatureSpi(String str, Digest digest2, QTESLASigner qTESLASigner) {
        super(str);
        this.digest = digest2;
        this.signer = qTESLASigner;
    }

    public void engineSetParameter(String str, Object obj) {
        throw new UnsupportedOperationException("engineSetParameter unsupported");
    }

    public void engineUpdate(byte[] bArr, int i, int i2) throws SignatureException {
        this.digest.update(bArr, i, i2);
    }

    public void engineInitSign(PrivateKey privateKey) throws InvalidKeyException {
        if (privateKey instanceof BCqTESLAPrivateKey) {
            CipherParameters keyParams = ((BCqTESLAPrivateKey) privateKey).getKeyParams();
            SecureRandom secureRandom = this.random;
            if (secureRandom != null) {
                keyParams = new ParametersWithRandom(keyParams, secureRandom);
            }
            this.signer.init(true, keyParams);
            return;
        }
        throw new InvalidKeyException("unknown private key passed to qTESLA");
    }
}
