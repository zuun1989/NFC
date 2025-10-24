package com.fis.ekyc.nfc.build_in.bouncycastle.crypto;

public interface EncapsulatedSecretExtractor {
    byte[] extractSecret(byte[] bArr);
}
