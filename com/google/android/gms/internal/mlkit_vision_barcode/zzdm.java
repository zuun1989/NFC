package com.google.android.gms.internal.mlkit_vision_barcode;

import java.util.Iterator;
import java.util.Map;

final class zzdm extends zzcv {
    private final transient zzcu zza;
    /* access modifiers changed from: private */
    public final transient Object[] zzb;
    /* access modifiers changed from: private */
    public final transient int zzc = 1;

    public zzdm(zzcu zzcu, Object[] objArr, int i, int i2) {
        this.zza = zzcu;
        this.zzb = objArr;
    }

    public final boolean contains(Object obj) {
        if (obj instanceof Map.Entry) {
            Map.Entry entry = (Map.Entry) obj;
            Object key = entry.getKey();
            Object value = entry.getValue();
            if (value == null || !value.equals(this.zza.get(key))) {
                return false;
            }
            return true;
        }
        return false;
    }

    public final /* synthetic */ Iterator iterator() {
        return zzf().listIterator(0);
    }

    public final int size() {
        return this.zzc;
    }

    public final int zza(Object[] objArr, int i) {
        return zzf().zza(objArr, i);
    }

    public final zzdu zzd() {
        return zzf().listIterator(0);
    }

    public final zzcs zzg() {
        return new zzdl(this);
    }
}
