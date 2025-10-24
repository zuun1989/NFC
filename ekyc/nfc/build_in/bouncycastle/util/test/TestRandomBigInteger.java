package com.fis.ekyc.nfc.build_in.bouncycastle.util.test;

import com.fis.ekyc.nfc.build_in.bouncycastle.util.BigIntegers;
import com.fis.ekyc.nfc.build_in.bouncycastle.util.test.FixedSecureRandom;
import java.math.BigInteger;

public class TestRandomBigInteger extends FixedSecureRandom {
    public TestRandomBigInteger(String str) {
        this(str, 10);
    }

    public TestRandomBigInteger(String str, int i) {
        super(new FixedSecureRandom.Source[]{new FixedSecureRandom.BigInteger(BigIntegers.asUnsignedByteArray(new BigInteger(str, i)))});
    }

    public TestRandomBigInteger(byte[] bArr) {
        super(new FixedSecureRandom.Source[]{new FixedSecureRandom.BigInteger(bArr)});
    }

    public TestRandomBigInteger(int i, byte[] bArr) {
        super(new FixedSecureRandom.Source[]{new FixedSecureRandom.BigInteger(i, bArr)});
    }
}
