package com.google.android.gms.internal.auth;

final class zzfs {
    private static final zzfr zza;
    private static final zzfr zzb = new zzfr();

    static {
        zzfr zzfr = null;
        try {
            zzfr = (zzfr) Class.forName("com.google.protobuf.MapFieldSchemaFull").getDeclaredConstructor((Class[]) null).newInstance((Object[]) null);
        } catch (Exception unused) {
        }
        zza = zzfr;
    }

    public static zzfr zza() {
        return zza;
    }

    public static zzfr zzb() {
        return zzb;
    }
}
