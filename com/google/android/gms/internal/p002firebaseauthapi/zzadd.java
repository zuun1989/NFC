package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.tasks.TaskCompletionSource;
import j6.i;
import j6.j;
import k6.H0;
import k6.t0;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzadd  reason: invalid package */
final class zzadd extends zzafg<i, t0> {
    private final j zzv;
    private final String zzw;

    public zzadd(j jVar, String str) {
        super(2);
        this.zzv = (j) Preconditions.checkNotNull(jVar, "credential cannot be null");
        Preconditions.checkNotEmpty(jVar.zzc(), "email cannot be null");
        Preconditions.checkNotEmpty(jVar.zzd(), "password cannot be null");
        this.zzw = str;
    }

    public final String zza() {
        return "linkEmailAuthCredential";
    }

    public final void zzb() {
        k6.i zza = zzacr.zza(this.zzc, this.zzk);
        ((t0) this.zze).a(this.zzj, zza);
        zzb(new H0(zza));
    }

    public final void zza(TaskCompletionSource taskCompletionSource, zzaep zzaep) {
        this.zzg = new zzafq(this, taskCompletionSource);
        zzaep.zza(this.zzv.zzc(), Preconditions.checkNotEmpty(this.zzv.zzd()), this.zzd.zze(), this.zzd.P1(), this.zzw, this.zzb);
    }
}
