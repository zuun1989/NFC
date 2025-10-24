package com.fis.ekyc.nfc.build_in.bouncycastle.jcajce.provider.asymmetric.ecgost12;

import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.pkcs.PKCSObjectIdentifiers;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.x509.SubjectPublicKeyInfo;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.x509.X509ObjectIdentifiers;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.DSAExt;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.Digest;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.digests.GOST3411_2012_256Digest;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.params.AsymmetricKeyParameter;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.params.ECKeyParameters;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.params.ParametersWithRandom;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.signers.ECGOST3410_2012Signer;
import com.fis.ekyc.nfc.build_in.bouncycastle.jcajce.provider.asymmetric.util.ECUtil;
import com.fis.ekyc.nfc.build_in.bouncycastle.jce.interfaces.ECKey;
import com.fis.ekyc.nfc.build_in.bouncycastle.jce.interfaces.ECPublicKey;
import com.fis.ekyc.nfc.build_in.bouncycastle.jce.provider.BouncyCastleProvider;
import java.math.BigInteger;
import java.security.AlgorithmParameters;
import java.security.InvalidKeyException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.SignatureException;
import java.security.SignatureSpi;
import java.security.spec.AlgorithmParameterSpec;

public class ECGOST2012SignatureSpi256 extends SignatureSpi implements PKCSObjectIdentifiers, X509ObjectIdentifiers {
    private Digest digest = new GOST3411_2012_256Digest();
    private int halfSize = (64 / 2);
    private DSAExt signer = new ECGOST3410_2012Signer();
    private int size = 64;

    public static AsymmetricKeyParameter generatePublicKeyParameter(PublicKey publicKey) throws InvalidKeyException {
        if (publicKey instanceof BCECGOST3410_2012PublicKey) {
            return ((BCECGOST3410_2012PublicKey) publicKey).engineGetKeyParameters();
        }
        return ECUtil.generatePublicKeyParameter(publicKey);
    }

    public Object engineGetParameter(String str) {
        throw new UnsupportedOperationException("engineSetParameter unsupported");
    }

    public AlgorithmParameters engineGetParameters() {
        return null;
    }

    public void engineInitSign(PrivateKey privateKey) throws InvalidKeyException {
        if (privateKey instanceof ECKey) {
            ECKeyParameters eCKeyParameters = (ECKeyParameters) ECUtil.generatePrivateKeyParameter(privateKey);
            if (eCKeyParameters.getParameters().getN().bitLength() <= 256) {
                this.digest.reset();
                SecureRandom secureRandom = this.appRandom;
                if (secureRandom != null) {
                    this.signer.init(true, new ParametersWithRandom(eCKeyParameters, secureRandom));
                } else {
                    this.signer.init(true, eCKeyParameters);
                }
            } else {
                throw new InvalidKeyException("key out of range for ECGOST-2012-256");
            }
        } else {
            throw new InvalidKeyException("cannot recognise key type in ECGOST-2012-256 signer");
        }
    }

    public void engineInitVerify(PublicKey publicKey) throws InvalidKeyException {
        ECKeyParameters eCKeyParameters;
        if (publicKey instanceof ECPublicKey) {
            eCKeyParameters = (ECKeyParameters) generatePublicKeyParameter(publicKey);
        } else {
            try {
                eCKeyParameters = (ECKeyParameters) ECUtil.generatePublicKeyParameter(BouncyCastleProvider.getPublicKey(SubjectPublicKeyInfo.getInstance(publicKey.getEncoded())));
            } catch (Exception unused) {
                throw new InvalidKeyException("cannot recognise key type in ECGOST-2012-256 signer");
            }
        }
        if (eCKeyParameters.getParameters().getN().bitLength() <= 256) {
            this.digest.reset();
            this.signer.init(false, eCKeyParameters);
            return;
        }
        throw new InvalidKeyException("key out of range for ECGOST-2012-256");
    }

    public void engineSetParameter(AlgorithmParameterSpec algorithmParameterSpec) {
        throw new UnsupportedOperationException("engineSetParameter unsupported");
    }

    public byte[] engineSign() throws SignatureException {
        byte[] bArr = new byte[this.digest.getDigestSize()];
        this.digest.doFinal(bArr, 0);
        try {
            byte[] bArr2 = new byte[this.size];
            BigInteger[] generateSignature = this.signer.generateSignature(bArr);
            byte[] byteArray = generateSignature[0].toByteArray();
            byte[] byteArray2 = generateSignature[1].toByteArray();
            if (byteArray2[0] != 0) {
                System.arraycopy(byteArray2, 0, bArr2, this.halfSize - byteArray2.length, byteArray2.length);
            } else {
                System.arraycopy(byteArray2, 1, bArr2, this.halfSize - (byteArray2.length - 1), byteArray2.length - 1);
            }
            if (byteArray[0] != 0) {
                System.arraycopy(byteArray, 0, bArr2, this.size - byteArray.length, byteArray.length);
            } else {
                System.arraycopy(byteArray, 1, bArr2, this.size - (byteArray.length - 1), byteArray.length - 1);
            }
            return bArr2;
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
        try {
            int i = this.halfSize;
            byte[] bArr3 = new byte[i];
            byte[] bArr4 = new byte[i];
            System.arraycopy(bArr, 0, bArr4, 0, i);
            int i2 = this.halfSize;
            System.arraycopy(bArr, i2, bArr3, 0, i2);
            BigInteger[] bigIntegerArr = {new BigInteger(1, bArr3), new BigInteger(1, bArr4)};
            return this.signer.verifySignature(bArr2, bigIntegerArr[0], bigIntegerArr[1]);
        } catch (Exception unused) {
            throw new SignatureException("error decoding signature bytes.");
        }
    }

    public void engineSetParameter(String str, Object obj) {
        throw new UnsupportedOperationException("engineSetParameter unsupported");
    }

    public void engineUpdate(byte[] bArr, int i, int i2) throws SignatureException {
        this.digest.update(bArr, i, i2);
    }
}
