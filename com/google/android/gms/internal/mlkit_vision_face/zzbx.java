package com.google.android.gms.internal.mlkit_vision_face;

import java.util.AbstractCollection;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;

final class zzbx extends AbstractCollection {
    final Map zza;

    public zzbx(Map map) {
        this.zza = map;
    }

    public final void clear() {
        this.zza.clear();
    }

    public final boolean contains(Object obj) {
        return this.zza.containsValue(obj);
    }

    public final boolean isEmpty() {
        return this.zza.isEmpty();
    }

    public final Iterator iterator() {
        return new zzbu(this.zza.entrySet().iterator());
    }

    public final boolean remove(Object obj) {
        try {
            return super.remove(obj);
        } catch (UnsupportedOperationException unused) {
            for (Map.Entry entry : this.zza.entrySet()) {
                if (zzx.zza(obj, entry.getValue())) {
                    this.zza.remove(entry.getKey());
                    return true;
                }
            }
            return false;
        }
    }

    public final boolean removeAll(Collection collection) {
        if (collection != null) {
            try {
                return super.removeAll(collection);
            } catch (UnsupportedOperationException unused) {
                HashSet hashSet = new HashSet();
                for (Map.Entry entry : this.zza.entrySet()) {
                    if (collection.contains(entry.getValue())) {
                        hashSet.add(entry.getKey());
                    }
                }
                return this.zza.keySet().removeAll(hashSet);
            }
        } else {
            throw null;
        }
    }

    public final boolean retainAll(Collection collection) {
        if (collection != null) {
            try {
                return super.retainAll(collection);
            } catch (UnsupportedOperationException unused) {
                HashSet hashSet = new HashSet();
                for (Map.Entry entry : this.zza.entrySet()) {
                    if (collection.contains(entry.getValue())) {
                        hashSet.add(entry.getKey());
                    }
                }
                return this.zza.keySet().retainAll(hashSet);
            }
        } else {
            throw null;
        }
    }

    public final int size() {
        return this.zza.size();
    }
}
