package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.tasks.TaskCompletionSource;
import j6.i;
import j6.j;
import k6.H0;
import k6.t0;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzadi  reason: invalid package */
final class zzadi extends zzafg<i, t0> {
    private final zzagy zzv;

    public zzadi(j jVar, String str) {
        super(2);
        Preconditions.checkNotNull(jVar, "credential cannot be null or empty");
        this.zzv = new zzagy(jVar, (String) null, str);
    }

    public final String zza() {
        return "reauthenticateWithEmailLinkWithData";
    }

    public final void zzb() {
        k6.i zza = zzacr.zza(this.zzc, this.zzk);
        if (this.zzd.d().equalsIgnoreCase(zza.d())) {
            ((t0) this.zze).a(this.zzj, zza);
            zzb(new H0(zza));
            return;
        }
        zza(new Status(17024));
    }

    public final void zza(TaskCompletionSource taskCompletionSource, zzaep zzaep) {
        this.zzg = new zzafq(this, taskCompletionSource);
        zzaep.zza(this.zzv, (zzaen) this.zzb);
    }
}
