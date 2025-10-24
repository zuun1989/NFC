package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.tasks.TaskCompletionSource;
import j6.e;
import k6.t0;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzadq  reason: invalid package */
final class zzadq extends zzafg<Void, t0> {
    private final zzahn zzv;
    private final String zzw;

    public zzadq(String str, e eVar, String str2, String str3, String str4) {
        super(4);
        Preconditions.checkNotEmpty(str, "email cannot be null or empty");
        zzahn zzahn = new zzahn(eVar.zza());
        this.zzv = zzahn;
        zzahn.zzb(str);
        zzahn.zza(eVar);
        zzahn.zzc(str2);
        zzahn.zza(str3);
        this.zzw = str4;
    }

    public final String zza() {
        return this.zzw;
    }

    public final void zzb() {
        zzb(null);
    }

    public final void zza(TaskCompletionSource taskCompletionSource, zzaep zzaep) {
        this.zzg = new zzafq(this, taskCompletionSource);
        zzaep.zzb(this.zzv, (zzaen) this.zzb);
    }
}
