package com.google.android.gms.internal.mlkit_vision_face;

import g8.g;

public final /* synthetic */ class zzmt implements Runnable {
    public final /* synthetic */ zzmz zza;
    public final /* synthetic */ zzkb zzb;
    public final /* synthetic */ Object zzc;
    public final /* synthetic */ long zzd;
    public final /* synthetic */ g zze;

    public /* synthetic */ zzmt(zzmz zzmz, zzkb zzkb, Object obj, long j, g gVar, byte[] bArr) {
        this.zza = zzmz;
        this.zzb = zzkb;
        this.zzc = obj;
        this.zzd = j;
        this.zze = gVar;
    }

    public final void run() {
        this.zza.zzf(this.zzb, this.zzc, this.zzd, this.zze);
    }
}
