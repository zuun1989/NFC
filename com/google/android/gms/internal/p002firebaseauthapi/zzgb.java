package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.internal.p002firebaseauthapi.zzgg;
import java.security.GeneralSecurityException;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzgb  reason: invalid package */
public final class zzgb extends zzcv {
    private final zzgg zza;
    private final zzaan zzb;
    private final zzaam zzc;
    private final Integer zzd;

    private zzgb(zzgg zzgg, zzaan zzaan, zzaam zzaam, Integer num) {
        this.zza = zzgg;
        this.zzb = zzaan;
        this.zzc = zzaam;
        this.zzd = num;
    }

    public final /* synthetic */ zzce zza() {
        return (zzgg) zza();
    }

    public final Integer zzb() {
        return this.zzd;
    }

    public final /* synthetic */ zzcx zzc() {
        return this.zza;
    }

    public final zzaam zzd() {
        return this.zzc;
    }

    public final zzaan zze() {
        return this.zzb;
    }

    public static zzgb zza(zzgg.zza zza2, zzaan zzaan, Integer num) throws GeneralSecurityException {
        zzaam zzaam;
        zzgg.zza zza3 = zzgg.zza.zzc;
        if (zza2 != zza3 && num == null) {
            String valueOf = String.valueOf(zza2);
            throw new GeneralSecurityException("For given Variant " + valueOf + " the value of idRequirement must be non-null");
        } else if (zza2 == zza3 && num != null) {
            throw new GeneralSecurityException("For given Variant NO_PREFIX the value of idRequirement must be null");
        } else if (zzaan.zza() == 32) {
            zzgg zza4 = zzgg.zza(zza2);
            if (zza4.zzb() == zza3) {
                zzaam = zzpd.zza;
            } else if (zza4.zzb() == zzgg.zza.zzb) {
                zzaam = zzpd.zza(num.intValue());
            } else if (zza4.zzb() == zzgg.zza.zza) {
                zzaam = zzpd.zzb(num.intValue());
            } else {
                String valueOf2 = String.valueOf(zza4.zzb());
                throw new IllegalStateException("Unknown Variant: " + valueOf2);
            }
            return new zzgb(zza4, zzaan, zzaam, num);
        } else {
            int zza5 = zzaan.zza();
            throw new GeneralSecurityException("XChaCha20Poly1305 key must be constructed with key of length 32 bytes, not " + zza5);
        }
    }
}
