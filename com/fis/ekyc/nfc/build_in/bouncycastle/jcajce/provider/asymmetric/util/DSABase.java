package com.fis.ekyc.nfc.build_in.bouncycastle.jcajce.provider.asymmetric.util;

import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.pkcs.PKCSObjectIdentifiers;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.x509.X509ObjectIdentifiers;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.DSAExt;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.Digest;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.signers.DSAEncoding;
import java.math.BigInteger;
import java.security.SignatureException;
import java.security.SignatureSpi;
import java.security.spec.AlgorithmParameterSpec;

public abstract class DSABase extends SignatureSpi implements PKCSObjectIdentifiers, X509ObjectIdentifiers {
    protected Digest digest;
    protected DSAEncoding encoding;
    protected DSAExt signer;

    public DSABase(Digest digest2, DSAExt dSAExt, DSAEncoding dSAEncoding) {
        this.digest = digest2;
        this.signer = dSAExt;
        this.encoding = dSAEncoding;
    }

    public Object engineGetParameter(String str) {
        throw new UnsupportedOperationException("engineSetParameter unsupported");
    }

    public void engineSetParameter(AlgorithmParameterSpec algorithmParameterSpec) {
        throw new UnsupportedOperationException("engineSetParameter unsupported");
    }

    public byte[] engineSign() throws SignatureException {
        byte[] bArr = new byte[this.digest.getDigestSize()];
        this.digest.doFinal(bArr, 0);
        try {
            BigInteger[] generateSignature = this.signer.generateSignature(bArr);
            return this.encoding.encode(this.signer.getOrder(), generateSignature[0], generateSignature[1]);
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
            BigInteger[] decode = this.encoding.decode(this.signer.getOrder(), bArr);
            return this.signer.verifySignature(bArr2, decode[0], decode[1]);
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
