package com.google.android.gms.internal.auth;

import java.nio.charset.Charset;

class zzeb extends zzea {
    protected final byte[] zza;

    public zzeb(byte[] bArr) {
        bArr.getClass();
        this.zza = bArr;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzee) || zzd() != ((zzee) obj).zzd()) {
            return false;
        }
        if (zzd() == 0) {
            return true;
        }
        if (!(obj instanceof zzeb)) {
            return obj.equals(this);
        }
        zzeb zzeb = (zzeb) obj;
        int zzj = zzj();
        int zzj2 = zzeb.zzj();
        if (zzj != 0 && zzj2 != 0 && zzj != zzj2) {
            return false;
        }
        int zzd = zzd();
        if (zzd > zzeb.zzd()) {
            throw new IllegalArgumentException("Length too large: " + zzd + zzd());
        } else if (zzd <= zzeb.zzd()) {
            byte[] bArr = this.zza;
            byte[] bArr2 = zzeb.zza;
            zzeb.zzc();
            int i = 0;
            int i2 = 0;
            while (i < zzd) {
                if (bArr[i] != bArr2[i2]) {
                    return false;
                }
                i++;
                i2++;
            }
            return true;
        } else {
            throw new IllegalArgumentException("Ran off end of other: 0, " + zzd + ", " + zzeb.zzd());
        }
    }

    public byte zza(int i) {
        return this.zza[i];
    }

    public byte zzb(int i) {
        return this.zza[i];
    }

    public int zzc() {
        return 0;
    }

    public int zzd() {
        return this.zza.length;
    }

    public final int zze(int i, int i2, int i3) {
        return zzez.zzd(i, this.zza, 0, i3);
    }

    public final zzee zzf(int i, int i2) {
        int zzi = zzee.zzi(0, i2, zzd());
        if (zzi == 0) {
            return zzee.zzb;
        }
        return new zzdy(this.zza, 0, zzi);
    }

    public final String zzg(Charset charset) {
        return new String(this.zza, 0, zzd(), charset);
    }

    public final boolean zzh() {
        return zzhm.zzd(this.zza, 0, zzd());
    }
}
