package com.fis.ekyc.nfc.build_in.eidparser.cbeff;

import com.fis.ekyc.nfc.build_in.eidparser.cbeff.BiometricDataBlock;
import java.io.IOException;
import java.io.InputStream;

public interface BiometricDataBlockDecoder<B extends BiometricDataBlock> {
    B decode(InputStream inputStream, StandardBiometricHeader standardBiometricHeader, int i, int i2) throws IOException;
}
