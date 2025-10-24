package com.google.android.gms.internal.maps;

import java.util.NoSuchElementException;

final class zzbp extends zzbz {
    private final Object zza;
    private boolean zzb;

    public zzbp(Object obj) {
        this.zza = obj;
    }

    public final boolean hasNext() {
        return !this.zzb;
    }

    public final Object next() {
        if (!this.zzb) {
            this.zzb = true;
            return this.zza;
        }
        throw new NoSuchElementException();
    }
}
