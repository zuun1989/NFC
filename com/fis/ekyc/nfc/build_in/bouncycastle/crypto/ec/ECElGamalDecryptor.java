package com.fis.ekyc.nfc.build_in.bouncycastle.crypto.ec;

import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.CipherParameters;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.params.ECPrivateKeyParameters;
import com.fis.ekyc.nfc.build_in.bouncycastle.math.ec.ECAlgorithms;
import com.fis.ekyc.nfc.build_in.bouncycastle.math.ec.ECCurve;
import com.fis.ekyc.nfc.build_in.bouncycastle.math.ec.ECPoint;

public class ECElGamalDecryptor implements ECDecryptor {
    private ECPrivateKeyParameters key;

    public ECPoint decrypt(ECPair eCPair) {
        ECPrivateKeyParameters eCPrivateKeyParameters = this.key;
        if (eCPrivateKeyParameters != null) {
            ECCurve curve = eCPrivateKeyParameters.getParameters().getCurve();
            return ECAlgorithms.cleanPoint(curve, eCPair.getY()).subtract(ECAlgorithms.cleanPoint(curve, eCPair.getX()).multiply(this.key.getD())).normalize();
        }
        throw new IllegalStateException("ECElGamalDecryptor not initialised");
    }

    public void init(CipherParameters cipherParameters) {
        if (cipherParameters instanceof ECPrivateKeyParameters) {
            this.key = (ECPrivateKeyParameters) cipherParameters;
            return;
        }
        throw new IllegalArgumentException("ECPrivateKeyParameters are required for decryption.");
    }
}
