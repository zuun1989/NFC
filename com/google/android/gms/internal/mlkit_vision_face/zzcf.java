package com.google.android.gms.internal.mlkit_vision_face;

import java.util.Iterator;

final class zzcf extends zzbq {
    private final transient zzbp zza;
    private final transient zzbn zzb;

    public zzcf(zzbp zzbp, zzbn zzbn) {
        this.zza = zzbp;
        this.zzb = zzbn;
    }

    public final boolean contains(Object obj) {
        if (this.zza.get(obj) != null) {
            return true;
        }
        return false;
    }

    public final /* synthetic */ Iterator iterator() {
        return this.zzb.listIterator(0);
    }

    public final int size() {
        return this.zza.size();
    }

    public final int zza(Object[] objArr, int i) {
        return this.zzb.zza(objArr, 0);
    }

    public final zzcl zzd() {
        return this.zzb.listIterator(0);
    }
}
