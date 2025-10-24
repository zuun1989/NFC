package com.google.android.gms.internal.mlkit_vision_face;

import com.google.android.gms.tasks.OnFailureListener;

public final /* synthetic */ class zzna implements OnFailureListener {
    public final /* synthetic */ zznb zza;
    public final /* synthetic */ long zzb;

    public /* synthetic */ zzna(zznb zznb, long j) {
        this.zza = zznb;
        this.zzb = j;
    }

    public final void onFailure(Exception exc) {
        this.zza.zzb(this.zzb, exc);
    }
}
