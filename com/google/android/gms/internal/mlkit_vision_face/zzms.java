package com.google.android.gms.internal.mlkit_vision_face;

import g8.g;

public final /* synthetic */ class zzms implements Runnable {
    public final /* synthetic */ zzmz zza;
    public final /* synthetic */ zzkb zzb;
    public final /* synthetic */ g zzc;

    public /* synthetic */ zzms(zzmz zzmz, zzkb zzkb, g gVar, byte[] bArr) {
        this.zza = zzmz;
        this.zzb = zzkb;
        this.zzc = gVar;
    }

    public final void run() {
        this.zza.zze(this.zzb, this.zzc);
    }
}
