package com.google.android.gms.internal.mlkit_vision_barcode;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;

abstract class zzbj implements Iterator {
    final Iterator zza;
    Object zzb = null;
    Collection zzc = null;
    Iterator zzd = zzcw.INSTANCE;
    final /* synthetic */ zzbr zze;

    public zzbj(zzbr zzbr) {
        this.zze = zzbr;
        this.zza = zzbr.zza.entrySet().iterator();
    }

    public final boolean hasNext() {
        if (this.zza.hasNext() || this.zzd.hasNext()) {
            return true;
        }
        return false;
    }

    public final Object next() {
        if (!this.zzd.hasNext()) {
            Map.Entry entry = (Map.Entry) this.zza.next();
            this.zzb = entry.getKey();
            Collection collection = (Collection) entry.getValue();
            this.zzc = collection;
            this.zzd = collection.iterator();
        }
        return zza(this.zzb, this.zzd.next());
    }

    public final void remove() {
        this.zzd.remove();
        Collection collection = this.zzc;
        Objects.requireNonNull(collection);
        if (collection.isEmpty()) {
            this.zza.remove();
        }
        zzbr zzbr = this.zze;
        zzbr.zzb = zzbr.zzb - 1;
    }

    public abstract Object zza(Object obj, Object obj2);
}
