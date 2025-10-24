package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.tasks.TaskCompletionSource;
import k6.t0;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzacq  reason: invalid package */
final class zzacq extends zzafg<Void, t0> {
    private final String zzv;
    private final String zzw;

    public zzacq(String str, String str2) {
        super(7);
        Preconditions.checkNotEmpty(str, "code cannot be null or empty");
        this.zzv = str;
        this.zzw = str2;
    }

    public final String zza() {
        return "applyActionCode";
    }

    public final void zzb() {
        zzb(null);
    }

    public final void zza(TaskCompletionSource taskCompletionSource, zzaep zzaep) {
        this.zzg = new zzafq(this, taskCompletionSource);
        zzaep.zza(this.zzv, this.zzw, (zzaen) this.zzb);
    }
}
