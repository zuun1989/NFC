package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.tasks.TaskCompletionSource;
import k6.t0;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzacs  reason: invalid package */
final class zzacs extends zzafg<Void, t0> {
    private final zzaid zzv;

    public zzacs(String str, String str2, String str3) {
        super(4);
        Preconditions.checkNotEmpty(str, "code cannot be null or empty");
        Preconditions.checkNotEmpty(str2, "new password cannot be null or empty");
        this.zzv = new zzaid(str, str2, str3);
    }

    public final String zza() {
        return "confirmPasswordReset";
    }

    public final void zzb() {
        zzb(null);
    }

    public final void zza(TaskCompletionSource taskCompletionSource, zzaep zzaep) {
        this.zzg = new zzafq(this, taskCompletionSource);
        zzaep.zza(this.zzv, (zzaen) this.zzb);
    }
}
