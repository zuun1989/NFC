package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.internal.p002firebaseauthapi.zzqw;
import java.security.GeneralSecurityException;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzqp  reason: invalid package */
public final class zzqp extends zzrn {
    private final zzqw zza;
    private final zzaan zzb;
    private final zzaam zzc;
    private final Integer zzd;

    /* renamed from: com.google.android.gms.internal.firebase-auth-api.zzqp$zza */
    public static class zza {
        private zzqw zza;
        private zzaan zzb;
        private Integer zzc;

        public final zza zza(zzaan zzaan) throws GeneralSecurityException {
            this.zzb = zzaan;
            return this;
        }

        private zza() {
            this.zza = null;
            this.zzb = null;
            this.zzc = null;
        }

        public final zza zza(Integer num) {
            this.zzc = num;
            return this;
        }

        public final zza zza(zzqw zzqw) {
            this.zza = zzqw;
            return this;
        }

        public final zzqp zza() throws GeneralSecurityException {
            zzaam zza2;
            zzqw zzqw = this.zza;
            if (zzqw == null || this.zzb == null) {
                throw new GeneralSecurityException("Cannot build without parameters and/or key material");
            } else if (zzqw.zzc() != this.zzb.zza()) {
                throw new GeneralSecurityException("Key size mismatch");
            } else if (this.zza.zza() && this.zzc == null) {
                throw new GeneralSecurityException("Cannot create key without ID requirement with parameters with ID requirement");
            } else if (this.zza.zza() || this.zzc == null) {
                if (this.zza.zze() == zzqw.zzb.zzd) {
                    zza2 = zzpd.zza;
                } else if (this.zza.zze() == zzqw.zzb.zzc || this.zza.zze() == zzqw.zzb.zzb) {
                    zza2 = zzpd.zza(this.zzc.intValue());
                } else if (this.zza.zze() == zzqw.zzb.zza) {
                    zza2 = zzpd.zzb(this.zzc.intValue());
                } else {
                    String valueOf = String.valueOf(this.zza.zze());
                    throw new IllegalStateException("Unknown AesCmacParametersParameters.Variant: " + valueOf);
                }
                return new zzqp(this.zza, this.zzb, zza2, this.zzc);
            } else {
                throw new GeneralSecurityException("Cannot create key with ID requirement with parameters without ID requirement");
            }
        }
    }

    public static zza zzc() {
        return new zza();
    }

    public final /* synthetic */ zzce zza() {
        return (zzqw) zza();
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

    private zzqp(zzqw zzqw, zzaan zzaan, zzaam zzaam, Integer num) {
        this.zza = zzqw;
        this.zzb = zzaan;
        this.zzc = zzaam;
        this.zzd = num;
    }
}
