package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.tasks.TaskCompletionSource;
import j6.A;
import j6.I;
import j6.i;
import k6.H0;
import k6.t0;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzacz  reason: invalid package */
final class zzacz extends zzafg<i, t0> {
    private final I zzv;
    private final String zzw;
    private final String zzx;

    public zzacz(I i, String str, String str2) {
        super(2);
        this.zzv = (I) Preconditions.checkNotNull(i);
        this.zzw = Preconditions.checkNotEmpty(str);
        this.zzx = str2;
    }

    public final String zza() {
        return "finalizeMfaSignIn";
    }

    public final void zzb() {
        k6.i zza = zzacr.zza(this.zzc, this.zzk);
        A a = this.zzd;
        if (a == null || a.d().equalsIgnoreCase(zza.d())) {
            ((t0) this.zze).a(this.zzj, zza);
            zzb(new H0(zza));
            return;
        }
        zza(new Status(17024));
    }

    public final void zza(TaskCompletionSource taskCompletionSource, zzaep zzaep) {
        this.zzg = new zzafq(this, taskCompletionSource);
        zzaep.zza(this.zzw, this.zzv, this.zzx, (zzaen) this.zzb);
    }
}
