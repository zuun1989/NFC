package com.google.android.gms.internal.p002firebaseauthapi;

import java.util.Map;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzoj  reason: invalid package */
public final class zzoj {
    public static final zzoj zza = new zzom().zza();
    private final Map<String, String> zzb;

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzoj)) {
            return false;
        }
        return this.zzb.equals(((zzoj) obj).zzb);
    }

    public final int hashCode() {
        return this.zzb.hashCode();
    }

    public final String toString() {
        return this.zzb.toString();
    }

    public final boolean zza() {
        return this.zzb.isEmpty();
    }

    private zzoj(Map<String, String> map) {
        this.zzb = map;
    }
}
