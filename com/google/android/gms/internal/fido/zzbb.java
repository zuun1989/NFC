package com.google.android.gms.internal.fido;

import java.util.Map;

abstract class zzbb extends zzbc {
    public final boolean contains(Object obj) {
        if (obj instanceof Map.Entry) {
            Map.Entry entry = (Map.Entry) obj;
            Object obj2 = zzf().get(entry.getKey());
            if (obj2 == null || !obj2.equals(entry.getValue())) {
                return false;
            }
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return zzbx.zza(zzf().entrySet());
    }

    public final int size() {
        return zzf().size();
    }

    public abstract zzba zzf();

    public final boolean zzg() {
        return false;
    }
}
