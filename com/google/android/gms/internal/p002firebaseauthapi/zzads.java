package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.tasks.TaskCompletionSource;
import j6.i;
import k6.H0;
import k6.t0;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzads  reason: invalid package */
final class zzads extends zzafg<i, t0> {
    private final String zzv;

    public zzads(String str) {
        super(2);
        this.zzv = str;
    }

    public final String zza() {
        return "signInAnonymously";
    }

    public final void zzb() {
        k6.i zza = zzacr.zza(this.zzc, this.zzk);
        ((t0) this.zze).a(this.zzj, zza);
        zzb(new H0(zza));
    }

    public final void zza(TaskCompletionSource taskCompletionSource, zzaep zzaep) {
        this.zzg = new zzafq(this, taskCompletionSource);
        zzaep.zzd(this.zzv, this.zzb);
    }
}
