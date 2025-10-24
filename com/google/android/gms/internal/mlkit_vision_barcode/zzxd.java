package com.google.android.gms.internal.mlkit_vision_barcode;

final class zzxd extends zzxl {
    private int zza;
    private int zzb;
    private float zzc;
    private float zzd;
    private boolean zze;
    private float zzf;
    private float zzg;
    private long zzh;
    private long zzi;
    private boolean zzj;
    private float zzk;
    private float zzl;
    private short zzm;

    public final zzxl zza(boolean z) {
        this.zzj = true;
        this.zzm = (short) (this.zzm | 512);
        return this;
    }

    public final zzxl zzb(float f) {
        this.zzg = 0.8f;
        this.zzm = (short) (this.zzm | 64);
        return this;
    }

    public final zzxl zzc(float f) {
        this.zzf = 0.5f;
        this.zzm = (short) (this.zzm | 32);
        return this;
    }

    public final zzxl zzd(float f) {
        this.zzd = 0.8f;
        this.zzm = (short) (this.zzm | 8);
        return this;
    }

    public final zzxl zze(int i) {
        this.zzb = 5;
        this.zzm = (short) (this.zzm | 2);
        return this;
    }

    public final zzxl zzf(float f) {
        this.zzc = 0.25f;
        this.zzm = (short) (this.zzm | 4);
        return this;
    }

    public final zzxl zzg(int i) {
        this.zza = 10;
        this.zzm = (short) (this.zzm | 1);
        return this;
    }

    public final zzxl zzh(long j) {
        this.zzi = 3000;
        this.zzm = (short) (this.zzm | 256);
        return this;
    }

    public final zzxl zzi(boolean z) {
        this.zze = z;
        this.zzm = (short) (this.zzm | 16);
        return this;
    }

    public final zzxl zzj(float f) {
        this.zzk = 0.1f;
        this.zzm = (short) (this.zzm | 1024);
        return this;
    }

    public final zzxl zzk(long j) {
        this.zzh = 1500;
        this.zzm = (short) (this.zzm | 128);
        return this;
    }

    public final zzxl zzl(float f) {
        this.zzl = 0.05f;
        this.zzm = (short) (this.zzm | 2048);
        return this;
    }

    public final zzxm zzm() {
        if (this.zzm != 4095) {
            StringBuilder sb2 = new StringBuilder();
            if ((this.zzm & 1) == 0) {
                sb2.append(" recentFramesToCheck");
            }
            if ((this.zzm & 2) == 0) {
                sb2.append(" recentFramesContainingPredictedArea");
            }
            if ((this.zzm & 4) == 0) {
                sb2.append(" recentFramesIou");
            }
            if ((this.zzm & 8) == 0) {
                sb2.append(" maxCoverage");
            }
            if ((this.zzm & 16) == 0) {
                sb2.append(" useConfidenceScore");
            }
            if ((this.zzm & 32) == 0) {
                sb2.append(" lowerConfidenceScore");
            }
            if ((this.zzm & 64) == 0) {
                sb2.append(" higherConfidenceScore");
            }
            if ((this.zzm & 128) == 0) {
                sb2.append(" zoomIntervalInMillis");
            }
            if ((this.zzm & 256) == 0) {
                sb2.append(" resetIntervalInMillis");
            }
            if ((this.zzm & 512) == 0) {
                sb2.append(" enableZoomThreshold");
            }
            if ((this.zzm & 1024) == 0) {
                sb2.append(" zoomInThreshold");
            }
            if ((this.zzm & 2048) == 0) {
                sb2.append(" zoomOutThreshold");
            }
            throw new IllegalStateException("Missing required properties:".concat(sb2.toString()));
        }
        return new zzxf(this.zza, this.zzb, this.zzc, this.zzd, this.zze, this.zzf, this.zzg, this.zzh, this.zzi, this.zzj, this.zzk, this.zzl, (zzxe) null);
    }
}
