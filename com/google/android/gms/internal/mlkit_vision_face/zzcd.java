package com.google.android.gms.internal.mlkit_vision_face;

import java.util.AbstractMap;

final class zzcd extends zzbn {
    final /* synthetic */ zzce zza;

    public zzcd(zzce zzce) {
        this.zza = zzce;
    }

    public final /* bridge */ /* synthetic */ Object get(int i) {
        zzab.zza(i, this.zza.zzc, "index");
        zzce zzce = this.zza;
        int i2 = i + i;
        Object obj = zzce.zzb[i2];
        obj.getClass();
        Object obj2 = zzce.zzb[i2 + 1];
        obj2.getClass();
        return new AbstractMap.SimpleImmutableEntry(obj, obj2);
    }

    public final int size() {
        return this.zza.zzc;
    }
}
