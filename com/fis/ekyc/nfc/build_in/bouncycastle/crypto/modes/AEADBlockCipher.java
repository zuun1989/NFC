package com.fis.ekyc.nfc.build_in.bouncycastle.crypto.modes;

import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.BlockCipher;

public interface AEADBlockCipher extends AEADCipher {
    BlockCipher getUnderlyingCipher();
}
