package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.tasks.TaskCompletionSource;
import j6.O;
import k6.t0;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzaeg  reason: invalid package */
final class zzaeg extends zzafg<Void, t0> {
    private final O zzv;

    public zzaeg(O o) {
        super(2);
        this.zzv = (O) Preconditions.checkNotNull(o);
    }

    public final String zza() {
        return "updatePhoneNumber";
    }

    public final void zzb() {
        ((t0) this.zze).a(this.zzj, zzacr.zza(this.zzc, this.zzk));
        zzb(null);
    }

    public final void zza(TaskCompletionSource taskCompletionSource, zzaep zzaep) {
        this.zzg = new zzafq(this, taskCompletionSource);
        zzaep.zza(new zzaia(this.zzd.zze(), zzafx.zza(this.zzv)), (zzaen) this.zzb);
    }
}
