package com.fis.ekyc.nfc.build_in.bouncycastle.pqc.crypto.lms;

import com.fis.ekyc.nfc.build_in.bouncycastle.util.Encodable;
import java.io.IOException;

class LMSSignedPubKey implements Encodable {
    private final LMSPublicKeyParameters publicKey;
    private final LMSSignature signature;

    public LMSSignedPubKey(LMSSignature lMSSignature, LMSPublicKeyParameters lMSPublicKeyParameters) {
        this.signature = lMSSignature;
        this.publicKey = lMSPublicKeyParameters;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        LMSSignedPubKey lMSSignedPubKey = (LMSSignedPubKey) obj;
        LMSSignature lMSSignature = this.signature;
        if (lMSSignature == null ? lMSSignedPubKey.signature != null : !lMSSignature.equals(lMSSignedPubKey.signature)) {
            return false;
        }
        LMSPublicKeyParameters lMSPublicKeyParameters = this.publicKey;
        LMSPublicKeyParameters lMSPublicKeyParameters2 = lMSSignedPubKey.publicKey;
        if (lMSPublicKeyParameters != null) {
            return lMSPublicKeyParameters.equals(lMSPublicKeyParameters2);
        }
        if (lMSPublicKeyParameters2 == null) {
            return true;
        }
        return false;
    }

    public byte[] getEncoded() throws IOException {
        return Composer.compose().bytes(this.signature.getEncoded()).bytes(this.publicKey.getEncoded()).build();
    }

    public LMSPublicKeyParameters getPublicKey() {
        return this.publicKey;
    }

    public LMSSignature getSignature() {
        return this.signature;
    }

    public int hashCode() {
        int i;
        LMSSignature lMSSignature = this.signature;
        int i2 = 0;
        if (lMSSignature != null) {
            i = lMSSignature.hashCode();
        } else {
            i = 0;
        }
        int i3 = i * 31;
        LMSPublicKeyParameters lMSPublicKeyParameters = this.publicKey;
        if (lMSPublicKeyParameters != null) {
            i2 = lMSPublicKeyParameters.hashCode();
        }
        return i3 + i2;
    }
}
