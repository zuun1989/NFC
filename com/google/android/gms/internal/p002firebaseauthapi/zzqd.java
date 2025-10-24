package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzqd  reason: invalid package */
public final class zzqd implements zzqi {
    private final zzaam zza;
    private final zzxe zzb;

    private zzqd(zzxe zzxe, zzaam zzaam) {
        this.zzb = zzxe;
        this.zza = zzaam;
    }

    public static zzqd zza(zzxe zzxe) throws GeneralSecurityException {
        return new zzqd(zzxe, zzqq.zza(zzxe.zzf()));
    }

    public static zzqd zzb(zzxe zzxe) {
        return new zzqd(zzxe, zzqq.zzb(zzxe.zzf()));
    }

    public final zzxe zza() {
        return this.zzb;
    }

    public final zzaam zzb() {
        return this.zza;
    }
}
