package com.google.android.gms.internal.mlkit_vision_barcode;

import java.util.Iterator;

final class zzdn extends zzcv {
    private final transient zzcu zza;
    private final transient zzcs zzb;

    public zzdn(zzcu zzcu, zzcs zzcs) {
        this.zza = zzcu;
        this.zzb = zzcs;
    }

    public final boolean contains(Object obj) {
        if (this.zza.get(obj) != null) {
            return true;
        }
        return false;
    }

    public final /* synthetic */ Iterator iterator() {
        return this.zzb.listIterator(0);
    }

    public final int size() {
        return 1;
    }

    public final int zza(Object[] objArr, int i) {
        return this.zzb.zza(objArr, i);
    }

    public final zzdu zzd() {
        return this.zzb.listIterator(0);
    }
}
