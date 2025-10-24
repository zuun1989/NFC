package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.internal.p002firebaseauthapi.zzjh;
import java.security.GeneralSecurityException;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzja  reason: invalid package */
public final class zzja extends zzjj {
    private final zzjh zza;
    private final zzaan zzb;
    private final zzaam zzc;
    private final Integer zzd;

    /* renamed from: com.google.android.gms.internal.firebase-auth-api.zzja$zza */
    public static class zza {
        private zzjh zza;
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

        public final zza zza(zzjh zzjh) {
            this.zza = zzjh;
            return this;
        }

        public final zzja zza() throws GeneralSecurityException {
            zzaam zzb2;
            zzjh zzjh = this.zza;
            if (zzjh == null || this.zzb == null) {
                throw new IllegalArgumentException("Cannot build without parameters and/or key material");
            } else if (zzjh.zzb() != this.zzb.zza()) {
                throw new GeneralSecurityException("Key size mismatch");
            } else if (this.zza.zza() && this.zzc == null) {
                throw new GeneralSecurityException("Cannot create key without ID requirement with parameters with ID requirement");
            } else if (this.zza.zza() || this.zzc == null) {
                if (this.zza.zzd() == zzjh.zzb.zzc) {
                    zzb2 = zzpd.zza;
                } else if (this.zza.zzd() == zzjh.zzb.zzb) {
                    zzb2 = zzpd.zza(this.zzc.intValue());
                } else if (this.zza.zzd() == zzjh.zzb.zza) {
                    zzb2 = zzpd.zzb(this.zzc.intValue());
                } else {
                    String valueOf = String.valueOf(this.zza.zzd());
                    throw new IllegalStateException("Unknown AesSivParameters.Variant: " + valueOf);
                }
                return new zzja(this.zza, this.zzb, zzb2, this.zzc);
            } else {
                throw new GeneralSecurityException("Cannot create key with ID requirement with parameters without ID requirement");
            }
        }
    }

    public static zza zzc() {
        return new zza();
    }

    public final /* synthetic */ zzce zza() {
        return (zzjh) zza();
    }

    public final Integer zzb() {
        return this.zzd;
    }

    public final /* synthetic */ zzjm zzd() {
        return this.zza;
    }

    public final zzaam zze() {
        return this.zzc;
    }

    public final zzaan zzf() {
        return this.zzb;
    }

    private zzja(zzjh zzjh, zzaan zzaan, zzaam zzaam, Integer num) {
        this.zza = zzjh;
        this.zzb = zzaan;
        this.zzc = zzaam;
        this.zzd = num;
    }
}
