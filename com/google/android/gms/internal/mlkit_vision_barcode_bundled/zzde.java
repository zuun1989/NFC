package com.google.android.gms.internal.mlkit_vision_barcode_bundled;

import java.io.IOException;
import java.nio.charset.Charset;

class zzde extends zzdd {
    protected final byte[] zza;

    public zzde(byte[] bArr) {
        super((zzdc) null);
        bArr.getClass();
        this.zza = bArr;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzdf) || zzd() != ((zzdf) obj).zzd()) {
            return false;
        }
        if (zzd() == 0) {
            return true;
        }
        if (!(obj instanceof zzde)) {
            return obj.equals(this);
        }
        zzde zzde = (zzde) obj;
        int zzp = zzp();
        int zzp2 = zzde.zzp();
        if (zzp == 0 || zzp2 == 0 || zzp == zzp2) {
            return zzg(zzde, 0, zzd());
        }
        return false;
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

    public void zze(byte[] bArr, int i, int i2, int i3) {
        System.arraycopy(this.zza, i, bArr, i2, i3);
    }

    public final boolean zzg(zzdf zzdf, int i, int i2) {
        if (i2 <= zzdf.zzd()) {
            int i3 = i + i2;
            if (i3 > zzdf.zzd()) {
                int zzd = zzdf.zzd();
                throw new IllegalArgumentException("Ran off end of other: " + i + ", " + i2 + ", " + zzd);
            } else if (!(zzdf instanceof zzde)) {
                return zzdf.zzk(i, i3).equals(zzk(0, i2));
            } else {
                zzde zzde = (zzde) zzdf;
                byte[] bArr = this.zza;
                byte[] bArr2 = zzde.zza;
                int zzc = zzc() + i2;
                int zzc2 = zzc();
                int zzc3 = zzde.zzc() + i;
                while (zzc2 < zzc) {
                    if (bArr[zzc2] != bArr2[zzc3]) {
                        return false;
                    }
                    zzc2++;
                    zzc3++;
                }
                return true;
            }
        } else {
            int zzd2 = zzd();
            throw new IllegalArgumentException("Length too large: " + i2 + zzd2);
        }
    }

    public final int zzi(int i, int i2, int i3) {
        return zzep.zzb(i, this.zza, zzc() + i2, i3);
    }

    public final int zzj(int i, int i2, int i3) {
        int zzc = zzc() + i2;
        return zzhe.zzf(i, this.zza, zzc, i3 + zzc);
    }

    public final zzdf zzk(int i, int i2) {
        int zzo = zzdf.zzo(i, i2, zzd());
        if (zzo == 0) {
            return zzdf.zzb;
        }
        return new zzda(this.zza, zzc() + i, zzo);
    }

    public final String zzl(Charset charset) {
        return new String(this.zza, zzc(), zzd(), charset);
    }

    public final void zzm(zzcx zzcx) throws IOException {
        ((zzdk) zzcx).zzc(this.zza, zzc(), zzd());
    }

    public final boolean zzn() {
        int zzc = zzc();
        return zzhe.zzg(this.zza, zzc, zzd() + zzc);
    }
}
