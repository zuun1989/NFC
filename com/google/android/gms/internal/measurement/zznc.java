package com.google.android.gms.internal.measurement;

final class zznc implements zznk {
    private final zznk[] zza;

    public zznc(zznk... zznkArr) {
        this.zza = zznkArr;
    }

    public final boolean zzb(Class cls) {
        for (int i = 0; i < 2; i++) {
            if (this.zza[i].zzb(cls)) {
                return true;
            }
        }
        return false;
    }

    public final zznj zzc(Class cls) {
        for (int i = 0; i < 2; i++) {
            zznk zznk = this.zza[i];
            if (zznk.zzb(cls)) {
                return zznk.zzc(cls);
            }
        }
        throw new UnsupportedOperationException("No factory is available for message type: ".concat(cls.getName()));
    }
}
