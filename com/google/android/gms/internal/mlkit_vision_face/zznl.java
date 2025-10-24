package com.google.android.gms.internal.mlkit_vision_face;

public final class zznl {
    private static zznl zza;

    private zznl() {
    }

    public static synchronized zznl zza() {
        zznl zznl;
        synchronized (zznl.class) {
            try {
                if (zza == null) {
                    zza = new zznl();
                }
                zznl = zza;
            } catch (Throwable th) {
                while (true) {
                    throw th;
                }
            }
        }
        return zznl;
    }
}
