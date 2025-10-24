package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.tasks.TaskCompletionSource;
import j6.e;
import k6.t0;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzadr  reason: invalid package */
final class zzadr extends zzafg<Void, t0> {
    private final zzahn zzv;

    public zzadr(String str, e eVar) {
        super(6);
        Preconditions.checkNotEmpty(str, "token cannot be null or empty");
        zzahn zzahn = new zzahn(4);
        this.zzv = zzahn;
        zzahn.zzd(str);
        if (eVar != null) {
            zzahn.zza(eVar);
        }
    }

    public final String zza() {
        return "sendEmailVerification";
    }

    public final void zzb() {
        zzb(null);
    }

    public final void zza(TaskCompletionSource taskCompletionSource, zzaep zzaep) {
        this.zzg = new zzafq(this, taskCompletionSource);
        zzaep.zza(this.zzv, (zzaen) this.zzb);
    }
}
