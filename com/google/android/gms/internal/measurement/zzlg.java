package com.google.android.gms.internal.measurement;

import java.io.IOException;

class zzlg extends zzlf {
    protected final byte[] zza;

    public zzlg(byte[] bArr) {
        super((byte[]) null);
        bArr.getClass();
        this.zza = bArr;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzlh) || zzc() != ((zzlh) obj).zzc()) {
            return false;
        }
        if (zzc() == 0) {
            return true;
        }
        if (!(obj instanceof zzlg)) {
            return obj.equals(this);
        }
        zzlg zzlg = (zzlg) obj;
        int zzi = zzi();
        int zzi2 = zzlg.zzi();
        if (zzi != 0 && zzi2 != 0 && zzi != zzi2) {
            return false;
        }
        int zzc = zzc();
        if (zzc > zzlg.zzc()) {
            int zzc2 = zzc();
            StringBuilder sb2 = new StringBuilder(String.valueOf(zzc).length() + 18 + String.valueOf(zzc2).length());
            sb2.append("Length too large: ");
            sb2.append(zzc);
            sb2.append(zzc2);
            throw new IllegalArgumentException(sb2.toString());
        } else if (zzc <= zzlg.zzc()) {
            byte[] bArr = this.zza;
            byte[] bArr2 = zzlg.zza;
            zzlg.zzd();
            int i = 0;
            int i2 = 0;
            while (i < zzc) {
                if (bArr[i] != bArr2[i2]) {
                    return false;
                }
                i++;
                i2++;
            }
            return true;
        } else {
            int zzc3 = zzlg.zzc();
            StringBuilder sb3 = new StringBuilder(String.valueOf(zzc).length() + 27 + String.valueOf(zzc3).length());
            sb3.append("Ran off end of other: 0, ");
            sb3.append(zzc);
            sb3.append(", ");
            sb3.append(zzc3);
            throw new IllegalArgumentException(sb3.toString());
        }
    }

    public byte zza(int i) {
        return this.zza[i];
    }

    public byte zzb(int i) {
        return this.zza[i];
    }

    public int zzc() {
        return this.zza.length;
    }

    public int zzd() {
        return 0;
    }

    public final zzlh zze(int i, int i2) {
        int zzj = zzlh.zzj(0, i2, zzc());
        if (zzj == 0) {
            return zzlh.zzb;
        }
        return new zzlc(this.zza, 0, zzj);
    }

    public final void zzf(zzkz zzkz) throws IOException {
        ((zzlk) zzkz).zzv(this.zza, 0, zzc());
    }

    public final int zzg(int i, int i2, int i3) {
        return zzmp.zzc(i, this.zza, 0, i3);
    }
}
