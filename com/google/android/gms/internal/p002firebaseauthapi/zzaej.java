package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.tasks.TaskCompletionSource;
import j6.d0;
import k6.t0;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzaej  reason: invalid package */
final class zzaej extends zzafg<Void, t0> {
    private final d0 zzv;

    public zzaej(d0 d0Var) {
        super(2);
        this.zzv = (d0) Preconditions.checkNotNull(d0Var, "request cannot be null");
    }

    public final String zza() {
        return "updateProfile";
    }

    public final void zzb() {
        ((t0) this.zze).a(this.zzj, zzacr.zza(this.zzc, this.zzk));
        zzb(null);
    }

    public final void zza(TaskCompletionSource taskCompletionSource, zzaep zzaep) {
        this.zzg = new zzafq(this, taskCompletionSource);
        zzaep.zza(this.zzd.zze(), this.zzv, (zzaen) this.zzb);
    }
}
