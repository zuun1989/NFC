package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;
import java.security.InvalidAlgorithmParameterException;
import java.util.Objects;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzjh  reason: invalid package */
public final class zzjh extends zzjm {
    private final int zza;
    private final zzb zzb;

    /* renamed from: com.google.android.gms.internal.firebase-auth-api.zzjh$zza */
    public static final class zza {
        private Integer zza;
        private zzb zzb;

        public final zza zza(int i) throws GeneralSecurityException {
            if (i == 32 || i == 48 || i == 64) {
                this.zza = Integer.valueOf(i);
                return this;
            }
            throw new InvalidAlgorithmParameterException(String.format("Invalid key size %d; only 32-byte, 48-byte and 64-byte AES-SIV keys are supported", new Object[]{Integer.valueOf(i)}));
        }

        private zza() {
            this.zza = null;
            this.zzb = zzb.zzc;
        }

        public final zza zza(zzb zzb2) {
            this.zzb = zzb2;
            return this;
        }

        public final zzjh zza() throws GeneralSecurityException {
            Integer num = this.zza;
            if (num == null) {
                throw new GeneralSecurityException("Key size is not set");
            } else if (this.zzb != null) {
                return new zzjh(num.intValue(), this.zzb);
            } else {
                throw new GeneralSecurityException("Variant is not set");
            }
        }
    }

    /* renamed from: com.google.android.gms.internal.firebase-auth-api.zzjh$zzb */
    public static final class zzb {
        public static final zzb zza = new zzb("TINK");
        public static final zzb zzb = new zzb("CRUNCHY");
        public static final zzb zzc = new zzb("NO_PREFIX");
        private final String zzd;

        private zzb(String str) {
            this.zzd = str;
        }

        public final String toString() {
            return this.zzd;
        }
    }

    public static zza zzc() {
        return new zza();
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzjh)) {
            return false;
        }
        zzjh zzjh = (zzjh) obj;
        if (zzjh.zza == this.zza && zzjh.zzb == this.zzb) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return Objects.hash(new Object[]{zzjh.class, Integer.valueOf(this.zza), this.zzb});
    }

    public final String toString() {
        String valueOf = String.valueOf(this.zzb);
        int i = this.zza;
        return "AesSiv Parameters (variant: " + valueOf + ", " + i + "-byte key)";
    }

    public final boolean zza() {
        if (this.zzb != zzb.zzc) {
            return true;
        }
        return false;
    }

    public final int zzb() {
        return this.zza;
    }

    public final zzb zzd() {
        return this.zzb;
    }

    private zzjh(int i, zzb zzb2) {
        this.zza = i;
        this.zzb = zzb2;
    }
}
