package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.tasks.TaskCompletionSource;
import k6.t0;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzaed  reason: invalid package */
final class zzaed extends zzafg<Void, t0> {
    private final String zzv;
    private final String zzw;
    private final String zzx;

    public zzaed(String str, String str2, String str3) {
        super(2);
        this.zzv = Preconditions.checkNotEmpty(str);
        this.zzw = Preconditions.checkNotEmpty(str2);
        this.zzx = str3;
    }

    public final String zza() {
        return "unenrollMfa";
    }

    public final void zzb() {
        ((t0) this.zze).a(this.zzj, zzacr.zza(this.zzc, this.zzk));
        zzb(null);
    }

    public final void zza(TaskCompletionSource taskCompletionSource, zzaep zzaep) {
        this.zzg = new zzafq(this, taskCompletionSource);
        zzaep.zza(this.zzv, this.zzw, this.zzx, (zzaen) this.zzb);
    }
}
