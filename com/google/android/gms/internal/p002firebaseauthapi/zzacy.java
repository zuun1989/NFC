package com.google.android.gms.internal.p002firebaseauthapi;

import android.text.TextUtils;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.tasks.TaskCompletionSource;
import j6.C;
import k6.L;
import k6.t0;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzacy  reason: invalid package */
final class zzacy extends zzafg<C, t0> {
    private final String zzv;

    public zzacy(String str) {
        super(1);
        Preconditions.checkNotEmpty(str, "refresh token cannot be null");
        this.zzv = str;
    }

    public final String zza() {
        return "getAccessToken";
    }

    public final void zzb() {
        if (TextUtils.isEmpty(this.zzj.zzd())) {
            this.zzj.zzc(this.zzv);
        }
        ((t0) this.zze).a(this.zzj, this.zzd);
        zzb(L.a(this.zzj.zzc()));
    }

    public final void zza(TaskCompletionSource taskCompletionSource, zzaep zzaep) {
        this.zzg = new zzafq(this, taskCompletionSource);
        zzaep.zzb(this.zzv, (zzaen) this.zzb);
    }
}
