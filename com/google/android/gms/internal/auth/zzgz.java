package com.google.android.gms.internal.auth;

import java.util.Arrays;

public final class zzgz {
    private static final zzgz zza = new zzgz(0, new int[0], new Object[0], false);
    private int zzb;
    private int[] zzc;
    private Object[] zzd;
    private boolean zze;

    private zzgz(int i, int[] iArr, Object[] objArr, boolean z) {
        this.zzb = i;
        this.zzc = iArr;
        this.zzd = objArr;
        this.zze = z;
    }

    public static zzgz zza() {
        return zza;
    }

    public static zzgz zzb(zzgz zzgz, zzgz zzgz2) {
        int i = zzgz.zzb + zzgz2.zzb;
        int[] copyOf = Arrays.copyOf(zzgz.zzc, i);
        System.arraycopy(zzgz2.zzc, 0, copyOf, zzgz.zzb, zzgz2.zzb);
        Object[] copyOf2 = Arrays.copyOf(zzgz.zzd, i);
        System.arraycopy(zzgz2.zzd, 0, copyOf2, zzgz.zzb, zzgz2.zzb);
        return new zzgz(i, copyOf, copyOf2, true);
    }

    public static zzgz zzc() {
        return new zzgz(0, new int[8], new Object[8], true);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof zzgz)) {
            return false;
        }
        zzgz zzgz = (zzgz) obj;
        int i = this.zzb;
        if (i == zzgz.zzb) {
            int[] iArr = this.zzc;
            int[] iArr2 = zzgz.zzc;
            int i2 = 0;
            while (true) {
                if (i2 >= i) {
                    Object[] objArr = this.zzd;
                    Object[] objArr2 = zzgz.zzd;
                    int i3 = this.zzb;
                    int i4 = 0;
                    while (i4 < i3) {
                        if (objArr[i4].equals(objArr2[i4])) {
                            i4++;
                        }
                    }
                    return true;
                } else if (iArr[i2] != iArr2[i2]) {
                    break;
                } else {
                    i2++;
                }
            }
        }
        return false;
    }

    public final int hashCode() {
        int i = this.zzb;
        int i2 = (i + 527) * 31;
        int[] iArr = this.zzc;
        int i3 = 17;
        int i4 = 17;
        for (int i5 = 0; i5 < i; i5++) {
            i4 = (i4 * 31) + iArr[i5];
        }
        int i6 = (i2 + i4) * 31;
        Object[] objArr = this.zzd;
        int i7 = this.zzb;
        for (int i8 = 0; i8 < i7; i8++) {
            i3 = (i3 * 31) + objArr[i8].hashCode();
        }
        return i6 + i3;
    }

    public final void zzd() {
        this.zze = false;
    }

    public final void zze(StringBuilder sb2, int i) {
        for (int i2 = 0; i2 < this.zzb; i2++) {
            zzfy.zzb(sb2, i, String.valueOf(this.zzc[i2] >>> 3), this.zzd[i2]);
        }
    }

    public final void zzf(int i, Object obj) {
        int i2;
        if (this.zze) {
            int i3 = this.zzb;
            int[] iArr = this.zzc;
            if (i3 == iArr.length) {
                if (i3 < 4) {
                    i2 = 8;
                } else {
                    i2 = i3 >> 1;
                }
                int i4 = i3 + i2;
                this.zzc = Arrays.copyOf(iArr, i4);
                this.zzd = Arrays.copyOf(this.zzd, i4);
            }
            int[] iArr2 = this.zzc;
            int i5 = this.zzb;
            iArr2[i5] = i;
            this.zzd[i5] = obj;
            this.zzb = i5 + 1;
            return;
        }
        throw new UnsupportedOperationException();
    }

    private zzgz() {
        this(0, new int[8], new Object[8], true);
    }
}
