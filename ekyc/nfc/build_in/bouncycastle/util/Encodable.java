package com.fis.ekyc.nfc.build_in.bouncycastle.util;

import java.io.IOException;

public interface Encodable {
    byte[] getEncoded() throws IOException;
}
