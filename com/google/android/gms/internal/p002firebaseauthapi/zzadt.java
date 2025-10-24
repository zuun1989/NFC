package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.tasks.TaskCompletionSource;
import k6.t0;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzadt  reason: invalid package */
final class zzadt extends zzafg<Void, t0> {
    private final zzaio zzv;

    public zzadt(String str) {
        super(9);
        this.zzv = new zzaio(str);
    }

    public final String zza() {
        return "setFirebaseUIVersion";
    }

    public final void zzb() {
        zzb(null);
    }

    public final void zza(TaskCompletionSource taskCompletionSource, zzaep zzaep) {
        this.zzg = new zzafq(this, taskCompletionSource);
        zzaep.zza(this.zzv, (zzaen) this.zzb);
    }
}
