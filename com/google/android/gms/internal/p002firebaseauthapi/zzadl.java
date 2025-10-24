package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.tasks.TaskCompletionSource;
import k6.i;
import k6.t0;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzadl  reason: invalid package */
final class zzadl extends zzafg<Void, t0> {
    private final String zzv;
    private final String zzw;
    private final String zzx;
    private final String zzy;

    public zzadl(String str, String str2, String str3, String str4) {
        super(2);
        Preconditions.checkNotEmpty(str, "email cannot be null or empty");
        Preconditions.checkNotEmpty(str2, "password cannot be null or empty");
        this.zzv = str;
        this.zzw = str2;
        this.zzx = str3;
        this.zzy = str4;
    }

    public final String zza() {
        return "reauthenticateWithEmailPassword";
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
        zzaep.zzb(this.zzv, this.zzw, this.zzx, this.zzy, this.zzb);
    }
}
