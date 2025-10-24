package com.fis.ekyc.nfc.build_in.bouncycastle.pqc.crypto.newhope;

import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.params.AsymmetricKeyParameter;
import com.fis.ekyc.nfc.build_in.bouncycastle.pqc.crypto.ExchangePair;
import com.fis.ekyc.nfc.build_in.bouncycastle.pqc.crypto.ExchangePairGenerator;
import java.security.SecureRandom;

public class NHExchangePairGenerator implements ExchangePairGenerator {
    private final SecureRandom random;

    public NHExchangePairGenerator(SecureRandom secureRandom) {
        this.random = secureRandom;
    }

    public ExchangePair GenerateExchange(AsymmetricKeyParameter asymmetricKeyParameter) {
        return generateExchange(asymmetricKeyParameter);
    }

    public ExchangePair generateExchange(AsymmetricKeyParameter asymmetricKeyParameter) {
        byte[] bArr = new byte[32];
        byte[] bArr2 = new byte[2048];
        NewHope.sharedB(this.random, bArr, bArr2, ((NHPublicKeyParameters) asymmetricKeyParameter).pubData);
        return new ExchangePair(new NHPublicKeyParameters(bArr2), bArr);
    }
}
