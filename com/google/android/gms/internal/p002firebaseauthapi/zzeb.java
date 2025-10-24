package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.internal.p002firebaseauthapi.zzeg;
import java.security.GeneralSecurityException;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzeb  reason: invalid package */
public final class zzeb extends zzcv {
    private final zzeg zza;
    private final zzaan zzb;
    private final zzaam zzc;
    private final Integer zzd;

    /* renamed from: com.google.android.gms.internal.firebase-auth-api.zzeb$zza */
    public static class zza {
        private zzeg zza;
        private zzaan zzb;
        private Integer zzc;

        public final zza zza(Integer num) {
            this.zzc = num;
            return this;
        }

        private zza() {
            this.zza = null;
            this.zzb = null;
            this.zzc = null;
        }

        public final zza zza(zzaan zzaan) {
            this.zzb = zzaan;
            return this;
        }

        public final zza zza(zzeg zzeg) {
            this.zza = zzeg;
            return this;
        }

        public final zzeb zza() throws GeneralSecurityException {
            zzaam zzb2;
            zzeg zzeg = this.zza;
            if (zzeg == null || this.zzb == null) {
                throw new GeneralSecurityException("Cannot build without parameters and/or key material");
            } else if (zzeg.zzb() != this.zzb.zza()) {
                throw new GeneralSecurityException("Key size mismatch");
            } else if (this.zza.zza() && this.zzc == null) {
                throw new GeneralSecurityException("Cannot create key without ID requirement with parameters with ID requirement");
            } else if (this.zza.zza() || this.zzc == null) {
                if (this.zza.zzd() == zzeg.zza.zzc) {
                    zzb2 = zzpd.zza;
                } else if (this.zza.zzd() == zzeg.zza.zzb) {
                    zzb2 = zzpd.zza(this.zzc.intValue());
                } else if (this.zza.zzd() == zzeg.zza.zza) {
                    zzb2 = zzpd.zzb(this.zzc.intValue());
                } else {
                    String valueOf = String.valueOf(this.zza.zzd());
                    throw new IllegalStateException("Unknown AesGcmSivParameters.Variant: " + valueOf);
                }
                return new zzeb(this.zza, this.zzb, zzb2, this.zzc);
            } else {
                throw new GeneralSecurityException("Cannot create key with ID requirement with parameters without ID requirement");
            }
        }
    }

    public static zza zze() {
        return new zza();
    }

    public final /* synthetic */ zzce zza() {
        return (zzeg) zza();
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

    public final zzaan zzf() {
        return this.zzb;
    }

    private zzeb(zzeg zzeg, zzaan zzaan, zzaam zzaam, Integer num) {
        this.zza = zzeg;
        this.zzb = zzaan;
        this.zzc = zzaam;
        this.zzd = num;
    }
}
