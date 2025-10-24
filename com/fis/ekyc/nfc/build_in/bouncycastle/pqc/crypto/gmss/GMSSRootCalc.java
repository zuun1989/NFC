package com.fis.ekyc.nfc.build_in.bouncycastle.pqc.crypto.gmss;

import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.Digest;
import com.fis.ekyc.nfc.build_in.bouncycastle.util.Arrays;
import com.fis.ekyc.nfc.build_in.bouncycastle.util.Integers;
import com.fis.ekyc.nfc.build_in.bouncycastle.util.encoders.Hex;
import java.lang.reflect.Array;
import java.util.Enumeration;
import java.util.Vector;

public class GMSSRootCalc {
    private byte[][] AuthPath;
    private int K;
    private GMSSDigestProvider digestProvider;
    private int heightOfNextSeed;
    private Vector heightOfNodes;
    private int heightOfTree;
    private int[] index;
    private int indexForNextSeed;
    private boolean isFinished;
    private boolean isInitialized;
    private int mdLength;
    private Digest messDigestTree;
    private Vector[] retain = new Vector[(this.K - 1)];
    private byte[] root = new byte[this.mdLength];
    private Vector tailStack;
    private Treehash[] treehash;

    public GMSSRootCalc(int i, int i2, GMSSDigestProvider gMSSDigestProvider) {
        this.heightOfTree = i;
        this.digestProvider = gMSSDigestProvider;
        Digest digest = gMSSDigestProvider.get();
        this.messDigestTree = digest;
        int digestSize = digest.getDigestSize();
        this.mdLength = digestSize;
        this.K = i2;
        this.index = new int[i];
        int[] iArr = new int[2];
        iArr[1] = digestSize;
        iArr[0] = i;
        this.AuthPath = (byte[][]) Array.newInstance(Byte.TYPE, iArr);
        for (int i3 = 0; i3 < i2 - 1; i3++) {
            this.retain[i3] = new Vector();
        }
    }

    public byte[][] getAuthPath() {
        return GMSSUtils.clone(this.AuthPath);
    }

    public Vector[] getRetain() {
        return GMSSUtils.clone(this.retain);
    }

    public byte[] getRoot() {
        return Arrays.clone(this.root);
    }

    public Vector getStack() {
        Vector vector = new Vector();
        Enumeration elements = this.tailStack.elements();
        while (elements.hasMoreElements()) {
            vector.addElement(elements.nextElement());
        }
        return vector;
    }

    public byte[][] getStatByte() {
        int i;
        Vector vector = this.tailStack;
        if (vector == null) {
            i = 0;
        } else {
            i = vector.size();
        }
        int[] iArr = new int[2];
        iArr[1] = 64;
        iArr[0] = this.heightOfTree + 1 + i;
        byte[][] bArr = (byte[][]) Array.newInstance(Byte.TYPE, iArr);
        bArr[0] = this.root;
        int i2 = 0;
        while (i2 < this.heightOfTree) {
            int i3 = i2 + 1;
            bArr[i3] = this.AuthPath[i2];
            i2 = i3;
        }
        for (int i4 = 0; i4 < i; i4++) {
            bArr[this.heightOfTree + 1 + i4] = (byte[]) this.tailStack.elementAt(i4);
        }
        return bArr;
    }

    public int[] getStatInt() {
        int i;
        Vector vector = this.tailStack;
        if (vector == null) {
            i = 0;
        } else {
            i = vector.size();
        }
        int i2 = this.heightOfTree;
        int[] iArr = new int[(i2 + 8 + i)];
        iArr[0] = i2;
        iArr[1] = this.mdLength;
        iArr[2] = this.K;
        iArr[3] = this.indexForNextSeed;
        iArr[4] = this.heightOfNextSeed;
        if (this.isFinished) {
            iArr[5] = 1;
        } else {
            iArr[5] = 0;
        }
        if (this.isInitialized) {
            iArr[6] = 1;
        } else {
            iArr[6] = 0;
        }
        iArr[7] = i;
        for (int i3 = 0; i3 < this.heightOfTree; i3++) {
            iArr[i3 + 8] = this.index[i3];
        }
        for (int i4 = 0; i4 < i; i4++) {
            iArr[this.heightOfTree + 8 + i4] = ((Integer) this.heightOfNodes.elementAt(i4)).intValue();
        }
        return iArr;
    }

    public Treehash[] getTreehash() {
        return GMSSUtils.clone(this.treehash);
    }

    public void initialize(Vector vector) {
        int i;
        this.treehash = new Treehash[(this.heightOfTree - this.K)];
        int i2 = 0;
        while (true) {
            i = this.heightOfTree;
            if (i2 >= i - this.K) {
                break;
            }
            this.treehash[i2] = new Treehash(vector, i2, this.digestProvider.get());
            i2++;
        }
        this.index = new int[i];
        int[] iArr = new int[2];
        iArr[1] = this.mdLength;
        iArr[0] = i;
        this.AuthPath = (byte[][]) Array.newInstance(Byte.TYPE, iArr);
        this.root = new byte[this.mdLength];
        this.tailStack = new Vector();
        this.heightOfNodes = new Vector();
        this.isInitialized = true;
        this.isFinished = false;
        for (int i3 = 0; i3 < this.heightOfTree; i3++) {
            this.index[i3] = -1;
        }
        this.retain = new Vector[(this.K - 1)];
        for (int i4 = 0; i4 < this.K - 1; i4++) {
            this.retain[i4] = new Vector();
        }
        this.indexForNextSeed = 3;
        this.heightOfNextSeed = 0;
    }

    public void initializeTreehashSeed(byte[] bArr, int i) {
        this.treehash[i].initializeSeed(bArr);
    }

    public String toString() {
        int i;
        Vector vector = this.tailStack;
        if (vector == null) {
            i = 0;
        } else {
            i = vector.size();
        }
        String str = "";
        for (int i2 = 0; i2 < this.heightOfTree + 8 + i; i2++) {
            str = str + getStatInt()[i2] + " ";
        }
        for (int i3 = 0; i3 < this.heightOfTree + 1 + i; i3++) {
            str = str + new String(Hex.encode(getStatByte()[i3])) + " ";
        }
        return str + "  " + this.digestProvider.get().getDigestSize();
    }

    public void update(byte[] bArr, byte[] bArr2) {
        int i = this.heightOfNextSeed;
        if (i < this.heightOfTree - this.K && this.indexForNextSeed - 2 == this.index[0]) {
            initializeTreehashSeed(bArr, i);
            this.heightOfNextSeed++;
            this.indexForNextSeed *= 2;
        }
        update(bArr2);
    }

    public boolean wasFinished() {
        return this.isFinished;
    }

    public boolean wasInitialized() {
        return this.isInitialized;
    }

    public void update(byte[] bArr) {
        if (this.isFinished) {
            System.out.print("Too much updates for Tree!!");
        } else if (!this.isInitialized) {
            System.err.println("GMSSRootCalc not initialized!");
        } else {
            int[] iArr = this.index;
            int i = iArr[0] + 1;
            iArr[0] = i;
            if (i == 1) {
                System.arraycopy(bArr, 0, this.AuthPath[0], 0, this.mdLength);
            } else if (i == 3 && this.heightOfTree > this.K) {
                this.treehash[0].setFirstNode(bArr);
            }
            int i2 = this.index[0];
            if ((i2 - 3) % 2 == 0 && i2 >= 3 && this.heightOfTree == this.K) {
                this.retain[0].insertElementAt(bArr, 0);
            }
            if (this.index[0] == 0) {
                this.tailStack.addElement(bArr);
                this.heightOfNodes.addElement(Integers.valueOf(0));
                return;
            }
            int i3 = this.mdLength;
            byte[] bArr2 = new byte[i3];
            int i4 = i3 << 1;
            byte[] bArr3 = new byte[i4];
            System.arraycopy(bArr, 0, bArr2, 0, i3);
            int i5 = 0;
            while (this.tailStack.size() > 0 && i5 == ((Integer) this.heightOfNodes.lastElement()).intValue()) {
                System.arraycopy(this.tailStack.lastElement(), 0, bArr3, 0, this.mdLength);
                Vector vector = this.tailStack;
                vector.removeElementAt(vector.size() - 1);
                Vector vector2 = this.heightOfNodes;
                vector2.removeElementAt(vector2.size() - 1);
                int i6 = this.mdLength;
                System.arraycopy(bArr2, 0, bArr3, i6, i6);
                this.messDigestTree.update(bArr3, 0, i4);
                bArr2 = new byte[this.messDigestTree.getDigestSize()];
                this.messDigestTree.doFinal(bArr2, 0);
                i5++;
                if (i5 < this.heightOfTree) {
                    int[] iArr2 = this.index;
                    int i7 = iArr2[i5] + 1;
                    iArr2[i5] = i7;
                    if (i7 == 1) {
                        System.arraycopy(bArr2, 0, this.AuthPath[i5], 0, this.mdLength);
                    }
                    if (i5 >= this.heightOfTree - this.K) {
                        if (i5 == 0) {
                            System.out.println("M���P");
                        }
                        int i8 = this.index[i5];
                        if ((i8 - 3) % 2 == 0 && i8 >= 3) {
                            this.retain[i5 - (this.heightOfTree - this.K)].insertElementAt(bArr2, 0);
                        }
                    } else if (this.index[i5] == 3) {
                        this.treehash[i5].setFirstNode(bArr2);
                    }
                }
            }
            this.tailStack.addElement(bArr2);
            this.heightOfNodes.addElement(Integers.valueOf(i5));
            if (i5 == this.heightOfTree) {
                this.isFinished = true;
                this.isInitialized = false;
                this.root = (byte[]) this.tailStack.lastElement();
            }
        }
    }
}
