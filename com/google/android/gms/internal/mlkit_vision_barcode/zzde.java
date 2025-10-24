package com.google.android.gms.internal.mlkit_vision_barcode;

import java.util.AbstractMap;
import java.util.Collection;
import java.util.Set;

abstract class zzde extends AbstractMap {
    private transient Set zza;
    private transient Set zzb;
    private transient Collection zzc;

    public final Set entrySet() {
        Set set = this.zza;
        if (set != null) {
            return set;
        }
        Set zzb2 = zzb();
        this.zza = zzb2;
        return zzb2;
    }

    public Set keySet() {
        Set set = this.zzb;
        if (set != null) {
            return set;
        }
        zzdc zzdc = new zzdc(this);
        this.zzb = zzdc;
        return zzdc;
    }

    public final Collection values() {
        Collection collection = this.zzc;
        if (collection != null) {
            return collection;
        }
        zzdd zzdd = new zzdd(this);
        this.zzc = zzdd;
        return zzdd;
    }

    public abstract Set zzb();
}
