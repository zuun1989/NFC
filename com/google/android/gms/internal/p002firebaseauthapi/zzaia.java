package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.common.internal.Preconditions;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzaia  reason: invalid package */
public final class zzaia {
    private final String zza;
    private final zzajh zzb;

    public zzaia(String str, zzajh zzajh) {
        this.zza = Preconditions.checkNotEmpty(str);
        this.zzb = (zzajh) Preconditions.checkNotNull(zzajh);
    }

    public final zzajh zza() {
        return this.zzb;
    }

    public final String zzb() {
        return this.zza;
    }
}
