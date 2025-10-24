package com.google.android.gms.internal.mlkit_vision_barcode_bundled;

import com.google.android.gms.common.api.Api;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Iterator;

final class zzgd extends zzdf {
    static final int[] zza = {1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233, 377, 610, 987, 1597, 2584, 4181, 6765, 10946, 17711, 28657, 46368, 75025, 121393, 196418, 317811, 514229, 832040, 1346269, 2178309, 3524578, 5702887, 9227465, 14930352, 24157817, 39088169, 63245986, 102334155, 165580141, 267914296, 433494437, 701408733, 1134903170, 1836311903, Api.BaseClientBuilder.API_PRIORITY_OTHER};
    private final int zzc;
    /* access modifiers changed from: private */
    public final zzdf zzd;
    /* access modifiers changed from: private */
    public final zzdf zze;
    private final int zzf;
    private final int zzg;

    public static int zzc(int i) {
        int[] iArr = zza;
        int length = iArr.length;
        if (i >= 47) {
            return Api.BaseClientBuilder.API_PRIORITY_OTHER;
        }
        return iArr[i];
    }

    public static zzdf zzy(zzdf zzdf, zzdf zzdf2) {
        if (zzdf2.zzd() == 0) {
            return zzdf;
        }
        if (zzdf.zzd() == 0) {
            return zzdf2;
        }
        int zzd2 = zzdf.zzd() + zzdf2.zzd();
        if (zzd2 < 128) {
            return zzz(zzdf, zzdf2);
        }
        if (zzdf instanceof zzgd) {
            zzgd zzgd = (zzgd) zzdf;
            if (zzgd.zze.zzd() + zzdf2.zzd() < 128) {
                return new zzgd(zzgd.zzd, zzz(zzgd.zze, zzdf2));
            }
            if (zzgd.zzd.zzf() > zzgd.zze.zzf() && zzgd.zzg > zzdf2.zzf()) {
                return new zzgd(zzgd.zzd, new zzgd(zzgd.zze, zzdf2));
            }
        }
        if (zzd2 >= zzc(Math.max(zzdf.zzf(), zzdf2.zzf()) + 1)) {
            return new zzgd(zzdf, zzdf2);
        }
        return zzfz.zza(new zzfz((zzfy) null), zzdf, zzdf2);
    }

    private static zzdf zzz(zzdf zzdf, zzdf zzdf2) {
        int zzd2 = zzdf.zzd();
        int zzd3 = zzdf2.zzd();
        byte[] bArr = new byte[(zzd2 + zzd3)];
        zzdf.zzv(bArr, 0, 0, zzd2);
        zzdf2.zzv(bArr, 0, zzd2, zzd3);
        return new zzde(bArr);
    }

    public final boolean equals(Object obj) {
        boolean z;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzdf)) {
            return false;
        }
        zzdf zzdf = (zzdf) obj;
        if (this.zzc != zzdf.zzd()) {
            return false;
        }
        if (this.zzc == 0) {
            return true;
        }
        int zzp = zzp();
        int zzp2 = zzdf.zzp();
        if (zzp != 0 && zzp2 != 0 && zzp != zzp2) {
            return false;
        }
        zzgb zzgb = new zzgb(this, (zzga) null);
        zzdd zza2 = zzgb.next();
        zzgb zzgb2 = new zzgb(zzdf, (zzga) null);
        zzdd zza3 = zzgb2.next();
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        while (true) {
            int zzd2 = zza2.zzd() - i;
            int zzd3 = zza3.zzd() - i2;
            int min = Math.min(zzd2, zzd3);
            if (i == 0) {
                z = zza2.zzg(zza3, i2, min);
            } else {
                z = zza3.zzg(zza2, i, min);
            }
            if (!z) {
                return false;
            }
            i3 += min;
            int i4 = this.zzc;
            if (i3 < i4) {
                if (min == zzd2) {
                    zza2 = zzgb.next();
                    i = 0;
                } else {
                    i += min;
                }
                if (min == zzd3) {
                    zza3 = zzgb2.next();
                    i2 = 0;
                } else {
                    i2 += min;
                }
            } else if (i3 == i4) {
                return true;
            } else {
                throw new IllegalStateException();
            }
        }
    }

    public final /* synthetic */ Iterator iterator() {
        return new zzfx(this);
    }

    public final byte zza(int i) {
        zzdf.zzu(i, this.zzc);
        return zzb(i);
    }

    public final byte zzb(int i) {
        int i2 = this.zzf;
        if (i < i2) {
            return this.zzd.zzb(i);
        }
        return this.zze.zzb(i - i2);
    }

    public final int zzd() {
        return this.zzc;
    }

    public final void zze(byte[] bArr, int i, int i2, int i3) {
        int i4 = i + i3;
        int i5 = this.zzf;
        if (i4 <= i5) {
            this.zzd.zze(bArr, i, i2, i3);
        } else if (i >= i5) {
            this.zze.zze(bArr, i - i5, i2, i3);
        } else {
            int i6 = i5 - i;
            this.zzd.zze(bArr, i, i2, i6);
            this.zze.zze(bArr, 0, i2 + i6, i3 - i6);
        }
    }

    public final int zzf() {
        return this.zzg;
    }

    public final boolean zzh() {
        if (this.zzc >= zzc(this.zzg)) {
            return true;
        }
        return false;
    }

    public final int zzi(int i, int i2, int i3) {
        int i4 = i2 + i3;
        int i5 = this.zzf;
        if (i4 <= i5) {
            return this.zzd.zzi(i, i2, i3);
        }
        if (i2 >= i5) {
            return this.zze.zzi(i, i2 - i5, i3);
        }
        int i6 = i5 - i2;
        return this.zze.zzi(this.zzd.zzi(i, i2, i6), 0, i3 - i6);
    }

    public final int zzj(int i, int i2, int i3) {
        int i4 = i2 + i3;
        int i5 = this.zzf;
        if (i4 <= i5) {
            return this.zzd.zzj(i, i2, i3);
        }
        if (i2 >= i5) {
            return this.zze.zzj(i, i2 - i5, i3);
        }
        int i6 = i5 - i2;
        return this.zze.zzj(this.zzd.zzj(i, i2, i6), 0, i3 - i6);
    }

    public final zzdf zzk(int i, int i2) {
        int zzo = zzdf.zzo(i, i2, this.zzc);
        if (zzo == 0) {
            return zzdf.zzb;
        }
        if (zzo == this.zzc) {
            return this;
        }
        int i3 = this.zzf;
        if (i2 <= i3) {
            return this.zzd.zzk(i, i2);
        }
        if (i >= i3) {
            return this.zze.zzk(i - i3, i2 - i3);
        }
        zzdf zzdf = this.zzd;
        return new zzgd(zzdf.zzk(i, zzdf.zzd()), this.zze.zzk(0, i2 - this.zzf));
    }

    public final String zzl(Charset charset) {
        return new String(zzw(), charset);
    }

    public final void zzm(zzcx zzcx) throws IOException {
        this.zzd.zzm(zzcx);
        this.zze.zzm(zzcx);
    }

    public final boolean zzn() {
        zzdf zzdf = this.zzd;
        zzdf zzdf2 = this.zze;
        if (zzdf2.zzj(zzdf.zzj(0, 0, this.zzf), 0, zzdf2.zzd()) == 0) {
            return true;
        }
        return false;
    }

    public final zzdb zzq() {
        return new zzfx(this);
    }

    private zzgd(zzdf zzdf, zzdf zzdf2) {
        this.zzd = zzdf;
        this.zze = zzdf2;
        int zzd2 = zzdf.zzd();
        this.zzf = zzd2;
        this.zzc = zzd2 + zzdf2.zzd();
        this.zzg = Math.max(zzdf.zzf(), zzdf2.zzf()) + 1;
    }
}
