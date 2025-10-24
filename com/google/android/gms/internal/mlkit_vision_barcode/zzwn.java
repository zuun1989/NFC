package com.google.android.gms.internal.mlkit_vision_barcode;

import c8.k;

public final /* synthetic */ class zzwn implements Runnable {
    public final /* synthetic */ zzwp zza;
    public final /* synthetic */ zzrc zzb;
    public final /* synthetic */ Object zzc;
    public final /* synthetic */ long zzd;
    public final /* synthetic */ k zze;

    public /* synthetic */ zzwn(zzwp zzwp, zzrc zzrc, Object obj, long j, k kVar) {
        this.zza = zzwp;
        this.zzb = zzrc;
        this.zzc = obj;
        this.zzd = j;
        this.zze = kVar;
    }

    public final void run() {
        this.zza.zzh(this.zzb, this.zzc, this.zzd, this.zze);
    }
}
