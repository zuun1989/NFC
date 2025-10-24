package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzsr  reason: invalid package */
public final class zzsr extends zzss {
    private final zzsq zza;
    private final zzaan zzb;

    private zzsr(zzsq zzsq, zzaan zzaan) {
        this.zza = zzsq;
        this.zzb = zzaan;
    }

    public final /* synthetic */ zzce zza() {
        return (zzsq) zza();
    }

    public final Integer zzb() {
        return null;
    }

    public final /* synthetic */ zzsv zzc() {
        return this.zza;
    }

    public final zzaan zzd() {
        return this.zzb;
    }

    public static zzsr zza(zzsq zzsq, zzaan zzaan) throws GeneralSecurityException {
        if (zzsq.zzb() == zzaan.zza()) {
            return new zzsr(zzsq, zzaan);
        }
        throw new GeneralSecurityException("Key size mismatch");
    }
}
