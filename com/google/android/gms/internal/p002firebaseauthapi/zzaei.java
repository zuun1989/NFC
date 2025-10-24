package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.tasks.TaskCompletionSource;
import j6.e;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzaei  reason: invalid package */
final class zzaei extends zzafg<Void, Void> {
    private final zzahn zzv;

    public zzaei(String str, String str2, e eVar) {
        super(6);
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotEmpty(str2);
        Preconditions.checkNotNull(eVar);
        this.zzv = zzahn.zza(eVar, str, str2);
    }

    public final String zza() {
        return "verifyBeforeUpdateEmail";
    }

    public final void zzb() {
        zzb(null);
    }

    public final void zza(TaskCompletionSource taskCompletionSource, zzaep zzaep) {
        this.zzg = new zzafq(this, taskCompletionSource);
        zzaep.zzc(this.zzv, (zzaen) this.zzb);
    }
}
