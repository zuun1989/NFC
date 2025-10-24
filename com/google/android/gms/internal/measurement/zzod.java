package com.google.android.gms.internal.measurement;

import java.util.AbstractSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;

final class zzod extends AbstractSet {
    final /* synthetic */ zzoe zza;

    public /* synthetic */ zzod(zzoe zzoe, byte[] bArr) {
        Objects.requireNonNull(zzoe);
        this.zza = zzoe;
    }

    public final /* bridge */ /* synthetic */ boolean add(Object obj) {
        Map.Entry entry = (Map.Entry) obj;
        if (contains(entry)) {
            return false;
        }
        this.zza.put((Comparable) entry.getKey(), entry.getValue());
        return true;
    }

    public final void clear() {
        this.zza.clear();
    }

    public final boolean contains(Object obj) {
        Map.Entry entry = (Map.Entry) obj;
        Object obj2 = this.zza.get(entry.getKey());
        Object value = entry.getValue();
        if (obj2 == value) {
            return true;
        }
        if (obj2 == null) {
            return false;
        }
        if (obj2.equals(value)) {
            return true;
        }
        return false;
    }

    public final Iterator iterator() {
        return new zzoc(this.zza, (byte[]) null);
    }

    public final boolean remove(Object obj) {
        Map.Entry entry = (Map.Entry) obj;
        if (!contains(entry)) {
            return false;
        }
        this.zza.remove(entry.getKey());
        return true;
    }

    public final int size() {
        return this.zza.size();
    }
}
