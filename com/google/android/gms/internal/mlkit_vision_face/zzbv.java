package com.google.android.gms.internal.mlkit_vision_face;

import com.google.android.gms.common.api.Api;
import java.util.Collection;
import java.util.HashSet;
import java.util.Map;

abstract class zzbv extends zzci {
    public final void clear() {
        zza().clear();
    }

    public boolean contains(Object obj) {
        if (!(obj instanceof Map.Entry)) {
            return false;
        }
        Map.Entry entry = (Map.Entry) obj;
        Object key = entry.getKey();
        Object zza = zzbz.zza(zza(), key);
        if (!zzx.zza(zza, entry.getValue())) {
            return false;
        }
        if (zza != null) {
            return true;
        }
        if (!zzbz.zzb(((zzah) zza()).zza, key)) {
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
        return ((zzah) zza()).zzb.zzq().remove(((Map.Entry) obj).getKey());
    }

    public final boolean removeAll(Collection collection) {
        if (collection != null) {
            try {
                return zzcj.zzb(this, collection);
            } catch (UnsupportedOperationException unused) {
                return zzcj.zzc(this, collection.iterator());
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
                    zzau.zza(size, "expectedSize");
                    i = size + 1;
                } else if (size < 1073741824) {
                    i = (int) ((((float) size) / 0.75f) + 1.0f);
                } else {
                    i = Api.BaseClientBuilder.API_PRIORITY_OTHER;
                }
                HashSet hashSet = new HashSet(i);
                for (Object next : collection) {
                    if (contains(next) && (next instanceof Map.Entry)) {
                        hashSet.add(((Map.Entry) next).getKey());
                    }
                }
                return ((zzah) zza()).zzb.zzq().retainAll(hashSet);
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
