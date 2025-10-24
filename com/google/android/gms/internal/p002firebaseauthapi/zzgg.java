package com.google.android.gms.internal.p002firebaseauthapi;

import java.util.Objects;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzgg  reason: invalid package */
public final class zzgg extends zzcx {
    private final zza zza;

    /* renamed from: com.google.android.gms.internal.firebase-auth-api.zzgg$zza */
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

    private zzgg(zza zza2) {
        this.zza = zza2;
    }

    public static zzgg zza(zza zza2) {
        return new zzgg(zza2);
    }

    public static zzgg zzc() {
        return new zzgg(zza.zzc);
    }

    public final boolean equals(Object obj) {
        if ((obj instanceof zzgg) && ((zzgg) obj).zza == this.zza) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return Objects.hash(new Object[]{zzgg.class, this.zza});
    }

    public final String toString() {
        String valueOf = String.valueOf(this.zza);
        return "XChaCha20Poly1305 Parameters (variant: " + valueOf + ")";
    }

    public final zza zzb() {
        return this.zza;
    }

    public final boolean zza() {
        return this.zza != zza.zzc;
    }
}
