package com.google.android.gms.internal.maps;

import java.util.AbstractMap;
import java.util.Objects;

final class zzbr extends zzbk {
    final /* synthetic */ zzbs zza;

    public zzbr(zzbs zzbs) {
        this.zza = zzbs;
    }

    public final /* bridge */ /* synthetic */ Object get(int i) {
        zzbs zzbs = this.zza;
        zzbc.zza(i, zzbs.zzc, "index");
        int i2 = i + i;
        Object obj = zzbs.zzb[i2];
        Objects.requireNonNull(obj);
        Object obj2 = zzbs.zzb[i2 + 1];
        Objects.requireNonNull(obj2);
        return new AbstractMap.SimpleImmutableEntry(obj, obj2);
    }

    public final int size() {
        return this.zza.zzc;
    }
}
