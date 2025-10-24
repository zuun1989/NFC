package com.google.android.gms.internal.mlkit_vision_barcode;

import java.util.AbstractMap;
import java.util.Objects;

final class zzdl extends zzcs {
    final /* synthetic */ zzdm zza;

    public zzdl(zzdm zzdm) {
        this.zza = zzdm;
    }

    public final /* bridge */ /* synthetic */ Object get(int i) {
        zzaz.zza(i, this.zza.zzc, "index");
        int i2 = i + i;
        Object obj = this.zza.zzb[i2];
        Objects.requireNonNull(obj);
        Object obj2 = this.zza.zzb[i2 + 1];
        Objects.requireNonNull(obj2);
        return new AbstractMap.SimpleImmutableEntry(obj, obj2);
    }

    public final int size() {
        return this.zza.zzc;
    }
}
