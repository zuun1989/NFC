package com.google.android.gms.internal.mlkit_vision_face;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;

final class zzai implements Iterator {
    Map.Entry zza;
    final /* synthetic */ Iterator zzb;
    final /* synthetic */ zzaj zzc;

    public zzai(zzaj zzaj, Iterator it) {
        this.zzc = zzaj;
        this.zzb = it;
    }

    public final boolean hasNext() {
        return this.zzb.hasNext();
    }

    public final Object next() {
        Map.Entry entry = (Map.Entry) this.zzb.next();
        this.zza = entry;
        return entry.getKey();
    }

    public final void remove() {
        boolean z;
        if (this.zza != null) {
            z = true;
        } else {
            z = false;
        }
        zzab.zzd(z, "no calls to next() since the last call to remove()");
        Collection collection = (Collection) this.zza.getValue();
        this.zzb.remove();
        zzap.zzg(this.zzc.zza, collection.size());
        collection.clear();
        this.zza = null;
    }
}
