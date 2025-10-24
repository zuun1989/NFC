package com.fis.ekyc.nfc.build_in.bouncycastle.crypto;

import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.params.AsymmetricKeyParameter;
import java.io.IOException;
import java.io.InputStream;

public interface KeyParser {
    AsymmetricKeyParameter readKey(InputStream inputStream) throws IOException;
}
