package com.fis.ekyc.nfc.build_in.bouncycastle.crypto.generators;

import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.AsymmetricCipherKeyPairGenerator;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.KeyGenerationParameters;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.params.NaccacheSternKeyGenerationParameters;
import com.fis.ekyc.nfc.build_in.bouncycastle.util.BigIntegers;
import com.fis.ekyc.nfc.build_in.eidparser.lds.LDSFile;
import com.google.android.gms.common.api.Api;
import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.Vector;

public class NaccacheSternKeyPairGenerator implements AsymmetricCipherKeyPairGenerator {
    private static final BigInteger ONE = BigInteger.valueOf(1);
    private static int[] smallPrimes;
    private NaccacheSternKeyGenerationParameters param;

    static {
        int[] iArr = new int[LDSFile.EF_DG5_TAG];
        // fill-array-data instruction
        iArr[0] = 3;
        iArr[1] = 5;
        iArr[2] = 7;
        iArr[3] = 11;
        iArr[4] = 13;
        iArr[5] = 17;
        iArr[6] = 19;
        iArr[7] = 23;
        iArr[8] = 29;
        iArr[9] = 31;
        iArr[10] = 37;
        iArr[11] = 41;
        iArr[12] = 43;
        iArr[13] = 47;
        iArr[14] = 53;
        iArr[15] = 59;
        iArr[16] = 61;
        iArr[17] = 67;
        iArr[18] = 71;
        iArr[19] = 73;
        iArr[20] = 79;
        iArr[21] = 83;
        iArr[22] = 89;
        iArr[23] = 97;
        iArr[24] = 101;
        iArr[25] = 103;
        iArr[26] = 107;
        iArr[27] = 109;
        iArr[28] = 113;
        iArr[29] = 127;
        iArr[30] = 131;
        iArr[31] = 137;
        iArr[32] = 139;
        iArr[33] = 149;
        iArr[34] = 151;
        iArr[35] = 157;
        iArr[36] = 163;
        iArr[37] = 167;
        iArr[38] = 173;
        iArr[39] = 179;
        iArr[40] = 181;
        iArr[41] = 191;
        iArr[42] = 193;
        iArr[43] = 197;
        iArr[44] = 199;
        iArr[45] = 211;
        iArr[46] = 223;
        iArr[47] = 227;
        iArr[48] = 229;
        iArr[49] = 233;
        iArr[50] = 239;
        iArr[51] = 241;
        iArr[52] = 251;
        iArr[53] = 257;
        iArr[54] = 263;
        iArr[55] = 269;
        iArr[56] = 271;
        iArr[57] = 277;
        iArr[58] = 281;
        iArr[59] = 283;
        iArr[60] = 293;
        iArr[61] = 307;
        iArr[62] = 311;
        iArr[63] = 313;
        iArr[64] = 317;
        iArr[65] = 331;
        iArr[66] = 337;
        iArr[67] = 347;
        iArr[68] = 349;
        iArr[69] = 353;
        iArr[70] = 359;
        iArr[71] = 367;
        iArr[72] = 373;
        iArr[73] = 379;
        iArr[74] = 383;
        iArr[75] = 389;
        iArr[76] = 397;
        iArr[77] = 401;
        iArr[78] = 409;
        iArr[79] = 419;
        iArr[80] = 421;
        iArr[81] = 431;
        iArr[82] = 433;
        iArr[83] = 439;
        iArr[84] = 443;
        iArr[85] = 449;
        iArr[86] = 457;
        iArr[87] = 461;
        iArr[88] = 463;
        iArr[89] = 467;
        iArr[90] = 479;
        iArr[91] = 487;
        iArr[92] = 491;
        iArr[93] = 499;
        iArr[94] = 503;
        iArr[95] = 509;
        iArr[96] = 521;
        iArr[97] = 523;
        iArr[98] = 541;
        iArr[99] = 547;
        iArr[100] = 557;
        smallPrimes = iArr;
    }

    private static Vector findFirstPrimes(int i) {
        Vector vector = new Vector(i);
        for (int i2 = 0; i2 != i; i2++) {
            vector.addElement(BigInteger.valueOf((long) smallPrimes[i2]));
        }
        return vector;
    }

    private static BigInteger generatePrime(int i, int i2, SecureRandom secureRandom) {
        BigInteger createRandomPrime = BigIntegers.createRandomPrime(i, i2, secureRandom);
        while (createRandomPrime.bitLength() != i) {
            createRandomPrime = BigIntegers.createRandomPrime(i, i2, secureRandom);
        }
        return createRandomPrime;
    }

    private static int getInt(SecureRandom secureRandom, int i) {
        int nextInt;
        int i2;
        if (((-i) & i) == i) {
            return (int) ((((long) i) * ((long) (secureRandom.nextInt() & Api.BaseClientBuilder.API_PRIORITY_OTHER))) >> 31);
        }
        do {
            nextInt = secureRandom.nextInt() & Api.BaseClientBuilder.API_PRIORITY_OTHER;
            i2 = nextInt % i;
        } while ((nextInt - i2) + (i - 1) < 0);
        return i2;
    }

    private static Vector permuteList(Vector vector, SecureRandom secureRandom) {
        Vector vector2 = new Vector();
        Vector vector3 = new Vector();
        for (int i = 0; i < vector.size(); i++) {
            vector3.addElement(vector.elementAt(i));
        }
        vector2.addElement(vector3.elementAt(0));
        vector3.removeElementAt(0);
        while (vector3.size() != 0) {
            vector2.insertElementAt(vector3.elementAt(0), getInt(secureRandom, vector2.size() + 1));
            vector3.removeElementAt(0);
        }
        return vector2;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:57:0x022b, code lost:
        r11 = r24;
        r2 = r25;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:58:0x022f, code lost:
        r24 = r3;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.fis.ekyc.nfc.build_in.bouncycastle.crypto.AsymmetricCipherKeyPair generateKeyPair() {
        /*
            r30 = this;
            r0 = r30
            com.fis.ekyc.nfc.build_in.bouncycastle.crypto.params.NaccacheSternKeyGenerationParameters r1 = r0.param
            int r1 = r1.getStrength()
            com.fis.ekyc.nfc.build_in.bouncycastle.crypto.params.NaccacheSternKeyGenerationParameters r2 = r0.param
            java.security.SecureRandom r2 = r2.getRandom()
            com.fis.ekyc.nfc.build_in.bouncycastle.crypto.params.NaccacheSternKeyGenerationParameters r3 = r0.param
            int r3 = r3.getCertainty()
            com.fis.ekyc.nfc.build_in.bouncycastle.crypto.params.NaccacheSternKeyGenerationParameters r4 = r0.param
            boolean r4 = r4.isDebug()
            if (r4 == 0) goto L_0x003d
            java.io.PrintStream r5 = java.lang.System.out
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            java.lang.String r7 = "Fetching first "
            r6.append(r7)
            com.fis.ekyc.nfc.build_in.bouncycastle.crypto.params.NaccacheSternKeyGenerationParameters r7 = r0.param
            int r7 = r7.getCntSmallPrimes()
            r6.append(r7)
            java.lang.String r7 = " primes."
            r6.append(r7)
            java.lang.String r6 = r6.toString()
            r5.println(r6)
        L_0x003d:
            com.fis.ekyc.nfc.build_in.bouncycastle.crypto.params.NaccacheSternKeyGenerationParameters r5 = r0.param
            int r5 = r5.getCntSmallPrimes()
            java.util.Vector r5 = findFirstPrimes(r5)
            java.util.Vector r10 = permuteList(r5, r2)
            java.math.BigInteger r5 = ONE
            r8 = r5
            r7 = 0
        L_0x004f:
            int r9 = r10.size()
            int r9 = r9 / 2
            if (r7 >= r9) goto L_0x0064
            java.lang.Object r9 = r10.elementAt(r7)
            java.math.BigInteger r9 = (java.math.BigInteger) r9
            java.math.BigInteger r8 = r8.multiply(r9)
            int r7 = r7 + 1
            goto L_0x004f
        L_0x0064:
            int r7 = r10.size()
            int r7 = r7 / 2
        L_0x006a:
            int r9 = r10.size()
            if (r7 >= r9) goto L_0x007d
            java.lang.Object r9 = r10.elementAt(r7)
            java.math.BigInteger r9 = (java.math.BigInteger) r9
            java.math.BigInteger r5 = r5.multiply(r9)
            int r7 = r7 + 1
            goto L_0x006a
        L_0x007d:
            java.math.BigInteger r7 = r8.multiply(r5)
            int r9 = r7.bitLength()
            int r9 = r1 - r9
            int r9 = r9 + -48
            int r9 = r9 / 2
            r11 = 1
            int r9 = r9 + r11
            java.math.BigInteger r12 = generatePrime(r9, r3, r2)
            java.math.BigInteger r9 = generatePrime(r9, r3, r2)
            if (r4 == 0) goto L_0x009e
            java.io.PrintStream r13 = java.lang.System.out
            java.lang.String r14 = "generating p and q"
            r13.println(r14)
        L_0x009e:
            java.math.BigInteger r8 = r12.multiply(r8)
            java.math.BigInteger r8 = r8.shiftLeft(r11)
            java.math.BigInteger r5 = r9.multiply(r5)
            java.math.BigInteger r5 = r5.shiftLeft(r11)
            r15 = 0
        L_0x00b0:
            r17 = 1
            long r13 = r15 + r17
            r11 = 24
            java.math.BigInteger r15 = generatePrime(r11, r3, r2)
            java.math.BigInteger r6 = r15.multiply(r8)
            java.math.BigInteger r11 = ONE
            java.math.BigInteger r6 = r6.add(r11)
            boolean r11 = r6.isProbablePrime(r3)
            if (r11 != 0) goto L_0x00cf
            r22 = r5
            r23 = r8
            goto L_0x0131
        L_0x00cf:
            r11 = 24
        L_0x00d1:
            java.math.BigInteger r0 = generatePrime(r11, r3, r2)
            boolean r21 = r15.equals(r0)
            if (r21 == 0) goto L_0x00dc
            goto L_0x00d1
        L_0x00dc:
            java.math.BigInteger r11 = r0.multiply(r5)
            r22 = r5
            java.math.BigInteger r5 = ONE
            java.math.BigInteger r11 = r11.add(r5)
            boolean r23 = r11.isProbablePrime(r3)
            if (r23 == 0) goto L_0x044f
            r23 = r8
            java.math.BigInteger r8 = r15.multiply(r0)
            java.math.BigInteger r8 = r7.gcd(r8)
            boolean r8 = r8.equals(r5)
            if (r8 != 0) goto L_0x00ff
            goto L_0x0131
        L_0x00ff:
            java.math.BigInteger r8 = r6.multiply(r11)
            int r8 = r8.bitLength()
            if (r8 >= r1) goto L_0x013a
            if (r4 == 0) goto L_0x0131
            java.io.PrintStream r0 = java.lang.System.out
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.String r8 = "key size too small. Should be "
            r5.append(r8)
            r5.append(r1)
            java.lang.String r8 = " but is actually "
            r5.append(r8)
            java.math.BigInteger r6 = r6.multiply(r11)
            int r6 = r6.bitLength()
            r5.append(r6)
            java.lang.String r5 = r5.toString()
            r0.println(r5)
        L_0x0131:
            r0 = r30
            r15 = r13
            r5 = r22
            r8 = r23
            goto L_0x00b0
        L_0x013a:
            java.lang.String r8 = "needed "
            r24 = r9
            if (r4 == 0) goto L_0x015c
            java.io.PrintStream r9 = java.lang.System.out
            r25 = r12
            java.lang.StringBuilder r12 = new java.lang.StringBuilder
            r12.<init>()
            r12.append(r8)
            r12.append(r13)
            java.lang.String r13 = " tries to generate p and q."
            r12.append(r13)
            java.lang.String r12 = r12.toString()
            r9.println(r12)
            goto L_0x015e
        L_0x015c:
            r25 = r12
        L_0x015e:
            java.math.BigInteger r9 = r6.multiply(r11)
            java.math.BigInteger r12 = r6.subtract(r5)
            java.math.BigInteger r5 = r11.subtract(r5)
            java.math.BigInteger r5 = r12.multiply(r5)
            if (r4 == 0) goto L_0x0177
            java.io.PrintStream r12 = java.lang.System.out
            java.lang.String r13 = "generating g"
            r12.println(r13)
        L_0x0177:
            r13 = 0
        L_0x0179:
            java.util.Vector r12 = new java.util.Vector
            r12.<init>()
            r27 = r6
            r26 = r11
            r11 = 0
        L_0x0183:
            int r6 = r10.size()
            if (r11 == r6) goto L_0x01b8
            java.lang.Object r6 = r10.elementAt(r11)
            java.math.BigInteger r6 = (java.math.BigInteger) r6
            java.math.BigInteger r6 = r5.divide(r6)
        L_0x0193:
            long r13 = r13 + r17
            r19 = r13
            java.math.BigInteger r13 = com.fis.ekyc.nfc.build_in.bouncycastle.util.BigIntegers.createRandomPrime(r1, r3, r2)
            java.math.BigInteger r14 = r13.modPow(r6, r9)
            r28 = r1
            java.math.BigInteger r1 = ONE
            boolean r1 = r14.equals(r1)
            if (r1 == 0) goto L_0x01ae
            r13 = r19
            r1 = r28
            goto L_0x0193
        L_0x01ae:
            r12.addElement(r13)
            int r11 = r11 + 1
            r13 = r19
            r1 = r28
            goto L_0x0183
        L_0x01b8:
            r28 = r1
            java.math.BigInteger r1 = ONE
            r6 = 0
        L_0x01bd:
            int r11 = r10.size()
            if (r6 >= r11) goto L_0x01e8
            java.lang.Object r11 = r12.elementAt(r6)
            java.math.BigInteger r11 = (java.math.BigInteger) r11
            java.lang.Object r19 = r10.elementAt(r6)
            r29 = r2
            r2 = r19
            java.math.BigInteger r2 = (java.math.BigInteger) r2
            java.math.BigInteger r2 = r7.divide(r2)
            java.math.BigInteger r2 = r11.modPow(r2, r9)
            java.math.BigInteger r1 = r1.multiply(r2)
            java.math.BigInteger r1 = r1.mod(r9)
            int r6 = r6 + 1
            r2 = r29
            goto L_0x01bd
        L_0x01e8:
            r29 = r2
            r2 = 0
        L_0x01eb:
            int r6 = r10.size()
            if (r2 >= r6) goto L_0x0236
            java.lang.Object r6 = r10.elementAt(r2)
            java.math.BigInteger r6 = (java.math.BigInteger) r6
            java.math.BigInteger r6 = r5.divide(r6)
            java.math.BigInteger r6 = r1.modPow(r6, r9)
            java.math.BigInteger r11 = ONE
            boolean r6 = r6.equals(r11)
            if (r6 == 0) goto L_0x0233
            if (r4 == 0) goto L_0x022b
            java.io.PrintStream r6 = java.lang.System.out
            java.lang.StringBuilder r11 = new java.lang.StringBuilder
            r11.<init>()
            java.lang.String r12 = "g has order phi(n)/"
            r11.append(r12)
            java.lang.Object r2 = r10.elementAt(r2)
            r11.append(r2)
            java.lang.String r2 = "\n g: "
            r11.append(r2)
            r11.append(r1)
            java.lang.String r1 = r11.toString()
            r6.println(r1)
        L_0x022b:
            r11 = r24
            r2 = r25
        L_0x022f:
            r24 = r3
            goto L_0x030a
        L_0x0233:
            int r2 = r2 + 1
            goto L_0x01eb
        L_0x0236:
            r11 = 4
            java.math.BigInteger r2 = java.math.BigInteger.valueOf(r11)
            java.math.BigInteger r2 = r5.divide(r2)
            java.math.BigInteger r2 = r1.modPow(r2, r9)
            java.math.BigInteger r6 = ONE
            boolean r2 = r2.equals(r6)
            if (r2 == 0) goto L_0x0265
            if (r4 == 0) goto L_0x022b
            java.io.PrintStream r2 = java.lang.System.out
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            java.lang.String r11 = "g has order phi(n)/4\n g:"
            r6.append(r11)
            r6.append(r1)
            java.lang.String r1 = r6.toString()
            r2.println(r1)
            goto L_0x022b
        L_0x0265:
            java.math.BigInteger r2 = r5.divide(r15)
            java.math.BigInteger r2 = r1.modPow(r2, r9)
            boolean r2 = r2.equals(r6)
            if (r2 == 0) goto L_0x028c
            if (r4 == 0) goto L_0x022b
            java.io.PrintStream r2 = java.lang.System.out
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            java.lang.String r11 = "g has order phi(n)/p'\n g: "
            r6.append(r11)
            r6.append(r1)
            java.lang.String r1 = r6.toString()
            r2.println(r1)
            goto L_0x022b
        L_0x028c:
            java.math.BigInteger r2 = r5.divide(r0)
            java.math.BigInteger r2 = r1.modPow(r2, r9)
            boolean r2 = r2.equals(r6)
            if (r2 == 0) goto L_0x02b4
            if (r4 == 0) goto L_0x022b
            java.io.PrintStream r2 = java.lang.System.out
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            java.lang.String r11 = "g has order phi(n)/q'\n g: "
            r6.append(r11)
            r6.append(r1)
            java.lang.String r1 = r6.toString()
            r2.println(r1)
            goto L_0x022b
        L_0x02b4:
            r2 = r25
            java.math.BigInteger r11 = r5.divide(r2)
            java.math.BigInteger r11 = r1.modPow(r11, r9)
            boolean r11 = r11.equals(r6)
            if (r11 == 0) goto L_0x02e0
            if (r4 == 0) goto L_0x02dc
            java.io.PrintStream r6 = java.lang.System.out
            java.lang.StringBuilder r11 = new java.lang.StringBuilder
            r11.<init>()
            java.lang.String r12 = "g has order phi(n)/a\n g: "
            r11.append(r12)
            r11.append(r1)
            java.lang.String r1 = r11.toString()
            r6.println(r1)
        L_0x02dc:
            r11 = r24
            goto L_0x022f
        L_0x02e0:
            r11 = r24
            java.math.BigInteger r12 = r5.divide(r11)
            java.math.BigInteger r12 = r1.modPow(r12, r9)
            boolean r6 = r12.equals(r6)
            if (r6 == 0) goto L_0x031a
            if (r4 == 0) goto L_0x022f
            java.io.PrintStream r6 = java.lang.System.out
            java.lang.StringBuilder r12 = new java.lang.StringBuilder
            r12.<init>()
            r24 = r3
            java.lang.String r3 = "g has order phi(n)/b\n g: "
            r12.append(r3)
            r12.append(r1)
            java.lang.String r1 = r12.toString()
            r6.println(r1)
        L_0x030a:
            r25 = r2
            r3 = r24
            r6 = r27
            r1 = r28
            r2 = r29
            r24 = r11
            r11 = r26
            goto L_0x0179
        L_0x031a:
            if (r4 == 0) goto L_0x0431
            java.io.PrintStream r3 = java.lang.System.out
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            r4.append(r8)
            r4.append(r13)
            java.lang.String r6 = " tries to generate g"
            r4.append(r6)
            java.lang.String r4 = r4.toString()
            r3.println(r4)
            r3.println()
            java.lang.String r4 = "found new NaccacheStern cipher variables:"
            r3.println(r4)
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r6 = "smallPrimes: "
            r4.append(r6)
            r4.append(r10)
            java.lang.String r4 = r4.toString()
            r3.println(r4)
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r6 = "sigma:...... "
            r4.append(r6)
            r4.append(r7)
            java.lang.String r6 = " ("
            r4.append(r6)
            int r6 = r7.bitLength()
            r4.append(r6)
            java.lang.String r6 = " bits)"
            r4.append(r6)
            java.lang.String r4 = r4.toString()
            r3.println(r4)
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r6 = "a:.......... "
            r4.append(r6)
            r4.append(r2)
            java.lang.String r2 = r4.toString()
            r3.println(r2)
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r4 = "b:.......... "
            r2.append(r4)
            r2.append(r11)
            java.lang.String r2 = r2.toString()
            r3.println(r2)
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r4 = "p':......... "
            r2.append(r4)
            r2.append(r15)
            java.lang.String r2 = r2.toString()
            r3.println(r2)
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r4 = "q':......... "
            r2.append(r4)
            r2.append(r0)
            java.lang.String r0 = r2.toString()
            r3.println(r0)
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r2 = "p:.......... "
            r0.append(r2)
            r6 = r27
            r0.append(r6)
            java.lang.String r0 = r0.toString()
            r3.println(r0)
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r2 = "q:.......... "
            r0.append(r2)
            r2 = r26
            r0.append(r2)
            java.lang.String r0 = r0.toString()
            r3.println(r0)
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r2 = "n:.......... "
            r0.append(r2)
            r0.append(r9)
            java.lang.String r0 = r0.toString()
            r3.println(r0)
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r2 = "phi(n):..... "
            r0.append(r2)
            r0.append(r5)
            java.lang.String r0 = r0.toString()
            r3.println(r0)
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r2 = "g:.......... "
            r0.append(r2)
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            r3.println(r0)
            r3.println()
        L_0x0431:
            com.fis.ekyc.nfc.build_in.bouncycastle.crypto.AsymmetricCipherKeyPair r0 = new com.fis.ekyc.nfc.build_in.bouncycastle.crypto.AsymmetricCipherKeyPair
            com.fis.ekyc.nfc.build_in.bouncycastle.crypto.params.NaccacheSternKeyParameters r2 = new com.fis.ekyc.nfc.build_in.bouncycastle.crypto.params.NaccacheSternKeyParameters
            int r3 = r7.bitLength()
            r8 = 0
            r2.<init>(r8, r1, r9, r3)
            com.fis.ekyc.nfc.build_in.bouncycastle.crypto.params.NaccacheSternPrivateKeyParameters r3 = new com.fis.ekyc.nfc.build_in.bouncycastle.crypto.params.NaccacheSternPrivateKeyParameters
            int r4 = r7.bitLength()
            r6 = r3
            r7 = r1
            r8 = r9
            r9 = r4
            r11 = r5
            r6.<init>(r7, r8, r9, r10, r11)
            r0.<init>((com.fis.ekyc.nfc.build_in.bouncycastle.crypto.params.AsymmetricKeyParameter) r2, (com.fis.ekyc.nfc.build_in.bouncycastle.crypto.params.AsymmetricKeyParameter) r3)
            return r0
        L_0x044f:
            r5 = r22
            goto L_0x00cf
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fis.ekyc.nfc.build_in.bouncycastle.crypto.generators.NaccacheSternKeyPairGenerator.generateKeyPair():com.fis.ekyc.nfc.build_in.bouncycastle.crypto.AsymmetricCipherKeyPair");
    }

    public void init(KeyGenerationParameters keyGenerationParameters) {
        this.param = (NaccacheSternKeyGenerationParameters) keyGenerationParameters;
    }
}
