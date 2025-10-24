package com.google.android.gms.internal.auth;

final class zzfn implements zzfu {
    private final zzfu[] zza;

    public zzfn(zzfu... zzfuArr) {
        this.zza = zzfuArr;
    }

    public final zzft zzb(Class cls) {
        zzfu[] zzfuArr = this.zza;
        for (int i = 0; i < 2; i++) {
            zzfu zzfu = zzfuArr[i];
            if (zzfu.zzc(cls)) {
                return zzfu.zzb(cls);
            }
        }
        throw new UnsupportedOperationException("No factory is available for message type: ".concat(cls.getName()));
    }

    public final boolean zzc(Class cls) {
        zzfu[] zzfuArr = this.zza;
        for (int i = 0; i < 2; i++) {
            if (zzfuArr[i].zzc(cls)) {
                return true;
            }
        }
        return false;
    }
}
