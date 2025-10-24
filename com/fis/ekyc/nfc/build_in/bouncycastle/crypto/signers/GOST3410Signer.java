package com.fis.ekyc.nfc.build_in.bouncycastle.crypto.signers;

import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.CipherParameters;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.CryptoServicesRegistrar;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.DSAExt;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.params.GOST3410KeyParameters;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.params.GOST3410Parameters;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.params.GOST3410PrivateKeyParameters;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.params.GOST3410PublicKeyParameters;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.params.ParametersWithRandom;
import com.fis.ekyc.nfc.build_in.bouncycastle.util.Arrays;
import com.fis.ekyc.nfc.build_in.bouncycastle.util.BigIntegers;
import java.math.BigInteger;
import java.security.SecureRandom;

public class GOST3410Signer implements DSAExt {
    GOST3410KeyParameters key;
    SecureRandom random;

    public BigInteger[] generateSignature(byte[] bArr) {
        BigInteger createRandomBigInteger;
        BigInteger bigInteger = new BigInteger(1, Arrays.reverse(bArr));
        GOST3410Parameters parameters = this.key.getParameters();
        do {
            createRandomBigInteger = BigIntegers.createRandomBigInteger(parameters.getQ().bitLength(), this.random);
        } while (createRandomBigInteger.compareTo(parameters.getQ()) >= 0);
        BigInteger mod = parameters.getA().modPow(createRandomBigInteger, parameters.getP()).mod(parameters.getQ());
        return new BigInteger[]{mod, createRandomBigInteger.multiply(bigInteger).add(((GOST3410PrivateKeyParameters) this.key).getX().multiply(mod)).mod(parameters.getQ())};
    }

    public BigInteger getOrder() {
        return this.key.getParameters().getQ();
    }

    public void init(boolean z, CipherParameters cipherParameters) {
        if (!z) {
            this.key = (GOST3410PublicKeyParameters) cipherParameters;
        } else if (cipherParameters instanceof ParametersWithRandom) {
            ParametersWithRandom parametersWithRandom = (ParametersWithRandom) cipherParameters;
            this.random = parametersWithRandom.getRandom();
            this.key = (GOST3410PrivateKeyParameters) parametersWithRandom.getParameters();
        } else {
            this.random = CryptoServicesRegistrar.getSecureRandom();
            this.key = (GOST3410PrivateKeyParameters) cipherParameters;
        }
    }

    public boolean verifySignature(byte[] bArr, BigInteger bigInteger, BigInteger bigInteger2) {
        BigInteger bigInteger3 = new BigInteger(1, Arrays.reverse(bArr));
        GOST3410Parameters parameters = this.key.getParameters();
        BigInteger valueOf = BigInteger.valueOf(0);
        if (valueOf.compareTo(bigInteger) >= 0 || parameters.getQ().compareTo(bigInteger) <= 0 || valueOf.compareTo(bigInteger2) >= 0 || parameters.getQ().compareTo(bigInteger2) <= 0) {
            return false;
        }
        BigInteger modPow = bigInteger3.modPow(parameters.getQ().subtract(new BigInteger("2")), parameters.getQ());
        return parameters.getA().modPow(bigInteger2.multiply(modPow).mod(parameters.getQ()), parameters.getP()).multiply(((GOST3410PublicKeyParameters) this.key).getY().modPow(parameters.getQ().subtract(bigInteger).multiply(modPow).mod(parameters.getQ()), parameters.getP())).mod(parameters.getP()).mod(parameters.getQ()).equals(bigInteger);
    }
}
