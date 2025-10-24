package com.fis.ekyc.nfc.build_in.eidparser.cbeff;

import com.fis.ekyc.nfc.build_in.eidparser.cbeff.BiometricDataBlock;
import java.io.IOException;
import java.io.OutputStream;

public interface BiometricDataBlockEncoder<B extends BiometricDataBlock> {
    void encode(B b, OutputStream outputStream) throws IOException;
}
