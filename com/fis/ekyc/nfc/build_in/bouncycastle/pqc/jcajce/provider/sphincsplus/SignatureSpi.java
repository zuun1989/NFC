package com.fis.ekyc.nfc.build_in.bouncycastle.pqc.jcajce.provider.sphincsplus;

import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.CipherParameters;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.Digest;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.digests.NullDigest;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.params.ParametersWithRandom;
import com.fis.ekyc.nfc.build_in.bouncycastle.pqc.crypto.sphincsplus.SPHINCSPlusSigner;
import java.security.InvalidKeyException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.SignatureException;
import java.security.spec.AlgorithmParameterSpec;

public class SignatureSpi extends java.security.SignatureSpi {
    private final Digest digest;
    private final SPHINCSPlusSigner signer;

    public static class Direct extends SignatureSpi {
        public Direct() {
            super(new NullDigest(), new SPHINCSPlusSigner());
        }
    }

    public SignatureSpi(Digest digest2, SPHINCSPlusSigner sPHINCSPlusSigner) {
        this.digest = digest2;
        this.signer = sPHINCSPlusSigner;
    }

    public Object engineGetParameter(String str) {
        throw new UnsupportedOperationException("engineSetParameter unsupported");
    }

    public void engineInitSign(PrivateKey privateKey, SecureRandom secureRandom) throws InvalidKeyException {
        this.appRandom = secureRandom;
        engineInitSign(privateKey);
    }

    public void engineInitVerify(PublicKey publicKey) throws InvalidKeyException {
        if (publicKey instanceof BCSPHINCSPlusPublicKey) {
            this.signer.init(false, ((BCSPHINCSPlusPublicKey) publicKey).getKeyParams());
            return;
        }
        throw new InvalidKeyException("unknown public key passed to SPHINCS-256");
    }

    public void engineSetParameter(AlgorithmParameterSpec algorithmParameterSpec) {
        throw new UnsupportedOperationException("engineSetParameter unsupported");
    }

    public byte[] engineSign() throws SignatureException {
        byte[] bArr = new byte[this.digest.getDigestSize()];
        this.digest.doFinal(bArr, 0);
        try {
            return this.signer.generateSignature(bArr);
        } catch (Exception e) {
            throw new SignatureException(e.toString());
        }
    }

    public void engineUpdate(byte b) throws SignatureException {
        this.digest.update(b);
    }

    public boolean engineVerify(byte[] bArr) throws SignatureException {
        byte[] bArr2 = new byte[this.digest.getDigestSize()];
        this.digest.doFinal(bArr2, 0);
        return this.signer.verifySignature(bArr2, bArr);
    }

    public void engineSetParameter(String str, Object obj) {
        throw new UnsupportedOperationException("engineSetParameter unsupported");
    }

    public void engineUpdate(byte[] bArr, int i, int i2) throws SignatureException {
        this.digest.update(bArr, i, i2);
    }

    public void engineInitSign(PrivateKey privateKey) throws InvalidKeyException {
        if (privateKey instanceof BCSPHINCSPlusPrivateKey) {
            CipherParameters keyParams = ((BCSPHINCSPlusPrivateKey) privateKey).getKeyParams();
            SecureRandom secureRandom = this.appRandom;
            if (secureRandom != null) {
                this.signer.init(true, new ParametersWithRandom(keyParams, secureRandom));
            } else {
                this.signer.init(true, keyParams);
            }
        } else {
            throw new InvalidKeyException("unknown private key passed to SPHINCS-256");
        }
    }
}
