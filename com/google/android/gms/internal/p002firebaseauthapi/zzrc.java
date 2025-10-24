package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.internal.p002firebaseauthapi.zzrj;
import java.security.GeneralSecurityException;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzrc  reason: invalid package */
public final class zzrc extends zzrn {
    private final zzrj zza;
    private final zzaan zzb;
    private final zzaam zzc;
    private final Integer zzd;

    /* renamed from: com.google.android.gms.internal.firebase-auth-api.zzrc$zza */
    public static class zza {
        private zzrj zza;
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

        public final zza zza(zzrj zzrj) {
            this.zza = zzrj;
            return this;
        }

        public final zzrc zza() throws GeneralSecurityException {
            zzaam zza2;
            zzrj zzrj = this.zza;
            if (zzrj == null || this.zzb == null) {
                throw new GeneralSecurityException("Cannot build without parameters and/or key material");
            } else if (zzrj.zzc() != this.zzb.zza()) {
                throw new GeneralSecurityException("Key size mismatch");
            } else if (this.zza.zza() && this.zzc == null) {
                throw new GeneralSecurityException("Cannot create key without ID requirement with parameters with ID requirement");
            } else if (this.zza.zza() || this.zzc == null) {
                if (this.zza.zzf() == zzrj.zzb.zzd) {
                    zza2 = zzpd.zza;
                } else if (this.zza.zzf() == zzrj.zzb.zzc || this.zza.zzf() == zzrj.zzb.zzb) {
                    zza2 = zzpd.zza(this.zzc.intValue());
                } else if (this.zza.zzf() == zzrj.zzb.zza) {
                    zza2 = zzpd.zzb(this.zzc.intValue());
                } else {
                    String valueOf = String.valueOf(this.zza.zzf());
                    throw new IllegalStateException("Unknown HmacParameters.Variant: " + valueOf);
                }
                return new zzrc(this.zza, this.zzb, zza2, this.zzc);
            } else {
                throw new GeneralSecurityException("Cannot create key with ID requirement with parameters without ID requirement");
            }
        }
    }

    public static zza zzc() {
        return new zza();
    }

    public final /* synthetic */ zzce zza() {
        return (zzrj) zza();
    }

    public final Integer zzb() {
        return this.zzd;
    }

    public final /* synthetic */ zzrm zzd() {
        return this.zza;
    }

    public final zzaam zze() {
        return this.zzc;
    }

    public final zzaan zzf() {
        return this.zzb;
    }

    private zzrc(zzrj zzrj, zzaan zzaan, zzaam zzaam, Integer num) {
        this.zza = zzrj;
        this.zzb = zzaan;
        this.zzc = zzaam;
        this.zzd = num;
    }
}
