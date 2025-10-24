package com.fis.ekyc.nfc.build_in.bouncycastle.jcajce.provider.asymmetric.util;

import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.BlockCipher;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.BufferedBlockCipher;
import com.fis.ekyc.nfc.build_in.bouncycastle.jce.spec.IESParameterSpec;

public class IESUtil {
    public static IESParameterSpec guessParameterSpec(BufferedBlockCipher bufferedBlockCipher, byte[] bArr) {
        if (bufferedBlockCipher == null) {
            return new IESParameterSpec((byte[]) null, (byte[]) null, 128);
        }
        BlockCipher underlyingCipher = bufferedBlockCipher.getUnderlyingCipher();
        if (underlyingCipher.getAlgorithmName().equals("DES") || underlyingCipher.getAlgorithmName().equals("RC2") || underlyingCipher.getAlgorithmName().equals("RC5-32") || underlyingCipher.getAlgorithmName().equals("RC5-64")) {
            return new IESParameterSpec((byte[]) null, (byte[]) null, 64, 64, bArr);
        }
        if (underlyingCipher.getAlgorithmName().equals("SKIPJACK")) {
            return new IESParameterSpec((byte[]) null, (byte[]) null, 80, 80, bArr);
        }
        if (underlyingCipher.getAlgorithmName().equals("GOST28147")) {
            return new IESParameterSpec((byte[]) null, (byte[]) null, 256, 256, bArr);
        }
        return new IESParameterSpec((byte[]) null, (byte[]) null, 128, 128, bArr);
    }
}
