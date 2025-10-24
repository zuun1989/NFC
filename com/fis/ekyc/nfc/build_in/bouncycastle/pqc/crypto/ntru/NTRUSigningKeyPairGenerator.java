package com.fis.ekyc.nfc.build_in.bouncycastle.pqc.crypto.ntru;

import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.AsymmetricCipherKeyPair;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.AsymmetricCipherKeyPairGenerator;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.CryptoServicesRegistrar;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.KeyGenerationParameters;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.params.AsymmetricKeyParameter;
import com.fis.ekyc.nfc.build_in.bouncycastle.pqc.crypto.ntru.NTRUSigningPrivateKeyParameters;
import com.fis.ekyc.nfc.build_in.bouncycastle.pqc.math.ntru.euclid.BigIntEuclidean;
import com.fis.ekyc.nfc.build_in.bouncycastle.pqc.math.ntru.polynomial.BigDecimalPolynomial;
import com.fis.ekyc.nfc.build_in.bouncycastle.pqc.math.ntru.polynomial.BigIntPolynomial;
import com.fis.ekyc.nfc.build_in.bouncycastle.pqc.math.ntru.polynomial.DenseTernaryPolynomial;
import com.fis.ekyc.nfc.build_in.bouncycastle.pqc.math.ntru.polynomial.IntegerPolynomial;
import com.fis.ekyc.nfc.build_in.bouncycastle.pqc.math.ntru.polynomial.Polynomial;
import com.fis.ekyc.nfc.build_in.bouncycastle.pqc.math.ntru.polynomial.ProductFormPolynomial;
import com.fis.ekyc.nfc.build_in.bouncycastle.pqc.math.ntru.polynomial.Resultant;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class NTRUSigningKeyPairGenerator implements AsymmetricCipherKeyPairGenerator {
    private NTRUSigningKeyGenerationParameters params;

    public class BasisGenerationTask implements Callable<NTRUSigningPrivateKeyParameters.Basis> {
        private BasisGenerationTask() {
        }

        public NTRUSigningPrivateKeyParameters.Basis call() throws Exception {
            return NTRUSigningKeyPairGenerator.this.generateBoundedBasis();
        }
    }

    public class FGBasis extends NTRUSigningPrivateKeyParameters.Basis {
        public IntegerPolynomial F;
        public IntegerPolynomial G;

        public FGBasis(Polynomial polynomial, Polynomial polynomial2, IntegerPolynomial integerPolynomial, IntegerPolynomial integerPolynomial2, IntegerPolynomial integerPolynomial3, NTRUSigningKeyGenerationParameters nTRUSigningKeyGenerationParameters) {
            super(polynomial, polynomial2, integerPolynomial, nTRUSigningKeyGenerationParameters);
            this.F = integerPolynomial2;
            this.G = integerPolynomial3;
        }

        public boolean isNormOk() {
            NTRUSigningKeyGenerationParameters nTRUSigningKeyGenerationParameters = this.params;
            double d = nTRUSigningKeyGenerationParameters.keyNormBoundSq;
            int i = nTRUSigningKeyGenerationParameters.q;
            if (((double) this.F.centeredNormSq(i)) >= d || ((double) this.G.centeredNormSq(i)) >= d) {
                return false;
            }
            return true;
        }
    }

    private FGBasis generateBasis() {
        int i;
        Polynomial generateRandom;
        Polynomial polynomial;
        IntegerPolynomial integerPolynomial;
        IntegerPolynomial invertFq;
        int i2;
        Resultant resultant;
        int i3;
        IntegerPolynomial integerPolynomial2;
        int i4;
        IntegerPolynomial integerPolynomial3;
        int i5;
        Polynomial polynomial2;
        Polynomial generateRandom2;
        Polynomial polynomial3;
        IntegerPolynomial integerPolynomial4;
        Resultant resultant2;
        BigIntEuclidean calculate;
        BigIntPolynomial bigIntPolynomial;
        IntegerPolynomial integerPolynomial5;
        IntegerPolynomial integerPolynomial6;
        NTRUSigningKeyGenerationParameters nTRUSigningKeyGenerationParameters = this.params;
        int i6 = nTRUSigningKeyGenerationParameters.N;
        int i7 = nTRUSigningKeyGenerationParameters.q;
        int i8 = nTRUSigningKeyGenerationParameters.d;
        int i9 = nTRUSigningKeyGenerationParameters.d1;
        int i10 = nTRUSigningKeyGenerationParameters.d2;
        int i11 = nTRUSigningKeyGenerationParameters.d3;
        int i12 = nTRUSigningKeyGenerationParameters.basisType;
        int i13 = (i6 * 2) + 1;
        boolean z = nTRUSigningKeyGenerationParameters.primeCheck;
        while (true) {
            if (this.params.polyType == 0) {
                generateRandom = DenseTernaryPolynomial.generateRandom(i6, i8 + 1, i8, CryptoServicesRegistrar.getSecureRandom());
                i = i13;
            } else {
                i = i13;
                generateRandom = ProductFormPolynomial.generateRandom(i6, i9, i10, i11 + 1, i11, CryptoServicesRegistrar.getSecureRandom());
            }
            polynomial = generateRandom;
            integerPolynomial = polynomial.toIntegerPolynomial();
            if (!z || !integerPolynomial.resultant(i).res.equals(BigInteger.ZERO)) {
                invertFq = integerPolynomial.invertFq(i7);
                if (invertFq != null) {
                    break;
                }
                i13 = i;
            } else {
                i13 = i;
            }
        }
        Resultant resultant3 = integerPolynomial.resultant();
        while (true) {
            if (this.params.polyType == 0) {
                generateRandom2 = DenseTernaryPolynomial.generateRandom(i6, i8 + 1, i8, CryptoServicesRegistrar.getSecureRandom());
                i2 = i8;
                i3 = i9;
                i4 = i10;
                i5 = i11;
                resultant = resultant3;
                integerPolynomial2 = invertFq;
                integerPolynomial3 = integerPolynomial;
                polynomial2 = polynomial;
            } else {
                int i14 = i9;
                i2 = i8;
                resultant = resultant3;
                int i15 = i10;
                i3 = i9;
                integerPolynomial2 = invertFq;
                int i16 = i11 + 1;
                i4 = i10;
                integerPolynomial3 = integerPolynomial;
                int i17 = i11;
                i5 = i11;
                polynomial2 = polynomial;
                generateRandom2 = ProductFormPolynomial.generateRandom(i6, i14, i15, i16, i17, CryptoServicesRegistrar.getSecureRandom());
            }
            polynomial3 = generateRandom2;
            integerPolynomial4 = polynomial3.toIntegerPolynomial();
            if (!z || !integerPolynomial4.resultant(i).res.equals(BigInteger.ZERO)) {
                if (integerPolynomial4.invertFq(i7) != null) {
                    resultant2 = integerPolynomial4.resultant();
                    calculate = BigIntEuclidean.calculate(resultant.res, resultant2.res);
                    if (calculate.gcd.equals(BigInteger.ONE)) {
                        break;
                    }
                }
            }
            resultant3 = resultant;
            invertFq = integerPolynomial2;
            integerPolynomial = integerPolynomial3;
            polynomial = polynomial2;
            i10 = i4;
            i8 = i2;
            i9 = i3;
            i11 = i5;
        }
        BigIntPolynomial bigIntPolynomial2 = (BigIntPolynomial) resultant.rho.clone();
        int i18 = i12;
        bigIntPolynomial2.mult(calculate.x.multiply(BigInteger.valueOf((long) i7)));
        BigIntPolynomial bigIntPolynomial3 = (BigIntPolynomial) resultant2.rho.clone();
        bigIntPolynomial3.mult(calculate.y.multiply(BigInteger.valueOf((long) (-i7))));
        int i19 = 0;
        if (this.params.keyGenAlg == 0) {
            int[] iArr = new int[i6];
            int[] iArr2 = new int[i6];
            iArr[0] = integerPolynomial3.coeffs[0];
            iArr2[0] = integerPolynomial4.coeffs[0];
            for (int i20 = 1; i20 < i6; i20++) {
                int i21 = i6 - i20;
                iArr[i20] = integerPolynomial3.coeffs[i21];
                iArr2[i20] = integerPolynomial4.coeffs[i21];
            }
            IntegerPolynomial integerPolynomial7 = new IntegerPolynomial(iArr);
            IntegerPolynomial integerPolynomial8 = new IntegerPolynomial(iArr2);
            IntegerPolynomial mult = polynomial2.mult(integerPolynomial7);
            mult.add(polynomial3.mult(integerPolynomial8));
            Resultant resultant4 = mult.resultant();
            BigIntPolynomial mult2 = integerPolynomial7.mult(bigIntPolynomial3);
            mult2.add(integerPolynomial8.mult(bigIntPolynomial2));
            bigIntPolynomial = mult2.mult(resultant4.rho);
            bigIntPolynomial.div(resultant4.res);
        } else {
            for (int i22 = 1; i22 < i6; i22 *= 10) {
                i19++;
            }
            BigDecimalPolynomial div = resultant.rho.div(new BigDecimal(resultant.res), bigIntPolynomial3.getMaxCoeffLength() + 1 + i19);
            BigDecimalPolynomial div2 = resultant2.rho.div(new BigDecimal(resultant2.res), bigIntPolynomial2.getMaxCoeffLength() + 1 + i19);
            BigDecimalPolynomial mult3 = div.mult(bigIntPolynomial3);
            mult3.add(div2.mult(bigIntPolynomial2));
            mult3.halve();
            bigIntPolynomial = mult3.round();
        }
        BigIntPolynomial bigIntPolynomial4 = (BigIntPolynomial) bigIntPolynomial3.clone();
        bigIntPolynomial4.sub(polynomial2.mult(bigIntPolynomial));
        BigIntPolynomial bigIntPolynomial5 = (BigIntPolynomial) bigIntPolynomial2.clone();
        bigIntPolynomial5.sub(polynomial3.mult(bigIntPolynomial));
        IntegerPolynomial integerPolynomial9 = new IntegerPolynomial(bigIntPolynomial4);
        IntegerPolynomial integerPolynomial10 = new IntegerPolynomial(bigIntPolynomial5);
        minimizeFG(integerPolynomial3, integerPolynomial4, integerPolynomial9, integerPolynomial10, i6);
        if (i18 == 0) {
            integerPolynomial5 = polynomial3.mult(integerPolynomial2, i7);
            integerPolynomial6 = integerPolynomial9;
        } else {
            integerPolynomial5 = integerPolynomial9.mult(integerPolynomial2, i7);
            integerPolynomial6 = polynomial3;
        }
        integerPolynomial5.modPositive(i7);
        return new FGBasis(polynomial2, integerPolynomial6, integerPolynomial5, integerPolynomial9, integerPolynomial10, this.params);
    }

    private void minimizeFG(IntegerPolynomial integerPolynomial, IntegerPolynomial integerPolynomial2, IntegerPolynomial integerPolynomial3, IntegerPolynomial integerPolynomial4, int i) {
        IntegerPolynomial integerPolynomial5 = integerPolynomial;
        IntegerPolynomial integerPolynomial6 = integerPolynomial2;
        IntegerPolynomial integerPolynomial7 = integerPolynomial3;
        IntegerPolynomial integerPolynomial8 = integerPolynomial4;
        int i2 = i;
        int i3 = 0;
        for (int i4 = 0; i4 < i2; i4++) {
            int i5 = integerPolynomial5.coeffs[i4];
            int i6 = integerPolynomial6.coeffs[i4];
            i3 += i2 * 2 * ((i5 * i5) + (i6 * i6));
        }
        int i7 = i3 - 4;
        IntegerPolynomial integerPolynomial9 = (IntegerPolynomial) integerPolynomial.clone();
        IntegerPolynomial integerPolynomial10 = (IntegerPolynomial) integerPolynomial2.clone();
        int i8 = 0;
        int i9 = 0;
        while (i8 < i2 && i9 < i2) {
            int i10 = 0;
            for (int i11 = 0; i11 < i2; i11++) {
                i10 += i2 * 4 * ((integerPolynomial7.coeffs[i11] * integerPolynomial5.coeffs[i11]) + (integerPolynomial8.coeffs[i11] * integerPolynomial6.coeffs[i11]));
            }
            int sumCoeffs = i10 - ((integerPolynomial3.sumCoeffs() + integerPolynomial4.sumCoeffs()) * 4);
            if (sumCoeffs > i7) {
                integerPolynomial7.sub(integerPolynomial9);
                integerPolynomial8.sub(integerPolynomial10);
            } else if (sumCoeffs < (-i7)) {
                integerPolynomial7.add(integerPolynomial9);
                integerPolynomial8.add(integerPolynomial10);
            } else {
                i9++;
                integerPolynomial9.rotate1();
                integerPolynomial10.rotate1();
            }
            i8++;
            i9 = 0;
            i9++;
            integerPolynomial9.rotate1();
            integerPolynomial10.rotate1();
        }
    }

    public NTRUSigningPrivateKeyParameters.Basis generateBoundedBasis() {
        FGBasis generateBasis;
        do {
            generateBasis = generateBasis();
        } while (!generateBasis.isNormOk());
        return generateBasis;
    }

    public AsymmetricCipherKeyPair generateKeyPair() {
        NTRUSigningPublicKeyParameters nTRUSigningPublicKeyParameters;
        ExecutorService newCachedThreadPool = Executors.newCachedThreadPool();
        ArrayList arrayList = new ArrayList();
        int i = this.params.B;
        while (true) {
            nTRUSigningPublicKeyParameters = null;
            if (i < 0) {
                break;
            }
            arrayList.add(newCachedThreadPool.submit(new BasisGenerationTask()));
            i--;
        }
        newCachedThreadPool.shutdown();
        ArrayList arrayList2 = new ArrayList();
        int i2 = this.params.B;
        while (i2 >= 0) {
            Future future = (Future) arrayList.get(i2);
            try {
                arrayList2.add((NTRUSigningPrivateKeyParameters.Basis) future.get());
                if (i2 == this.params.B) {
                    nTRUSigningPublicKeyParameters = new NTRUSigningPublicKeyParameters(((NTRUSigningPrivateKeyParameters.Basis) future.get()).h, this.params.getSigningParameters());
                }
                i2--;
            } catch (Exception e) {
                throw new IllegalStateException(e);
            }
        }
        return new AsymmetricCipherKeyPair((AsymmetricKeyParameter) nTRUSigningPublicKeyParameters, (AsymmetricKeyParameter) new NTRUSigningPrivateKeyParameters((List<NTRUSigningPrivateKeyParameters.Basis>) arrayList2, nTRUSigningPublicKeyParameters));
    }

    public AsymmetricCipherKeyPair generateKeyPairSingleThread() {
        ArrayList arrayList = new ArrayList();
        NTRUSigningPublicKeyParameters nTRUSigningPublicKeyParameters = null;
        for (int i = this.params.B; i >= 0; i--) {
            NTRUSigningPrivateKeyParameters.Basis generateBoundedBasis = generateBoundedBasis();
            arrayList.add(generateBoundedBasis);
            if (i == 0) {
                nTRUSigningPublicKeyParameters = new NTRUSigningPublicKeyParameters(generateBoundedBasis.h, this.params.getSigningParameters());
            }
        }
        return new AsymmetricCipherKeyPair((AsymmetricKeyParameter) nTRUSigningPublicKeyParameters, (AsymmetricKeyParameter) new NTRUSigningPrivateKeyParameters((List<NTRUSigningPrivateKeyParameters.Basis>) arrayList, nTRUSigningPublicKeyParameters));
    }

    public void init(KeyGenerationParameters keyGenerationParameters) {
        this.params = (NTRUSigningKeyGenerationParameters) keyGenerationParameters;
    }
}
