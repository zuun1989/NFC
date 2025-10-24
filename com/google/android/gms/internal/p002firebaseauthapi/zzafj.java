package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.firebase.auth.b;
import j6.O;
import java.util.Objects;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzafj  reason: invalid package */
final class zzafj implements zzafn {
    private final /* synthetic */ O zza;

    public zzafj(zzafi zzafi, O o) {
        this.zza = o;
        Objects.requireNonNull(zzafi);
    }

    public final void zza(b.b bVar, Object... objArr) {
        bVar.onVerificationCompleted(this.zza);
    }
}
