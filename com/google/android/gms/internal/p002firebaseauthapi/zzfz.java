package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;
import java.util.Objects;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzfz  reason: invalid package */
public final class zzfz extends zzcx {
    private final zza zza;
    private final int zzb;

    /* renamed from: com.google.android.gms.internal.firebase-auth-api.zzfz$zza */
    public static final class zza {
        public static final zza zza = new zza("TINK");
        public static final zza zzb = new zza("NO_PREFIX");
        private final String zzc;

        private zza(String str) {
            this.zzc = str;
        }

        public final String toString() {
            return this.zzc;
        }
    }

    private zzfz(zza zza2, int i) {
        this.zza = zza2;
        this.zzb = i;
    }

    public static zzfz zza(zza zza2, int i) throws GeneralSecurityException {
        if (i >= 8 && i <= 12) {
            return new zzfz(zza2, i);
        }
        throw new GeneralSecurityException("Salt size must be between 8 and 12 bytes");
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzfz)) {
            return false;
        }
        zzfz zzfz = (zzfz) obj;
        if (zzfz.zza == this.zza && zzfz.zzb == this.zzb) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return Objects.hash(new Object[]{zzfz.class, this.zza, Integer.valueOf(this.zzb)});
    }

    public final String toString() {
        String valueOf = String.valueOf(this.zza);
        int i = this.zzb;
        return "X-AES-GCM Parameters (variant: " + valueOf + "salt_size_bytes: " + i + ")";
    }

    public final int zzb() {
        return this.zzb;
    }

    public final zza zzc() {
        return this.zza;
    }

    public final boolean zza() {
        return this.zza != zza.zzb;
    }
}
