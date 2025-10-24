package com.fis.ekyc.nfc.build_in.bouncycastle.crypto.agreement.srp;

import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.Digest;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.params.SRP6GroupParameters;
import java.math.BigInteger;

public class SRP6VerifierGenerator {
    protected BigInteger N;
    protected Digest digest;
    protected BigInteger g;

    public BigInteger generateVerifier(byte[] bArr, byte[] bArr2, byte[] bArr3) {
        return this.g.modPow(SRP6Util.calculateX(this.digest, this.N, bArr, bArr2, bArr3), this.N);
    }

    public void init(BigInteger bigInteger, BigInteger bigInteger2, Digest digest2) {
        this.N = bigInteger;
        this.g = bigInteger2;
        this.digest = digest2;
    }

    public void init(SRP6GroupParameters sRP6GroupParameters, Digest digest2) {
        this.N = sRP6GroupParameters.getN();
        this.g = sRP6GroupParameters.getG();
        this.digest = digest2;
    }
}
