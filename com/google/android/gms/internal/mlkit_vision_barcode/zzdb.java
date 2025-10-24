package com.google.android.gms.internal.mlkit_vision_barcode;

import com.google.android.gms.common.api.Api;
import java.util.Collection;
import java.util.HashSet;
import java.util.Map;

abstract class zzdb extends zzdr {
    public final void clear() {
        zza().clear();
    }

    public boolean contains(Object obj) {
        if (!(obj instanceof Map.Entry)) {
            return false;
        }
        Map.Entry entry = (Map.Entry) obj;
        Object key = entry.getKey();
        Object zza = zzdf.zza(zza(), key);
        if (!zzax.zza(zza, entry.getValue())) {
            return false;
        }
        if (zza != null) {
            return true;
        }
        if (!zzdf.zzb(((zzbi) zza()).zza, key)) {
            return false;
        }
        return true;
    }

    public final boolean isEmpty() {
        return zza().isEmpty();
    }

    public boolean remove(Object obj) {
        if (!contains(obj) || !(obj instanceof Map.Entry)) {
            return false;
        }
        return ((zzbi) zza()).zzb.zzw().remove(((Map.Entry) obj).getKey());
    }

    public final boolean removeAll(Collection collection) {
        if (collection != null) {
            try {
                return zzds.zzc(this, collection);
            } catch (UnsupportedOperationException unused) {
                return zzds.zzd(this, collection.iterator());
            }
        } else {
            throw null;
        }
    }

    public final boolean retainAll(Collection collection) {
        int i;
        if (collection != null) {
            try {
                return super.retainAll(collection);
            } catch (UnsupportedOperationException unused) {
                int size = collection.size();
                if (size < 3) {
                    zzby.zza(size, "expectedSize");
                    i = size + 1;
                } else if (size < 1073741824) {
                    i = (int) Math.ceil(((double) size) / 0.75d);
                } else {
                    i = Api.BaseClientBuilder.API_PRIORITY_OTHER;
                }
                HashSet hashSet = new HashSet(i);
                for (Object next : collection) {
                    if (contains(next) && (next instanceof Map.Entry)) {
                        hashSet.add(((Map.Entry) next).getKey());
                    }
                }
                return ((zzbi) zza()).zzb.zzw().retainAll(hashSet);
            }
        } else {
            throw null;
        }
    }

    public final int size() {
        return zza().size();
    }

    public abstract Map zza();
}
