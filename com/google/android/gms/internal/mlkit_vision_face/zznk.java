package com.google.android.gms.internal.mlkit_vision_face;

public final class zznk {
    private static zznj zza;

    public static synchronized zzmz zza(zzmq zzmq) {
        zzmz zzmz;
        synchronized (zznk.class) {
            try {
                if (zza == null) {
                    zza = new zznj((zzni) null);
                }
                zzmz = (zzmz) zza.get(zzmq);
            } catch (Throwable th) {
                while (true) {
                    throw th;
                }
            }
        }
        return zzmz;
    }

    public static synchronized zzmz zzb(String str) {
        zzmz zza2;
        synchronized (zznk.class) {
            zza2 = zza(zzmq.zzd(str).zzd());
        }
        return zza2;
    }
}
