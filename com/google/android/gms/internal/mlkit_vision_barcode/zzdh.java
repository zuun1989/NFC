package com.google.android.gms.internal.mlkit_vision_barcode;

import java.util.AbstractCollection;
import java.util.Map;

abstract class zzdh extends AbstractCollection {
    public final void clear() {
        zza().zzs();
    }

    public final boolean contains(Object obj) {
        if (!(obj instanceof Map.Entry)) {
            return false;
        }
        Map.Entry entry = (Map.Entry) obj;
        return zza().zzx(entry.getKey(), entry.getValue());
    }

    public final boolean remove(Object obj) {
        if (!(obj instanceof Map.Entry)) {
            return false;
        }
        Map.Entry entry = (Map.Entry) obj;
        return zza().zzy(entry.getKey(), entry.getValue());
    }

    public final int size() {
        return zza().zzh();
    }

    public abstract zzdg zza();
}
