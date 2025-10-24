package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.tasks.TaskCompletionSource;
import j6.i;
import k6.H0;
import k6.t0;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzadu  reason: invalid package */
final class zzadu extends zzafg<i, t0> {
    private final zzajd zzv;

    public zzadu(String str, String str2) {
        super(2);
        Preconditions.checkNotEmpty(str, "token cannot be null or empty");
        this.zzv = new zzajd(str, str2);
    }

    public final String zza() {
        return "signInWithCustomToken";
    }

    public final void zzb() {
        k6.i zza = zzacr.zza(this.zzc, this.zzk);
        ((t0) this.zze).a(this.zzj, zza);
        zzb(new H0(zza));
    }

    public final void zza(TaskCompletionSource taskCompletionSource, zzaep zzaep) {
        this.zzg = new zzafq(this, taskCompletionSource);
        zzaep.zza(this.zzv, (zzaen) this.zzb);
    }
}
