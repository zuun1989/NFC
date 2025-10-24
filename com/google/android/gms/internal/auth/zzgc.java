package com.google.android.gms.internal.auth;

final class zzgc {
    private static final zzgb zza;
    private static final zzgb zzb = new zzgb();

    static {
        zzgb zzgb = null;
        try {
            zzgb = (zzgb) Class.forName("com.google.protobuf.NewInstanceSchemaFull").getDeclaredConstructor((Class[]) null).newInstance((Object[]) null);
        } catch (Exception unused) {
        }
        zza = zzgb;
    }

    public static zzgb zza() {
        return zza;
    }

    public static zzgb zzb() {
        return zzb;
    }
}
