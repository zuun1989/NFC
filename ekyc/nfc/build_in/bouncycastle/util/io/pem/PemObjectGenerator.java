package com.fis.ekyc.nfc.build_in.bouncycastle.util.io.pem;

public interface PemObjectGenerator {
    PemObject generate() throws PemGenerationException;
}
