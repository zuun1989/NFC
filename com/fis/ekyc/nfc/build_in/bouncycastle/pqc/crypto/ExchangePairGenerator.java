package com.fis.ekyc.nfc.build_in.bouncycastle.pqc.crypto;

import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.params.AsymmetricKeyParameter;

public interface ExchangePairGenerator {
    ExchangePair GenerateExchange(AsymmetricKeyParameter asymmetricKeyParameter);

    ExchangePair generateExchange(AsymmetricKeyParameter asymmetricKeyParameter);
}
