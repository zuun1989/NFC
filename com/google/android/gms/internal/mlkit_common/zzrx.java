package com.google.android.gms.internal.mlkit_common;

import W7.l;

final class zzrx extends zzsj {
    private final zzmu zza;
    private final String zzb;
    private final boolean zzc;
    private final boolean zzd;
    private final l zze;
    private final zzna zzf;
    private final int zzg;

    public /* synthetic */ zzrx(zzmu zzmu, String str, boolean z, boolean z2, l lVar, zzna zzna, int i, zzrw zzrw) {
        this.zza = zzmu;
        this.zzb = str;
        this.zzc = z;
        this.zzd = z2;
        this.zze = lVar;
        this.zzf = zzna;
        this.zzg = i;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof zzsj) {
            zzsj zzsj = (zzsj) obj;
            if (!this.zza.equals(zzsj.zzc()) || !this.zzb.equals(zzsj.zze()) || this.zzc != zzsj.zzg() || this.zzd != zzsj.zzf() || !this.zze.equals(zzsj.zzb()) || !this.zzf.equals(zzsj.zzd()) || this.zzg != zzsj.zza()) {
                return false;
            }
            return true;
        }
        return false;
    }

    public final int hashCode() {
        int i;
        int hashCode = ((this.zza.hashCode() ^ 1000003) * 1000003) ^ this.zzb.hashCode();
        int i2 = 1231;
        if (true != this.zzc) {
            i = 1237;
        } else {
            i = 1231;
        }
        int i3 = ((hashCode * 1000003) ^ i) * 1000003;
        if (true != this.zzd) {
            i2 = 1237;
        }
        return ((((((i3 ^ i2) * 1000003) ^ this.zze.hashCode()) * 1000003) ^ this.zzf.hashCode()) * 1000003) ^ this.zzg;
    }

    public final String toString() {
        zzna zzna = this.zzf;
        l lVar = this.zze;
        String obj = this.zza.toString();
        String obj2 = lVar.toString();
        String obj3 = zzna.toString();
        return "RemoteModelLoggingOptions{errorCode=" + obj + ", tfliteSchemaVersion=" + this.zzb + ", shouldLogRoughDownloadTime=" + this.zzc + ", shouldLogExactDownloadTime=" + this.zzd + ", modelType=" + obj2 + ", downloadStatus=" + obj3 + ", failureStatusCode=" + this.zzg + "}";
    }

    public final int zza() {
        return this.zzg;
    }

    public final l zzb() {
        return this.zze;
    }

    public final zzmu zzc() {
        return this.zza;
    }

    public final zzna zzd() {
        return this.zzf;
    }

    public final String zze() {
        return this.zzb;
    }

    public final boolean zzf() {
        return this.zzd;
    }

    public final boolean zzg() {
        return this.zzc;
    }
}
