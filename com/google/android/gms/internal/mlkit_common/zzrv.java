package com.google.android.gms.internal.mlkit_common;

import W7.l;

final class zzrv extends zzsi {
    private zzmu zza;
    private String zzb;
    private boolean zzc;
    private boolean zzd;
    private l zze;
    private zzna zzf;
    private int zzg;
    private byte zzh;

    public final zzsi zza(zzna zzna) {
        if (zzna != null) {
            this.zzf = zzna;
            return this;
        }
        throw new NullPointerException("Null downloadStatus");
    }

    public final zzsi zzb(zzmu zzmu) {
        if (zzmu != null) {
            this.zza = zzmu;
            return this;
        }
        throw new NullPointerException("Null errorCode");
    }

    public final zzsi zzc(int i) {
        this.zzg = i;
        this.zzh = (byte) (this.zzh | 4);
        return this;
    }

    public final zzsi zzd(l lVar) {
        if (lVar != null) {
            this.zze = lVar;
            return this;
        }
        throw new NullPointerException("Null modelType");
    }

    public final zzsi zze(boolean z) {
        this.zzd = z;
        this.zzh = (byte) (this.zzh | 2);
        return this;
    }

    public final zzsi zzf(boolean z) {
        this.zzc = z;
        this.zzh = (byte) (this.zzh | 1);
        return this;
    }

    public final zzsi zzg(String str) {
        this.zzb = "NA";
        return this;
    }

    public final zzsj zzh() {
        zzmu zzmu;
        String str;
        l lVar;
        zzna zzna;
        if (this.zzh == 7 && (zzmu = this.zza) != null && (str = this.zzb) != null && (lVar = this.zze) != null && (zzna = this.zzf) != null) {
            return new zzrx(zzmu, str, this.zzc, this.zzd, lVar, zzna, this.zzg, (zzrw) null);
        }
        StringBuilder sb2 = new StringBuilder();
        if (this.zza == null) {
            sb2.append(" errorCode");
        }
        if (this.zzb == null) {
            sb2.append(" tfliteSchemaVersion");
        }
        if ((this.zzh & 1) == 0) {
            sb2.append(" shouldLogRoughDownloadTime");
        }
        if ((this.zzh & 2) == 0) {
            sb2.append(" shouldLogExactDownloadTime");
        }
        if (this.zze == null) {
            sb2.append(" modelType");
        }
        if (this.zzf == null) {
            sb2.append(" downloadStatus");
        }
        if ((this.zzh & 4) == 0) {
            sb2.append(" failureStatusCode");
        }
        throw new IllegalStateException("Missing required properties:".concat(sb2.toString()));
    }
}
