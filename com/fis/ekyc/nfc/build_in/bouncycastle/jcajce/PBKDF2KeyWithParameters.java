package com.fis.ekyc.nfc.build_in.bouncycastle.jcajce;

import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.CharToByteConverter;
import com.fis.ekyc.nfc.build_in.bouncycastle.util.Arrays;
import javax.crypto.interfaces.PBEKey;

public class PBKDF2KeyWithParameters extends PBKDF2Key implements PBEKey {
    private final int iterationCount;
    private final byte[] salt;

    public PBKDF2KeyWithParameters(char[] cArr, CharToByteConverter charToByteConverter, byte[] bArr, int i) {
        super(cArr, charToByteConverter);
        this.salt = Arrays.clone(bArr);
        this.iterationCount = i;
    }

    public int getIterationCount() {
        return this.iterationCount;
    }

    public byte[] getSalt() {
        return this.salt;
    }
}
