package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.tasks.TaskCompletionSource;
import j6.V;
import java.util.List;
import k6.t0;
import k6.u;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzacx  reason: invalid package */
final class zzacx extends zzafg<V, t0> {
    private final String zzv;
    private final String zzw;

    public zzacx(String str, String str2) {
        super(3);
        Preconditions.checkNotEmpty(str, "email cannot be null or empty");
        this.zzv = str;
        this.zzw = str2;
    }

    public final String zza() {
        return "fetchSignInMethodsForEmail";
    }

    public final void zzb() {
        List list;
        if (this.zzl.zza() == null) {
            list = zzah.zzg();
        } else {
            list = (List) Preconditions.checkNotNull(this.zzl.zza());
        }
        zzb(new u(list));
    }

    public final void zza(TaskCompletionSource taskCompletionSource, zzaep zzaep) {
        this.zzg = new zzafq(this, taskCompletionSource);
        zzaep.zze(this.zzv, this.zzw, this.zzb);
    }
}
