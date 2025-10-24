package com.google.android.gms.internal.auth;

final class zzdy extends zzeb {
    private final int zzc;

    public zzdy(byte[] bArr, int i, int i2) {
        super(bArr);
        zzee.zzi(0, i2, bArr.length);
        this.zzc = i2;
    }

    public final byte zza(int i) {
        int i2 = this.zzc;
        if (((i2 - (i + 1)) | i) >= 0) {
            return this.zza[i];
        }
        if (i < 0) {
            throw new ArrayIndexOutOfBoundsException("Index < 0: " + i);
        }
        throw new ArrayIndexOutOfBoundsException("Index > length: " + i + ", " + i2);
    }

    public final byte zzb(int i) {
        return this.zza[i];
    }

    public final int zzc() {
        return 0;
    }

    public final int zzd() {
        return this.zzc;
    }
}
