package com.google.android.gms.internal.p002firebaseauthapi;

import java.util.Iterator;
import java.util.Objects;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzani  reason: invalid package */
final class zzani extends zzann {
    private final /* synthetic */ zzanh zza;

    public final Iterator iterator() {
        return new zzanj(this.zza);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    private zzani(zzanh zzanh) {
        super(zzanh);
        Objects.requireNonNull(zzanh);
        this.zza = zzanh;
    }
}
