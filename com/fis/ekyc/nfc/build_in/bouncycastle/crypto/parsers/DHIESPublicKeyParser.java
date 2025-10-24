package com.fis.ekyc.nfc.build_in.bouncycastle.crypto.parsers;

import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.KeyParser;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.params.AsymmetricKeyParameter;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.params.DHParameters;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.params.DHPublicKeyParameters;
import com.fis.ekyc.nfc.build_in.bouncycastle.util.io.Streams;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigInteger;

public class DHIESPublicKeyParser implements KeyParser {
    private DHParameters dhParams;

    public DHIESPublicKeyParser(DHParameters dHParameters) {
        this.dhParams = dHParameters;
    }

    public AsymmetricKeyParameter readKey(InputStream inputStream) throws IOException {
        int bitLength = (this.dhParams.getP().bitLength() + 7) / 8;
        byte[] bArr = new byte[bitLength];
        Streams.readFully(inputStream, bArr, 0, bitLength);
        return new DHPublicKeyParameters(new BigInteger(1, bArr), this.dhParams);
    }
}
