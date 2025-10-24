package com.google.android.gms.internal.mlkit_vision_barcode;

import java.util.AbstractSet;
import java.util.Iterator;
import java.util.Map;

final class zzcf extends AbstractSet {
    final /* synthetic */ zzci zza;

    public zzcf(zzci zzci) {
        this.zza = zzci;
    }

    public final void clear() {
        this.zza.clear();
    }

    public final boolean contains(Object obj) {
        return this.zza.containsKey(obj);
    }

    public final Iterator iterator() {
        zzci zzci = this.zza;
        Map zzl = zzci.zzl();
        if (zzl != null) {
            return zzl.keySet().iterator();
        }
        return new zzbz(zzci);
    }

    public final boolean remove(Object obj) {
        Map zzl = this.zza.zzl();
        if (zzl != null) {
            return zzl.keySet().remove(obj);
        }
        if (this.zza.zzy(obj) == zzci.zzd) {
            return false;
        }
        return true;
    }

    public final int size() {
        return this.zza.size();
    }
}
