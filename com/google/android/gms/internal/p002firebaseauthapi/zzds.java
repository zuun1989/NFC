package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.internal.p002firebaseauthapi.zzdz;
import java.security.GeneralSecurityException;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzds  reason: invalid package */
public final class zzds extends zzcv {
    private final zzdz zza;
    private final zzaan zzb;
    private final zzaam zzc;
    private final Integer zzd;

    /* renamed from: com.google.android.gms.internal.firebase-auth-api.zzds$zza */
    public static class zza {
        private zzdz zza;
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

        public final zza zza(zzdz zzdz) {
            this.zza = zzdz;
            return this;
        }

        public final zzds zza() throws GeneralSecurityException {
            zzaam zzb2;
            zzdz zzdz = this.zza;
            if (zzdz == null || this.zzb == null) {
                throw new GeneralSecurityException("Cannot build without parameters and/or key material");
            } else if (zzdz.zzc() != this.zzb.zza()) {
                throw new GeneralSecurityException("Key size mismatch");
            } else if (this.zza.zza() && this.zzc == null) {
                throw new GeneralSecurityException("Cannot create key without ID requirement with parameters with ID requirement");
            } else if (this.zza.zza() || this.zzc == null) {
                if (this.zza.zzf() == zzdz.zzb.zzc) {
                    zzb2 = zzpd.zza;
                } else if (this.zza.zzf() == zzdz.zzb.zzb) {
                    zzb2 = zzpd.zza(this.zzc.intValue());
                } else if (this.zza.zzf() == zzdz.zzb.zza) {
                    zzb2 = zzpd.zzb(this.zzc.intValue());
                } else {
                    String valueOf = String.valueOf(this.zza.zzf());
                    throw new IllegalStateException("Unknown AesGcmParameters.Variant: " + valueOf);
                }
                return new zzds(this.zza, this.zzb, zzb2, this.zzc);
            } else {
                throw new GeneralSecurityException("Cannot create key with ID requirement with parameters without ID requirement");
            }
        }
    }

    public static zza zze() {
        return new zza();
    }

    public final /* synthetic */ zzce zza() {
        return (zzdz) zza();
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

    private zzds(zzdz zzdz, zzaan zzaan, zzaam zzaam, Integer num) {
        this.zza = zzdz;
        this.zzb = zzaan;
        this.zzc = zzaam;
        this.zzd = num;
    }
}
