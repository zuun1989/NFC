package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.tasks.TaskCompletionSource;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzadb  reason: invalid package */
final class zzadb extends zzafg<zzahs, Void> {
    private final zzahp zzv = zzahp.zzb();

    public zzadb() {
        super(11);
    }

    public final String zza() {
        return "getRecaptchaParam";
    }

    public final void zzb() {
        zzb(this.zzs);
    }

    public final void zza(TaskCompletionSource<zzahs> taskCompletionSource, zzaep zzaep) {
        this.zzg = new zzafq(this, taskCompletionSource);
        zzaep.zza(this.zzv, (zzaen) this.zzb);
    }
}
