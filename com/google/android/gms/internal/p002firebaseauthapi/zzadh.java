package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.tasks.TaskCompletionSource;
import j6.h;
import k6.i;
import k6.s0;
import k6.t0;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzadh  reason: invalid package */
final class zzadh extends zzafg<Void, t0> {
    private final zzajc zzv;

    public zzadh(h hVar, String str) {
        super(2);
        Preconditions.checkNotNull(hVar, "credential cannot be null");
        this.zzv = s0.a(hVar, str).zza(false);
    }

    public final String zza() {
        return "reauthenticateWithCredential";
    }

    public final void zzb() {
        i zza = zzacr.zza(this.zzc, this.zzk);
        if (this.zzd.d().equalsIgnoreCase(zza.d())) {
            ((t0) this.zze).a(this.zzj, zza);
            zzb(null);
            return;
        }
        zza(new Status(17024));
    }

    public final void zza(TaskCompletionSource taskCompletionSource, zzaep zzaep) {
        this.zzg = new zzafq(this, taskCompletionSource);
        zzaep.zza(this.zzv, (zzaen) this.zzb);
    }
}
