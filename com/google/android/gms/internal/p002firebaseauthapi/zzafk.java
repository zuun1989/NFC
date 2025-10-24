package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.firebase.auth.b;
import java.util.Objects;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzafk  reason: invalid package */
final class zzafk implements zzafn {
    private final /* synthetic */ String zza;

    public zzafk(zzafi zzafi, String str) {
        this.zza = str;
        Objects.requireNonNull(zzafi);
    }

    public final void zza(b.b bVar, Object... objArr) {
        bVar.onCodeSent(this.zza, b.a.K1());
    }
}
