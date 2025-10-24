package com.fis.ekyc.nfc.build_in.bouncycastle.pqc.jcajce.provider.rainbow;

import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.CipherParameters;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.Digest;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.digests.SHA224Digest;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.digests.SHA256Digest;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.digests.SHA384Digest;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.digests.SHA512Digest;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.params.AsymmetricKeyParameter;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.params.ParametersWithRandom;
import com.fis.ekyc.nfc.build_in.bouncycastle.pqc.crypto.rainbow.RainbowSigner;
import java.security.InvalidKeyException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.SignatureException;
import java.security.spec.AlgorithmParameterSpec;

public class SignatureSpi extends java.security.SignatureSpi {
    private Digest digest;
    private SecureRandom random;
    private RainbowSigner signer;

    public static class withSha224 extends SignatureSpi {
        public withSha224() {
            super(new SHA224Digest(), new RainbowSigner());
        }
    }

    public static class withSha256 extends SignatureSpi {
        public withSha256() {
            super(new SHA256Digest(), new RainbowSigner());
        }
    }

    public static class withSha384 extends SignatureSpi {
        public withSha384() {
            super(new SHA384Digest(), new RainbowSigner());
        }
    }

    public static class withSha512 extends SignatureSpi {
        public withSha512() {
            super(new SHA512Digest(), new RainbowSigner());
        }
    }

    public SignatureSpi(Digest digest2, RainbowSigner rainbowSigner) {
        this.digest = digest2;
        this.signer = rainbowSigner;
    }

    public Object engineGetParameter(String str) {
        throw new UnsupportedOperationException("engineSetParameter unsupported");
    }

    public void engineInitSign(PrivateKey privateKey, SecureRandom secureRandom) throws InvalidKeyException {
        this.random = secureRandom;
        engineInitSign(privateKey);
    }

    public void engineInitVerify(PublicKey publicKey) throws InvalidKeyException {
        AsymmetricKeyParameter generatePublicKeyParameter = RainbowKeysToParams.generatePublicKeyParameter(publicKey);
        this.digest.reset();
        this.signer.init(false, generatePublicKeyParameter);
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
        CipherParameters generatePrivateKeyParameter = RainbowKeysToParams.generatePrivateKeyParameter(privateKey);
        SecureRandom secureRandom = this.random;
        if (secureRandom != null) {
            generatePrivateKeyParameter = new ParametersWithRandom(generatePrivateKeyParameter, secureRandom);
        }
        this.digest.reset();
        this.signer.init(true, generatePrivateKeyParameter);
    }
}
