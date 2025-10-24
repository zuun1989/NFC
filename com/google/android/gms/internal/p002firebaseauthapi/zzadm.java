package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.tasks.TaskCompletionSource;
import j6.O;
import j6.i;
import k6.H0;
import k6.t0;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzadm  reason: invalid package */
final class zzadm extends zzafg<i, t0> {
    private final zzaao zzv;

    public zzadm(O o, String str) {
        super(2);
        Preconditions.checkNotNull(o, "credential cannot be null");
        this.zzv = new zzaao(o.P1(false), str);
    }

    public final String zza() {
        return "reauthenticateWithPhoneCredentialWithData";
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
