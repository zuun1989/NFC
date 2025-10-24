package com.fis.ekyc.nfc.build_in.bouncycastle.crypto.macs;

import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.BlockCipher;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.CipherParameters;

public class CMacWithIV extends CMac {
    public CMacWithIV(BlockCipher blockCipher) {
        super(blockCipher);
    }

    public void validate(CipherParameters cipherParameters) {
    }

    public CMacWithIV(BlockCipher blockCipher, int i) {
        super(blockCipher, i);
    }
}
