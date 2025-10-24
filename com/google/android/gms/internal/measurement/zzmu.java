package com.google.android.gms.internal.measurement;

import java.util.Iterator;
import java.util.Map;

final class zzmu implements Iterator {
    private final Iterator zza;

    public zzmu(Iterator it) {
        this.zza = it;
    }

    public final boolean hasNext() {
        return this.zza.hasNext();
    }

    public final /* bridge */ /* synthetic */ Object next() {
        Map.Entry entry = (Map.Entry) this.zza.next();
        if (entry.getValue() instanceof zzmv) {
            return new zzmt(entry, (byte[]) null);
        }
        return entry;
    }

    public final void remove() {
        this.zza.remove();
    }
}
