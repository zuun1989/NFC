package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.tasks.TaskCompletionSource;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzafs  reason: invalid package */
public final /* synthetic */ class zzafs implements Runnable {
    private /* synthetic */ zzafp zza;
    private /* synthetic */ zzafr zzb;
    private /* synthetic */ TaskCompletionSource zzc;

    public /* synthetic */ zzafs(zzafp zzafp, zzafr zzafr, TaskCompletionSource taskCompletionSource) {
        this.zza = zzafp;
        this.zzb = zzafr;
        this.zzc = taskCompletionSource;
    }

    public final void run() {
        this.zzb.zza(this.zzc, this.zza.zza);
    }
}
