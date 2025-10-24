package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.tasks.TaskCompletionSource;
import k6.p;
import k6.t0;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzady  reason: invalid package */
final class zzady extends zzafg<Void, t0> {
    private final boolean zzaa;
    private final String zzab;
    private final String zzac;
    private final String zzad;
    private final boolean zzae;
    private final String zzv;
    private final String zzw;
    private final String zzx;
    private final long zzy;
    private final boolean zzz;

    public zzady(p pVar, String str, String str2, long j, boolean z, boolean z2, String str3, String str4, String str5, boolean z3) {
        super(8);
        Preconditions.checkNotNull(pVar);
        Preconditions.checkNotEmpty(str);
        this.zzv = Preconditions.checkNotEmpty(pVar.zzb());
        this.zzw = str;
        this.zzx = str2;
        this.zzy = j;
        this.zzz = z;
        this.zzaa = z2;
        this.zzab = str3;
        this.zzac = str4;
        this.zzad = str5;
        this.zzae = z3;
    }

    public final String zza() {
        return "startMfaEnrollment";
    }

    public final void zzb() {
    }

    public final void zza(TaskCompletionSource taskCompletionSource, zzaep zzaep) {
        this.zzg = new zzafq(this, taskCompletionSource);
        zzaep.zza(this.zzv, this.zzw, this.zzx, this.zzy, this.zzz, this.zzaa, this.zzab, this.zzac, this.zzad, this.zzae, this.zzb);
    }
}
