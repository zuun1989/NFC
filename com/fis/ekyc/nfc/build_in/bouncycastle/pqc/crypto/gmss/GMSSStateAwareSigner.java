package com.fis.ekyc.nfc.build_in.bouncycastle.pqc.crypto.gmss;

import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.CipherParameters;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.Digest;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.params.AsymmetricKeyParameter;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.params.ParametersWithRandom;
import com.fis.ekyc.nfc.build_in.bouncycastle.pqc.crypto.StateAwareMessageSigner;
import com.fis.ekyc.nfc.build_in.bouncycastle.util.Memoable;

public class GMSSStateAwareSigner implements StateAwareMessageSigner {
    private final GMSSSigner gmssSigner;
    private GMSSPrivateKeyParameters key;

    public GMSSStateAwareSigner(Digest digest) {
        if (digest instanceof Memoable) {
            final Memoable copy = ((Memoable) digest).copy();
            this.gmssSigner = new GMSSSigner(new GMSSDigestProvider() {
                public Digest get() {
                    return (Digest) copy.copy();
                }
            });
            return;
        }
        throw new IllegalArgumentException("digest must implement Memoable");
    }

    public byte[] generateSignature(byte[] bArr) {
        if (this.key != null) {
            byte[] generateSignature = this.gmssSigner.generateSignature(bArr);
            this.key = this.key.nextKey();
            return generateSignature;
        }
        throw new IllegalStateException("signing key no longer usable");
    }

    public AsymmetricKeyParameter getUpdatedPrivateKey() {
        GMSSPrivateKeyParameters gMSSPrivateKeyParameters = this.key;
        this.key = null;
        return gMSSPrivateKeyParameters;
    }

    public void init(boolean z, CipherParameters cipherParameters) {
        if (z) {
            if (cipherParameters instanceof ParametersWithRandom) {
                this.key = (GMSSPrivateKeyParameters) ((ParametersWithRandom) cipherParameters).getParameters();
            } else {
                this.key = (GMSSPrivateKeyParameters) cipherParameters;
            }
        }
        this.gmssSigner.init(z, cipherParameters);
    }

    public boolean verifySignature(byte[] bArr, byte[] bArr2) {
        return this.gmssSigner.verifySignature(bArr, bArr2);
    }
}
