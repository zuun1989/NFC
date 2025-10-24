package com.google.android.gms.internal.p002firebaseauthapi;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzaan  reason: invalid package */
public final class zzaan {
    private final zzaam zza;

    private zzaan(zzaam zzaam) {
        this.zza = zzaam;
    }

    public final int zza() {
        return this.zza.zza();
    }

    public static zzaan zza(byte[] bArr, zzck zzck) {
        if (zzck != null) {
            return new zzaan(zzaam.zza(bArr));
        }
        throw new NullPointerException("SecretKeyAccess required");
    }

    public static zzaan zza(int i) {
        return new zzaan(zzaam.zza(zzqg.zza(i)));
    }

    public final byte[] zza(zzck zzck) {
        if (zzck != null) {
            return this.zza.zzb();
        }
        throw new NullPointerException("SecretKeyAccess required");
    }
}
