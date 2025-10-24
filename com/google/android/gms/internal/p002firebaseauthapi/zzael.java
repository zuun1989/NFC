package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.tasks.TaskCompletionSource;
import k6.C0;
import k6.t0;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzael  reason: invalid package */
final class zzael extends zzafg<String, t0> {
    private final String zzv;
    private final String zzw;

    public zzael(String str, String str2) {
        super(4);
        Preconditions.checkNotEmpty(str, "code cannot be null or empty");
        this.zzv = str;
        this.zzw = str2;
    }

    public final String zza() {
        return "verifyPasswordResetCode";
    }

    public final void zzb() {
        if (new C0(this.zzm).getOperation() != 0) {
            zza(new Status(17499));
        } else {
            zzb(this.zzm.zzb());
        }
    }

    public final void zza(TaskCompletionSource taskCompletionSource, zzaep zzaep) {
        this.zzg = new zzafq(this, taskCompletionSource);
        zzaep.zzd(this.zzv, this.zzw, this.zzb);
    }
}
