package com.google.android.gms.internal.mlkit_vision_face;

public final /* synthetic */ class zzmu implements Runnable {
    public final /* synthetic */ zzmz zza;
    public final /* synthetic */ zzkb zzb;
    public final /* synthetic */ String zzc;
    public final /* synthetic */ zznc zzd;

    public /* synthetic */ zzmu(zzmz zzmz, zznc zznc, zzkb zzkb, String str, byte[] bArr) {
        this.zza = zzmz;
        this.zzd = zznc;
        this.zzb = zzkb;
        this.zzc = str;
    }

    public final void run() {
        this.zza.zzd(this.zzd, this.zzb, this.zzc);
    }
}
