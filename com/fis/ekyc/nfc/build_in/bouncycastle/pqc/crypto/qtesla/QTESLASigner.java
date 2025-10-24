package com.fis.ekyc.nfc.build_in.bouncycastle.pqc.crypto.qtesla;

import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.CipherParameters;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.CryptoServicesRegistrar;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.params.ParametersWithRandom;
import com.fis.ekyc.nfc.build_in.bouncycastle.pqc.crypto.MessageSigner;
import java.security.SecureRandom;

public class QTESLASigner implements MessageSigner {
    private QTESLAPrivateKeyParameters privateKey;
    private QTESLAPublicKeyParameters publicKey;
    private SecureRandom secureRandom;

    public byte[] generateSignature(byte[] bArr) {
        byte[] bArr2 = new byte[QTESLASecurityCategory.getSignatureSize(this.privateKey.getSecurityCategory())];
        int securityCategory = this.privateKey.getSecurityCategory();
        if (securityCategory == 5) {
            QTesla1p.generateSignature(bArr2, bArr, 0, bArr.length, this.privateKey.getSecret(), this.secureRandom);
        } else if (securityCategory == 6) {
            QTesla3p.generateSignature(bArr2, bArr, 0, bArr.length, this.privateKey.getSecret(), this.secureRandom);
        } else {
            throw new IllegalArgumentException("unknown security category: " + this.privateKey.getSecurityCategory());
        }
        return bArr2;
    }

    public void init(boolean z, CipherParameters cipherParameters) {
        if (z) {
            if (cipherParameters instanceof ParametersWithRandom) {
                ParametersWithRandom parametersWithRandom = (ParametersWithRandom) cipherParameters;
                this.secureRandom = parametersWithRandom.getRandom();
                this.privateKey = (QTESLAPrivateKeyParameters) parametersWithRandom.getParameters();
            } else {
                this.secureRandom = CryptoServicesRegistrar.getSecureRandom();
                this.privateKey = (QTESLAPrivateKeyParameters) cipherParameters;
            }
            this.publicKey = null;
            QTESLASecurityCategory.validate(this.privateKey.getSecurityCategory());
            return;
        }
        this.privateKey = null;
        QTESLAPublicKeyParameters qTESLAPublicKeyParameters = (QTESLAPublicKeyParameters) cipherParameters;
        this.publicKey = qTESLAPublicKeyParameters;
        QTESLASecurityCategory.validate(qTESLAPublicKeyParameters.getSecurityCategory());
    }

    public boolean verifySignature(byte[] bArr, byte[] bArr2) {
        int i;
        int securityCategory = this.publicKey.getSecurityCategory();
        if (securityCategory == 5) {
            i = QTesla1p.verifying(bArr, bArr2, 0, bArr2.length, this.publicKey.getPublicData());
        } else if (securityCategory == 6) {
            i = QTesla3p.verifying(bArr, bArr2, 0, bArr2.length, this.publicKey.getPublicData());
        } else {
            throw new IllegalArgumentException("unknown security category: " + this.publicKey.getSecurityCategory());
        }
        if (i == 0) {
            return true;
        }
        return false;
    }
}
