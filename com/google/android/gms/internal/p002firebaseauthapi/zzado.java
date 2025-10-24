package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.tasks.TaskCompletionSource;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzado  reason: invalid package */
final class zzado extends zzafg<Void, Void> {
    private final zzaif zzv;

    public zzado(String str, String str2, String str3, String str4) {
        super(15);
        this.zzv = zzaif.zzg().zzd(str).zza(str2).zzc(str4).zzb(str3).zza(zzahh.ACCESS_TOKEN).zza();
    }

    public final String zza() {
        return "revokeAccessToken";
    }

    public final void zzb() {
        zzb(null);
    }

    public final void zza(TaskCompletionSource<Void> taskCompletionSource, zzaep zzaep) {
        this.zzg = new zzafq(this, taskCompletionSource);
        zzaep.zza(this.zzv, (zzaen) this.zzb);
    }
}
