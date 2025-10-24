package com.google.android.gms.internal.p002firebaseauthapi;

import java.io.IOException;
import java.util.Arrays;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzany  reason: invalid package */
public final class zzany {
    private static final zzany zza = new zzany(0, new int[0], new Object[0], false);
    private int zzb;
    private int[] zzc;
    private Object[] zzd;
    private int zze;
    private boolean zzf;

    private zzany() {
        this(0, new int[8], new Object[8], true);
    }

    public static zzany zzc() {
        return zza;
    }

    public static zzany zzd() {
        return new zzany();
    }

    private final void zzf() {
        if (!this.zzf) {
            throw new UnsupportedOperationException();
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof zzany)) {
            return false;
        }
        zzany zzany = (zzany) obj;
        int i = this.zzb;
        if (i == zzany.zzb) {
            int[] iArr = this.zzc;
            int[] iArr2 = zzany.zzc;
            int i2 = 0;
            while (true) {
                if (i2 >= i) {
                    Object[] objArr = this.zzd;
                    Object[] objArr2 = zzany.zzd;
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

    public final int zza() {
        int zze2;
        int i = this.zze;
        if (i != -1) {
            return i;
        }
        int i2 = 0;
        for (int i3 = 0; i3 < this.zzb; i3++) {
            int i4 = this.zzc[i3];
            int i5 = i4 >>> 3;
            int i6 = i4 & 7;
            if (i6 == 0) {
                zze2 = zzako.zze(i5, ((Long) this.zzd[i3]).longValue());
            } else if (i6 == 1) {
                zze2 = zzako.zza(i5, ((Long) this.zzd[i3]).longValue());
            } else if (i6 == 2) {
                zze2 = zzako.zza(i5, (zzajw) this.zzd[i3]);
            } else if (i6 == 3) {
                zze2 = (zzako.zzg(i5) << 1) + ((zzany) this.zzd[i3]).zza();
            } else if (i6 == 5) {
                zze2 = zzako.zzb(i5, ((Integer) this.zzd[i3]).intValue());
            } else {
                throw new IllegalStateException(zzalm.zza());
            }
            i2 += zze2;
        }
        this.zze = i2;
        return i2;
    }

    public final int zzb() {
        int i = this.zze;
        if (i != -1) {
            return i;
        }
        int i2 = 0;
        for (int i3 = 0; i3 < this.zzb; i3++) {
            i2 += zzako.zzb(this.zzc[i3] >>> 3, (zzajw) this.zzd[i3]);
        }
        this.zze = i2;
        return i2;
    }

    public final void zze() {
        if (this.zzf) {
            this.zzf = false;
        }
    }

    private zzany(int i, int[] iArr, Object[] objArr, boolean z) {
        this.zze = -1;
        this.zzb = i;
        this.zzc = iArr;
        this.zzd = objArr;
        this.zzf = z;
    }

    public final void zzb(zzaom zzaom) throws IOException {
        if (this.zzb != 0) {
            if (zzaom.zza() == 1) {
                for (int i = 0; i < this.zzb; i++) {
                    zza(this.zzc[i], this.zzd[i], zzaom);
                }
                return;
            }
            for (int i2 = this.zzb - 1; i2 >= 0; i2--) {
                zza(this.zzc[i2], this.zzd[i2], zzaom);
            }
        }
    }

    public final zzany zza(zzany zzany) {
        if (zzany.equals(zza)) {
            return this;
        }
        zzf();
        int i = this.zzb + zzany.zzb;
        zza(i);
        System.arraycopy(zzany.zzc, 0, this.zzc, this.zzb, zzany.zzb);
        System.arraycopy(zzany.zzd, 0, this.zzd, this.zzb, zzany.zzb);
        this.zzb = i;
        return this;
    }

    public static zzany zza(zzany zzany, zzany zzany2) {
        int i = zzany.zzb + zzany2.zzb;
        int[] copyOf = Arrays.copyOf(zzany.zzc, i);
        System.arraycopy(zzany2.zzc, 0, copyOf, zzany.zzb, zzany2.zzb);
        Object[] copyOf2 = Arrays.copyOf(zzany.zzd, i);
        System.arraycopy(zzany2.zzd, 0, copyOf2, zzany.zzb, zzany2.zzb);
        return new zzany(i, copyOf, copyOf2, true);
    }

    private final void zza(int i) {
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

    public final void zza(StringBuilder sb2, int i) {
        for (int i2 = 0; i2 < this.zzb; i2++) {
            zzamo.zza(sb2, i, String.valueOf(this.zzc[i2] >>> 3), this.zzd[i2]);
        }
    }

    public final void zza(int i, Object obj) {
        zzf();
        zza(this.zzb + 1);
        int[] iArr = this.zzc;
        int i2 = this.zzb;
        iArr[i2] = i;
        this.zzd[i2] = obj;
        this.zzb = i2 + 1;
    }

    public final void zza(zzaom zzaom) throws IOException {
        if (zzaom.zza() == 2) {
            for (int i = this.zzb - 1; i >= 0; i--) {
                zzaom.zza(this.zzc[i] >>> 3, this.zzd[i]);
            }
            return;
        }
        for (int i2 = 0; i2 < this.zzb; i2++) {
            zzaom.zza(this.zzc[i2] >>> 3, this.zzd[i2]);
        }
    }

    private static void zza(int i, Object obj, zzaom zzaom) throws IOException {
        int i2 = i >>> 3;
        int i3 = i & 7;
        if (i3 == 0) {
            zzaom.zzb(i2, ((Long) obj).longValue());
        } else if (i3 == 1) {
            zzaom.zza(i2, ((Long) obj).longValue());
        } else if (i3 == 2) {
            zzaom.zza(i2, (zzajw) obj);
        } else if (i3 != 3) {
            if (i3 == 5) {
                zzaom.zzb(i2, ((Integer) obj).intValue());
                return;
            }
            throw new RuntimeException(zzalm.zza());
        } else if (zzaom.zza() == 1) {
            zzaom.zzb(i2);
            ((zzany) obj).zzb(zzaom);
            zzaom.zza(i2);
        } else {
            zzaom.zza(i2);
            ((zzany) obj).zzb(zzaom);
            zzaom.zzb(i2);
        }
    }
}
