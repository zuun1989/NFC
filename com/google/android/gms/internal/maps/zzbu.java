package com.google.android.gms.internal.maps;

import java.util.Objects;

final class zzbu extends zzbk {
    private final transient Object[] zza;
    private final transient int zzb;
    private final transient int zzc;

    public zzbu(Object[] objArr, int i, int i2) {
        this.zza = objArr;
        this.zzb = i;
        this.zzc = i2;
    }

    public final Object get(int i) {
        zzbc.zza(i, this.zzc, "index");
        Object obj = this.zza[i + i + this.zzb];
        Objects.requireNonNull(obj);
        return obj;
    }

    public final int size() {
        return this.zzc;
    }
}
