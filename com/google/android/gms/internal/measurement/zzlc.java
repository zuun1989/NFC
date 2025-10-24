package com.google.android.gms.internal.measurement;

final class zzlc extends zzlg {
    private final int zzc;

    public zzlc(byte[] bArr, int i, int i2) {
        super(bArr);
        zzlh.zzj(0, i2, bArr.length);
        this.zzc = i2;
    }

    public final byte zza(int i) {
        int i2 = this.zzc;
        if (((i2 - (i + 1)) | i) >= 0) {
            return this.zza[i];
        }
        if (i < 0) {
            StringBuilder sb2 = new StringBuilder(String.valueOf(i).length() + 11);
            sb2.append("Index < 0: ");
            sb2.append(i);
            throw new ArrayIndexOutOfBoundsException(sb2.toString());
        }
        StringBuilder sb3 = new StringBuilder(String.valueOf(i).length() + 18 + String.valueOf(i2).length());
        sb3.append("Index > length: ");
        sb3.append(i);
        sb3.append(", ");
        sb3.append(i2);
        throw new ArrayIndexOutOfBoundsException(sb3.toString());
    }

    public final byte zzb(int i) {
        return this.zza[i];
    }

    public final int zzc() {
        return this.zzc;
    }

    public final int zzd() {
        return 0;
    }
}
