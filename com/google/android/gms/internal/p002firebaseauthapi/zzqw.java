package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;
import java.security.InvalidAlgorithmParameterException;
import java.util.Objects;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzqw  reason: invalid package */
public final class zzqw extends zzrm {
    private final int zza;
    private final int zzb;
    private final zzb zzc;

    /* renamed from: com.google.android.gms.internal.firebase-auth-api.zzqw$zza */
    public static final class zza {
        private Integer zza;
        private Integer zzb;
        private zzb zzc;

        public final zza zza(int i) throws GeneralSecurityException {
            if (i == 16 || i == 32) {
                this.zza = Integer.valueOf(i);
                return this;
            }
            throw new InvalidAlgorithmParameterException(String.format("Invalid key size %d; only 128-bit and 256-bit AES keys are supported", new Object[]{Integer.valueOf(i << 3)}));
        }

        public final zza zzb(int i) throws GeneralSecurityException {
            if (i < 10 || 16 < i) {
                throw new GeneralSecurityException("Invalid tag size for AesCmacParameters: " + i);
            }
            this.zzb = Integer.valueOf(i);
            return this;
        }

        private zza() {
            this.zza = null;
            this.zzb = null;
            this.zzc = zzb.zzd;
        }

        public final zza zza(zzb zzb2) {
            this.zzc = zzb2;
            return this;
        }

        public final zzqw zza() throws GeneralSecurityException {
            Integer num = this.zza;
            if (num == null) {
                throw new GeneralSecurityException("key size not set");
            } else if (this.zzb == null) {
                throw new GeneralSecurityException("tag size not set");
            } else if (this.zzc != null) {
                return new zzqw(num.intValue(), this.zzb.intValue(), this.zzc);
            } else {
                throw new GeneralSecurityException("variant not set");
            }
        }
    }

    /* renamed from: com.google.android.gms.internal.firebase-auth-api.zzqw$zzb */
    public static final class zzb {
        public static final zzb zza = new zzb("TINK");
        public static final zzb zzb = new zzb("CRUNCHY");
        public static final zzb zzc = new zzb("LEGACY");
        public static final zzb zzd = new zzb("NO_PREFIX");
        private final String zze;

        private zzb(String str) {
            this.zze = str;
        }

        public final String toString() {
            return this.zze;
        }
    }

    public static zza zzd() {
        return new zza();
    }

    private final int zzf() {
        int i;
        zzb zzb2 = this.zzc;
        if (zzb2 == zzb.zzd) {
            return this.zzb;
        }
        if (zzb2 == zzb.zza) {
            i = this.zzb;
        } else if (zzb2 == zzb.zzb) {
            i = this.zzb;
        } else if (zzb2 == zzb.zzc) {
            i = this.zzb;
        } else {
            throw new IllegalStateException("Unknown variant");
        }
        return i + 5;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzqw)) {
            return false;
        }
        zzqw zzqw = (zzqw) obj;
        if (zzqw.zza == this.zza && zzqw.zzf() == zzf() && zzqw.zzc == this.zzc) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return Objects.hash(new Object[]{zzqw.class, Integer.valueOf(this.zza), Integer.valueOf(this.zzb), this.zzc});
    }

    public final String toString() {
        String valueOf = String.valueOf(this.zzc);
        int i = this.zzb;
        int i2 = this.zza;
        return "AES-CMAC Parameters (variant: " + valueOf + ", " + i + "-byte tags, and " + i2 + "-byte key)";
    }

    public final boolean zza() {
        if (this.zzc != zzb.zzd) {
            return true;
        }
        return false;
    }

    public final int zzb() {
        return this.zzb;
    }

    public final int zzc() {
        return this.zza;
    }

    public final zzb zze() {
        return this.zzc;
    }

    private zzqw(int i, int i2, zzb zzb2) {
        this.zza = i;
        this.zzb = i2;
        this.zzc = zzb2;
    }
}
