package com.google.android.gms.internal.p002firebaseauthapi;

import java.util.concurrent.atomic.AtomicReference;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzov  reason: invalid package */
public final class zzov {
    private static final zzov zza = new zzov();
    private static final zzoy zzb = new zzoy();
    private final AtomicReference<zzoo> zzc = new AtomicReference<>();

    public static zzov zzb() {
        return zza;
    }

    public final zzoo zza() {
        zzoo zzoo = this.zzc.get();
        if (zzoo == null) {
            return zzb;
        }
        return zzoo;
    }
}
