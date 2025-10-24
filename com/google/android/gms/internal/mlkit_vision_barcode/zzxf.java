package com.google.android.gms.internal.mlkit_vision_barcode;

final class zzxf extends zzxm {
    private final int zzb;
    private final int zzc;
    private final float zzd;
    private final float zze;
    private final boolean zzf;
    private final float zzg;
    private final float zzh;
    private final long zzi;
    private final long zzj;
    private final boolean zzk;
    private final float zzl;
    private final float zzm;

    public /* synthetic */ zzxf(int i, int i2, float f, float f2, boolean z, float f3, float f4, long j, long j2, boolean z2, float f5, float f6, zzxe zzxe) {
        this.zzb = i;
        this.zzc = i2;
        this.zzd = f;
        this.zze = f2;
        this.zzf = z;
        this.zzg = f3;
        this.zzh = f4;
        this.zzi = j;
        this.zzj = j2;
        this.zzk = z2;
        this.zzl = f5;
        this.zzm = f6;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof zzxm) {
            zzxm zzxm = (zzxm) obj;
            if (this.zzb == zzxm.zzh() && this.zzc == zzxm.zzg() && Float.floatToIntBits(this.zzd) == Float.floatToIntBits(zzxm.zzd()) && Float.floatToIntBits(this.zze) == Float.floatToIntBits(zzxm.zzc()) && this.zzf == zzxm.zzl() && Float.floatToIntBits(this.zzg) == Float.floatToIntBits(zzxm.zzb()) && Float.floatToIntBits(this.zzh) == Float.floatToIntBits(zzxm.zza()) && this.zzi == zzxm.zzj() && this.zzj == zzxm.zzi() && this.zzk == zzxm.zzk() && Float.floatToIntBits(this.zzl) == Float.floatToIntBits(zzxm.zze()) && Float.floatToIntBits(this.zzm) == Float.floatToIntBits(zzxm.zzf())) {
                return true;
            }
            return false;
        }
        return false;
    }

    public final int hashCode() {
        int i;
        int floatToIntBits = ((((((this.zzb ^ 1000003) * 1000003) ^ this.zzc) * 1000003) ^ Float.floatToIntBits(this.zzd)) * 1000003) ^ Float.floatToIntBits(this.zze);
        int i2 = 1231;
        if (true != this.zzf) {
            i = 1237;
        } else {
            i = 1231;
        }
        int floatToIntBits2 = ((((((((((floatToIntBits * 1000003) ^ i) * 1000003) ^ Float.floatToIntBits(this.zzg)) * 1000003) ^ Float.floatToIntBits(this.zzh)) * 1000003) ^ ((int) this.zzi)) * 1000003) ^ ((int) this.zzj)) * 1000003;
        if (true != this.zzk) {
            i2 = 1237;
        }
        return ((((floatToIntBits2 ^ i2) * 1000003) ^ Float.floatToIntBits(this.zzl)) * 1000003) ^ Float.floatToIntBits(this.zzm);
    }

    public final String toString() {
        return "AutoZoomOptions{recentFramesToCheck=" + this.zzb + ", recentFramesContainingPredictedArea=" + this.zzc + ", recentFramesIou=" + this.zzd + ", maxCoverage=" + this.zze + ", useConfidenceScore=" + this.zzf + ", lowerConfidenceScore=" + this.zzg + ", higherConfidenceScore=" + this.zzh + ", zoomIntervalInMillis=" + this.zzi + ", resetIntervalInMillis=" + this.zzj + ", enableZoomThreshold=" + this.zzk + ", zoomInThreshold=" + this.zzl + ", zoomOutThreshold=" + this.zzm + "}";
    }

    public final float zza() {
        return this.zzh;
    }

    public final float zzb() {
        return this.zzg;
    }

    public final float zzc() {
        return this.zze;
    }

    public final float zzd() {
        return this.zzd;
    }

    public final float zze() {
        return this.zzl;
    }

    public final float zzf() {
        return this.zzm;
    }

    public final int zzg() {
        return this.zzc;
    }

    public final int zzh() {
        return this.zzb;
    }

    public final long zzi() {
        return this.zzj;
    }

    public final long zzj() {
        return this.zzi;
    }

    public final boolean zzk() {
        return this.zzk;
    }

    public final boolean zzl() {
        return this.zzf;
    }
}
