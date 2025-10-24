package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.tasks.TaskCompletionSource;
import k6.t0;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzaee  reason: invalid package */
final class zzaee extends zzafg<Void, t0> {
    private final String zzv;

    public zzaee(String str) {
        super(2);
        this.zzv = Preconditions.checkNotEmpty(str, "email cannot be null or empty");
    }

    public final String zza() {
        return "updateEmail";
    }

    public final void zzb() {
        ((t0) this.zze).a(this.zzj, zzacr.zza(this.zzc, this.zzk));
        zzb(null);
    }

    public final void zza(TaskCompletionSource taskCompletionSource, zzaep zzaep) {
        this.zzg = new zzafq(this, taskCompletionSource);
        zzaep.zzb(this.zzd.zze(), this.zzv, this.zzb);
    }
}
