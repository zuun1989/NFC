package com.fis.ekyc.nfc.build_in.bouncycastle.pqc.crypto.ntru;

import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.AsymmetricBlockCipher;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.CipherParameters;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.CryptoServicesRegistrar;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.DataLengthException;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.Digest;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.InvalidCipherTextException;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.params.ParametersWithRandom;
import com.fis.ekyc.nfc.build_in.bouncycastle.pqc.math.ntru.polynomial.DenseTernaryPolynomial;
import com.fis.ekyc.nfc.build_in.bouncycastle.pqc.math.ntru.polynomial.IntegerPolynomial;
import com.fis.ekyc.nfc.build_in.bouncycastle.pqc.math.ntru.polynomial.Polynomial;
import com.fis.ekyc.nfc.build_in.bouncycastle.pqc.math.ntru.polynomial.ProductFormPolynomial;
import com.fis.ekyc.nfc.build_in.bouncycastle.pqc.math.ntru.polynomial.SparseTernaryPolynomial;
import com.fis.ekyc.nfc.build_in.bouncycastle.pqc.math.ntru.polynomial.TernaryPolynomial;
import com.fis.ekyc.nfc.build_in.bouncycastle.util.Arrays;
import java.security.SecureRandom;

public class NTRUEngine implements AsymmetricBlockCipher {
    private boolean forEncryption;
    private NTRUEncryptionParameters params;
    private NTRUEncryptionPrivateKeyParameters privKey;
    private NTRUEncryptionPublicKeyParameters pubKey;
    private SecureRandom random;

    private IntegerPolynomial MGF(byte[] bArr, int i, int i2, boolean z) {
        Digest digest = this.params.hashAlg;
        int digestSize = digest.getDigestSize();
        byte[] bArr2 = new byte[(i2 * digestSize)];
        if (z) {
            bArr = calcHash(digest, bArr);
        }
        int i3 = 0;
        while (i3 < i2) {
            digest.update(bArr, 0, bArr.length);
            putInt(digest, i3);
            System.arraycopy(calcHash(digest), 0, bArr2, i3 * digestSize, digestSize);
            i3++;
        }
        IntegerPolynomial integerPolynomial = new IntegerPolynomial(i);
        while (true) {
            int i4 = 0;
            for (int i5 = 0; i5 != bArr2.length; i5++) {
                int i6 = bArr2[i5] & 255;
                if (i6 < 243) {
                    for (int i7 = 0; i7 < 4; i7++) {
                        int i8 = i6 % 3;
                        integerPolynomial.coeffs[i4] = i8 - 1;
                        i4++;
                        if (i4 == i) {
                            return integerPolynomial;
                        }
                        i6 = (i6 - i8) / 3;
                    }
                    integerPolynomial.coeffs[i4] = i6 - 1;
                    i4++;
                    if (i4 == i) {
                        return integerPolynomial;
                    }
                }
            }
            if (i4 >= i) {
                return integerPolynomial;
            }
            digest.update(bArr, 0, bArr.length);
            putInt(digest, i3);
            bArr2 = calcHash(digest);
            i3++;
        }
    }

    private byte[] buildSData(byte[] bArr, byte[] bArr2, int i, byte[] bArr3, byte[] bArr4) {
        byte[] bArr5 = new byte[(bArr.length + i + bArr3.length + bArr4.length)];
        System.arraycopy(bArr, 0, bArr5, 0, bArr.length);
        System.arraycopy(bArr2, 0, bArr5, bArr.length, bArr2.length);
        System.arraycopy(bArr3, 0, bArr5, bArr.length + bArr2.length, bArr3.length);
        System.arraycopy(bArr4, 0, bArr5, bArr.length + bArr2.length + bArr3.length, bArr4.length);
        return bArr5;
    }

    private byte[] calcHash(Digest digest) {
        byte[] bArr = new byte[digest.getDigestSize()];
        digest.doFinal(bArr, 0);
        return bArr;
    }

    private byte[] copyOf(byte[] bArr, int i) {
        byte[] bArr2 = new byte[i];
        if (i >= bArr.length) {
            i = bArr.length;
        }
        System.arraycopy(bArr, 0, bArr2, 0, i);
        return bArr2;
    }

    private byte[] decrypt(byte[] bArr, NTRUEncryptionPrivateKeyParameters nTRUEncryptionPrivateKeyParameters) throws InvalidCipherTextException {
        NTRUEncryptionPrivateKeyParameters nTRUEncryptionPrivateKeyParameters2 = nTRUEncryptionPrivateKeyParameters;
        Polynomial polynomial = nTRUEncryptionPrivateKeyParameters2.t;
        IntegerPolynomial integerPolynomial = nTRUEncryptionPrivateKeyParameters2.fp;
        IntegerPolynomial integerPolynomial2 = nTRUEncryptionPrivateKeyParameters2.h;
        NTRUEncryptionParameters nTRUEncryptionParameters = this.params;
        int i = nTRUEncryptionParameters.N;
        int i2 = nTRUEncryptionParameters.q;
        int i3 = nTRUEncryptionParameters.db;
        int i4 = nTRUEncryptionParameters.maxMsgLenBytes;
        int i5 = nTRUEncryptionParameters.dm0;
        int i6 = nTRUEncryptionParameters.pkLen;
        int i7 = nTRUEncryptionParameters.minCallsMask;
        boolean z = nTRUEncryptionParameters.hashSeed;
        byte[] bArr2 = nTRUEncryptionParameters.oid;
        if (i4 <= 255) {
            int i8 = i3 / 8;
            IntegerPolynomial fromBinary = IntegerPolynomial.fromBinary(bArr, i, i2);
            IntegerPolynomial decrypt = decrypt(fromBinary, polynomial, integerPolynomial);
            if (decrypt.count(-1) < i5) {
                throw new InvalidCipherTextException("Less than dm0 coefficients equal -1");
            } else if (decrypt.count(0) < i5) {
                throw new InvalidCipherTextException("Less than dm0 coefficients equal 0");
            } else if (decrypt.count(1) >= i5) {
                IntegerPolynomial integerPolynomial3 = (IntegerPolynomial) fromBinary.clone();
                integerPolynomial3.sub(decrypt);
                integerPolynomial3.modPositive(i2);
                IntegerPolynomial integerPolynomial4 = (IntegerPolynomial) integerPolynomial3.clone();
                integerPolynomial4.modPositive(4);
                decrypt.sub(MGF(integerPolynomial4.toBinary(4), i, i7, z));
                decrypt.mod3();
                byte[] binary3Sves = decrypt.toBinary3Sves();
                byte[] bArr3 = new byte[i8];
                System.arraycopy(binary3Sves, 0, bArr3, 0, i8);
                int i9 = 255 & binary3Sves[i8];
                if (i9 <= i4) {
                    byte[] bArr4 = new byte[i9];
                    int i10 = i8 + 1;
                    System.arraycopy(binary3Sves, i10, bArr4, 0, i9);
                    int i11 = i10 + i9;
                    int length = binary3Sves.length - i11;
                    byte[] bArr5 = new byte[length];
                    System.arraycopy(binary3Sves, i11, bArr5, 0, length);
                    if (Arrays.constantTimeAreEqual(bArr5, new byte[length])) {
                        IntegerPolynomial mult = generateBlindingPoly(buildSData(bArr2, bArr4, i9, bArr3, copyOf(integerPolynomial2.toBinary(i2), i6 / 8)), bArr4).mult(integerPolynomial2);
                        mult.modPositive(i2);
                        if (mult.equals(integerPolynomial3)) {
                            return bArr4;
                        }
                        throw new InvalidCipherTextException("Invalid message encoding");
                    }
                    throw new InvalidCipherTextException("The message is not followed by zeroes");
                }
                throw new InvalidCipherTextException("Message too long: " + i9 + ">" + i4);
            } else {
                throw new InvalidCipherTextException("Less than dm0 coefficients equal 1");
            }
        } else {
            throw new DataLengthException("maxMsgLenBytes values bigger than 255 are not supported");
        }
    }

    private byte[] encrypt(byte[] bArr, NTRUEncryptionPublicKeyParameters nTRUEncryptionPublicKeyParameters) {
        byte[] bArr2 = bArr;
        IntegerPolynomial integerPolynomial = nTRUEncryptionPublicKeyParameters.h;
        NTRUEncryptionParameters nTRUEncryptionParameters = this.params;
        int i = nTRUEncryptionParameters.N;
        int i2 = nTRUEncryptionParameters.q;
        int i3 = nTRUEncryptionParameters.maxMsgLenBytes;
        int i4 = nTRUEncryptionParameters.db;
        int i5 = nTRUEncryptionParameters.bufferLenBits;
        int i6 = nTRUEncryptionParameters.dm0;
        int i7 = nTRUEncryptionParameters.pkLen;
        int i8 = nTRUEncryptionParameters.minCallsMask;
        boolean z = nTRUEncryptionParameters.hashSeed;
        byte[] bArr3 = nTRUEncryptionParameters.oid;
        int length = bArr2.length;
        if (i3 > 255) {
            throw new IllegalArgumentException("llen values bigger than 1 are not supported");
        } else if (length <= i3) {
            while (true) {
                int i9 = i4 / 8;
                byte[] bArr4 = new byte[i9];
                boolean z2 = z;
                this.random.nextBytes(bArr4);
                int i10 = (i3 + 1) - length;
                int i11 = i8;
                int i12 = i4;
                byte[] bArr5 = new byte[(i5 / 8)];
                int i13 = i5;
                System.arraycopy(bArr4, 0, bArr5, 0, i9);
                bArr5[i9] = (byte) length;
                int i14 = i9 + 1;
                System.arraycopy(bArr2, 0, bArr5, i14, bArr2.length);
                System.arraycopy(new byte[i10], 0, bArr5, i14 + bArr2.length, i10);
                IntegerPolynomial fromBinary3Sves = IntegerPolynomial.fromBinary3Sves(bArr5, i);
                byte[] copyOf = copyOf(integerPolynomial.toBinary(i2), i7 / 8);
                byte[] bArr6 = bArr4;
                int i15 = length;
                byte[] bArr7 = bArr3;
                boolean z3 = z2;
                int i16 = i7;
                int i17 = i11;
                IntegerPolynomial mult = generateBlindingPoly(buildSData(bArr3, bArr, i15, bArr6, copyOf), bArr5).mult(integerPolynomial, i2);
                IntegerPolynomial integerPolynomial2 = (IntegerPolynomial) mult.clone();
                integerPolynomial2.modPositive(4);
                fromBinary3Sves.add(MGF(integerPolynomial2.toBinary(4), i, i17, z3));
                fromBinary3Sves.mod3();
                if (fromBinary3Sves.count(-1) >= i6 && fromBinary3Sves.count(0) >= i6 && fromBinary3Sves.count(1) >= i6) {
                    mult.add(fromBinary3Sves, i2);
                    mult.ensurePositive(i2);
                    return mult.toBinary(i2);
                }
                z = z3;
                i8 = i17;
                i7 = i16;
                i4 = i12;
                i5 = i13;
                length = i15;
                bArr3 = bArr7;
                bArr2 = bArr;
            }
        } else {
            throw new DataLengthException("Message too long: " + length + ">" + i3);
        }
    }

    private int[] generateBlindingCoeffs(IndexGenerator indexGenerator, int i) {
        int[] iArr = new int[this.params.N];
        for (int i2 = -1; i2 <= 1; i2 += 2) {
            int i3 = 0;
            while (i3 < i) {
                int nextIndex = indexGenerator.nextIndex();
                if (iArr[nextIndex] == 0) {
                    iArr[nextIndex] = i2;
                    i3++;
                }
            }
        }
        return iArr;
    }

    private Polynomial generateBlindingPoly(byte[] bArr, byte[] bArr2) {
        IndexGenerator indexGenerator = new IndexGenerator(bArr, this.params);
        NTRUEncryptionParameters nTRUEncryptionParameters = this.params;
        if (nTRUEncryptionParameters.polyType == 1) {
            return new ProductFormPolynomial(new SparseTernaryPolynomial(generateBlindingCoeffs(indexGenerator, nTRUEncryptionParameters.dr1)), new SparseTernaryPolynomial(generateBlindingCoeffs(indexGenerator, this.params.dr2)), new SparseTernaryPolynomial(generateBlindingCoeffs(indexGenerator, this.params.dr3)));
        }
        int i = nTRUEncryptionParameters.dr;
        boolean z = nTRUEncryptionParameters.sparse;
        int[] generateBlindingCoeffs = generateBlindingCoeffs(indexGenerator, i);
        if (z) {
            return new SparseTernaryPolynomial(generateBlindingCoeffs);
        }
        return new DenseTernaryPolynomial(generateBlindingCoeffs);
    }

    private int log2(int i) {
        if (i == 2048) {
            return 11;
        }
        throw new IllegalStateException("log2 not fully implemented");
    }

    private void putInt(Digest digest, int i) {
        digest.update((byte) (i >> 24));
        digest.update((byte) (i >> 16));
        digest.update((byte) (i >> 8));
        digest.update((byte) i);
    }

    public int getInputBlockSize() {
        return this.params.maxMsgLenBytes;
    }

    public int getOutputBlockSize() {
        NTRUEncryptionParameters nTRUEncryptionParameters = this.params;
        return ((nTRUEncryptionParameters.N * log2(nTRUEncryptionParameters.q)) + 7) / 8;
    }

    public void init(boolean z, CipherParameters cipherParameters) {
        this.forEncryption = z;
        if (z) {
            if (cipherParameters instanceof ParametersWithRandom) {
                ParametersWithRandom parametersWithRandom = (ParametersWithRandom) cipherParameters;
                this.random = parametersWithRandom.getRandom();
                this.pubKey = (NTRUEncryptionPublicKeyParameters) parametersWithRandom.getParameters();
            } else {
                this.random = CryptoServicesRegistrar.getSecureRandom();
                this.pubKey = (NTRUEncryptionPublicKeyParameters) cipherParameters;
            }
            this.params = this.pubKey.getParameters();
            return;
        }
        NTRUEncryptionPrivateKeyParameters nTRUEncryptionPrivateKeyParameters = (NTRUEncryptionPrivateKeyParameters) cipherParameters;
        this.privKey = nTRUEncryptionPrivateKeyParameters;
        this.params = nTRUEncryptionPrivateKeyParameters.getParameters();
    }

    public byte[] processBlock(byte[] bArr, int i, int i2) throws InvalidCipherTextException {
        byte[] bArr2 = new byte[i2];
        System.arraycopy(bArr, i, bArr2, 0, i2);
        if (this.forEncryption) {
            return encrypt(bArr2, this.pubKey);
        }
        return decrypt(bArr2, this.privKey);
    }

    private byte[] calcHash(Digest digest, byte[] bArr) {
        byte[] bArr2 = new byte[digest.getDigestSize()];
        digest.update(bArr, 0, bArr.length);
        digest.doFinal(bArr2, 0);
        return bArr2;
    }

    public IntegerPolynomial encrypt(IntegerPolynomial integerPolynomial, TernaryPolynomial ternaryPolynomial, IntegerPolynomial integerPolynomial2) {
        IntegerPolynomial mult = ternaryPolynomial.mult(integerPolynomial2, this.params.q);
        mult.add(integerPolynomial, this.params.q);
        mult.ensurePositive(this.params.q);
        return mult;
    }

    public IntegerPolynomial decrypt(IntegerPolynomial integerPolynomial, Polynomial polynomial, IntegerPolynomial integerPolynomial2) {
        IntegerPolynomial integerPolynomial3;
        NTRUEncryptionParameters nTRUEncryptionParameters = this.params;
        if (nTRUEncryptionParameters.fastFp) {
            integerPolynomial3 = polynomial.mult(integerPolynomial, nTRUEncryptionParameters.q);
            integerPolynomial3.mult(3);
            integerPolynomial3.add(integerPolynomial);
        } else {
            integerPolynomial3 = polynomial.mult(integerPolynomial, nTRUEncryptionParameters.q);
        }
        integerPolynomial3.center0(this.params.q);
        integerPolynomial3.mod3();
        if (!this.params.fastFp) {
            integerPolynomial3 = new DenseTernaryPolynomial(integerPolynomial3).mult(integerPolynomial2, 3);
        }
        integerPolynomial3.center0(3);
        return integerPolynomial3;
    }
}
