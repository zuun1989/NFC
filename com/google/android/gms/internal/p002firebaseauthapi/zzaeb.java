package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.tasks.TaskCompletionSource;
import k6.p;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzaeb  reason: invalid package */
final class zzaeb extends zzafg<zzais, Void> {
    private final zzaiv zzv;

    public zzaeb(p pVar, String str) {
        super(12);
        Preconditions.checkNotNull(pVar);
        this.zzv = zzaiv.zza(Preconditions.checkNotEmpty(pVar.zzb()), str);
    }

    public final String zza() {
        return "startMfaEnrollment";
    }

    public final void zzb() {
        zzb(this.zzt);
    }

    public final void zza(TaskCompletionSource taskCompletionSource, zzaep zzaep) {
        this.zzg = new zzafq(this, taskCompletionSource);
        zzaep.zza(this.zzv, (zzaen) this.zzb);
    }
}
