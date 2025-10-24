package com.fis.ekyc.nfc.build_in.bouncycastle.crypto.ec;

import com.fis.ekyc.nfc.build_in.bouncycastle.math.ec.ECConstants;
import com.fis.ekyc.nfc.build_in.bouncycastle.util.BigIntegers;
import java.math.BigInteger;
import java.security.SecureRandom;

class ECUtil {
    public static BigInteger generateK(BigInteger bigInteger, SecureRandom secureRandom) {
        int bitLength = bigInteger.bitLength();
        while (true) {
            BigInteger createRandomBigInteger = BigIntegers.createRandomBigInteger(bitLength, secureRandom);
            if (!createRandomBigInteger.equals(ECConstants.ZERO) && createRandomBigInteger.compareTo(bigInteger) < 0) {
                return createRandomBigInteger;
            }
        }
    }
}
