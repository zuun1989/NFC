package com.google.android.gms.internal.mlkit_common;

import java.util.Iterator;

final class zzao extends zzaj {
    private final transient zzai zza;
    private final transient zzaf zzb;

    public zzao(zzai zzai, zzaf zzaf) {
        this.zza = zzai;
        this.zzb = zzaf;
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

    public final zzas zzd() {
        return this.zzb.listIterator(0);
    }
}
