package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.tasks.TaskCompletionSource;
import j6.d;
import k6.C0;
import k6.t0;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzact  reason: invalid package */
final class zzact extends zzafg<d, t0> {
    private final String zzv;
    private final String zzw;

    public zzact(String str, String str2) {
        super(4);
        Preconditions.checkNotEmpty(str, "code cannot be null or empty");
        this.zzv = str;
        this.zzw = str2;
    }

    public final String zza() {
        return "checkActionCode";
    }

    public final void zzb() {
        zzb(new C0(this.zzm));
    }

    public final void zza(TaskCompletionSource taskCompletionSource, zzaep zzaep) {
        this.zzg = new zzafq(this, taskCompletionSource);
        zzaep.zzd(this.zzv, this.zzw, this.zzb);
    }
}
