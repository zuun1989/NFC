package com.google.android.gms.internal.clearcut;

final class zzdf implements zzdn {
    private zzdn[] zzma;

    public zzdf(zzdn... zzdnArr) {
        this.zzma = zzdnArr;
    }

    public final boolean zza(Class<?> cls) {
        for (zzdn zza : this.zzma) {
            if (zza.zza(cls)) {
                return true;
            }
        }
        return false;
    }

    public final zzdm zzb(Class<?> cls) {
        for (zzdn zzdn : this.zzma) {
            if (zzdn.zza(cls)) {
                return zzdn.zzb(cls);
            }
        }
        String name = cls.getName();
        throw new UnsupportedOperationException(name.length() != 0 ? "No factory is available for message type: ".concat(name) : new String("No factory is available for message type: "));
    }
}
