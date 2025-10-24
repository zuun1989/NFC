package com.fis.ekyc.nfc.build_in.bouncycastle.math.raw;

public abstract class Nat512 {
    public static void mul(int[] iArr, int[] iArr2, int[] iArr3) {
        boolean z;
        int i;
        Nat256.mul(iArr, iArr2, iArr3);
        Nat256.mul(iArr, 8, iArr2, 8, iArr3, 16);
        int addToEachOther = Nat256.addToEachOther(iArr3, 8, iArr3, 16);
        int addTo = addToEachOther + Nat256.addTo(iArr3, 24, iArr3, 16, Nat256.addTo(iArr3, 0, iArr3, 8, 0) + addToEachOther);
        int[] create = Nat256.create();
        int[] create2 = Nat256.create();
        if (Nat256.diff(iArr, 8, iArr, 0, create, 0) != Nat256.diff(iArr2, 8, iArr2, 0, create2, 0)) {
            z = true;
        } else {
            z = false;
        }
        int[] createExt = Nat256.createExt();
        Nat256.mul(create, create2, createExt);
        if (z) {
            i = Nat.addTo(16, createExt, 0, iArr3, 8);
        } else {
            i = Nat.subFrom(16, createExt, 0, iArr3, 8);
        }
        Nat.addWordAt(32, addTo + i, iArr3, 24);
    }

    public static void square(int[] iArr, int[] iArr2) {
        Nat256.square(iArr, iArr2);
        Nat256.square(iArr, 8, iArr2, 16);
        int addToEachOther = Nat256.addToEachOther(iArr2, 8, iArr2, 16);
        int addTo = addToEachOther + Nat256.addTo(iArr2, 24, iArr2, 16, Nat256.addTo(iArr2, 0, iArr2, 8, 0) + addToEachOther);
        int[] create = Nat256.create();
        Nat256.diff(iArr, 8, iArr, 0, create, 0);
        int[] createExt = Nat256.createExt();
        Nat256.square(create, createExt);
        Nat.addWordAt(32, addTo + Nat.subFrom(16, createExt, 0, iArr2, 8), iArr2, 24);
    }
}
