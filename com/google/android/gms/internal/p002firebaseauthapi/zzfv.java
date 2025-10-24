package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.internal.p002firebaseauthapi.zzfz;
import java.security.GeneralSecurityException;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzfv  reason: invalid package */
public final class zzfv extends zzcv {
    private final zzfz zza;
    private final zzaan zzb;
    private final zzaam zzc;
    private final Integer zzd;

    private zzfv(zzfz zzfz, zzaan zzaan, zzaam zzaam, Integer num) {
        this.zza = zzfz;
        this.zzb = zzaan;
        this.zzc = zzaam;
        this.zzd = num;
    }

    public final /* synthetic */ zzce zza() {
        return (zzfz) zza();
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

    public static zzfv zza(zzfz zzfz, zzaan zzaan, Integer num) throws GeneralSecurityException {
        zzaam zzaam;
        zzfz.zza zzc2 = zzfz.zzc();
        zzfz.zza zza2 = zzfz.zza.zzb;
        if (zzc2 != zza2 && num == null) {
            String valueOf = String.valueOf(zzfz.zzc());
            throw new GeneralSecurityException("For given Variant " + valueOf + " the value of idRequirement must be non-null");
        } else if (zzfz.zzc() == zza2 && num != null) {
            throw new GeneralSecurityException("For given Variant NO_PREFIX the value of idRequirement must be null");
        } else if (zzaan.zza() == 32) {
            if (zzfz.zzc() == zza2) {
                zzaam = zzpd.zza;
            } else if (zzfz.zzc() == zzfz.zza.zza) {
                zzaam = zzpd.zzb(num.intValue());
            } else {
                String valueOf2 = String.valueOf(zzfz.zzc());
                throw new IllegalStateException("Unknown Variant: " + valueOf2);
            }
            return new zzfv(zzfz, zzaan, zzaam, num);
        } else {
            int zza3 = zzaan.zza();
            throw new GeneralSecurityException("XAesGcmKey key must be constructed with key of length 32 bytes, not " + zza3);
        }
    }
}
