package com.google.android.gms.internal.p002firebaseauthapi;

import java.util.Objects;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzem  reason: invalid package */
public final class zzem extends zzcx {
    private final zza zza;

    /* renamed from: com.google.android.gms.internal.firebase-auth-api.zzem$zza */
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

    private zzem(zza zza2) {
        this.zza = zza2;
    }

    public static zzem zza(zza zza2) {
        return new zzem(zza2);
    }

    public final boolean equals(Object obj) {
        if ((obj instanceof zzem) && ((zzem) obj).zza == this.zza) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return Objects.hash(new Object[]{zzem.class, this.zza});
    }

    public final String toString() {
        String valueOf = String.valueOf(this.zza);
        return "ChaCha20Poly1305 Parameters (variant: " + valueOf + ")";
    }

    public final zza zzb() {
        return this.zza;
    }

    public final boolean zza() {
        return this.zza != zza.zzc;
    }
}
