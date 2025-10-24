package com.google.android.gms.internal.mlkit_vision_barcode_bundled;

import java.io.IOException;
import java.util.Arrays;

public final class zzgt {
    private static final zzgt zza = new zzgt(0, new int[0], new Object[0], false);
    private int zzb;
    private int[] zzc;
    private Object[] zzd;
    private int zze;
    private boolean zzf;

    private zzgt(int i, int[] iArr, Object[] objArr, boolean z) {
        this.zze = -1;
        this.zzb = i;
        this.zzc = iArr;
        this.zzd = objArr;
        this.zzf = z;
    }

    public static zzgt zzc() {
        return zza;
    }

    public static zzgt zze(zzgt zzgt, zzgt zzgt2) {
        int i = zzgt.zzb + zzgt2.zzb;
        int[] copyOf = Arrays.copyOf(zzgt.zzc, i);
        System.arraycopy(zzgt2.zzc, 0, copyOf, zzgt.zzb, zzgt2.zzb);
        Object[] copyOf2 = Arrays.copyOf(zzgt.zzd, i);
        System.arraycopy(zzgt2.zzd, 0, copyOf2, zzgt.zzb, zzgt2.zzb);
        return new zzgt(i, copyOf, copyOf2, true);
    }

    public static zzgt zzf() {
        return new zzgt(0, new int[8], new Object[8], true);
    }

    private final void zzm(int i) {
        int[] iArr = this.zzc;
        if (i > iArr.length) {
            int i2 = this.zzb;
            int i3 = i2 + (i2 / 2);
            if (i3 >= i) {
                i = i3;
            }
            if (i < 8) {
                i = 8;
            }
            this.zzc = Arrays.copyOf(iArr, i);
            this.zzd = Arrays.copyOf(this.zzd, i);
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof zzgt)) {
            return false;
        }
        zzgt zzgt = (zzgt) obj;
        int i = this.zzb;
        if (i == zzgt.zzb) {
            int[] iArr = this.zzc;
            int[] iArr2 = zzgt.zzc;
            int i2 = 0;
            while (true) {
                if (i2 >= i) {
                    Object[] objArr = this.zzd;
                    Object[] objArr2 = zzgt.zzd;
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
        int i2 = i + 527;
        int[] iArr = this.zzc;
        int i3 = 17;
        int i4 = 17;
        for (int i5 = 0; i5 < i; i5++) {
            i4 = (i4 * 31) + iArr[i5];
        }
        int i6 = ((i2 * 31) + i4) * 31;
        Object[] objArr = this.zzd;
        int i7 = this.zzb;
        for (int i8 = 0; i8 < i7; i8++) {
            i3 = (i3 * 31) + objArr[i8].hashCode();
        }
        return i6 + i3;
    }

    public final int zza() {
        int zzA;
        int zzB;
        int i;
        int i2 = this.zze;
        if (i2 != -1) {
            return i2;
        }
        int i3 = 0;
        for (int i4 = 0; i4 < this.zzb; i4++) {
            int i5 = this.zzc[i4];
            int i6 = i5 >>> 3;
            int i7 = i5 & 7;
            if (i7 == 0) {
                int i8 = i6 << 3;
                long longValue = ((Long) this.zzd[i4]).longValue();
                zzA = zzdn.zzA(i8);
                zzB = zzdn.zzB(longValue);
                i = zzA + zzB;
            } else if (i7 == 1) {
                ((Long) this.zzd[i4]).longValue();
                i = zzdn.zzA(i6 << 3) + 8;
            } else if (i7 == 2) {
                int zzA2 = zzdn.zzA(i6 << 3);
                int zzd2 = ((zzdf) this.zzd[i4]).zzd();
                i = zzA2 + zzdn.zzA(zzd2) + zzd2;
            } else if (i7 == 3) {
                int zzA3 = zzdn.zzA(i6 << 3);
                zzA = zzA3 + zzA3;
                zzB = ((zzgt) this.zzd[i4]).zza();
                i = zzA + zzB;
            } else if (i7 == 5) {
                ((Integer) this.zzd[i4]).intValue();
                i = zzdn.zzA(i6 << 3) + 4;
            } else {
                throw new IllegalStateException(new zzeq("Protocol message tag had invalid wire type."));
            }
            i3 += i;
        }
        this.zze = i3;
        return i3;
    }

    public final int zzb() {
        int i = this.zze;
        if (i != -1) {
            return i;
        }
        int i2 = 0;
        for (int i3 = 0; i3 < this.zzb; i3++) {
            int zzA = zzdn.zzA(8);
            int zzA2 = zzdn.zzA(16) + zzdn.zzA(this.zzc[i3] >>> 3);
            int zzA3 = zzdn.zzA(24);
            int zzd2 = ((zzdf) this.zzd[i3]).zzd();
            i2 += zzA + zzA + zzA2 + zzA3 + zzdn.zzA(zzd2) + zzd2;
        }
        this.zze = i2;
        return i2;
    }

    public final zzgt zzd(zzgt zzgt) {
        if (zzgt.equals(zza)) {
            return this;
        }
        zzg();
        int i = this.zzb + zzgt.zzb;
        zzm(i);
        System.arraycopy(zzgt.zzc, 0, this.zzc, this.zzb, zzgt.zzb);
        System.arraycopy(zzgt.zzd, 0, this.zzd, this.zzb, zzgt.zzb);
        this.zzb = i;
        return this;
    }

    public final void zzg() {
        if (!this.zzf) {
            throw new UnsupportedOperationException();
        }
    }

    public final void zzh() {
        if (this.zzf) {
            this.zzf = false;
        }
    }

    public final void zzi(StringBuilder sb2, int i) {
        for (int i2 = 0; i2 < this.zzb; i2++) {
            zzfo.zzb(sb2, i, String.valueOf(this.zzc[i2] >>> 3), this.zzd[i2]);
        }
    }

    public final void zzj(int i, Object obj) {
        zzg();
        zzm(this.zzb + 1);
        int[] iArr = this.zzc;
        int i2 = this.zzb;
        iArr[i2] = i;
        this.zzd[i2] = obj;
        this.zzb = i2 + 1;
    }

    public final void zzk(zzhh zzhh) throws IOException {
        for (int i = 0; i < this.zzb; i++) {
            zzhh.zzw(this.zzc[i] >>> 3, this.zzd[i]);
        }
    }

    public final void zzl(zzhh zzhh) throws IOException {
        if (this.zzb != 0) {
            for (int i = 0; i < this.zzb; i++) {
                int i2 = this.zzc[i];
                Object obj = this.zzd[i];
                int i3 = i2 & 7;
                int i4 = i2 >>> 3;
                if (i3 == 0) {
                    zzhh.zzt(i4, ((Long) obj).longValue());
                } else if (i3 == 1) {
                    zzhh.zzm(i4, ((Long) obj).longValue());
                } else if (i3 == 2) {
                    zzhh.zzd(i4, (zzdf) obj);
                } else if (i3 == 3) {
                    zzhh.zzF(i4);
                    ((zzgt) obj).zzl(zzhh);
                    zzhh.zzh(i4);
                } else if (i3 == 5) {
                    zzhh.zzk(i4, ((Integer) obj).intValue());
                } else {
                    throw new RuntimeException(new zzeq("Protocol message tag had invalid wire type."));
                }
            }
        }
    }

    private zzgt() {
        this(0, new int[8], new Object[8], true);
    }
}
