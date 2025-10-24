package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.firebase.auth.b;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzaek  reason: invalid package */
final class zzaek extends zzafg<Void, b.b> {
    private final zzaik zzv;

    public zzaek(zzaik zzaik) {
        super(8);
        Preconditions.checkNotNull(zzaik);
        this.zzv = zzaik;
    }

    public final String zza() {
        return "verifyPhoneNumber";
    }

    public final void zzb() {
    }

    public final void zza(TaskCompletionSource taskCompletionSource, zzaep zzaep) {
        this.zzg = new zzafq(this, taskCompletionSource);
        zzaep.zza(this.zzv, (zzaen) this.zzb);
    }
}
