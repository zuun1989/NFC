package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.firebase.auth.b;
import j6.S;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzaea  reason: invalid package */
final class zzaea extends zzafg<Void, b.b> {
    private final zzaar zzv;

    public zzaea(S s, String str, String str2, long j, boolean z, boolean z2, String str3, String str4, String str5, boolean z3) {
        super(8);
        Preconditions.checkNotNull(s);
        Preconditions.checkNotEmpty(str);
        this.zzv = new zzaar(s, str, str2, j, z, z2, str3, str4, str5, z3);
    }

    public final String zza() {
        return "startMfaSignInWithPhoneNumber";
    }

    public final void zzb() {
    }

    public final void zza(TaskCompletionSource taskCompletionSource, zzaep zzaep) {
        this.zzg = new zzafq(this, taskCompletionSource);
        zzaep.zza(this.zzv, (zzaen) this.zzb);
    }
}
