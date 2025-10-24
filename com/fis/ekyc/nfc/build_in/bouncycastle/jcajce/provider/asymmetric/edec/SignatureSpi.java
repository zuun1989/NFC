package com.fis.ekyc.nfc.build_in.bouncycastle.jcajce.provider.asymmetric.edec;

import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.CryptoException;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.Signer;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.params.AsymmetricKeyParameter;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.params.Ed448PrivateKeyParameters;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.params.Ed448PublicKeyParameters;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.signers.Ed25519Signer;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.signers.Ed448Signer;
import com.fis.ekyc.nfc.build_in.bouncycastle.jcajce.spec.EdDSAParameterSpec;
import java.security.AlgorithmParameters;
import java.security.InvalidKeyException;
import java.security.InvalidParameterException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SignatureException;

public class SignatureSpi extends java.security.SignatureSpi {
    private static final byte[] EMPTY_CONTEXT = new byte[0];
    private final String algorithm;
    private Signer signer;

    public static final class Ed25519 extends SignatureSpi {
        public Ed25519() {
            super(EdDSAParameterSpec.Ed25519);
        }
    }

    public static final class Ed448 extends SignatureSpi {
        public Ed448() {
            super(EdDSAParameterSpec.Ed448);
        }
    }

    public static final class EdDSA extends SignatureSpi {
        public EdDSA() {
            super((String) null);
        }
    }

    public SignatureSpi(String str) {
        this.algorithm = str;
    }

    private Signer getSigner(String str) throws InvalidKeyException {
        String str2 = this.algorithm;
        if (str2 != null && !str.equals(str2)) {
            throw new InvalidKeyException("inappropriate key for " + this.algorithm);
        } else if (str.equals(EdDSAParameterSpec.Ed448)) {
            return new Ed448Signer(EMPTY_CONTEXT);
        } else {
            return new Ed25519Signer();
        }
    }

    public Object engineGetParameter(String str) throws InvalidParameterException {
        throw new UnsupportedOperationException("engineGetParameter unsupported");
    }

    public AlgorithmParameters engineGetParameters() {
        return null;
    }

    public void engineInitSign(PrivateKey privateKey) throws InvalidKeyException {
        if (privateKey instanceof BCEdDSAPrivateKey) {
            AsymmetricKeyParameter engineGetKeyParameters = ((BCEdDSAPrivateKey) privateKey).engineGetKeyParameters();
            if (engineGetKeyParameters instanceof Ed448PrivateKeyParameters) {
                this.signer = getSigner(EdDSAParameterSpec.Ed448);
            } else {
                this.signer = getSigner(EdDSAParameterSpec.Ed25519);
            }
            this.signer.init(true, engineGetKeyParameters);
            return;
        }
        throw new InvalidKeyException("cannot identify EdDSA private key");
    }

    public void engineInitVerify(PublicKey publicKey) throws InvalidKeyException {
        if (publicKey instanceof BCEdDSAPublicKey) {
            AsymmetricKeyParameter engineGetKeyParameters = ((BCEdDSAPublicKey) publicKey).engineGetKeyParameters();
            if (engineGetKeyParameters instanceof Ed448PublicKeyParameters) {
                this.signer = getSigner(EdDSAParameterSpec.Ed448);
            } else {
                this.signer = getSigner(EdDSAParameterSpec.Ed25519);
            }
            this.signer.init(false, engineGetKeyParameters);
            return;
        }
        throw new InvalidKeyException("cannot identify EdDSA public key");
    }

    public void engineSetParameter(String str, Object obj) throws InvalidParameterException {
        throw new UnsupportedOperationException("engineSetParameter unsupported");
    }

    public byte[] engineSign() throws SignatureException {
        try {
            return this.signer.generateSignature();
        } catch (CryptoException e) {
            throw new SignatureException(e.getMessage());
        }
    }

    public void engineUpdate(byte b) throws SignatureException {
        this.signer.update(b);
    }

    public boolean engineVerify(byte[] bArr) throws SignatureException {
        return this.signer.verifySignature(bArr);
    }

    public void engineUpdate(byte[] bArr, int i, int i2) throws SignatureException {
        this.signer.update(bArr, i, i2);
    }
}
