package com.google.android.gms.internal.maps;

import java.util.Iterator;

final class zzbt extends zzbo {
    private final transient zzbn zza;
    private final transient zzbk zzb;

    public zzbt(zzbn zzbn, zzbk zzbk) {
        this.zza = zzbn;
        this.zzb = zzbk;
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

    public final zzbz zzd() {
        return this.zzb.listIterator(0);
    }
}
