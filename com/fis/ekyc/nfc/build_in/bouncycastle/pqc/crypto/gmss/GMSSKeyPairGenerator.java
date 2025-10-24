package com.fis.ekyc.nfc.build_in.bouncycastle.pqc.crypto.gmss;

import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.AsymmetricCipherKeyPair;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.AsymmetricCipherKeyPairGenerator;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.Digest;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.KeyGenerationParameters;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.params.AsymmetricKeyParameter;
import com.fis.ekyc.nfc.build_in.bouncycastle.pqc.crypto.gmss.util.GMSSRandom;
import com.fis.ekyc.nfc.build_in.bouncycastle.pqc.crypto.gmss.util.WinternitzOTSVerify;
import com.fis.ekyc.nfc.build_in.bouncycastle.pqc.crypto.gmss.util.WinternitzOTSignature;
import java.lang.reflect.Array;
import java.security.SecureRandom;
import java.util.Vector;

public class GMSSKeyPairGenerator implements AsymmetricCipherKeyPairGenerator {
    public static final String OID = "1.3.6.1.4.1.8301.3.1.3.3";
    private int[] K;
    private byte[][] currentRootSigs;
    private byte[][] currentSeeds;
    private GMSSDigestProvider digestProvider;
    private GMSSParameters gmssPS;
    private GMSSKeyGenerationParameters gmssParams;
    private GMSSRandom gmssRandom;
    private int[] heightOfTrees;
    private boolean initialized = false;
    private int mdLength;
    private Digest messDigestTree;
    private byte[][] nextNextSeeds;
    private int numLayer;
    private int[] otsIndex;

    public GMSSKeyPairGenerator(GMSSDigestProvider gMSSDigestProvider) {
        this.digestProvider = gMSSDigestProvider;
        Digest digest = gMSSDigestProvider.get();
        this.messDigestTree = digest;
        this.mdLength = digest.getDigestSize();
        this.gmssRandom = new GMSSRandom(this.messDigestTree);
    }

    private AsymmetricCipherKeyPair genKeyPair() {
        int i;
        int i2;
        GMSSRootCalc gMSSRootCalc;
        if (!this.initialized) {
            initializeDefault();
        }
        int i3 = this.numLayer;
        byte[][][] bArr = new byte[i3][][];
        byte[][][] bArr2 = new byte[(i3 - 1)][][];
        Treehash[][] treehashArr = new Treehash[i3][];
        Treehash[][] treehashArr2 = new Treehash[(i3 - 1)][];
        Vector[] vectorArr = new Vector[i3];
        Vector[] vectorArr2 = new Vector[(i3 - 1)];
        Vector[][] vectorArr3 = new Vector[i3][];
        int i4 = 1;
        Vector[][] vectorArr4 = new Vector[(i3 - 1)][];
        char c = 0;
        int i5 = 0;
        while (true) {
            i = this.numLayer;
            if (i5 >= i) {
                break;
            }
            int i6 = this.heightOfTrees[i5];
            int[] iArr = new int[2];
            iArr[1] = this.mdLength;
            iArr[c] = i6;
            Class cls = Byte.TYPE;
            bArr[i5] = (byte[][]) Array.newInstance(cls, iArr);
            int i7 = this.heightOfTrees[i5];
            treehashArr[i5] = new Treehash[(i7 - this.K[i5])];
            if (i5 > 0) {
                int i8 = i5 - 1;
                int[] iArr2 = new int[2];
                iArr2[1] = this.mdLength;
                iArr2[0] = i7;
                bArr2[i8] = (byte[][]) Array.newInstance(cls, iArr2);
                treehashArr2[i8] = new Treehash[(this.heightOfTrees[i5] - this.K[i5])];
            }
            vectorArr[i5] = new Vector();
            if (i5 > 0) {
                vectorArr2[i5 - 1] = new Vector();
            }
            i5++;
            c = 0;
        }
        int[] iArr3 = new int[2];
        iArr3[1] = this.mdLength;
        iArr3[0] = i;
        Class cls2 = Byte.TYPE;
        byte[][] bArr3 = (byte[][]) Array.newInstance(cls2, iArr3);
        Treehash[][] treehashArr3 = treehashArr2;
        int[] iArr4 = new int[2];
        iArr4[1] = this.mdLength;
        iArr4[0] = this.numLayer - 1;
        int i9 = this.numLayer;
        byte[][] bArr4 = (byte[][]) Array.newInstance(cls2, iArr4);
        int[] iArr5 = new int[2];
        iArr5[1] = this.mdLength;
        iArr5[0] = i9;
        byte[][] bArr5 = (byte[][]) Array.newInstance(cls2, iArr5);
        int i10 = 0;
        while (true) {
            i2 = this.numLayer;
            if (i10 >= i2) {
                break;
            }
            System.arraycopy(this.currentSeeds[i10], 0, bArr5[i10], 0, this.mdLength);
            i10++;
        }
        int[] iArr6 = new int[2];
        iArr6[1] = this.mdLength;
        iArr6[0] = i2 - 1;
        this.currentRootSigs = (byte[][]) Array.newInstance(Byte.TYPE, iArr6);
        int i11 = this.numLayer - 1;
        while (i11 >= 0) {
            if (i11 == this.numLayer - i4) {
                gMSSRootCalc = generateCurrentAuthpathAndRoot((byte[]) null, vectorArr[i11], bArr5[i11], i11);
            } else {
                gMSSRootCalc = generateCurrentAuthpathAndRoot(bArr3[i11 + 1], vectorArr[i11], bArr5[i11], i11);
            }
            int i12 = 0;
            while (i12 < this.heightOfTrees[i11]) {
                System.arraycopy(gMSSRootCalc.getAuthPath()[i12], 0, bArr[i11][i12], 0, this.mdLength);
                i12++;
                vectorArr = vectorArr;
            }
            vectorArr3[i11] = gMSSRootCalc.getRetain();
            treehashArr[i11] = gMSSRootCalc.getTreehash();
            System.arraycopy(gMSSRootCalc.getRoot(), 0, bArr3[i11], 0, this.mdLength);
            i11--;
            vectorArr = vectorArr;
            i4 = 1;
        }
        Vector[] vectorArr5 = vectorArr;
        int i13 = this.numLayer - 2;
        while (i13 >= 0) {
            int i14 = i13 + 1;
            GMSSRootCalc generateNextAuthpathAndRoot = generateNextAuthpathAndRoot(vectorArr2[i13], bArr5[i14], i14);
            int i15 = 0;
            while (i15 < this.heightOfTrees[i14]) {
                System.arraycopy(generateNextAuthpathAndRoot.getAuthPath()[i15], 0, bArr2[i13][i15], 0, this.mdLength);
                i15++;
                vectorArr3 = vectorArr3;
            }
            vectorArr4[i13] = generateNextAuthpathAndRoot.getRetain();
            treehashArr3[i13] = generateNextAuthpathAndRoot.getTreehash();
            System.arraycopy(generateNextAuthpathAndRoot.getRoot(), 0, bArr4[i13], 0, this.mdLength);
            System.arraycopy(bArr5[i14], 0, this.nextNextSeeds[i13], 0, this.mdLength);
            i13--;
            vectorArr3 = vectorArr3;
        }
        GMSSPublicKeyParameters gMSSPublicKeyParameters = new GMSSPublicKeyParameters(bArr3[0], this.gmssPS);
        byte[][] bArr6 = this.currentSeeds;
        byte[][] bArr7 = this.nextNextSeeds;
        byte[][] bArr8 = this.currentRootSigs;
        GMSSParameters gMSSParameters = this.gmssPS;
        GMSSDigestProvider gMSSDigestProvider = this.digestProvider;
        GMSSPrivateKeyParameters gMSSPrivateKeyParameters = r2;
        GMSSPrivateKeyParameters gMSSPrivateKeyParameters2 = new GMSSPrivateKeyParameters(bArr6, bArr7, bArr, bArr2, treehashArr, treehashArr3, vectorArr5, vectorArr2, vectorArr3, vectorArr4, bArr4, bArr8, gMSSParameters, gMSSDigestProvider);
        return new AsymmetricCipherKeyPair((AsymmetricKeyParameter) gMSSPublicKeyParameters, (AsymmetricKeyParameter) gMSSPrivateKeyParameters);
    }

    private GMSSRootCalc generateCurrentAuthpathAndRoot(byte[] bArr, Vector vector, byte[] bArr2, int i) {
        byte[] bArr3;
        int i2 = this.mdLength;
        byte[] bArr4 = new byte[i2];
        byte[] bArr5 = new byte[i2];
        byte[] nextSeed = this.gmssRandom.nextSeed(bArr2);
        GMSSRootCalc gMSSRootCalc = new GMSSRootCalc(this.heightOfTrees[i], this.K[i], this.digestProvider);
        gMSSRootCalc.initialize(vector);
        if (i == this.numLayer - 1) {
            bArr3 = new WinternitzOTSignature(nextSeed, this.digestProvider.get(), this.otsIndex[i]).getPublicKey();
        } else {
            this.currentRootSigs[i] = new WinternitzOTSignature(nextSeed, this.digestProvider.get(), this.otsIndex[i]).getSignature(bArr);
            bArr3 = new WinternitzOTSVerify(this.digestProvider.get(), this.otsIndex[i]).Verify(bArr, this.currentRootSigs[i]);
        }
        gMSSRootCalc.update(bArr3);
        int i3 = 3;
        int i4 = 0;
        int i5 = 1;
        while (true) {
            int i6 = this.heightOfTrees[i];
            if (i5 >= (1 << i6)) {
                break;
            }
            if (i5 == i3 && i4 < i6 - this.K[i]) {
                gMSSRootCalc.initializeTreehashSeed(bArr2, i4);
                i3 *= 2;
                i4++;
            }
            gMSSRootCalc.update(new WinternitzOTSignature(this.gmssRandom.nextSeed(bArr2), this.digestProvider.get(), this.otsIndex[i]).getPublicKey());
            i5++;
        }
        if (gMSSRootCalc.wasFinished()) {
            return gMSSRootCalc;
        }
        System.err.println("Baum noch nicht fertig konstruiert!!!");
        return null;
    }

    private GMSSRootCalc generateNextAuthpathAndRoot(Vector vector, byte[] bArr, int i) {
        byte[] bArr2 = new byte[this.numLayer];
        GMSSRootCalc gMSSRootCalc = new GMSSRootCalc(this.heightOfTrees[i], this.K[i], this.digestProvider);
        gMSSRootCalc.initialize(vector);
        int i2 = 3;
        int i3 = 0;
        int i4 = 0;
        while (true) {
            int i5 = this.heightOfTrees[i];
            if (i3 >= (1 << i5)) {
                break;
            }
            if (i3 == i2 && i4 < i5 - this.K[i]) {
                gMSSRootCalc.initializeTreehashSeed(bArr, i4);
                i2 *= 2;
                i4++;
            }
            gMSSRootCalc.update(new WinternitzOTSignature(this.gmssRandom.nextSeed(bArr), this.digestProvider.get(), this.otsIndex[i]).getPublicKey());
            i3++;
        }
        if (gMSSRootCalc.wasFinished()) {
            return gMSSRootCalc;
        }
        System.err.println("N�chster Baum noch nicht fertig konstruiert!!!");
        return null;
    }

    private void initializeDefault() {
        initialize(new GMSSKeyGenerationParameters((SecureRandom) null, new GMSSParameters(4, new int[]{10, 10, 10, 10}, new int[]{3, 3, 3, 3}, new int[]{2, 2, 2, 2})));
    }

    public AsymmetricCipherKeyPair generateKeyPair() {
        return genKeyPair();
    }

    public void init(KeyGenerationParameters keyGenerationParameters) {
        initialize(keyGenerationParameters);
    }

    public void initialize(int i, SecureRandom secureRandom) {
        GMSSKeyGenerationParameters gMSSKeyGenerationParameters;
        if (i <= 10) {
            gMSSKeyGenerationParameters = new GMSSKeyGenerationParameters(secureRandom, new GMSSParameters(1, new int[]{10}, new int[]{3}, new int[]{2}));
        } else if (i <= 20) {
            gMSSKeyGenerationParameters = new GMSSKeyGenerationParameters(secureRandom, new GMSSParameters(2, new int[]{10, 10}, new int[]{5, 4}, new int[]{2, 2}));
        } else {
            gMSSKeyGenerationParameters = new GMSSKeyGenerationParameters(secureRandom, new GMSSParameters(4, new int[]{10, 10, 10, 10}, new int[]{9, 9, 9, 3}, new int[]{2, 2, 2, 2}));
        }
        initialize(gMSSKeyGenerationParameters);
    }

    public void initialize(KeyGenerationParameters keyGenerationParameters) {
        GMSSKeyGenerationParameters gMSSKeyGenerationParameters = (GMSSKeyGenerationParameters) keyGenerationParameters;
        this.gmssParams = gMSSKeyGenerationParameters;
        GMSSParameters gMSSParameters = new GMSSParameters(gMSSKeyGenerationParameters.getParameters().getNumOfLayers(), this.gmssParams.getParameters().getHeightOfTrees(), this.gmssParams.getParameters().getWinternitzParameter(), this.gmssParams.getParameters().getK());
        this.gmssPS = gMSSParameters;
        this.numLayer = gMSSParameters.getNumOfLayers();
        this.heightOfTrees = this.gmssPS.getHeightOfTrees();
        this.otsIndex = this.gmssPS.getWinternitzParameter();
        this.K = this.gmssPS.getK();
        int i = this.numLayer;
        int[] iArr = new int[2];
        iArr[1] = this.mdLength;
        iArr[0] = i;
        Class cls = Byte.TYPE;
        this.currentSeeds = (byte[][]) Array.newInstance(cls, iArr);
        int[] iArr2 = new int[2];
        iArr2[1] = this.mdLength;
        iArr2[0] = this.numLayer - 1;
        this.nextNextSeeds = (byte[][]) Array.newInstance(cls, iArr2);
        SecureRandom random = keyGenerationParameters.getRandom();
        for (int i2 = 0; i2 < this.numLayer; i2++) {
            random.nextBytes(this.currentSeeds[i2]);
            this.gmssRandom.nextSeed(this.currentSeeds[i2]);
        }
        this.initialized = true;
    }
}
