package com.fis.ekyc.nfc.build_in.bouncycastle.pqc.crypto.ntru;

import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.AsymmetricCipherKeyPair;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.AsymmetricCipherKeyPairGenerator;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.KeyGenerationParameters;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.params.AsymmetricKeyParameter;
import com.fis.ekyc.nfc.build_in.bouncycastle.pqc.math.ntru.polynomial.DenseTernaryPolynomial;
import com.fis.ekyc.nfc.build_in.bouncycastle.pqc.math.ntru.polynomial.IntegerPolynomial;
import com.fis.ekyc.nfc.build_in.bouncycastle.pqc.math.ntru.polynomial.Polynomial;
import com.fis.ekyc.nfc.build_in.bouncycastle.pqc.math.ntru.polynomial.ProductFormPolynomial;
import com.fis.ekyc.nfc.build_in.bouncycastle.pqc.math.ntru.util.Util;

public class NTRUEncryptionKeyPairGenerator implements AsymmetricCipherKeyPairGenerator {
    private NTRUEncryptionKeyGenerationParameters params;

    public AsymmetricCipherKeyPair generateKeyPair() {
        IntegerPolynomial integerPolynomial;
        Polynomial polynomial;
        IntegerPolynomial invertFq;
        IntegerPolynomial integerPolynomial2;
        DenseTernaryPolynomial generateRandom;
        Polynomial generateRandom2;
        NTRUEncryptionKeyGenerationParameters nTRUEncryptionKeyGenerationParameters = this.params;
        int i = nTRUEncryptionKeyGenerationParameters.N;
        int i2 = nTRUEncryptionKeyGenerationParameters.q;
        int i3 = nTRUEncryptionKeyGenerationParameters.df;
        int i4 = nTRUEncryptionKeyGenerationParameters.df1;
        int i5 = nTRUEncryptionKeyGenerationParameters.df2;
        int i6 = nTRUEncryptionKeyGenerationParameters.df3;
        int i7 = nTRUEncryptionKeyGenerationParameters.dg;
        boolean z = nTRUEncryptionKeyGenerationParameters.fastFp;
        boolean z2 = nTRUEncryptionKeyGenerationParameters.sparse;
        IntegerPolynomial integerPolynomial3 = null;
        while (true) {
            if (z) {
                NTRUEncryptionKeyGenerationParameters nTRUEncryptionKeyGenerationParameters2 = this.params;
                if (nTRUEncryptionKeyGenerationParameters2.polyType == 0) {
                    polynomial = Util.generateRandomTernary(i, i3, i3, z2, nTRUEncryptionKeyGenerationParameters2.getRandom());
                } else {
                    polynomial = ProductFormPolynomial.generateRandom(i, i4, i5, i6, i6, nTRUEncryptionKeyGenerationParameters2.getRandom());
                }
                integerPolynomial = polynomial.toIntegerPolynomial();
                integerPolynomial.mult(3);
                int[] iArr = integerPolynomial.coeffs;
                iArr[0] = iArr[0] + 1;
            } else {
                NTRUEncryptionKeyGenerationParameters nTRUEncryptionKeyGenerationParameters3 = this.params;
                if (nTRUEncryptionKeyGenerationParameters3.polyType == 0) {
                    generateRandom2 = Util.generateRandomTernary(i, i3, i3 - 1, z2, nTRUEncryptionKeyGenerationParameters3.getRandom());
                } else {
                    generateRandom2 = ProductFormPolynomial.generateRandom(i, i4, i5, i6, i6 - 1, nTRUEncryptionKeyGenerationParameters3.getRandom());
                }
                integerPolynomial = polynomial.toIntegerPolynomial();
                integerPolynomial3 = integerPolynomial.invertF3();
                if (integerPolynomial3 == null) {
                    continue;
                }
            }
            invertFq = integerPolynomial.invertFq(i2);
            if (invertFq != null) {
                break;
            }
        }
        if (z) {
            integerPolynomial2 = new IntegerPolynomial(i);
            integerPolynomial2.coeffs[0] = 1;
        } else {
            integerPolynomial2 = integerPolynomial3;
        }
        do {
            generateRandom = DenseTernaryPolynomial.generateRandom(i, i7, i7 - 1, this.params.getRandom());
        } while (generateRandom.invertFq(i2) == null);
        IntegerPolynomial mult = generateRandom.mult(invertFq, i2);
        mult.mult3(i2);
        mult.ensurePositive(i2);
        generateRandom.clear();
        invertFq.clear();
        return new AsymmetricCipherKeyPair((AsymmetricKeyParameter) new NTRUEncryptionPublicKeyParameters(mult, this.params.getEncryptionParameters()), (AsymmetricKeyParameter) new NTRUEncryptionPrivateKeyParameters(mult, polynomial, integerPolynomial2, this.params.getEncryptionParameters()));
    }

    public void init(KeyGenerationParameters keyGenerationParameters) {
        this.params = (NTRUEncryptionKeyGenerationParameters) keyGenerationParameters;
    }
}
