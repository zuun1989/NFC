package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.tasks.TaskCompletionSource;
import j6.h;
import j6.i;
import k6.H0;
import k6.s0;
import k6.t0;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzadc  reason: invalid package */
final class zzadc extends zzafg<i, t0> {
    private final zzajc zzv;

    public zzadc(h hVar) {
        super(2);
        Preconditions.checkNotNull(hVar, "credential cannot be null");
        this.zzv = s0.a(hVar, (String) null);
    }

    public final String zza() {
        return "linkFederatedCredential";
    }

    public final void zzb() {
        k6.i zza = zzacr.zza(this.zzc, this.zzk);
        ((t0) this.zze).a(this.zzj, zza);
        zzb(new H0(zza));
    }

    public final void zza(TaskCompletionSource taskCompletionSource, zzaep zzaep) {
        this.zzg = new zzafq(this, taskCompletionSource);
        zzaep.zza(this.zzd.zze(), this.zzv, (zzaen) this.zzb);
    }
}
