package com.google.android.gms.internal.mlkit_vision_barcode_bundled;

final class zzda extends zzde {
    private final int zzc;
    private final int zzd;

    public zzda(byte[] bArr, int i, int i2) {
        super(bArr);
        zzdf.zzo(i, i + i2, bArr.length);
        this.zzc = i;
        this.zzd = i2;
    }

    public final byte zza(int i) {
        zzdf.zzu(i, this.zzd);
        return this.zza[this.zzc + i];
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
        System.arraycopy(this.zza, this.zzc + i, bArr, i2, i3);
    }
}
