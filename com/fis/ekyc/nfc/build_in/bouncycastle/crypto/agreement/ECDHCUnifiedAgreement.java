package com.fis.ekyc.nfc.build_in.bouncycastle.crypto.agreement;

import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.CipherParameters;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.params.ECDHUPrivateParameters;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.params.ECDHUPublicParameters;
import com.fis.ekyc.nfc.build_in.bouncycastle.util.BigIntegers;
import java.math.BigInteger;

public class ECDHCUnifiedAgreement {
    private ECDHUPrivateParameters privParams;

    public byte[] calculateAgreement(CipherParameters cipherParameters) {
        ECDHUPublicParameters eCDHUPublicParameters = (ECDHUPublicParameters) cipherParameters;
        ECDHCBasicAgreement eCDHCBasicAgreement = new ECDHCBasicAgreement();
        ECDHCBasicAgreement eCDHCBasicAgreement2 = new ECDHCBasicAgreement();
        eCDHCBasicAgreement.init(this.privParams.getStaticPrivateKey());
        BigInteger calculateAgreement = eCDHCBasicAgreement.calculateAgreement(eCDHUPublicParameters.getStaticPublicKey());
        eCDHCBasicAgreement2.init(this.privParams.getEphemeralPrivateKey());
        BigInteger calculateAgreement2 = eCDHCBasicAgreement2.calculateAgreement(eCDHUPublicParameters.getEphemeralPublicKey());
        int fieldSize = getFieldSize();
        byte[] bArr = new byte[(fieldSize * 2)];
        BigIntegers.asUnsignedByteArray(calculateAgreement2, bArr, 0, fieldSize);
        BigIntegers.asUnsignedByteArray(calculateAgreement, bArr, fieldSize, fieldSize);
        return bArr;
    }

    public int getFieldSize() {
        return (this.privParams.getStaticPrivateKey().getParameters().getCurve().getFieldSize() + 7) / 8;
    }

    public void init(CipherParameters cipherParameters) {
        this.privParams = (ECDHUPrivateParameters) cipherParameters;
    }
}
