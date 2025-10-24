package com.google.android.gms.internal.fido;

final class zzct extends zzcw {
    private final int zzc;
    private final int zzd;

    public zzct(byte[] bArr, int i, int i2) {
        super(bArr);
        zzcz.zzj(i, i + i2, bArr.length);
        this.zzc = i;
        this.zzd = i2;
    }

    public final byte zza(int i) {
        int i2 = this.zzd;
        if (((i2 - (i + 1)) | i) >= 0) {
            return this.zza[this.zzc + i];
        }
        if (i < 0) {
            throw new ArrayIndexOutOfBoundsException("Index < 0: " + i);
        }
        throw new ArrayIndexOutOfBoundsException("Index > length: " + i + ", " + i2);
    }

    public final byte zzb(int i) {
        return this.zza[this.zzc + i];
    }

    public final int zzc() {
        return this.zzc;
    }

    public final int zzd() {
        return this.zzd;
    }

    public final void zze(byte[] bArr, int i, int i2, int i3) {
        System.arraycopy(this.zza, this.zzc, bArr, 0, i3);
    }
}
