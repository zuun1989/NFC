package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.tasks.TaskCompletionSource;
import j6.i;
import k6.H0;
import k6.t0;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzaef  reason: invalid package */
final class zzaef extends zzafg<i, t0> {
    private String zzv;

    public zzaef(String str) {
        super(2);
        this.zzv = Preconditions.checkNotEmpty(str, "provider cannot be null or empty");
    }

    public final String zza() {
        return "unlinkFederatedCredential";
    }

    public final void zzb() {
        k6.i zza = zzacr.zza(this.zzc, this.zzk);
        ((t0) this.zze).a(this.zzj, zza);
        zzb(new H0(zza));
    }

    public final void zza(TaskCompletionSource taskCompletionSource, zzaep zzaep) {
        this.zzg = new zzafq(this, taskCompletionSource);
        zzaep.zzf(this.zzv, this.zzd.zze(), this.zzb);
    }
}
