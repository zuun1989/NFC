package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;
import java.security.InvalidAlgorithmParameterException;
import java.util.Objects;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzeg  reason: invalid package */
public final class zzeg extends zzcx {
    private final int zza;
    private final zza zzb;

    /* renamed from: com.google.android.gms.internal.firebase-auth-api.zzeg$zza */
    public static final class zza {
        public static final zza zza = new zza("TINK");
        public static final zza zzb = new zza("CRUNCHY");
        public static final zza zzc = new zza("NO_PREFIX");
        private final String zzd;

        private zza(String str) {
            this.zzd = str;
        }

        public final String toString() {
            return this.zzd;
        }
    }

    /* renamed from: com.google.android.gms.internal.firebase-auth-api.zzeg$zzb */
    public static final class zzb {
        private Integer zza;
        private zza zzb;

        public final zzb zza(int i) throws GeneralSecurityException {
            if (i == 16 || i == 32) {
                this.zza = Integer.valueOf(i);
                return this;
            }
            throw new InvalidAlgorithmParameterException(String.format("Invalid key size %d; only 16-byte and 32-byte AES keys are supported", new Object[]{Integer.valueOf(i)}));
        }

        private zzb() {
            this.zza = null;
            this.zzb = zza.zzc;
        }

        public final zzb zza(zza zza2) {
            this.zzb = zza2;
            return this;
        }

        public final zzeg zza() throws GeneralSecurityException {
            Integer num = this.zza;
            if (num == null) {
                throw new GeneralSecurityException("Key size is not set");
            } else if (this.zzb != null) {
                return new zzeg(num.intValue(), this.zzb);
            } else {
                throw new GeneralSecurityException("Variant is not set");
            }
        }
    }

    public static zzb zzc() {
        return new zzb();
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzeg)) {
            return false;
        }
        zzeg zzeg = (zzeg) obj;
        if (zzeg.zza == this.zza && zzeg.zzb == this.zzb) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return Objects.hash(new Object[]{zzeg.class, Integer.valueOf(this.zza), this.zzb});
    }

    public final String toString() {
        String valueOf = String.valueOf(this.zzb);
        int i = this.zza;
        return "AesGcmSiv Parameters (variant: " + valueOf + ", " + i + "-byte key)";
    }

    public final boolean zza() {
        if (this.zzb != zza.zzc) {
            return true;
        }
        return false;
    }

    public final int zzb() {
        return this.zza;
    }

    public final zza zzd() {
        return this.zzb;
    }

    private zzeg(int i, zza zza2) {
        this.zza = i;
        this.zzb = zza2;
    }
}
