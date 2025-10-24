package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.common.api.Status;
import com.google.firebase.auth.b;
import java.util.Objects;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzafl  reason: invalid package */
final class zzafl implements zzafn {
    private final /* synthetic */ Status zza;

    public zzafl(zzafi zzafi, Status status) {
        this.zza = status;
        Objects.requireNonNull(zzafi);
    }

    public final void zza(b.b bVar, Object... objArr) {
        bVar.onVerificationFailed(zzaeo.zza(this.zza));
    }
}
