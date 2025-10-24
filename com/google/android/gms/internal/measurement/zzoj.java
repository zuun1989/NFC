package com.google.android.gms.internal.measurement;

import java.io.IOException;
import java.util.Arrays;

public final class zzoj {
    private static final zzoj zza = new zzoj(0, new int[0], new Object[0], false);
    private int zzb;
    private int[] zzc;
    private Object[] zzd;
    private int zze;
    private boolean zzf;

    private zzoj(int i, int[] iArr, Object[] objArr, boolean z) {
        this.zze = -1;
        this.zzb = i;
        this.zzc = iArr;
        this.zzd = objArr;
        this.zzf = z;
    }

    public static zzoj zza() {
        return zza;
    }

    public static zzoj zzb() {
        return new zzoj(0, new int[8], new Object[8], true);
    }

    public static zzoj zzc(zzoj zzoj, zzoj zzoj2) {
        int i = zzoj.zzb + zzoj2.zzb;
        int[] copyOf = Arrays.copyOf(zzoj.zzc, i);
        System.arraycopy(zzoj2.zzc, 0, copyOf, zzoj.zzb, zzoj2.zzb);
        Object[] copyOf2 = Arrays.copyOf(zzoj.zzd, i);
        System.arraycopy(zzoj2.zzd, 0, copyOf2, zzoj.zzb, zzoj2.zzb);
        return new zzoj(i, copyOf, copyOf2, true);
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
        if (obj == null || !(obj instanceof zzoj)) {
            return false;
        }
        zzoj zzoj = (zzoj) obj;
        int i = this.zzb;
        if (i == zzoj.zzb) {
            int[] iArr = this.zzc;
            int[] iArr2 = zzoj.zzc;
            int i2 = 0;
            while (true) {
                if (i2 >= i) {
                    Object[] objArr = this.zzd;
                    Object[] objArr2 = zzoj.zzd;
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

    public final void zzd() {
        if (this.zzf) {
            this.zzf = false;
        }
    }

    public final void zze() {
        if (!this.zzf) {
            throw new UnsupportedOperationException();
        }
    }

    public final void zzf(zzov zzov) throws IOException {
        for (int i = 0; i < this.zzb; i++) {
            zzov.zzv(this.zzc[i] >>> 3, this.zzd[i]);
        }
    }

    public final void zzg(zzov zzov) throws IOException {
        if (this.zzb != 0) {
            for (int i = 0; i < this.zzb; i++) {
                int i2 = this.zzc[i];
                Object obj = this.zzd[i];
                int i3 = i2 & 7;
                int i4 = i2 >>> 3;
                if (i3 == 0) {
                    zzov.zzc(i4, ((Long) obj).longValue());
                } else if (i3 == 1) {
                    zzov.zzj(i4, ((Long) obj).longValue());
                } else if (i3 == 2) {
                    zzov.zzn(i4, (zzlh) obj);
                } else if (i3 == 3) {
                    zzov.zzt(i4);
                    ((zzoj) obj).zzg(zzov);
                    zzov.zzu(i4);
                } else if (i3 == 5) {
                    zzov.zzk(i4, ((Integer) obj).intValue());
                } else {
                    throw new RuntimeException(new zzmq("Protocol message tag had invalid wire type."));
                }
            }
        }
    }

    public final int zzh() {
        int i = this.zze;
        if (i != -1) {
            return i;
        }
        int i2 = 0;
        for (int i3 = 0; i3 < this.zzb; i3++) {
            int zzz = zzlm.zzz(8);
            int zzz2 = zzlm.zzz(16) + zzlm.zzz(this.zzc[i3] >>> 3);
            int zzz3 = zzlm.zzz(24);
            int zzc2 = ((zzlh) this.zzd[i3]).zzc();
            i2 += zzz + zzz + zzz2 + zzz3 + zzlm.zzz(zzc2) + zzc2;
        }
        this.zze = i2;
        return i2;
    }

    public final int zzi() {
        int zzz;
        int zzA;
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
                zzz = zzlm.zzz(i8);
                zzA = zzlm.zzA(longValue);
                i = zzz + zzA;
            } else if (i7 == 1) {
                ((Long) this.zzd[i4]).longValue();
                i = zzlm.zzz(i6 << 3) + 8;
            } else if (i7 == 2) {
                int zzz2 = zzlm.zzz(i6 << 3);
                int zzc2 = ((zzlh) this.zzd[i4]).zzc();
                i = zzz2 + zzlm.zzz(zzc2) + zzc2;
            } else if (i7 == 3) {
                int zzz3 = zzlm.zzz(i6 << 3);
                zzz = zzz3 + zzz3;
                zzA = ((zzoj) this.zzd[i4]).zzi();
                i = zzz + zzA;
            } else if (i7 == 5) {
                ((Integer) this.zzd[i4]).intValue();
                i = zzlm.zzz(i6 << 3) + 4;
            } else {
                throw new IllegalStateException(new zzmq("Protocol message tag had invalid wire type."));
            }
            i3 += i;
        }
        this.zze = i3;
        return i3;
    }

    public final void zzj(StringBuilder sb2, int i) {
        for (int i2 = 0; i2 < this.zzb; i2++) {
            zzno.zzb(sb2, i, String.valueOf(this.zzc[i2] >>> 3), this.zzd[i2]);
        }
    }

    public final void zzk(int i, Object obj) {
        zze();
        zzm(this.zzb + 1);
        int[] iArr = this.zzc;
        int i2 = this.zzb;
        iArr[i2] = i;
        this.zzd[i2] = obj;
        this.zzb = i2 + 1;
    }

    public final zzoj zzl(zzoj zzoj) {
        if (zzoj.equals(zza)) {
            return this;
        }
        zze();
        int i = this.zzb + zzoj.zzb;
        zzm(i);
        System.arraycopy(zzoj.zzc, 0, this.zzc, this.zzb, zzoj.zzb);
        System.arraycopy(zzoj.zzd, 0, this.zzd, this.zzb, zzoj.zzb);
        this.zzb = i;
        return this;
    }

    private zzoj() {
        this(0, new int[8], new Object[8], true);
    }
}
