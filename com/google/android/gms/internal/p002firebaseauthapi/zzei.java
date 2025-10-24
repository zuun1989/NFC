package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.internal.p002firebaseauthapi.zzem;
import java.security.GeneralSecurityException;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzei  reason: invalid package */
public final class zzei extends zzcv {
    private final zzem zza;
    private final zzaan zzb;
    private final zzaam zzc;
    private final Integer zzd;

    private zzei(zzem zzem, zzaan zzaan, zzaam zzaam, Integer num) {
        this.zza = zzem;
        this.zzb = zzaan;
        this.zzc = zzaam;
        this.zzd = num;
    }

    public final /* synthetic */ zzce zza() {
        return (zzem) zza();
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

    public static zzei zza(zzem.zza zza2, zzaan zzaan, Integer num) throws GeneralSecurityException {
        zzaam zzaam;
        zzem.zza zza3 = zzem.zza.zzc;
        if (zza2 != zza3 && num == null) {
            String valueOf = String.valueOf(zza2);
            throw new GeneralSecurityException("For given Variant " + valueOf + " the value of idRequirement must be non-null");
        } else if (zza2 == zza3 && num != null) {
            throw new GeneralSecurityException("For given Variant NO_PREFIX the value of idRequirement must be null");
        } else if (zzaan.zza() == 32) {
            zzem zza4 = zzem.zza(zza2);
            if (zza4.zzb() == zza3) {
                zzaam = zzpd.zza;
            } else if (zza4.zzb() == zzem.zza.zzb) {
                zzaam = zzpd.zza(num.intValue());
            } else if (zza4.zzb() == zzem.zza.zza) {
                zzaam = zzpd.zzb(num.intValue());
            } else {
                String valueOf2 = String.valueOf(zza4.zzb());
                throw new IllegalStateException("Unknown Variant: " + valueOf2);
            }
            return new zzei(zza4, zzaan, zzaam, num);
        } else {
            int zza5 = zzaan.zza();
            throw new GeneralSecurityException("ChaCha20Poly1305 key must be constructed with key of length 32 bytes, not " + zza5);
        }
    }
}
