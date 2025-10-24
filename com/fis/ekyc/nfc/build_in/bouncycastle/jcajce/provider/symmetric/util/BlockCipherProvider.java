package com.fis.ekyc.nfc.build_in.bouncycastle.jcajce.provider.symmetric.util;

import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.BlockCipher;

public interface BlockCipherProvider {
    BlockCipher get();
}
