package com.google.android.gms.internal.p002firebaseauthapi;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzamc  reason: invalid package */
final class zzamc implements zzamk {
    private zzamk[] zza;

    public zzamc(zzamk... zzamkArr) {
        this.zza = zzamkArr;
    }

    public final zzaml zza(Class<?> cls) {
        for (zzamk zzamk : this.zza) {
            if (zzamk.zzb(cls)) {
                return zzamk.zza(cls);
            }
        }
        throw new UnsupportedOperationException("No factory is available for message type: " + cls.getName());
    }

    public final boolean zzb(Class<?> cls) {
        for (zzamk zzb : this.zza) {
            if (zzb.zzb(cls)) {
                return true;
            }
        }
        return false;
    }
}
