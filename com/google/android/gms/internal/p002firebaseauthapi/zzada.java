package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.tasks.TaskCompletionSource;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzada  reason: invalid package */
final class zzada extends zzafg<zzaht, Void> {
    private final zzahu zzv;

    public zzada(String str, String str2) {
        super(10);
        Preconditions.checkNotEmpty(str2);
        this.zzv = zzahu.zza(str, str2);
    }

    public final String zza() {
        return "getRecaptchaConfig";
    }

    public final void zzb() {
        zzb(this.zzr);
    }

    public final void zza(TaskCompletionSource taskCompletionSource, zzaep zzaep) {
        this.zzg = new zzafq(this, taskCompletionSource);
        zzaep.zza(this.zzv, (zzaen) this.zzb);
    }
}
