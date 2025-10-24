package com.fis.ekyc.nfc.build_in.bouncycastle.crypto.signers;

import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.CipherParameters;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.DSA;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.DSAExt;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.Digest;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.Signer;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.params.AsymmetricKeyParameter;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.params.ParametersWithRandom;
import java.math.BigInteger;

public class DSADigestSigner implements Signer {
    private final Digest digest;
    private final DSA dsa;
    private final DSAEncoding encoding;
    private boolean forSigning;

    public DSADigestSigner(DSA dsa2, Digest digest2) {
        this.dsa = dsa2;
        this.digest = digest2;
        this.encoding = StandardDSAEncoding.INSTANCE;
    }

    public byte[] generateSignature() {
        if (this.forSigning) {
            byte[] bArr = new byte[this.digest.getDigestSize()];
            this.digest.doFinal(bArr, 0);
            BigInteger[] generateSignature = this.dsa.generateSignature(bArr);
            try {
                return this.encoding.encode(getOrder(), generateSignature[0], generateSignature[1]);
            } catch (Exception unused) {
                throw new IllegalStateException("unable to encode signature");
            }
        } else {
            throw new IllegalStateException("DSADigestSigner not initialised for signature generation.");
        }
    }

    public BigInteger getOrder() {
        DSA dsa2 = this.dsa;
        if (dsa2 instanceof DSAExt) {
            return ((DSAExt) dsa2).getOrder();
        }
        return null;
    }

    public void init(boolean z, CipherParameters cipherParameters) {
        AsymmetricKeyParameter asymmetricKeyParameter;
        this.forSigning = z;
        if (cipherParameters instanceof ParametersWithRandom) {
            asymmetricKeyParameter = (AsymmetricKeyParameter) ((ParametersWithRandom) cipherParameters).getParameters();
        } else {
            asymmetricKeyParameter = (AsymmetricKeyParameter) cipherParameters;
        }
        if (z && !asymmetricKeyParameter.isPrivate()) {
            throw new IllegalArgumentException("Signing Requires Private Key.");
        } else if (z || !asymmetricKeyParameter.isPrivate()) {
            reset();
            this.dsa.init(z, cipherParameters);
        } else {
            throw new IllegalArgumentException("Verification Requires Public Key.");
        }
    }

    public void reset() {
        this.digest.reset();
    }

    public void update(byte b) {
        this.digest.update(b);
    }

    public boolean verifySignature(byte[] bArr) {
        if (!this.forSigning) {
            byte[] bArr2 = new byte[this.digest.getDigestSize()];
            this.digest.doFinal(bArr2, 0);
            try {
                BigInteger[] decode = this.encoding.decode(getOrder(), bArr);
                return this.dsa.verifySignature(bArr2, decode[0], decode[1]);
            } catch (Exception unused) {
                return false;
            }
        } else {
            throw new IllegalStateException("DSADigestSigner not initialised for verification");
        }
    }

    public void update(byte[] bArr, int i, int i2) {
        this.digest.update(bArr, i, i2);
    }

    public DSADigestSigner(DSAExt dSAExt, Digest digest2, DSAEncoding dSAEncoding) {
        this.dsa = dSAExt;
        this.digest = digest2;
        this.encoding = dSAEncoding;
    }
}
