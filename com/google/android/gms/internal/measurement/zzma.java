package com.google.android.gms.internal.measurement;

final class zzma implements zznk {
    private static final zzma zza = new zzma();

    private zzma() {
    }

    public static zzma zza() {
        return zza;
    }

    public final boolean zzb(Class cls) {
        return zzmf.class.isAssignableFrom(cls);
    }

    public final zznj zzc(Class cls) {
        Class<zzmf> cls2 = zzmf.class;
        if (cls2.isAssignableFrom(cls)) {
            try {
                return (zznj) zzmf.zzco(cls.asSubclass(cls2)).zzl(3, (Object) null, (Object) null);
            } catch (Exception e) {
                throw new RuntimeException("Unable to get message info for ".concat(cls.getName()), e);
            }
        } else {
            throw new IllegalArgumentException("Unsupported message type: ".concat(cls.getName()));
        }
    }
}
