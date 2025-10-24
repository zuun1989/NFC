package com.google.android.gms.internal.clearcut;

final class zzbe extends zzbi {
    private final int zzfm;
    private final int zzfn;

    public zzbe(byte[] bArr, int i, int i2) {
        super(bArr);
        zzbb.zzb(i, i + i2, bArr.length);
        this.zzfm = i;
        this.zzfn = i2;
    }

    public final int size() {
        return this.zzfn;
    }

    public final int zzac() {
        return this.zzfm;
    }

    public final byte zzj(int i) {
        int size = size();
        if (((size - (i + 1)) | i) >= 0) {
            return this.zzfp[this.zzfm + i];
        }
        if (i < 0) {
            StringBuilder sb2 = new StringBuilder(22);
            sb2.append("Index < 0: ");
            sb2.append(i);
            throw new ArrayIndexOutOfBoundsException(sb2.toString());
        }
        StringBuilder sb3 = new StringBuilder(40);
        sb3.append("Index > length: ");
        sb3.append(i);
        sb3.append(", ");
        sb3.append(size);
        throw new ArrayIndexOutOfBoundsException(sb3.toString());
    }
}
