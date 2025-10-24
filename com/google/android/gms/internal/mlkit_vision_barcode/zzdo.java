package com.google.android.gms.internal.mlkit_vision_barcode;

import java.util.Objects;

final class zzdo extends zzcs {
    private final transient Object[] zza;
    private final transient int zzb;
    private final transient int zzc = 1;

    public zzdo(Object[] objArr, int i, int i2) {
        this.zza = objArr;
        this.zzb = i;
    }

    public final Object get(int i) {
        zzaz.zza(i, this.zzc, "index");
        Object obj = this.zza[i + i + this.zzb];
        Objects.requireNonNull(obj);
        return obj;
    }

    public final int size() {
        return this.zzc;
    }
}
