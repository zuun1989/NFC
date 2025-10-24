package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.tasks.TaskCompletionSource;
import j6.I;
import k6.t0;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzacw  reason: invalid package */
final class zzacw extends zzafg<Void, t0> {
    private final I zzv;
    private final String zzw;
    private final String zzx;
    private final String zzy;

    public zzacw(I i, String str, String str2, String str3) {
        super(2);
        this.zzv = (I) Preconditions.checkNotNull(i);
        this.zzw = Preconditions.checkNotEmpty(str);
        this.zzx = str2;
        this.zzy = str3;
    }

    public final String zza() {
        return "finalizeMfaEnrollment";
    }

    public final void zzb() {
        ((t0) this.zze).a(this.zzj, zzacr.zza(this.zzc, this.zzk));
        zzb(null);
    }

    public final void zza(TaskCompletionSource taskCompletionSource, zzaep zzaep) {
        this.zzg = new zzafq(this, taskCompletionSource);
        zzaep.zza(this.zzv, this.zzw, this.zzx, this.zzy, (zzaen) this.zzb);
    }
}
