package com.google.android.gms.internal.mlkit_vision_barcode;

public final class zzxa {
    private static zzwz zza;

    public static synchronized zzwp zza(zzwh zzwh) {
        zzwp zzwp;
        synchronized (zzxa.class) {
            try {
                if (zza == null) {
                    zza = new zzwz((zzwy) null);
                }
                zzwp = (zzwp) zza.get(zzwh);
            } catch (Throwable th) {
                while (true) {
                    throw th;
                }
            }
        }
        return zzwp;
    }

    public static synchronized zzwp zzb(String str) {
        zzwp zza2;
        synchronized (zzxa.class) {
            zza2 = zza(zzwh.zzd(str).zzd());
        }
        return zza2;
    }
}
