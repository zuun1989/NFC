package com.google.android.gms.internal.mlkit_vision_face;

import java.util.Iterator;

abstract class zzck implements Iterator {
    final Iterator zza;

    public zzck(Iterator it) {
        it.getClass();
        this.zza = it;
    }

    public final boolean hasNext() {
        return this.zza.hasNext();
    }

    public final Object next() {
        return zza(this.zza.next());
    }

    public final void remove() {
        this.zza.remove();
    }

    public abstract Object zza(Object obj);
}
