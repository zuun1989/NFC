package com.fis.ekyc.nfc.build_in.bouncycastle.crypto.engines;

import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.AsymmetricBlockCipher;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.CipherParameters;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.CryptoServicesRegistrar;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.DataLengthException;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.params.ElGamalKeyParameters;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.params.ElGamalPrivateKeyParameters;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.params.ElGamalPublicKeyParameters;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.params.ParametersWithRandom;
import com.fis.ekyc.nfc.build_in.bouncycastle.util.BigIntegers;
import java.math.BigInteger;
import java.security.SecureRandom;

public class ElGamalEngine implements AsymmetricBlockCipher {
    private static final BigInteger ONE = BigInteger.valueOf(1);
    private static final BigInteger TWO = BigInteger.valueOf(2);
    private static final BigInteger ZERO = BigInteger.valueOf(0);
    private int bitSize;
    private boolean forEncryption;
    private ElGamalKeyParameters key;
    private SecureRandom random;

    public int getInputBlockSize() {
        if (this.forEncryption) {
            return (this.bitSize - 1) / 8;
        }
        return ((this.bitSize + 7) / 8) * 2;
    }

    public int getOutputBlockSize() {
        if (this.forEncryption) {
            return ((this.bitSize + 7) / 8) * 2;
        }
        return (this.bitSize - 1) / 8;
    }

    public void init(boolean z, CipherParameters cipherParameters) {
        if (cipherParameters instanceof ParametersWithRandom) {
            ParametersWithRandom parametersWithRandom = (ParametersWithRandom) cipherParameters;
            this.key = (ElGamalKeyParameters) parametersWithRandom.getParameters();
            this.random = parametersWithRandom.getRandom();
        } else {
            this.key = (ElGamalKeyParameters) cipherParameters;
            this.random = CryptoServicesRegistrar.getSecureRandom();
        }
        this.forEncryption = z;
        this.bitSize = this.key.getParameters().getP().bitLength();
        if (z) {
            if (!(this.key instanceof ElGamalPublicKeyParameters)) {
                throw new IllegalArgumentException("ElGamalPublicKeyParameters are required for encryption.");
            }
        } else if (!(this.key instanceof ElGamalPrivateKeyParameters)) {
            throw new IllegalArgumentException("ElGamalPrivateKeyParameters are required for decryption.");
        }
    }

    public byte[] processBlock(byte[] bArr, int i, int i2) {
        int i3;
        if (this.key != null) {
            if (this.forEncryption) {
                i3 = (this.bitSize + 6) / 8;
            } else {
                i3 = getInputBlockSize();
            }
            if (i2 <= i3) {
                BigInteger p = this.key.getParameters().getP();
                if (this.key instanceof ElGamalPrivateKeyParameters) {
                    int i4 = i2 / 2;
                    byte[] bArr2 = new byte[i4];
                    byte[] bArr3 = new byte[i4];
                    System.arraycopy(bArr, i, bArr2, 0, i4);
                    System.arraycopy(bArr, i + i4, bArr3, 0, i4);
                    BigInteger bigInteger = new BigInteger(1, bArr2);
                    return BigIntegers.asUnsignedByteArray(bigInteger.modPow(p.subtract(ONE).subtract(((ElGamalPrivateKeyParameters) this.key).getX()), p).multiply(new BigInteger(1, bArr3)).mod(p));
                }
                if (!(i == 0 && i2 == bArr.length)) {
                    byte[] bArr4 = new byte[i2];
                    System.arraycopy(bArr, i, bArr4, 0, i2);
                    bArr = bArr4;
                }
                BigInteger bigInteger2 = new BigInteger(1, bArr);
                if (bigInteger2.compareTo(p) < 0) {
                    ElGamalPublicKeyParameters elGamalPublicKeyParameters = (ElGamalPublicKeyParameters) this.key;
                    int bitLength = p.bitLength();
                    BigInteger createRandomBigInteger = BigIntegers.createRandomBigInteger(bitLength, this.random);
                    while (true) {
                        if (!createRandomBigInteger.equals(ZERO) && createRandomBigInteger.compareTo(p.subtract(TWO)) <= 0) {
                            break;
                        }
                        createRandomBigInteger = BigIntegers.createRandomBigInteger(bitLength, this.random);
                    }
                    BigInteger modPow = this.key.getParameters().getG().modPow(createRandomBigInteger, p);
                    BigInteger mod = bigInteger2.multiply(elGamalPublicKeyParameters.getY().modPow(createRandomBigInteger, p)).mod(p);
                    byte[] byteArray = modPow.toByteArray();
                    byte[] byteArray2 = mod.toByteArray();
                    int outputBlockSize = getOutputBlockSize();
                    byte[] bArr5 = new byte[outputBlockSize];
                    int i5 = outputBlockSize / 2;
                    if (byteArray.length > i5) {
                        System.arraycopy(byteArray, 1, bArr5, i5 - (byteArray.length - 1), byteArray.length - 1);
                    } else {
                        System.arraycopy(byteArray, 0, bArr5, i5 - byteArray.length, byteArray.length);
                    }
                    if (byteArray2.length > i5) {
                        System.arraycopy(byteArray2, 1, bArr5, outputBlockSize - (byteArray2.length - 1), byteArray2.length - 1);
                    } else {
                        System.arraycopy(byteArray2, 0, bArr5, outputBlockSize - byteArray2.length, byteArray2.length);
                    }
                    return bArr5;
                }
                throw new DataLengthException("input too large for ElGamal cipher.\n");
            }
            throw new DataLengthException("input too large for ElGamal cipher.\n");
        }
        throw new IllegalStateException("ElGamal engine not initialised");
    }
}
