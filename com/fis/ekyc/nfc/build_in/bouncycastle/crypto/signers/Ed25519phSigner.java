package com.fis.ekyc.nfc.build_in.bouncycastle.crypto.signers;

import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.CipherParameters;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.Digest;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.Signer;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.params.Ed25519PrivateKeyParameters;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.params.Ed25519PublicKeyParameters;
import com.fis.ekyc.nfc.build_in.bouncycastle.math.ec.rfc8032.Ed25519;
import com.fis.ekyc.nfc.build_in.bouncycastle.util.Arrays;

public class Ed25519phSigner implements Signer {
    private final byte[] context;
    private boolean forSigning;
    private final Digest prehash = Ed25519.createPrehash();
    private Ed25519PrivateKeyParameters privateKey;
    private Ed25519PublicKeyParameters publicKey;

    public Ed25519phSigner(byte[] bArr) {
        this.context = Arrays.clone(bArr);
    }

    public byte[] generateSignature() {
        if (!this.forSigning || this.privateKey == null) {
            throw new IllegalStateException("Ed25519phSigner not initialised for signature generation.");
        }
        byte[] bArr = new byte[64];
        if (64 == this.prehash.doFinal(bArr, 0)) {
            byte[] bArr2 = new byte[64];
            this.privateKey.sign(2, this.context, bArr, 0, 64, bArr2, 0);
            return bArr2;
        }
        throw new IllegalStateException("Prehash digest failed");
    }

    public void init(boolean z, CipherParameters cipherParameters) {
        this.forSigning = z;
        if (z) {
            this.privateKey = (Ed25519PrivateKeyParameters) cipherParameters;
            this.publicKey = null;
        } else {
            this.privateKey = null;
            this.publicKey = (Ed25519PublicKeyParameters) cipherParameters;
        }
        reset();
    }

    public void reset() {
        this.prehash.reset();
    }

    public void update(byte b) {
        this.prehash.update(b);
    }

    public boolean verifySignature(byte[] bArr) {
        Ed25519PublicKeyParameters ed25519PublicKeyParameters;
        if (this.forSigning || (ed25519PublicKeyParameters = this.publicKey) == null) {
            throw new IllegalStateException("Ed25519phSigner not initialised for verification");
        } else if (64 != bArr.length) {
            this.prehash.reset();
            return false;
        } else {
            return Ed25519.verifyPrehash(bArr, 0, ed25519PublicKeyParameters.getEncoded(), 0, this.context, this.prehash);
        }
    }

    public void update(byte[] bArr, int i, int i2) {
        this.prehash.update(bArr, i, i2);
    }
}
